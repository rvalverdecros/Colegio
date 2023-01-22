import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void menu() {

        Colegio colegio = new Colegio("IES Rafael Alberti");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido usuari@");
        System.out.println("¿Que opcion le gustaría escoger?");
        opciones();
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> {
                creacionaula(colegio);
                menu();
            }
            case 2 -> {
                creacioncurso(colegio);
                menu();
            }
            case 3 -> {
                creacionprofesor(colegio);
                menu();
            }
            case 4 -> {
                creacionalumno(colegio);
                menu();
            }
            case 5 -> {
                modificacionaula(colegio);
                menu();
            }
            case 6 -> {
                modificacioncurso(colegio);
                menu();
            }
            case 7 -> {
                modificacionprofesor(colegio);
                menu();
            }
            case 8 -> {
                modificacionalumno(colegio);
                menu();
            }
            case 9 -> {
                borraraula(colegio);
                menu();
            }
            case 10 -> {
                borrarcurso(colegio);
                menu();
            }
            case 11 -> {
                borrarprofesor(colegio);
                menu();
            }
            case 12 -> {
                borraralumno(colegio);
                menu();
            }
            case 13 -> {
                mostrartodo(colegio);
                menu();
            }
            case 14 -> {
                cerrarsesion();
            }
            default -> {
                System.out.println("¡Opción Invalida!");
            }
        }

    }

    private static void opciones() {
        System.out.println("1. Creación de aula");
        System.out.println("2. Creación de curso");
        System.out.println("3. Creación de profesor");
        System.out.println("4. Creación de alumno");
        System.out.println("5. Modificación de aula");
        System.out.println("6. Modificación de curso");
        System.out.println("7. Modificación de profesor");
        System.out.println("8. Modificación de alumno");
        System.out.println("9. Borrar un aula");
        System.out.println("10. Borrar un curso");
        System.out.println("11. Borrar un profesor");
        System.out.println("12. Borrar un alumno");
        System.out.println("13. Mostrar todo");
        System.out.println("14. Cerrar Sesión");
    }

    private static void creacionaula(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el nombre del Aula");
        String nombre = scanner.nextLine();
        System.out.println("¿Tiene pizarra?");
        String res = scanner.nextLine();
        boolean pizarra;
        String resminus = res.toLowerCase();
        if (resminus.equals("si")) {
            pizarra = true;
        } else {
            pizarra = false;
        }
        System.out.println("¿Cuantas sillas tiene el aula?");
        int sillas = scanner.nextInt();
        System.out.println("¿Cuantas mesas tiene el aula?");
        int mesas = scanner.nextInt();
        System.out.println("¿Cual es el estado del aula?");
        String estado = scanner.nextLine();
        if (estado != EstadoAula.enObras && estado != EstadoAula.libre && estado != EstadoAula.ocupado) {
            estado = EstadoAula.libre;
        }
        Aula aula = new Aula(nombre, pizarra, sillas, mesas);
        aula.setEstado(estado);
        colegio.anadirAula(aula);
    }

    private static void creacioncurso(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del curso: ");
        String nombre = scanner.nextLine();

        Curso cursoNuevo = new Curso(nombre);
        colegio.anadirCurso(cursoNuevo);
    }

    private static void creacionprofesor(Colegio colegio) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre completo del profesor: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca la edad del profesor: ");
        int edad = sc.nextInt();
        System.out.println("Introduzca el género del profesor (): ");
        char sexo = sc.nextLine().charAt(0);
        System.out.println("Introduzca el DNI del profesor: ");
        String dni = sc.nextLine();

        Profesor profesorNuevo = new Profesor(dni, nombre, edad, sexo);
        colegio.anadirProfesor(profesorNuevo);
    }

    private static void creacionalumno(Colegio colegio) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre completo del alumno: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca la edad del alumno: ");
        int edad = sc.nextInt();
        System.out.println("Introduzca el género del alumno (): ");
        char sexo = sc.nextLine().charAt(0);
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = sc.nextLine();

        Alumno alumnoNuevo = new Alumno(dni, nombre, edad, sexo);

        colegio.anadirAlumno(alumnoNuevo);
    }

    private static void modificacionaula(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.aulas.size(); i++) {
            System.out.println(i + ". " + colegio.aulas.get(i));
        }
        System.out.println("Seleccione una opcion");
        int opcion = scanner.nextInt();
        if (opcion < colegio.aulas.size()) {
            System.out.println("¿Que opcion le gustaría modificar?");
            System.out.println("1.Nombre");
            System.out.println("2.Pizarra");
            System.out.println("3.Sillas");
            System.out.println("4.Mesas");
            System.out.println("5.Estado");
            int res = scanner.nextInt();
            switch (res) {
                case 1 -> {
                    System.out.println("Escriba un nuevo nombre");
                    String nombre = scanner.nextLine();
                    colegio.aulas.get(opcion).setNombreAula(nombre);
                }
                case 2 -> {
                    System.out.println("¿Tiene pizarra?");
                    String piz = scanner.nextLine();
                    boolean pizarra;
                    if (piz.toLowerCase(Locale.ROOT) == "si") {
                        pizarra = true;
                    } else {
                        pizarra = false;
                    }
                    colegio.aulas.get(opcion).setPizarra(pizarra);
                }
                case 3 -> {
                    System.out.println("¿cuantas Sillas tiene");
                    int sillas = scanner.nextInt();
                    colegio.aulas.get(opcion).setSillas(sillas);
                }
                case 4 -> {
                    System.out.println("¿cuantas Mesas tiene");
                    int mesas = scanner.nextInt();
                    colegio.aulas.get(opcion).setMesas(mesas);
                }
                case 5 -> {
                    System.out.println("¿cual es el estado del aula?");
                    String estado = scanner.nextLine();
                    if (estado != EstadoAula.enObras && estado != EstadoAula.libre && estado != EstadoAula.ocupado) {
                        estado = EstadoAula.libre;
                    }
                    colegio.aulas.get(opcion).setEstado(estado);
                }
                default -> {
                    System.out.println("¡Opción Invalida!");
                }
            }
        } else {
            System.out.println("¡Error! ¡Opción no Valida!");
        }
    }

    private static void modificacioncurso(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.cursos.size(); i++) {
            System.out.println(i + ". " + colegio.cursos.get(i));
        }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.cursos.size()) {
            System.out.println("¿Que opción le gustaría modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Estado");
            System.out.println("3. Añadir un alumno");
            System.out.println("4. Añadir un profesor");
            System.out.println("5. Borrar un alumno");
            System.out.println("6. Borrar un profesor");
            int res = scanner.nextInt();
            switch (res) {
                case 1 -> {
                    System.out.println("Escriba un nuevo nombre");
                    String nombre = scanner.nextLine();
                    colegio.cursos.get(opcion).setNombre(nombre);
                }
                case 2 -> {

                    System.out.println("Introduzca el estado de la clase");
                    String estado = scanner.nextLine();
                    String estadoCurso;
                    switch (estado){
                        case Actividades.celebracion -> estadoCurso = Actividades.celebracion;
                        case Actividades.jornadaDep -> estadoCurso = Actividades.jornadaDep;
                        case Actividades.teatro -> estadoCurso = Actividades.teatro;
                        case Descanso.excursion -> estadoCurso = Descanso.excursion;
                        case Descanso.festivo -> estadoCurso = Descanso.festivo;
                        case Descanso.recreo-> estadoCurso = Descanso.recreo;
                        case Descanso.vacaciones-> estadoCurso = Descanso.vacaciones;
                        default -> estadoCurso = Actividades.clase;
                    };

                    colegio.cursos.get(opcion).setEstado(estadoCurso);

                }
                case 3 -> {
                    System.out.println("Introduzca el DNI del alumno a ingresar en el curso: ");
                    String DNI = scanner.nextLine();
                    Alumno alumno = colegio.getAlumno(DNI);
                    if (alumno != null) {
                        if (!colegio.cursos.get(opcion).existeAlumno(alumno)) {
                            colegio.cursos.get(opcion).anadirAlumno(alumno);
                        } else {
                            System.out.println("¡Ese alumno ya está en el curso!");
                        }
                    } else {
                        System.out.println("No existe un alumno con ese DNI");
                    }
                }
                case 4 -> {
                    System.out.println("Introduzca el DNI del profesor a ingresar en el curso: ");
                    String DNI = scanner.nextLine();
                    Profesor profesor = colegio.getProfesor(DNI);
                    if (profesor != null) {
                        if (!colegio.cursos.get(opcion).existeProfesor(profesor)) {
                            colegio.cursos.get(opcion).anadirProfesor(profesor);
                        } else {
                            System.out.println("¡Ese profesor ya está en el curso!");
                        }
                    } else {
                        System.out.println("No existe un profesor con ese DNI");
                    }
                }
                case 5 -> {
                    System.out.println("Introduzca el DNI del alumno a borrar del curso: ");
                    String DNI = scanner.nextLine();
                    Alumno alumno = colegio.getAlumno(DNI);
                    if (alumno != null) {
                        if (colegio.cursos.get(opcion).existeAlumno(alumno)) {
                            colegio.cursos.get(opcion).borrarAlumno(alumno);
                        } else {
                            System.out.println("¡Ese alumno no está en el curso!");
                        }
                    } else {
                        System.out.println("No existe un alumno con ese DNI");
                    }
                }
                case 6 -> {
                    System.out.println("Introduzca el DNI del profesor a borrar del curso: ");
                    String DNI = scanner.nextLine();
                    Profesor profesor = colegio.getProfesor(DNI);
                    if (profesor != null) {
                        if (colegio.cursos.get(opcion).existeProfesor(profesor)) {
                            colegio.cursos.get(opcion).borrarProfesor(profesor);
                        } else {
                            System.out.println("¡Ese profesor no está en el curso!");
                        }
                    } else {
                        System.out.println("No existe un profesor con ese DNI");
                    }
                }
                default -> {
                    System.out.println("¡Opción Invalida!");
                }
            }
        } else {
            System.out.println("¡Error! ¡Opción no valida!");
        }
    }

    private static void modificacionprofesor(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.profesores.size(); i++) {
            System.out.println(i + ". " + colegio.profesores.get(i));
        }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.profesores.size()) {
            System.out.println("¿Que opción le gustaría modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Edad");
            System.out.println("3. Sexo");
            System.out.println("4. Estado");
            System.out.println("5. Añadir un material");
            System.out.println("6. Borrar un material");
            System.out.println("7. Cambiar estatus del profesor (Es o no un miembro directivo)");
            int res = scanner.nextInt();
            switch (res) {
                case 1 -> {
                    System.out.println("Escriba un nuevo nombre");
                    String nombre = scanner.nextLine();
                    colegio.profesores.get(opcion).setNombre(nombre);
                }
                case 2 -> {
                    System.out.println("Escriba la nueva edad");
                    int edad = scanner.nextInt();
                    colegio.profesores.get(opcion).setEdad(edad);
                }
                case 3 -> {
                    System.out.println("Escriba el nuevo sexo");
                    char sexo = scanner.nextLine().charAt(0);
                    colegio.profesores.get(opcion).setSexo(sexo);
                }
                case 4 -> {
                    System.out.println("Introduzca el estado del profesor");
                    String estado = scanner.nextLine();
                    colegio.profesores.get(opcion).setEstado(estado);
                }
                case 5 -> {
                    System.out.println("¿Que material quiere añadir?");
                    String material = scanner.nextLine();
                    Material materialNuevo = new Material(material);
                    colegio.profesores.get(opcion).anadirMaterial(materialNuevo);
                }
                case 6 -> {
                    System.out.println("¿Que material quiere eliminar?");
                    String material = scanner.nextLine();
                    Material materialABorrar = new Material(material);
                    if (colegio.profesores.get(opcion).existeMaterial(materialABorrar)) {
                        colegio.profesores.get(opcion).dejarMaterial(materialABorrar);
                    } else {
                        System.out.println("¡No existe ese material!");
                    }
                }
                case 7 -> {
                    System.out.println("¿Desea que el profesor en cuestión sea miembro directivo (SI/NO)?");
                    String opcionMiembroDirectivo = scanner.nextLine();
                    if (opcionMiembroDirectivo.toLowerCase() == "si") {
                        colegio.profesores.get(opcion).setMiembroDirectivo(true);
                    } else if (opcionMiembroDirectivo.toLowerCase() == "no") {
                        colegio.profesores.get(opcion).setMiembroDirectivo(false);
                    } else {
                        System.out.println("¡Error! ¡Opción no valida!");
                    }
                }
                default -> {
                    System.out.println("¡Opción Invalida!");
                }
            }
        } else {
            System.out.println("¡Error! ¡Opción no valida!");
        }
    }

    private static void modificacionalumno(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.alumnos.size(); i++) {
            System.out.println(i + ". " + colegio.alumnos.get(i));
        }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.alumnos.size()) {
            System.out.println("¿Que opción le gustaría modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Edad");
            System.out.println("3. Sexo");
            System.out.println("4. Estado");
            System.out.println("5. Añadir un material");
            System.out.println("6. Borrar un material");
            int res = scanner.nextInt();
            switch (res) {
                case 1 -> {
                    System.out.println("Escriba un nuevo nombre: ");
                    String nombre = scanner.nextLine();
                    colegio.alumnos.get(opcion).setNombre(nombre);
                }
                case 2 -> {
                    System.out.println("Escriba la nueva edad: ");
                    int edad = scanner.nextInt();
                    colegio.alumnos.get(opcion).setEdad(edad);
                }
                case 3 -> {
                    System.out.println("Escriba el nuevo sexo: ");
                    char sexo = scanner.nextLine().charAt(0);
                    colegio.alumnos.get(opcion).setSexo(sexo);
                }
                case 4 -> {
                    System.out.println("Introduzca el estado del alumno");
                    String estado = scanner.nextLine();
                    colegio.alumnos.get(opcion).setEstado(estado);
                }
                case 5 -> {
                    System.out.println("¿Que material quiere añadir?");
                    String material = scanner.nextLine();
                    Material materialNuevo = new Material(material);
                    colegio.alumnos.get(opcion).anadirMaterial(materialNuevo);
                }
                case 6 -> {
                    System.out.println("¿Que material quiere eliminar?");
                    String material = scanner.nextLine();
                    Material materialABorrar = new Material(material);
                    if (colegio.alumnos.get(opcion).existeMaterial(materialABorrar)) {
                        colegio.alumnos.get(opcion).dejarMaterial(materialABorrar);
                    } else {
                        System.out.println("¡No existe ese material!");
                    }
                }
                default -> {
                    System.out.println("¡Opción Invalida!");
                }
            }
        } else {
            System.out.println("¡Error! ¡Opción no valida!");
        }
    }

    private static void borraraula(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.aulas.size(); i++) {
            System.out.println(i + ". " + colegio.aulas.get(i));
        }
        System.out.println("Seleccione una opcion");
        int opcion = scanner.nextInt();
        if (opcion < colegio.aulas.size()) {
            colegio.eliminarAula(opcion);
            System.out.println("Se ha eliminado correctamente");
        }else{
            System.out.println("No existe esa opcion!");
        }
    }

    private static void borrarcurso(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.cursos.size(); i++) {
            System.out.println(i + ". " + colegio.cursos.get(i));
        }
        System.out.println("Seleccione una opcion");
        int opcion = scanner.nextInt();
        if (opcion < colegio.cursos.size()) {
            colegio.eliminarCurso(opcion);
            System.out.println("Se ha eliminado correctamente");
        }else{
            System.out.println("No existe esa opcion!");
        }
    }

    private static void borrarprofesor(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.profesores.size(); i++) {
            System.out.println(i + ". " + colegio.profesores.get(i));
        }
        System.out.println("Seleccione una opcion");
        int opcion = scanner.nextInt();
        if (opcion < colegio.profesores.size()) {
            colegio.eliminarProfesores(opcion);
            System.out.println("Se ha eliminado correctamente");
        }else{
            System.out.println("No existe esa opcion!");
        }
    }

    private static void borraralumno(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.alumnos.size(); i++) {
            System.out.println(i + ". " + colegio.alumnos.get(i));
        }
        System.out.println("Seleccione una opcion");
        int opcion = scanner.nextInt();
        if (opcion < colegio.alumnos.size()) {
            colegio.eliminarAlumnos(opcion);
            System.out.println("Se ha eliminado correctamente");
        }else{
            System.out.println("No existe esa opcion!");
        }
    }

    private static void mostrartodo(Colegio colegio){
        System.out.println("Aulas");
        colegio.mostrarAula();
        System.out.println("Cursos");
        colegio.mostrarCurso();
        System.out.println("Alumnos");
        colegio.mostrarAlumno();
        System.out.println("Profesores");
        colegio.mostrarProfesor();
    }

    private static void cerrarsesion(){
        System.out.println("Adios!");
        System.exit(0);
    }

    public static void main(String[] args) {
        menu();
    }
}
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public static void menu(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido usuari@");
        System.out.println("¿Que opción le gustaría escoger?");
        opciones();
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> { creacionaula(colegio); }
            case 2 -> { creacioncurso(colegio); }
            case 3 -> { creacionprofesor(colegio); }
            case 4 -> { creacionalumno(colegio); }
            case 5 -> { modificacionaula(colegio); }
            case 6 -> { modificacioncurso(colegio); }
            case 7 -> { modificacionprofesor(colegio); }
            case 8 -> { modificacionalumno(colegio); }
            case 9 -> { borraraula(colegio); }
            case 10 -> { borrarcurso(colegio); }
            case 11 -> { borrarprofesor(colegio); }
            case 12 -> { borraralumno(colegio); }
            case 13 -> { mostrartodo(colegio); }
            case 14 -> { cerrarsesion(); }
            default -> { System.out.println("¡Opción Invalida!"); }
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
        System.out.println("Escriba el nombre del aula: ");
        String nombre = scanner.next();
        System.out.println("¿Tiene pizarra?");
        String res = scanner.next();
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
        String estado = scanner.next();
        if (estado != EstadoAula.enObras && estado != EstadoAula.libre && estado != EstadoAula.ocupado) {
            estado = EstadoAula.libre;
        }
        Aula aula = new Aula(nombre, pizarra, sillas, mesas);
        aula.setEstado(estado);
        colegio.anadirAula(aula);
        menu(colegio);
    }

    private static void creacioncurso(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del curso: ");
        String nombre = scanner.next();

        Curso cursoNuevo = new Curso(nombre);
        colegio.anadirCurso(cursoNuevo);
        menu(colegio);
    }

    private static void creacionprofesor(Colegio colegio) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre completo del profesor: ");
        String nombre = sc.next();
        System.out.println("Introduzca la edad del profesor: ");
        int edad = sc.nextInt();
        String genero = comprobarsexProfesor();
        System.out.println("Introduzca el DNI del profesor: ");
        String dni = sc.next();

        Profesor profesorNuevo = new Profesor(dni, nombre, edad, genero);
        colegio.anadirProfesor(profesorNuevo);
        menu(colegio);
    }

    private static void creacionalumno(Colegio colegio) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el nombre completo del alumno: ");
        String nombre = sc.next();
        System.out.println("Introduzca la edad del alumno: ");
        int edad = sc.nextInt();
        String sexo = comprobarsexAlumno();
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = sc.next();

        Alumno alumnoNuevo = new Alumno(dni, nombre, edad, sexo);

        colegio.anadirAlumno(alumnoNuevo);
        menu(colegio);
    }

    private static String comprobarsexAlumno(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el género del alumno (Hombre/Mujer): ");
        String sexo = sc.next();
        if (sexo.toLowerCase() != "hombre" || sexo.toLowerCase() != "mujer"){
            comprobarsexAlumno();
        }
        return sexo;

    }

    private static String comprobarsexProfesor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el género del alumno (Hombre/Mujer): ");
        String sexo = sc.next();
        if (sexo.toLowerCase() != "hombre" || sexo.toLowerCase() != "mujer"){
            comprobarsexProfesor();
        }
        return sexo;

    }

    private static void modificacionaula(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.aulas.size(); i++) {
            System.out.println(i + ". " + colegio.aulas.get(i));
        }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.aulas.size()) {
            System.out.println("¿Que opción le gustaría modificar?");
            System.out.println("1.Nombre");
            System.out.println("2.Pizarra");
            System.out.println("3.Sillas");
            System.out.println("4.Mesas");
            System.out.println("5.Estado");
            System.out.println("6.Cambiar curso");
            int res = scanner.nextInt();
            switch (res) {
                case 1 -> {
                    System.out.println("Escriba un nuevo nombre: ");
                    String nombre = scanner.next();
                    colegio.aulas.get(opcion).setNombreAula(nombre);
                    menu(colegio);
                }
                case 2 -> {
                    System.out.println("¿Tiene pizarra?");
                    String piz = scanner.next();
                    boolean pizarra;
                    if (piz.toLowerCase(Locale.ROOT) == "si") {
                        pizarra = true;
                    } else {
                        pizarra = false;
                    }
                    colegio.aulas.get(opcion).setPizarra(pizarra);
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("¿Cuantas sillas tiene?");
                    int sillas = scanner.nextInt();
                    colegio.aulas.get(opcion).setSillas(sillas);
                    menu(colegio);
                }
                case 4 -> {
                    System.out.println("¿Cuantas mesas tiene?");
                    int mesas = scanner.nextInt();
                    colegio.aulas.get(opcion).setMesas(mesas);
                    menu(colegio);
                }
                case 5 -> {
                    System.out.println("¿Cual es el estado del aula?");
                    String estado = scanner.next();
                    if (estado != EstadoAula.enObras && estado != EstadoAula.libre && estado != EstadoAula.ocupado) {
                        estado = EstadoAula.libre;
                    }
                    colegio.aulas.get(opcion).setEstado(estado);
                    menu(colegio);
                }
                case 6 -> {
                    if (colegio.aulas.get(opcion).getCurso() != null){
                        System.out.println("¿Que quieres hacer?");
                        System.out.println("1. Cambiar el curso que usa el aula");
                        System.out.println("2. Retirar el curso que usa el aula");
                        int res1 = scanner.nextInt();

                        switch (res1){
                            case 1 -> {
                                System.out.println("Elige el curso que quieres que reemplace al actual");
                                for (int i = 0; i < colegio.cursos.size(); i++) {
                                    System.out.println(i + ". " + colegio.cursos.get(i));
                                }
                                System.out.println("Seleccione una opción: ");
                                int opcion2 = scanner.nextInt();
                                colegio.aulas.get(opcion).setCurso(colegio.cursos.get(opcion2));
                            }

                            case 2 -> {
                                colegio.aulas.get(opcion).setCurso(null);
                            }
                            default -> {
                                System.out.println("¡Opción Invalida!");
                                menu(colegio);
                            }
                        }

                    }else{

                        System.out.println("¿Que curso quieres que use el aula");
                        for (int i = 0; i < colegio.cursos.size(); i++) {
                            System.out.println(i + ". " + colegio.cursos.get(i));
                        }
                        System.out.println("Seleccione una opción: ");
                        int opcion2 = scanner.nextInt();
                        colegio.aulas.get(opcion).setCurso(colegio.cursos.get(opcion2));
                    }
                    menu(colegio);
                }
                default -> {
                    System.out.println("¡Opción Invalida!");
                    menu(colegio);
                }
            }
        } else {
            System.out.println("¡Error! ¡Opción no Valida!");
            menu(colegio);
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
                    System.out.println("Escriba un nuevo nombre: ");
                    String nombre = scanner.next();
                    colegio.cursos.get(opcion).setNombre(nombre);
                    menu(colegio);
                }
                case 2 -> {
                    System.out.println("Introduzca el estado de la clase: ");
                    String estado = scanner.next();
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
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("Introduzca el DNI del alumno a ingresar en el curso: ");
                    String DNI = scanner.next();
                    Alumno alumno = colegio.getAlumno(DNI);
                    if (alumno != null) {
                        if (!colegio.cursos.get(opcion).existeAlumno(alumno)) {
                            colegio.cursos.get(opcion).anadirAlumno(alumno);
                            menu(colegio);
                        } else {
                            System.out.println("¡Ese alumno ya está en el curso!");
                            menu(colegio);
                        }
                    } else {
                        System.out.println("No existe un alumno con ese DNI");
                        menu(colegio);
                    }
                }
                case 4 -> {
                    System.out.println("Introduzca el DNI del profesor a ingresar en el curso: ");
                    String DNI = scanner.next();
                    Profesor profesor = colegio.getProfesor(DNI);
                    if (profesor != null) {
                        if (!colegio.cursos.get(opcion).existeProfesor(profesor)) {
                            colegio.cursos.get(opcion).anadirProfesor(profesor);
                            menu(colegio);
                        } else {
                            System.out.println("¡Ese profesor ya está en el curso!");
                            menu(colegio);
                        }
                    } else {
                        System.out.println("No existe un profesor con ese DNI");
                        menu(colegio);
                    }
                }
                case 5 -> {
                    System.out.println("Introduzca el DNI del alumno a borrar del curso: ");
                    String DNI = scanner.next();
                    Alumno alumno = colegio.getAlumno(DNI);
                    if (alumno != null) {
                        if (colegio.cursos.get(opcion).existeAlumno(alumno)) {
                            colegio.cursos.get(opcion).borrarAlumno(alumno);
                            menu(colegio);
                        } else {
                            System.out.println("¡Ese alumno no está en el curso!");
                            menu(colegio);
                        }
                    } else {
                        System.out.println("No existe un alumno con ese DNI");
                        menu(colegio);
                    }
                }
                case 6 -> {
                    System.out.println("Introduzca el DNI del profesor a borrar del curso: ");
                    String DNI = scanner.next();
                    Profesor profesor = colegio.getProfesor(DNI);
                    if (profesor != null) {
                        if (colegio.cursos.get(opcion).existeProfesor(profesor)) {
                            colegio.cursos.get(opcion).borrarProfesor(profesor);
                            menu(colegio);
                        } else {
                            System.out.println("¡Ese profesor no está en el curso!");
                            menu(colegio);
                        }
                    } else {
                        System.out.println("No existe un profesor con ese DNI");
                        menu(colegio);
                    }
                }
                default -> { System.out.println("¡Opción Invalida!"); }
            }
        } else { System.out.println("¡Error! ¡Opción no valida!"); }
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
                    System.out.println("Escriba un nuevo nombre: ");
                    String nombre = scanner.next();
                    colegio.profesores.get(opcion).setNombre(nombre);
                    menu(colegio);
                }
                case 2 -> {
                    System.out.println("Escriba la nueva edad: ");
                    int edad = scanner.nextInt();
                    colegio.profesores.get(opcion).setEdad(edad);
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("Escriba el nuevo sexo (HOMBRE/MUJER): ");
                    String sexo = scanner.next();
                    colegio.profesores.get(opcion).setSexo(sexo);
                    menu(colegio);
                }
                case 4 -> {
                    System.out.println("Introduzca el estado del profesor: ");
                    String estado = scanner.next();
                    colegio.profesores.get(opcion).setEstado(estado);
                    menu(colegio);
                }
                case 5 -> {
                    System.out.println("¿Que material quiere añadir?");
                    String material = scanner.next();
                    Material materialNuevo = new Material(material);
                    colegio.profesores.get(opcion).anadirMaterial(materialNuevo);
                    menu(colegio);
                }
                case 6 -> {
                    System.out.println("¿Que material quiere eliminar?");
                    String material = scanner.next();
                    Material materialABorrar = new Material(material);
                    if (colegio.profesores.get(opcion).existeMaterial(materialABorrar)) {
                        colegio.profesores.get(opcion).dejarMaterial(materialABorrar);
                        menu(colegio);
                    } else {
                        System.out.println("¡No existe ese material!");
                        menu(colegio);
                    }
                }
                case 7 -> {
                    System.out.println("¿Desea que el profesor en cuestión sea miembro directivo (SI/NO)?");
                    String opcionMiembroDirectivo = scanner.next();
                    if (opcionMiembroDirectivo.toLowerCase() == "si") {
                        colegio.profesores.get(opcion).setMiembroDirectivo(true);
                        menu(colegio);
                    } else if (opcionMiembroDirectivo.toLowerCase() == "no") {
                        colegio.profesores.get(opcion).setMiembroDirectivo(false);
                        menu(colegio);
                    } else {
                        System.out.println("¡Error! ¡Opción no valida!");
                        menu(colegio);
                    }
                }
                default -> {
                    System.out.println("¡Opción Invalida!");
                    menu(colegio);
                }
            }
        } else {
            System.out.println("¡Error! ¡Opción no valida!");
            menu(colegio);
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
                    String nombre = scanner.next();
                    colegio.alumnos.get(opcion).setNombre(nombre);
                    menu(colegio);
                }
                case 2 -> {
                    System.out.println("Escriba la nueva edad: ");
                    int edad = scanner.nextInt();
                    colegio.alumnos.get(opcion).setEdad(edad);
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("Escriba el nuevo sexo (HOMBRE/MUJER): ");
                    String sexo = scanner.next();
                    colegio.alumnos.get(opcion).setSexo(sexo);
                    menu(colegio);
                }
                case 4 -> {
                    System.out.println("Introduzca el estado del alumno: ");
                    String estado = scanner.next();
                    colegio.alumnos.get(opcion).setEstado(estado);
                    menu(colegio);
                }
                case 5 -> {
                    System.out.println("¿Que material quiere añadir?");
                    String material = scanner.next();
                    Material materialNuevo = new Material(material);
                    colegio.alumnos.get(opcion).anadirMaterial(materialNuevo);
                    menu(colegio);
                }
                case 6 -> {
                    System.out.println("¿Que material quiere eliminar?");
                    String material = scanner.next();
                    Material materialABorrar = new Material(material);
                    if (colegio.alumnos.get(opcion).existeMaterial(materialABorrar)) {
                        colegio.alumnos.get(opcion).dejarMaterial(materialABorrar);
                        menu(colegio);
                    } else {
                        System.out.println("¡No existe ese material!");
                        menu(colegio);
                    }
                }
                default -> {
                    System.out.println("¡Opción Invalida!");
                    menu(colegio);
                }
            }
        } else {
            System.out.println("¡Error! ¡Opción no valida!");
            menu(colegio);
        }
    }

    private static void borraraula(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.aulas.size(); i++) { System.out.println(i + ". " + colegio.aulas.get(i)); }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.aulas.size()) {
            colegio.eliminarAula(opcion);
            System.out.println("Se ha eliminado correctamente");
            menu(colegio);
        }else{
            System.out.println("¡No existe esa opción!");
            menu(colegio);
        }
    }

    private static void borrarcurso(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.cursos.size(); i++) { System.out.println(i + ". " + colegio.cursos.get(i)); }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.cursos.size()) {
            colegio.eliminarCurso(opcion);
            System.out.println("Se ha eliminado correctamente");
            menu(colegio);
        }else{
            System.out.println("¡No existe esa opción!");
            menu(colegio);
        }
    }

    private static void borrarprofesor(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.profesores.size(); i++) { System.out.println(i + ". " + colegio.profesores.get(i)); }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.profesores.size()) {
            colegio.eliminarProfesores(opcion);
            System.out.println("Se ha eliminado correctamente");
            menu(colegio);
        }else{
            System.out.println("¡No existe esa opción!");
            menu(colegio);
        }
    }

    private static void borraralumno(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < colegio.alumnos.size(); i++) { System.out.println(i + ". " + colegio.alumnos.get(i)); }
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (opcion < colegio.alumnos.size()) {
            colegio.eliminarAlumnos(opcion);
            System.out.println("Se ha eliminado correctamente");
            menu(colegio);
        }else{
            System.out.println("¡No existe esa opción!");
            menu(colegio);
        }
    }

    private static void mostrartodo(Colegio colegio){
        System.out.println("AULAS\n");
        System.out.println(colegio.mostrarAula());
        System.out.println("CURSOS\n");
        System.out.println(colegio.mostrarCurso());
        System.out.println("ALUMNOS\n");
        System.out.println(colegio.mostrarAlumno());
        System.out.println("PROFESORES\n");
        System.out.println(colegio.mostrarProfesor());
        menu(colegio);
    }

    private static void cerrarsesion(){
        System.out.println("¡Adiós!");
        System.exit(0);
    }

}

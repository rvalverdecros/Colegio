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
            case 14 -> {
            	scanner.close();
            	cerrarsesion();}
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

        switch (estado){
            case EstadoAula.enObras, EstadoAula.libre, EstadoAula.ocupado -> {}

            default -> estado = EstadoAula.libre;
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
        System.out.println("Introduzca el género del profesor (Hombre/Mujer): ");
        String genero = sc.next();
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
        System.out.println("Introduzca el género del alumno (Hombre/Mujer): ");
        String sexo = sc.next();
        System.out.println("Introduzca el DNI del alumno: ");
        String dni = sc.next();

        Alumno alumnoNuevo = new Alumno(dni, nombre, edad, sexo);

        colegio.anadirAlumno(alumnoNuevo);
        menu(colegio);
    }

    private static void modificacionaula(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(colegio.mostrarAula());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findAula(opcion) != null) {
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
                    colegio.findAula(opcion).setNombreAula(nombre);
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
                    colegio.findAula(opcion).setPizarra(pizarra);
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("¿Cuantas sillas tiene?");
                    int sillas = scanner.nextInt();
                    colegio.findAula(opcion).setSillas(sillas);
                    menu(colegio);
                }
                case 4 -> {
                    System.out.println("¿Cuantas mesas tiene?");
                    int mesas = scanner.nextInt();
                    colegio.findAula(opcion).setMesas(mesas);
                    menu(colegio);
                }
                case 5 -> {
                    System.out.println("¿Cual es el estado del aula?");
                    String estado = scanner.next();

                    switch (estado){
                        case EstadoAula.enObras, EstadoAula.libre, EstadoAula.ocupado -> {}

                        default -> {estado = EstadoAula.libre;}
                    }

                    colegio.findAula(opcion).setEstado(estado);
                    menu(colegio);
                }
                case 6 -> {
                    if (colegio.findAula(opcion).getCurso() != null){
                        System.out.println("¿Que quieres hacer?");
                        System.out.println("1. Cambiar el curso que usa el aula");
                        System.out.println("2. Retirar el curso que usa el aula");
                        int res1 = scanner.nextInt();

                        switch (res1){
                            case 1 -> {
                                System.out.println("Elige el curso que quieres que reemplace al actual");
                                System.out.println(colegio.mostrarCurso());
                                System.out.println("Seleccione una opción: ");
                                int opcion2 = scanner.nextInt();
                                colegio.findAula(opcion).setCurso(colegio.findCurso(opcion2));
                            }

                            case 2 -> {
                                colegio.findAula(opcion).setCurso(null);
                            }
                            default -> {
                                System.out.println("¡Opción Invalida!");
                                menu(colegio);
                            }
                        }

                    }else{

                        System.out.println("¿Que curso quieres que use el aula");
                        System.out.println(colegio.mostrarCurso());
                        System.out.println("Seleccione una opción: ");
                        int opcion2 = scanner.nextInt();
                        colegio.findAula(opcion).setCurso(colegio.findCurso(opcion2));
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
        System.out.println(colegio.mostrarCurso());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findCurso(opcion) != null) {
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
                    colegio.findCurso(opcion).setNombre(nombre);
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
                    colegio.findCurso(opcion).setEstado(estadoCurso);
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("Introduzca la id del alumno a ingresar en el curso: ");
                    int id = scanner.nextInt();
                    Alumno alumno = colegio.findAlumno(id);
                    if (alumno != null) {
                        if (!colegio.findCurso(opcion).existeAlumno(alumno)) {
                            colegio.findCurso(opcion).anadirAlumno(alumno);
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
                    System.out.println("Introduzca la id del profesor a ingresar en el curso: ");
                    int id = scanner.nextInt();
                    Profesor profesor = colegio.findProfesor(id);
                    if (profesor != null) {
                        if (!colegio.findCurso(opcion).existeProfesor(profesor)) {
                            colegio.findCurso(opcion).anadirProfesor(profesor);
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
                    System.out.println("Introduzca la id del alumno a borrar del curso: ");
                    int id = scanner.nextInt();
                    Alumno alumno = colegio.findAlumno(id);
                    if (alumno != null) {
                        if (colegio.findCurso(opcion).existeAlumno(alumno)) {
                            colegio.findCurso(opcion).borrarAlumno(alumno);
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
                    System.out.println("Introduzca la id del profesor a borrar del curso: ");
                    int id = scanner.nextInt();
                    Profesor profesor = colegio.findProfesor(id);
                    if (profesor != null) {
                        if (colegio.findCurso(opcion).existeProfesor(profesor)) {
                            colegio.findCurso(opcion).borrarProfesor(profesor);
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
        System.out.println(colegio.mostrarProfesor());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findProfesor(opcion) != null) {
            System.out.println("¿Que opción le gustaría modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. DNI");
            System.out.println("3. Edad");
            System.out.println("4. Sexo");
            System.out.println("5. Estado");
            System.out.println("6. Añadir un material");
            System.out.println("7. Borrar un material");
            System.out.println("8. Cambiar estatus del profesor (Es o no un miembro directivo)");
            int res = scanner.nextInt();
            switch (res) {
                case 1 -> {
                    System.out.println("Escriba un nuevo nombre: ");
                    String nombre = scanner.next();
                    colegio.findProfesor(opcion).setNombreProfesor(nombre);
                    menu(colegio);
                }
                case 2 -> {
                    System.out.println("Escriba un nuevo dni: ");
                    String dni = scanner.next();
                    colegio.findProfesor(opcion).setDNIProfesor(dni);
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("Escriba la nueva edad: ");
                    int edad = scanner.nextInt();
                    colegio.findProfesor(opcion).setEdadProfesor(edad);
                    menu(colegio);
                }
                case 4 -> {
                    System.out.println("Escriba el nuevo sexo (HOMBRE/MUJER): ");
                    String sexo = scanner.next();
                    colegio.findProfesor(opcion).setSexoProfesor(sexo);
                    menu(colegio);
                }
                case 5 -> {
                    System.out.println("Introduzca el estado del profesor: ");
                    String estado = scanner.next();
                    colegio.findProfesor(opcion).setEstadoProfesor(estado);
                    menu(colegio);
                }
                case 6 -> {
                    System.out.println("¿Que material quiere añadir?");
                    String material = scanner.next();
                    Material materialNuevo = new Material(material);
                    colegio.findProfesor(opcion).anadirMaterialProfesor(materialNuevo);
                    menu(colegio);
                }
                case 7 -> {
                    System.out.println("¿Que material quiere eliminar?");
                    String material = scanner.next();
                    Material materialABorrar = new Material(material);
                    if (colegio.findProfesor(opcion).existeMaterialProfesor(materialABorrar)) {
                        colegio.findProfesor(opcion).dejarMaterialProfesor(materialABorrar);
                        menu(colegio);
                    } else {
                        System.out.println("¡No existe ese material!");
                        menu(colegio);
                    }
                }
                case 8 -> {
                    System.out.println("¿Desea que el profesor en cuestión sea miembro directivo (SI/NO)?");
                    String opcionMiembroDirectivo = scanner.next();
                    if (opcionMiembroDirectivo.toLowerCase() == "si") {
                        colegio.findProfesor(opcion).setMiembroDirectivo(true);
                        menu(colegio);
                    } else if (opcionMiembroDirectivo.toLowerCase() == "no") {
                        colegio.findProfesor(opcion).setMiembroDirectivo(false);
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
        System.out.println(colegio.mostrarAlumno());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findAlumno(opcion) != null) {
            System.out.println("¿Que opción le gustaría modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. DNI");
            System.out.println("3. Edad");
            System.out.println("4. Sexo");
            System.out.println("5. Estado");
            System.out.println("6. Añadir un material");
            System.out.println("7. Borrar un material");
            int res = scanner.nextInt();
            switch (res) {
                case 1 -> {
                    System.out.println("Escriba un nuevo nombre: ");
                    String nombre = scanner.next();
                    colegio.findAlumno(opcion).setNombreAlumno(nombre);
                    menu(colegio);
                }
                case 2 -> {
                    System.out.println("Escriba un nuevo nombre: ");
                    String dni = scanner.next();
                    colegio.findAlumno(opcion).setDNIAlumno(dni);
                    menu(colegio);
                }
                case 3 -> {
                    System.out.println("Escriba la nueva edad: ");
                    int edad = scanner.nextInt();
                    colegio.findAlumno(opcion).setEdadAlumno(edad);
                    menu(colegio);
                }
                case 4 -> {
                    System.out.println("Escriba el nuevo sexo (HOMBRE/MUJER): ");
                    String sexo = scanner.next();
                    colegio.findAlumno(opcion).setSexoAlumno(sexo);
                    menu(colegio);
                }
                case 5 -> {
                    System.out.println("Introduzca el estado del alumno: ");
                    String estado = scanner.next();
                    colegio.findAlumno(opcion).setEstadoAlumno(estado);
                    menu(colegio);
                }
                case 6 -> {
                    System.out.println("¿Que material quiere añadir?");
                    String material = scanner.next();
                    Material materialNuevo = new Material(material);
                    colegio.findAlumno(opcion).anadirMaterialAlumno(materialNuevo);
                    menu(colegio);
                }
                case 7 -> {
                    System.out.println("¿Que material quiere eliminar?");
                    String material = scanner.next();
                    Material materialABorrar = new Material(material);
                    if (colegio.findAlumno(opcion).existeMaterialAlumno(materialABorrar)) {
                        colegio.findAlumno(opcion).dejarMaterialAlumno(materialABorrar);
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
        System.out.println(colegio.mostrarAula());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findAula(opcion) != null) {
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
        System.out.println(colegio.mostrarCurso());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findCurso(opcion) != null) {
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
        System.out.println(colegio.mostrarProfesor());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findProfesor(opcion) != null) {
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
        System.out.println(colegio.mostrarAlumno());
        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        if (colegio.findAlumno(opcion) != null) {
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

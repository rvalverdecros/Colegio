import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public void menu() {

        Colegio colegio = new Colegio("IES Rafael Alberti");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido usuari@");
        System.out.println("¿Que opcion le gustaría escoger?");
        opciones();
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1 -> {
                creacionaula(colegio);
            }
            case 2 -> {
                creacioncurso(colegio);
            }
            case 3 -> {
                creacionprofesor(colegio);
            }
            case 4 -> {
                creacionalumno(colegio);
            }
            case 5 -> {
                modificacionaula(colegio);
            }
            case 6 -> {
                modificacioncurso(colegio);
            }
            case 7 -> {
                modificacionprofesor(colegio);
            }
            case 8 -> {
                modificacionalumno(colegio);
            }
            case 9 -> {
                borraraula(colegio);
            }
            case 10 -> {
                borrarcurso(colegio);
            }
            case 11 -> {
                borrarprofesor(colegio);
            }
            case 12 -> {
                borraralumno(colegio);
            }
            case 13 -> {
                mostrartodo(colegio);
            }
            case 14 -> {
                cerrarsesion();
            }
            default -> {
                System.out.println("Opcion Invalida!");
            }
        }

    }

    private void opciones() {
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

    private void creacionaula(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el nombre del Aula");
        String nombre = scanner.nextLine();
        System.out.println("¿Tiene pizarra?");
        String res = scanner.nextLine();
        boolean pizarra;
        if (res.toLowerCase(Locale.ROOT) == "si") {
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
        colegio.anadirAula(aula);
    }

    private void creacioncurso(Colegio colegio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el nombre del curso: ");
        String nombre = scanner.nextLine();

        Curso cursoNuevo = new Curso(nombre);
        colegio.anadirCurso(cursoNuevo);
    }

    private void creacionprofesor(Colegio colegio) {
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

    private void creacionalumno(Colegio colegio) {
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

    private void modificacionaula(Colegio colegio) {
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
                    System.out.println("Opcion Invalida!");
                }
            }
        } else {
            System.out.println("Error!. Opcion no Valida!");
        }
    }

    private void borraraula(Colegio colegio) {
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

    private void borrarcurso(Colegio colegio) {
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

    private void borrarprofesor(Colegio colegio) {
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

    private void borraralumno(Colegio colegio) {
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

    private void mostrartodo(Colegio colegio){
        System.out.println("Aulas");
        colegio.mostrarAula();
        System.out.println("Cursos");
        colegio.mostrarCurso();
        System.out.println("Alumnos");
        colegio.mostrarAlumno();
        System.out.println("Profesores");
        colegio.mostrarProfesor();
    }

    private void cerrarsesion(){
        System.out.println("Adios!");
        System.exit(0);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
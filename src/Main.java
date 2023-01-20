import java.util.Scanner;

public class Main {

    public void menu(){

        Colegio colegio = new Colegio("IES Rafael Alberti");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido usuari@");
        System.out.println("¿Que opcion le gustaría escoger?");
        opciones();


    }

    private void opciones(){
        System.out.println("1. Creación de aula");
        System.out.println("2. Creación de curso");
        System.out.println("3. Creación de profesor");
        System.out.println("4. Creación de alumno");
        System.out.println("5. Modificacion de aula");
        System.out.println("6. Modificacion de curso");
        System.out.println("7. Modificacion de profesor");
        System.out.println("8. Modificacion de alumno");
        System.out.println("9. Borrar un aula");
        System.out.println("10. Borrar un curso");
        System.out.println("11. Borrar un profesor");
        System.out.println("12. Borrar un alumno");
        System.out.println("13. Mostrar todo");
        System.out.println("14. Cerrar Sesión");
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
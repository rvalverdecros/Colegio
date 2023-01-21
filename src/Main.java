import java.util.Locale;
import java.util.Scanner;

public class Main {

    public void menu(){

        Colegio colegio = new Colegio("IES Rafael Alberti");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido usuari@");
        System.out.println("¿Que opcion le gustaría escoger?");
        opciones();
        int opcion = scanner.nextInt();
        switch (opcion){
            case 1 -> {creacionaula(colegio);}
            case 2 -> {creacioncurso(colegio);}
            case 3 -> {creacionprofesor(colegio);}
            case 4 -> {creacionalumno(colegio);}
            case 5 -> {modificacionaula(colegio);}
            case 6 -> {modificacioncurso(colegio);}
            case 7 -> {modificacionprofesor(colegio);}
            case 8 -> {modificacionalumno(colegio);}
            case 9 -> {borraraula(colegio);}
            case 10 -> {borrarcurso(colegio);}
            case 11 -> {borrarprofesor(colegio);}
            case 12 -> {borraralumno(colegio);}
            case 13 -> {mostrartodo(colegio);}
            case 14 -> {cerrarsesion();}
            default -> {
                System.out.println("Opcion Invalida!");
            }
        }

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

    private void creacionaula(Colegio colegio){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escriba el nombre del Aula");
        String nombre = scanner.nextLine();
        System.out.println("¿Tiene pizarra?");
        String res = scanner.nextLine();
        boolean pizarra;
        if (res.toLowerCase(Locale.ROOT) == "si"){
            pizarra = true;
        }else{
            pizarra = false;
        }
        System.out.println("¿Cuantas sillas tiene el aula?");
        int sillas = scanner.nextInt();
        System.out.println("¿Cuantas mesas tiene el aula?");
        int mesas = scanner.nextInt();
        System.out.println("¿Cual es el estado del aula?");
        String estado = scanner.nextLine();
        if (estado != EstadoAula.enObras || estado != EstadoAula.libre|| estado!=EstadoAula.ocupado){
            estado = EstadoAula.libre;
        }
        Aula aula = new Aula(nombre,pizarra,sillas,mesas);
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
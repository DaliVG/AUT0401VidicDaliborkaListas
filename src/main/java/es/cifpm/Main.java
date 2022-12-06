package es.cifpm;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static es.cifpm.Funciones.*;

public class Main {

    public static List<Farmacia> sucursales = new ArrayList<Farmacia>();
    public static Persistencia pst = new impPersistenciaVidic();
    public static void main(String[] args) {


        File fileName= new File("farmacias_v1.json");





        pst.open();
        Menu();
        IntroOpcion();
        MenuAdios();
        IntroOpcionAdios();
    }
    public static void Menu() {

        System.out.println("------------------------------------");
        System.out.println("---------------- MENU --------------");
        System.out.println("------------------------------------");
        System.out.println("1. Buscar por nombre.");
        System.out.println("2. Lista de farmacias disponibles.");
        System.out.println("0. Salir.");
        System.out.println("------------------------------------");
        System.out.println("9. Admin");

    }
    public static void IntroOpcion(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la opción que desea: ");
        int option = sc.nextInt();

        switch(option) {
            case 1:
                Buscar(pst.list());
                break;
            case 2:
                MostradoFarmacias(pst.list());
                break;
            case 0:
                pst.close();
                break;
            case 9:
                MenuAdmin();
                IntroOpcionAdmin();
                break;
            default:
                System.out.println("No ha introducido una opción válida.");
        }
    }

    public static void IntroOpcionAdmin(){

        Scanner sc = new Scanner(System.in);

        System.out.println("ADMIN: Introduzca la opción que desea: ");
        int option = sc.nextInt();

        switch(option) {
            case 1:
               pst.add(IntroducirFarmacia());
                break;
            case 2:
                pst.delete(BorrarFarmacia(pst.list()));
            case 3:
                MostradoFarmacias(pst.list());
                break;
            case 0:
                pst.close();
                break;
            default:
                System.out.println("No ha introducido una opción válida.");
        }
    }
    public static void IntroOpcionAdios(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la opción que desea: ");
        int option = sc.nextInt();

        switch(option) {
            case 1:
                Menu();
                IntroOpcion();
                break;
            case 0:
                pst.close();
                System.out.println("Adioooooooos");
                break;
            default:
                System.out.println("No ha introducido una opción válida.");
        }
    }

    public static void MenuAdmin() {

        System.out.println("------------------------------------");
        System.out.println("---------------- MENU --------------");
        System.out.println("------------------------------------");
        System.out.println("1. Añadir farmacia.");
        System.out.println("2. Borrar farmacia.");
        System.out.println("3. Listar farmacia.");
        System.out.println("------------------------------------");
        System.out.println("0. Salir");
    }

    public static void MenuAdios() {

        System.out.println("------------------------------------");
        System.out.println("¿Desea realizar alguna otra consulta?");
        System.out.println("------------------------------------");
        System.out.println("1. Si");
        System.out.println("0. Adiós");
        System.out.println("------------------------------------");
    }
}
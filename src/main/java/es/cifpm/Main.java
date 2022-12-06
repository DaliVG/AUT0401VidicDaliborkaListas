package es.cifpm;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import static es.cifpm.Funciones.*;

public class Main {

    public static Persistencia pst = new impPersistenciaVidic();
    public static void main(String[] args) {

        Menu();
        IntroOpcion();

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
}
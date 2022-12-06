package es.cifpm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static es.cifpm.Funciones.*;

public class VidicGutierrezDaliborkaFarmacias {

    public static List<Farmacia> sucursales = new ArrayList<Farmacia>();
    public static Persistencia pst = new impPersistenciaVidic();
    public static void main(String[] args) {

        pst.openJSON();
        Menu();
        IntroOpcion();
        MenuAdios();
        IntroOpcionAdios();
        pst.close();
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

        switch (option) {
            case 1 -> Buscar(pst.list());
            case 2 -> MostradoFarmacias(pst.list());
            case 0 -> System.exit(0);
            case 9 -> {
                MenuAdmin();
                IntroOpcionAdmin();
            }
            default -> System.out.println("No ha introducido una opción válida.");
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
                System.exit(0);
                break;
            default:
                System.out.println("No ha introducido una opción válida.");
        }
    }
    public static void IntroOpcionAdios(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la opción que desea: ");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> {
                Menu();
                IntroOpcion();
            }
            case 0 -> {
                System.exit(0);
                System.out.println("Adioooooooos");
            }
            default -> System.out.println("No ha introducido una opción válida.");
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

    public static void LimpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
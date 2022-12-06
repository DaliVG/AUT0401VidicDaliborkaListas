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
        pst.closeJSON();
    }
    public static void IntroOpcion(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la opción que desea: ");
        int option = sc.nextInt();

        switch (option) {
            case 1 -> {Buscar(pst.list());
                MenuAdios();
                IntroOpcionAdios();}
            case 2 -> {MostradoFarmacias(pst.list());
                MenuAdios();
                IntroOpcionAdios();}
            case 0 -> {MenuAdios();IntroOpcionAdios();}
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
                MenuAdios();
                IntroOpcionAdios();
                break;
            case 2:
                pst.delete(BorrarFarmacia(pst.list()));
                MenuAdios();
                IntroOpcionAdios();
            case 3:
                MostradoFarmacias(pst.list());
                MenuAdios();
                IntroOpcionAdios();
                break;
            case 0:
                MenuAdios();
                IntroOpcionAdios();
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
            case 2 -> {
                pst.closeJSON();
                System.out.println("Adioooooooos");
                System.exit(0);
            }
            case 0 -> {
                System.out.println("Adioooooooos");
                System.exit(0);
            }
            default -> System.out.println("No ha introducido una opción válida.");
        }
    }
    public static void Menu() {
        StringBuilder print = new StringBuilder("---------- Menú ----------\n");
        print.append("------------------------------------");
        print.append("1. Buscar por nombre.");
        print.append("2. Lista de farmacias disponibles.");
        print.append("0. Salir.");
        print.append("------------------------------------");
        print.append("9. Admin");
    }
    public static void MenuAdmin() {
        StringBuilder print = new StringBuilder("---------- Menú ----------\n");
        print.append("------------------------------------");
        print.append("1. Añadir farmacia.");
        print.append("2. Borrar farmacia.");
        print.append("3. Listar farmacia.");
        print.append("------------------------------------");
        print.append("0. Salir");
    }
    public static void MenuAdios() {
        StringBuilder print = new StringBuilder("---------- Menú ----------\n");
        print.append("------------------------------------");
        print.append("¿Desea realizar alguna otra consulta?");
        print.append("------------------------------------");
        print.append("1. Si");
        print.append("2. Salir y guardar.");
        print.append("0. Adiós.");
        print.append("------------------------------------");
    }
    public static void LimpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
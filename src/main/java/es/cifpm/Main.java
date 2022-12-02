package es.cifpm;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import static es.cifpm.Funciones.IntroducirFarmacia;
import static es.cifpm.Funciones.MostradoFarmacias;

public class Main {

    public static Persistencia pst = new impPersistenciaVidic();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Farmacia> sucursales = new ArrayList<Farmacia>();

        boolean validOpen = pst.open();
        System.out.println(validOpen);

        System.out.println("Desea introducir una farmacia o mostrar la lista? L = List, F = Intro");
        String opcion = sc.nextLine();

        if (opcion.equals("F")){

            IntroducirFarmacia(sucursales);

        } else if (opcion.equals("L")){

            MostradoFarmacias(sucursales);

        } else {

            System.out.println("no ha introducido una selección válida.");

        }
    }
}
package es.cifpm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Funciones {
    static Scanner sc = new Scanner(System.in);
    public static Farmacia IntroducirFarmacia() {

        boolean ok = true;
        boolean valid=false;
        Farmacia sucursal = null;
        String nombre = null;
        String telefono = null;
        float ux;
        float uy;
        String web = null;
        System.out.println("Introduzca el nombre de la farmacia: ");

        nombre = sc.nextLine();

        do {

            if (IntroducirData(nombre, ok)) {

                System.out.println("Introduzca el telefono de la farmacia: ");

                telefono = sc.nextLine();

            }
            if (IntroducirData(telefono, ok)) {

                System.out.println("Introduzca la web de la farmacia: ");
                web = sc.nextLine();

            }
            if (IntroducirData(web, ok)) {

                System.out.println("Introduzca las cordenadas de la farmacia: ");
                System.out.println("Introduzca las UX de la farmacia: ");
                ux = ComprobacionFloat(sc.nextLine());

                System.out.println("Introduzca las UY de la farmacia: ");
                uy = ComprobacionFloat(sc.nextLine());

                sucursal = new Farmacia(nombre, telefono, ux, uy, web);
                System.out.println("Se ha creado la siguiente farmacia: " + sucursal.nombre);
                valid = true;
            }
        }
        while (!valid);

        return sucursal;
    }

    private static Float ComprobacionFloat(String coordenadas) {

        try {

            Float.parseFloat(coordenadas);

        } catch (Exception e) {

            System.out.println("No ha introducido las coordenadas correctamente.");

        }
        return Float.parseFloat(coordenadas);
    }

    private static boolean IntroducirData(String data, boolean ok) {

        if (!data.equals("")) {
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }
    public static Farmacia BorrarFarmacia (List < Farmacia > sucursales) {

            Farmacia sucursalBorrar = null;
            String nombre = "";

            Buscar(sucursales);

            System.out.println("¿Qué farmacia desea eliminar?: ");
            nombre = sc.nextLine();

            for (Farmacia sucursal : sucursales) {
                if (sucursal.nombre.equals(nombre)) {
                    sucursalBorrar = sucursal;
                }
            }

            return sucursalBorrar;
    }

    public static void Buscar (List < Farmacia > sucursales) {

            String nombre = "";
            System.out.println("Introduzca el nombre de la farmacia que desea buscar: ");
            nombre = (sc.nextLine()).toUpperCase();
            System.out.println("Hemos obtenido los siguientes resultados: ");

            List<Farmacia> searchResult = new ArrayList<Farmacia>();

            for (Farmacia sucursal : sucursales) {
                if ((sucursal.nombre).toUpperCase().contains(nombre)) {
                    searchResult.add(sucursal);
                }
            }

            MostradoFarmacias(searchResult);
    }
    public static void MostradoFarmacias (List < Farmacia > sucursales) {

            for (Farmacia sucursal : sucursales
            ) {
                System.out.println("Nombre: " + sucursal.nombre + " Tlfno: " + sucursal.telefono + " Coordenadas: Ux " + sucursal.Ux + " Uy " + sucursal.Uy + " web: " + sucursal.web);
            }
    }
}


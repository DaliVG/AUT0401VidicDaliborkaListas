package es.cifpm;

import java.util.List;
import java.util.Scanner;

public class Funciones {
    public static void IntroducirFarmacia(List<Farmacia> sucursales){
        Scanner sc = new Scanner(System.in);
        boolean ok = false;
        String nombre="";
        System.out.println("Introduzca el nombre de la farmacia: ");

        nombre = sc.nextLine();
        do{
            if (nombre==""){
                System.out.println("Debe introducir un nombre.");
            } else{
                System.out.println("Nombre introducido");

                System.out.println("Introduzca el telefono de la farmacia: ");
                String telefono = sc.nextLine();

                if (telefono == ""){
                    System.out.println("Debe introducir un telefono.");
                } else{
                    System.out.println("Telefono introducido");

                    System.out.println("Introduzca la web de la farmacia: ");
                    String web = sc.nextLine();

                    if (telefono == ""){
                        System.out.println("Debe introducir una web.");
                    } else{
                        System.out.println("Web introducida");

                        System.out.println("Introduzca las cordenadas de la farmacia: ");
                        System.out.println("Introduzca las UX de la farmacia: ");
                        Float ux = sc.nextFloat();
                        System.out.println("Introduzca las UY de la farmacia: ");
                        Float uy = sc.nextFloat();
                        sucursales.add(CreacionFarmacia(nombre, telefono, ux, uy, web));
                        ok = true;
                    }
                }
            }
        }
        while (!ok);
    }

    private static Farmacia CreacionFarmacia(String nombre, String telefono, Float ux, Float uy, String web){
        Farmacia sucursal = new Farmacia(nombre, telefono, ux, uy, web);
        return sucursal;
    }

    public static void MostradoFarmacias(List<Farmacia> sucursales){



        for (Farmacia sucursal: sucursales
        ) {
            System.out.println("Nombre: "+sucursal.nombre+" Tlfno: "+sucursal.telefono+ "Coordenadas: Ux"+sucursal.Ux +" Uy"+sucursal.Uy+" web: "+sucursal.web);
        }
    }
}

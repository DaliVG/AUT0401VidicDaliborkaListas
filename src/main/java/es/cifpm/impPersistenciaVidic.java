package es.cifpm;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class impPersistenciaVidic implements Persistencia{

    public static List<Farmacia> sucursales = new ArrayList<Farmacia>();

    @Override
    public boolean openJSON() {

        boolean validOpen = true;

        File fileName= new File("VidicDaliborka_farmacias.json");

        if (fileName.exists()){
            try {
                FileReader fileReader = new FileReader(fileName);
                Type type = new TypeToken<List<Farmacia>>(){}.getType();
                Gson gson = new Gson();
                sucursales = gson.fromJson(fileReader, type);
                fileReader.close();
            } catch (FileNotFoundException e){
                validOpen=false;
                System.err.println("Error en creacion del fichero");
            } catch (IOException e) {
                validOpen=false;
                System.err.println("Error en cerrado del fichero");
            }
        } else {

            sucursales = new ArrayList<>();
            sucursales.add(new Farmacia("Ofra", "922165658", 5.65f, 3.25f, "www.jajaejje.es"));
            sucursales.add(new Farmacia("Meridiano", "922005658", 5.65f, 3.25f, "www.meri.es"));
            sucursales.add(new Farmacia("Gran Tarajal", "928165658", 5.65f, 3.25f, "www.gt.es"));

            try {
                FileWriter fileWriter = new FileWriter(fileName);
                Gson gson = new Gson();
                gson.toJson(sucursales, fileWriter);
                fileWriter.close();

            } catch (FileNotFoundException e){
                validOpen=false;
                System.err.println("Error en escribir el fichero");
            } catch (IOException e) {
                validOpen=false;
                System.err.println("Error en cerrado del fichero");
            }
        }

        return validOpen;
    }

    @Override
    public boolean closeJSON() {
        boolean validOpen = true;
        File fileName= new File("VidicDaliborka_farmacias.json");
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            Gson gson = new Gson();
            gson.toJson(sucursales, fileWriter);
            fileWriter.close();

        } catch (FileNotFoundException e){

            System.err.println("Error en escribir el fichero");
            validOpen=false;
        } catch (IOException e) {

            System.err.println("Error en cerrado del fichero");
            validOpen=false;
        }
        return false;
    }

    @Override
    public boolean add(Farmacia sucursal) {
        try {

            sucursales.add(sucursal);

        } catch (Exception e){

            return false;

        }
        return true;
    }

    @Override
    public boolean delete(Farmacia sucursal) {
        try{

            sucursales.remove(sucursal);
            System.out.println("Se ha borrado con exito.");

        } catch (Exception e){

            return false;
        }

        return true;
    }

    @Override
    public List<Farmacia> list() {

        return sucursales;

    }
}

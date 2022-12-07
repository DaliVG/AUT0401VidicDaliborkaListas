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
    public boolean openJSON(){

        String fileName = ("VidicDaliborka_farmacias.json");
        File fileDone = new File(System.getProperty("java.io.tmpdir")+fileName);
            try {
                FileReader fileReader = new FileReader(fileDone);
                Type type = new TypeToken<List<Farmacia>>(){}.getType();
                Gson gson = new Gson();
                sucursales = gson.fromJson(fileReader, type);
                fileReader.close();
            } catch (FileNotFoundException e){
                System.err.println("No se ha encontrado un fichero.");
                return false;
            } catch (IOException e) {
                System.err.println("Error en cerrado del fichero");
                return false;
            }

        return true;
    }
    @Override
    public boolean closeJSON(){
        boolean validOpen = true;

        try {
            String fileName= "VidicDaliborka_farmacias.json";
            FileWriter fileWriter = new FileWriter((System.getProperty("java.io.tmpdir")+fileName), true);
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
        return validOpen;
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

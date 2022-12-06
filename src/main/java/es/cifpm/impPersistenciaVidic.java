package es.cifpm;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class impPersistenciaVidic implements Persistencia{

    public static List<Farmacia> sucursales = new ArrayList<Farmacia>();
    @Override
    public boolean open() {

        boolean validOpen = true;


        return validOpen;
    }

    @Override
    public boolean close() {
        return false;
    }

    @Override
    public boolean add(Farmacia sucursal) {
        try{

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

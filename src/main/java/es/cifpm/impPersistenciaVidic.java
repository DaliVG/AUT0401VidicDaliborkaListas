package es.cifpm;

import java.util.ArrayList;
import java.util.List;

public class impPersistenciaVidic implements Persistencia{

    List<Farmacia> sucursales = new ArrayList<Farmacia>();
    @Override
    public boolean open() {

        boolean validOpen = true;

        sucursales.add(new Farmacia("Ofra", "922165658", 5.65f, 3.25f, "www.jajaejje.es"));
        sucursales.add(new Farmacia("Meridiano", "922005658", 5.65f, 3.25f, "www.meri.es"));
        sucursales.add(new Farmacia("Gran Tarajal", "928165658", 5.65f, 3.25f, "www.gt.es"));

        if (sucursales.size()!=3) {
            validOpen=false;
        }
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
        } catch (Exception e){
            return false;
        }
        System.out.println("Se ha borrado con exito.");
        return true;
    }

    @Override
    public List<Farmacia> list() {
        return sucursales;
    }
}

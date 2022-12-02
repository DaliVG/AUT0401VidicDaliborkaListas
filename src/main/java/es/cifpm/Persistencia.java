package es.cifpm;

import java.util.ArrayList;
import java.util.List;

public interface Persistencia {
    public boolean open();

    public boolean close();

    public boolean add();

    public boolean delete(Farmacia sucursal);

    public List<Farmacia> sucursales(Farmacia sucursal);
}

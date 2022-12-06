package es.cifpm;

import java.util.ArrayList;
import java.util.List;

public interface Persistencia {
    boolean openJSON();

    boolean close();

    boolean add(Farmacia sucursal);

    boolean delete(Farmacia sucursal);

    List<Farmacia> list();
}

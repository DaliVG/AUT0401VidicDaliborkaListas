package es.cifpm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Persistencia {
    boolean openJSON();

    boolean closeJSON();

    boolean add(Farmacia sucursal);

    boolean delete(Farmacia sucursal);

    List<Farmacia> list();
}

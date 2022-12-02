package es.cifpm;

import java.util.List;

public class impPersistenciaVidic implements Persistencia{

    @Override
    public boolean open() {
        return false;
    }

    @Override
    public boolean close() {
        return false;
    }

    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean delete(Farmacia sucursal) {
        return false;
    }

    @Override
    public List<Farmacia> sucursales(Farmacia sucursal) {
        return null;
    }
}

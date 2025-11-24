package main.java.infrastructure.adapters.out.emisoras;

import main.java.application.usecases.emisoras.EmisoraRepository;
import main.java.domain.emisoras.Emisora;

import java.util.*;

public class EmisoraRepositoryInMemory implements EmisoraRepository {

    private final Map<String, Emisora> storage = new HashMap<>();

    @Override
    public void guardar(Emisora emisora) {
        if (emisora == null) {
            throw new IllegalArgumentException("La emisora no puede ser null");
        }
        storage.put(emisora.getNif(), emisora);
    }

    @Override
    public Emisora buscarPorNif(String nif) {
        return storage.get(nif);
    }

    @Override
    public List<Emisora> listarTodas() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void eliminar(String nif) {
        storage.remove(nif);
    }
}

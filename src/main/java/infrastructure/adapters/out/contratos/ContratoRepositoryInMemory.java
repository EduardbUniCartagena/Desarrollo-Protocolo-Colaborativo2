package main.java.infrastructure.adapters.out.contratos;

import main.java.application.usecases.contratos.ContratoRepository;
import main.java.domain.contratos.Contrato;

import java.util.*;

public class ContratoRepositoryInMemory implements ContratoRepository {

    // Mapa interno para simular la base de datos
    private final Map<String, Contrato> contratos = new HashMap<>();

    @Override
    public void guardar(Contrato contrato) {
        contratos.put(contrato.getNumeroContrato(), contrato);
    }

    @Override
    public Contrato buscarPorNumero(String numeroContrato) {
        return contratos.get(numeroContrato);
    }

    @Override
    public List<Contrato> listarTodos() {
        return new ArrayList<>(contratos.values());
    }

    @Override
    public void actualizar(Contrato contrato) {
        // Reemplaza el contrato existente con el contrato actualizado
        contratos.put(contrato.getNumeroContrato(), contrato);
    }

    @Override
    public void eliminar(String numeroContrato) {
        contratos.remove(numeroContrato);
    }
}

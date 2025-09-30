package main.java.infrastructure.adapters.out;



import main.java.application.usecases.ContratoRepository;
import main.java.domain.contratos.Contrato;

import java.util.HashMap;
import java.util.Map;

public class ContratoRepositoryInMemory implements ContratoRepository {
    private final Map<String, Contrato> storage = new HashMap<>();

    @Override
    public void guardar(Contrato contrato) {
        storage.put(contrato.getNumeroContrato(), contrato);
    }

    @Override
    public Contrato buscarPorNumero(String numeroContrato) {
        return storage.get(numeroContrato);
    }
}

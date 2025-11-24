package main.java.application.usecases.emisoras;

import main.java.domain.emisoras.Emisora;
import java.util.List;

public interface EmisoraRepository {

    void guardar(Emisora emisora);

    Emisora buscarPorNif(String nif);

    List<Emisora> listarTodas();

    void eliminar(String nif);
}

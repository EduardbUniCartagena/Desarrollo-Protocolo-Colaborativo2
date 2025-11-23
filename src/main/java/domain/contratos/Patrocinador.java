package main.java.domain.contratos;

public class Patrocinador {
    private final String id;

    public Patrocinador(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id del patrocinador es obligatorio");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

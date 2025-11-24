package main.java.application.usecases.emisoras;

public class EliminarEmisoraUseCase {

    private final EmisoraRepository repository;

    public EliminarEmisoraUseCase(EmisoraRepository repository) {
        this.repository = repository;
    }

    public void ejecutar(String nif) {

        // Validación básica
        if (nif == null || nif.isBlank()) {
            throw new IllegalArgumentException("El NIF no puede estar vacío");
        }

        // Eliminar la emisora por su NIF
        repository.eliminar(nif);
    }
}

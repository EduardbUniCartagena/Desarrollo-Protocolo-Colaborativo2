package main.java.domain.contratos;

import main.java.domain.excepciones.DomainException;

public class Duracion {
    private final int meses;

    public Duracion(int meses) {
        if (meses <= 0) {
            throw new DomainException("Duración inválida");
        }
        this.meses = meses;
    }

    public int getMeses() {
        return meses;
    }
}
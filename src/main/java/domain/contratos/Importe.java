package main.java.domain.contratos;

import main.java.domain.excepciones.DomainException;

public class Importe {
    private final double valor;

    public Importe(double valor) {
        if (valor <= 0) {
            throw new DomainException("El importe debe ser mayor que 0");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
package main.java.domain.emisoras;


import java.time.LocalTime;
import main.java.domain.excepciones.DomainException;

public class FranjaHoraria {
    private final LocalTime inicio;
    private final LocalTime fin;

    public FranjaHoraria(LocalTime inicio, LocalTime fin) {
        if (inicio == null || fin == null) {
            throw new DomainException("Las horas no pueden ser nulas");
        }
        if (!fin.isAfter(inicio)) {
            throw new DomainException("La hora de fin debe ser posterior a la de inicio");
        }
        this.inicio = inicio;
        this.fin = fin;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public LocalTime getFin() {
        return fin;
    }
}

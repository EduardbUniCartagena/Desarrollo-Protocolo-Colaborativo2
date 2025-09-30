package main.java.domain.servicios;


import main.java.domain.emisoras.FranjaHoraria;
import main.java.domain.specification.Specification;

public class FranjaHorariaDisponibleSpecification implements Specification<FranjaHoraria> {

    private final FranjaHoraria franjaOcupada;

    public FranjaHorariaDisponibleSpecification(FranjaHoraria franjaOcupada) {
        this.franjaOcupada = franjaOcupada;
    }

    @Override
    public boolean isSatisfiedBy(FranjaHoraria nuevaFranja) {
        // Regla: no debe solaparse con la franja ocupada
        boolean solapado = !(nuevaFranja.getFin().isBefore(franjaOcupada.getInicio()) ||
                nuevaFranja.getInicio().isAfter(franjaOcupada.getFin()));
        return !solapado;
    }
}


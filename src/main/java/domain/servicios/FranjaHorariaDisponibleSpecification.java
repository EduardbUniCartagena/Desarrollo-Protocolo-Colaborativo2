package main.java.domain.servicios;


import main.java.domain.emisoras.FranjaHoraria;

public class FranjaHorariaDisponibleSpecification {

    private final FranjaHoraria franjaOcupada;

    public FranjaHorariaDisponibleSpecification(FranjaHoraria franjaOcupada) {
        this.franjaOcupada = franjaOcupada;
    }

    public boolean esSatisfechaPor(FranjaHoraria nuevaFranja) {
        // Regla: no debe solaparse con la franja ocupada
        boolean solapado = !(nuevaFranja.getFin().isBefore(franjaOcupada.getInicio()) ||
                nuevaFranja.getInicio().isAfter(franjaOcupada.getFin()));
        return !solapado;
    }
}

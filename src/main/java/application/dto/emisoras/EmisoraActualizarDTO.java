package main.java.application.dto.emisoras;


public class EmisoraActualizarDTO {

    private String nif;
    private String nuevoNombre;

    public EmisoraActualizarDTO() {
    }

    public EmisoraActualizarDTO(String nif, String nuevoNombre) {
        this.nif = nif;
        this.nuevoNombre = nuevoNombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }
}


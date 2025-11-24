package main.java.application.dto.emisoras;

public class EmisoraCrearDTO {

    private String nif;
    private String nombre;

    public EmisoraCrearDTO() {
    }

    public EmisoraCrearDTO(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

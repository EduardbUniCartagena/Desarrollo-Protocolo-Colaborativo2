package main.java.application.dto.emisoras;

public class EmisoraRespuestaDTO {

    private String nif;
    private String nombre;

    public EmisoraRespuestaDTO(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }
}

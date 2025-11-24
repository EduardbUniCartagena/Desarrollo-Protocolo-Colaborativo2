package main.java.application.dto.contratos;

/**
 * DTO utilizado para devolver información de un contrato
 * hacia capas externas (servicio, controlador, cliente, etc.).
 */
public class ContratoRespuestaDTO {

    private String id;
    private String patrocinadorId;
    private String programaId;
    private int duracionEnSegundos;
    private double importe;

    public ContratoRespuestaDTO() {
    }

    public ContratoRespuestaDTO(String id, String patrocinadorId, String programaId,
                                int duracionEnSegundos, double importe) {
        this.id = id;
        this.patrocinadorId = patrocinadorId;
        this.programaId = programaId;
        this.duracionEnSegundos = duracionEnSegundos;
        this.importe = importe;
    }

    public ContratoRespuestaDTO(String numeroContrato, String id, int i, double valor, int meses) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatrocinadorId() {
        return patrocinadorId;
    }

    public void setPatrocinadorId(String patrocinadorId) {
        this.patrocinadorId = patrocinadorId;
    }

    public String getProgramaId() {
        return programaId;
    }

    public void setProgramaId(String programaId) {
        this.programaId = programaId;
    }

    public int getDuracionEnSegundos() {
        return duracionEnSegundos;
    }

    public void setDuracionEnSegundos(int duracionEnSegundos) {
        this.duracionEnSegundos = duracionEnSegundos;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}

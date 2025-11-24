package main.java.application.dto.contratos;

public class ContratoCrearDTO {

    private String id;
    private String patrocinadorId;
    private String programaId;
    private int duracionEnSegundos;
    private double importe;

    public ContratoCrearDTO() {
    }

    public ContratoCrearDTO(String id, String patrocinadorId, String programaId,
                            int duracionEnSegundos, double importe) {
        this.id = id;
        this.patrocinadorId = patrocinadorId;
        this.programaId = programaId;
        this.duracionEnSegundos = duracionEnSegundos;
        this.importe = importe;
    }

    public String getId() { return id; }
    public String getPatrocinadorId() { return patrocinadorId; }
    public String getProgramaId() { return programaId; }
    public int getDuracionEnSegundos() { return duracionEnSegundos; }
    public double getImporte() { return importe; }

    public void setId(String id) { this.id = id; }
    public void setPatrocinadorId(String patrocinadorId) { this.patrocinadorId = patrocinadorId; }
    public void setProgramaId(String programaId) { this.programaId = programaId; }
    public void setDuracionEnSegundos(int duracionEnSegundos) { this.duracionEnSegundos = duracionEnSegundos; }
    public void setImporte(double importe) { this.importe = importe; }
}

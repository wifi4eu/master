package wifi4eu.wifi4eu.common.dto.model;


public class ValidateLEFDTO {

    private Integer idLef;

    private String stat;

    public ValidateLEFDTO() {}

    public ValidateLEFDTO(Integer idLef, String stat) {
        this.idLef = idLef;
        this.stat = stat;
    }

    public Integer getIdLef() {
        return idLef;
    }

    public void setIdLef(Integer idLef) {
        this.idLef = idLef;
    }

    public String getStatus() {
        return stat;
    }

    public void setStatus(String stat) {
        this.stat = stat;
    }
}

package wifi4eu.wifi4eu.common.dto.model;


public class ValidatedLEFDTO {

    private Integer idLef;

    private String status;

    public ValidatedLEFDTO() {}

    public ValidatedLEFDTO(Integer idLef, String status) {
        this.idLef = idLef;
        this.status = status;
    }

    public Integer getIdLef() {
        return idLef;
    }

    public void setIdLef(Integer idLef) {
        this.idLef = idLef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

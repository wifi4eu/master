package wifi4eu.wifi4eu.common.dto.model;

public class UserHistoryActionDTO {
    private String municipality;
    private String actionPerformed;
    private Long date;

    public UserHistoryActionDTO() {
    }

    public UserHistoryActionDTO(String municipality, String actionPerformed, Long date) {
        this.municipality = municipality;
        this.actionPerformed = actionPerformed;
        this.date = date;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getActionPerformed() {
        return actionPerformed;
    }

    public void setActionPerformed(String actionPerformed) {
        this.actionPerformed = actionPerformed;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
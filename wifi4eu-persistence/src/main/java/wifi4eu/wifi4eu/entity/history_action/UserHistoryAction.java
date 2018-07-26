package wifi4eu.wifi4eu.entity.history_action;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserHistoryAction {
    @Id
    private Integer id;
    private String municipality;
    private String actionPerformed;
    private Long date;

    public UserHistoryAction() {
    }

    public UserHistoryAction(Integer id, String municipality, String actionPerformed, Long date) {
        this.id = id;
        this.municipality = municipality;
        this.actionPerformed = actionPerformed;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
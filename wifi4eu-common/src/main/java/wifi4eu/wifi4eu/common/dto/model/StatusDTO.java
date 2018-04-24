package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;

public class StatusDTO implements Serializable {

    private Long id;
    private String status;
    private int active;
    private Date createdDate;

    public StatusDTO() {

    }

    public StatusDTO(Long id, String status, int active, Date createdDate) {
        this.id = id;
        this.status = status;
        this.active = active;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}

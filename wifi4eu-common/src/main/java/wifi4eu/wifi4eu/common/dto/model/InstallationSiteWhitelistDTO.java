package wifi4eu.wifi4eu.common.dto.model;

import javax.persistence.*;

public class InstallationSiteWhitelistDTO {

    private Long id;
    private String origin;
    private int active;

    public InstallationSiteWhitelistDTO() {
    }

    public InstallationSiteWhitelistDTO(Long id, String origin, int active) {
        this.id = id;
        this.origin = origin;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}


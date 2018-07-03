package wifi4eu.wifi4eu.entity.installation;

import javax.persistence.*;

@Entity
@Table(name="installation_site_whitelist")
public class InstallationSiteWhitelist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="origin")
    private String origin;

    @Column(name="active")
    private int active;

    public InstallationSiteWhitelist() {
    }

    public InstallationSiteWhitelist(Long id, String origin, int active) {
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

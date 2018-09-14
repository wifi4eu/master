package wifi4eu.wifi4eu.entity.installation;

import wifi4eu.wifi4eu.entity.municipality.Municipality;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "installation_site")
public class InstallationSite {

    @Column (name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_municipality")
    private Integer municipality;

    @Column(name = "id_status")
    private Integer status;

    /*
    @ManyToOne
    @JoinColumn(name = "id_municipality")
    private Municipality municipality;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
    */

    @Column(name = "id_network_snippet", length = 75)
    private String idNetworkSnippet;

    @Column(name = "name", length = 75)
    private String name;

    @Column(name = "date_registered")
    private Timestamp dateRegistered;

    @Column(name = "domain_name")
    private String domainName;

    @Column(name = "url")
    private String url;

    @Column(name = "number")
    private Integer number;

    public InstallationSite() {
    }

    public InstallationSite(Integer id, Municipality municipality, String idNetworkSnippet, String name, Timestamp dateRegistered, String domainName, String url, Integer number) {
        this.id = id;
        // this.municipality = municipality;
        // this.status = status;
        this.idNetworkSnippet = idNetworkSnippet;
        this.name = name;
        this.dateRegistered = dateRegistered;
        this.domainName = domainName;
        this.url = url;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*
    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Status getId_status() {
        return status;
    }

    public void setId_status(Status id_status) {
        this.status = id_status;
    }
    */

    public Integer getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Integer municipality) {
        this.municipality = municipality;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIdNetworkSnippet() {
        return idNetworkSnippet;
    }

    public void setIdNetworkSnippet(String idNetworkSnippet) {
        this.idNetworkSnippet = idNetworkSnippet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Timestamp dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
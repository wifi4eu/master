package wifi4eu.wifi4eu.entity.registration;


@Entity
@Table(name = "installation_site")
public class InstallationSite {

    @Id
    @SequenceGenerator(name = "installation_site_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "installation_site_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_municipality")
    private Municipality municipality;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status idStatus;

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

    public InstallationSite(Municipality municipality, Status id_status, String idNetworkSnippet, String name, Date dateRegistered, String domainName, String url) {
        this.municipality = municipality;
        this.id_status = id_status;
        this.idNetworkSnippet = idNetworkSnippet;
        this.name = name;
        this.dateRegistered = dateRegistered;
        this.domainName = domainName;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Status getId_status() {
        return id_status;
    }

    public void setId_status(Status id_status) {
        this.id_status = id_status;
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

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
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
}
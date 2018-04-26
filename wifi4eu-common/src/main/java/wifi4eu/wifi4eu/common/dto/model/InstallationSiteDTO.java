package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;

public class InstallationSiteDTO implements Serializable {
    private Integer id;
    private MunicipalityDTO municipality;
    private StatusDTO status;
    private String idNetworkSnippet;
    private String name;
    private String domainName;
    private String url;

    public InstallationSiteDTO() {

    }

    public InstallationSiteDTO(Integer id, MunicipalityDTO municipality, StatusDTO status, String idNetworkSnippet, String name, String domainName, String url) {
        this.id = id;
        this.municipality = municipality;
        this.status = status;
        this.idNetworkSnippet = idNetworkSnippet;
        this.name = name;
        this.domainName = domainName;
        this.url = url;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MunicipalityDTO getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MunicipalityDTO municipality) {
        this.municipality = municipality;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
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

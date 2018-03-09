package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MunicipalityCacheDTO implements Serializable {
    private List<String> municipalities;
    private Date dateCached;

    public MunicipalityCacheDTO(List<String> municipalities, Date dateCached) {
        this.municipalities = municipalities;
        this.dateCached = dateCached;
    }

    public MunicipalityCacheDTO() {
    }

    public List<String> getMunicipalities() {
        return municipalities;
    }

    public void setMunicipalities(List<String> municipalities) {
        this.municipalities = municipalities;
    }

    public Date getDateCached() {
        return dateCached;
    }

    public void setDateCached(Date dateCached) {
        this.dateCached = dateCached;
    }
}

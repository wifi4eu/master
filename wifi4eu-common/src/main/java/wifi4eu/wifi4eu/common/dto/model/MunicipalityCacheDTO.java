package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MunicipalityCacheDTO implements Serializable {
    private List<MunicipalityDTO> municipalityDTOList;
    private Date dateCached;

    public MunicipalityCacheDTO(List<MunicipalityDTO> municipalityDTOList, Date dateCached) {
        this.municipalityDTOList = municipalityDTOList;
        this.dateCached = dateCached;
    }

    public MunicipalityCacheDTO() {
    }

    public List<MunicipalityDTO> getMunicipalityDTOList() {
        return municipalityDTOList;
    }

    public void setMunicipalityDTOList(List<MunicipalityDTO> municipalityDTOList) {
        this.municipalityDTOList = municipalityDTOList;
    }

    public Date getDateCached() {
        return dateCached;
    }

    public void setDateCached(Date dateCached) {
        this.dateCached = dateCached;
    }
}

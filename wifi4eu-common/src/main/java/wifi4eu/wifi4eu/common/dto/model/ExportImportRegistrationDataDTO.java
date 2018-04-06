package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;


public class ExportImportRegistrationDataDTO implements Serializable {

    private Integer id;
    private Integer rId;
    private String mCountry;
    private String mName;
    private String uName;
    private String uEcasEmail;
    private String uEcasUserName;
    private String uType;
    private String abacReference;
    private String abacStandarName;
    private Integer municipality;

    public ExportImportRegistrationDataDTO() {}

    public ExportImportRegistrationDataDTO(Integer id, Integer rId, String mCountry, String mName, String uName, String uEcasEmail, String uEcasUserName, String uType, String abacReference, String abacStandarName, Integer municipality) {
        this.id = id;
        this.rId = rId;
        this.mCountry = mCountry;
        this.mName = mName;
        this.uName = uName;
        this.uEcasEmail = uEcasEmail;
        this.uEcasUserName = uEcasUserName;
        this.uType = uType;
        this.abacReference = abacReference;
        this.abacStandarName = abacStandarName;
        this.municipality = municipality;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public String getmCountry() { return mCountry; }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmName() { return mName; }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEcasEmail() {
        return uEcasEmail;
    }

    public void setuEcasEmail(String uEcasEmail) {
        this.uEcasEmail = uEcasEmail;
    }

    public String getuEcasUserName() {
        return uEcasUserName;
    }

    public void setuEcasUserName(String uEcasUserName) {
        this.uEcasUserName = uEcasUserName;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getAbacReference() {
        return abacReference;
    }

    public void setAbacReference(String abacReference) { this.abacReference = abacReference; }

    public String getAbacStandarName() {
        return abacStandarName;
    }

    public void setAbacStandarName(String abacStandarName) {
        this.abacStandarName = abacStandarName;
    }

    public Integer getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Integer municipality) {
        this.municipality = municipality;
    }

    @Override
    public String toString() {
        return "ExportImportRegistrationDataDTO{" +
                "id=" + id + '\'' +
                ", rId=" + rId + '\'' +
                ", mCountry=" + mCountry + '\'' +
                ", mName=" + mName + '\'' +
                ", uName=" + uName + '\'' +
                ", uEcasEmail=" + uEcasEmail + '\'' +
                ", uEcasUserName=" + uEcasUserName + '\'' +
                ", abacReference='" + abacReference + '\'' +
                ", abacStandarName='" + abacStandarName + '\'' +
                ", municipality='" + municipality +
                '}';
    }
}


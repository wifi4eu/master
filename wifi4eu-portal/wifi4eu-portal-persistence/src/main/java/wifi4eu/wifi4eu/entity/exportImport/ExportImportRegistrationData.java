package wifi4eu.wifi4eu.entity.exportImport;

import wifi4eu.wifi4eu.entity.location.Lau;
import wifi4eu.wifi4eu.entity.registration.Registration;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "municipalities_abac")
public class ExportImportRegistrationData {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rId")
    private Integer rId;

    @Column(name = "mCountry")
    private String mCountry;

    @Column(name = "mName")
    private String mName;

    @Column(name = "uName")
    private String uName;

    @Column(name = "uEcasEmail")
    private String uEcasEmail;

    @Column(name = "uEcasUserName")
    private String uEcasUserName;

    @Column(name = "uType")
    private String uType;

    @Column(name = "abacReference")
    private String abacReference;

    @Column(name = "abacStandarName")
    private String abacStandarName;

    @Column(name = "municipality")
    private Integer municipality;

    public ExportImportRegistrationData() {}

    public ExportImportRegistrationData(Integer id, Integer rId, String mCountry, String mName, String uName, String uEcasEmail, String uEcasUserName, String uType, String abacReference, String abacStandarName, Integer municipality) {
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

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmName() {
        return mName;
    }

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

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getuEcasUserName() {
        return uEcasUserName;
    }

    public void setuEcasUserName(String uEcasUserName) {
        this.uEcasUserName = uEcasUserName;
    }

    public String getAbacReference() {
        return abacReference;
    }

    public void setAbacReference(String abacReference) {
        this.abacReference = abacReference;
    }

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
}

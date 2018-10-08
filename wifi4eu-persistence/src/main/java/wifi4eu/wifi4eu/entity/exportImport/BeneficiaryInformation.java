package wifi4eu.wifi4eu.entity.exportImport;

import wifi4eu.wifi4eu.entity.registration.FileType;

import java.util.Date;

public class BeneficiaryInformation {

    private Integer mun_id;

    private String mun_name;

    private String mun_abacName;

    private String mun_address;

    private String mun_address_num;

    private String mun_postalCode;

    private String mun_city;

    private String mun_countryCodeISO;

    private String mun_languageCodeISO;

    private Integer mun_registrationNumber;

    private String mun_abacReference;

    private Integer mun_callNumber;

    private Integer doc_portalId;

    private String doc_name;

    private String doc_fileName;

    private String doc_mimeType;

    private Date doc_date;

    private Integer doc_type;

    private String doc_location;

    private String aresReference;

    private String azureUri;

    public BeneficiaryInformation() {
    }

    public BeneficiaryInformation(Integer mun_id, String mun_name, String mun_address, String mun_address_num, String mun_postalCode, String mun_city,
                                  String mun_countryCodeISO, Integer mun_registrationNumber, Integer doc_portalId, String doc_name, String doc_fileName, String doc_mimeType,
                                  Long doc_date, Integer doc_type, String azureUri, String mun_abacReference, String mun_abacName, Integer mun_callNumber,
                                  String mun_languageCodeISO) {
        this.mun_id = mun_id;
        this.mun_name = mun_name;
        this.mun_abacName = mun_abacName;
        this.mun_address = mun_address;
        this.mun_address_num = mun_address_num;
        this.mun_postalCode = mun_postalCode;
        this.mun_city = mun_city;
        this.mun_countryCodeISO = mun_countryCodeISO;
        this.mun_languageCodeISO = mun_languageCodeISO;
        this.mun_registrationNumber = mun_registrationNumber;
        this.mun_abacReference = mun_abacReference;
        this.mun_callNumber = mun_callNumber;
        this.doc_portalId = doc_portalId;
        this.doc_name = doc_name;
        this.doc_fileName = doc_fileName;
        this.doc_mimeType = doc_mimeType;
        this.doc_date = doc_date != null ? new Date(doc_date) : null;
        this.doc_type = doc_type;
        this.azureUri = azureUri;

        // TODO: missing
        this.doc_location = null;
        this.aresReference = null;
    }

    public Integer getMun_id() {
        return mun_id;
    }

    public void setMun_id(Integer mun_id) {
        this.mun_id = mun_id;
    }

    public String getMun_name() {
        return mun_name;
    }

    public void setMun_name(String mun_name) {
        this.mun_name = mun_name;
    }

    public String getMun_address() {
        return mun_address;
    }

    public void setMun_address(String mun_address) {
        this.mun_address = mun_address;
    }

    public String getMun_postalCode() {
        return mun_postalCode;
    }

    public void setMun_postalCode(String mun_postalCode) {
        this.mun_postalCode = mun_postalCode;
    }

    public String getMun_city() {
        return mun_city;
    }

    public void setMun_city(String mun_city) {
        this.mun_city = mun_city;
    }

    public String getMun_countryCodeISO() {
        return mun_countryCodeISO;
    }

    public void setMun_countryCodeISO(String mun_countryCodeISO) {
        this.mun_countryCodeISO = mun_countryCodeISO;
    }

    public String getMun_languageCodeISO() {
        return mun_languageCodeISO;
    }

    public void setMun_languageCodeISO(String mun_languageCodeISO) {
        this.mun_languageCodeISO = mun_languageCodeISO;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_fileName() {
        return doc_fileName;
    }

    public void setDoc_fileName(String doc_fileName) {
        this.doc_fileName = doc_fileName;
    }

    public String getDoc_mimeType() {
        return doc_mimeType;
    }

    public void setDoc_mimeType(String doc_mimeType) {
        this.doc_mimeType = doc_mimeType;
    }

    public Date getDoc_date() {
        return doc_date;
    }

    public void setDoc_date(Date doc_date) {
        this.doc_date = doc_date;
    }

    public FileType getDoc_type() {
        return FileType.fromCode(doc_type);
    }

    public void setDoc_type(Integer doc_type) {
        this.doc_type = doc_type;
    }

    public void setDoc_type(FileType fileType) {
        this.doc_type = fileType != null ? fileType.getCode() : null;
    }

    public String getDoc_location() {
        return doc_location;
    }

    public void setDoc_location(String doc_location) {
        this.doc_location = doc_location;
    }

    public String getMun_abacName() {
        return mun_abacName;
    }

    public void setMun_abacName(String mun_abacName) {
        this.mun_abacName = mun_abacName;
    }

    public String getMun_abacReference() {
        return mun_abacReference;
    }

    public void setMun_abacReference(String mun_abacReference) {
        this.mun_abacReference = mun_abacReference;
    }

    public String getAresReference() {
        return aresReference;
    }

    public void setAresReference(String aresReference) {
        this.aresReference = aresReference;
    }

    public Integer getMun_callNumber() {
        return mun_callNumber;
    }

    public void setMun_callNumber(Integer mun_callNumber) {
        this.mun_callNumber = mun_callNumber;
    }

    public Integer getMun_registrationNumber() {
        return mun_registrationNumber;
    }

    public void setMun_registrationNumber(Integer mun_registrationNumber) {
        this.mun_registrationNumber = mun_registrationNumber;
    }

    public Integer getDoc_portalId() {
        return doc_portalId;
    }

    public void setDoc_portalId(Integer doc_portalId) {
        this.doc_portalId = doc_portalId;
    }

    public String getAzureUri() {
        return azureUri;
    }

    public void setAzureUri(String azureUri) {
        this.azureUri = azureUri;
    }

    public String getMun_address_num() {
        return mun_address_num;
    }

    public void setMun_address_num(String mun_address_num) {
        this.mun_address_num = mun_address_num;
    }

    public String getFullAddress() {
        return mun_address + ", " + mun_address_num;
    }
}

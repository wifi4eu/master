package wifi4eu.wifi4eu.entity.exportImport;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeneficiaryInformation {

    @Id
    private Integer id;

	private String mun_id;

	private String mun_name;

	private String mun_address;

	private String mun_postalCode;

	private String mun_city;

	private String mun_countryCodeISO;

	private String mun_languageCodeISO;

	private Integer mun_registrationNumber;

	private Integer doc_portalId;

	private String doc_name;

	private String doc_fileName;

	private String doc_mimeType;

	private Date doc_date;

	private String doc_type;
	
	private String doc_location;

	public String getMun_id() {
		return mun_id;
	}

	public void setMun_id(String mun_id) {
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

	public String getDoc_type() {
		return doc_type;
	}

	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}

	public String getDoc_location() {
		return doc_location;
	}

	public void setDoc_location(String doc_location) {
		this.doc_location = doc_location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}

package wifi4eu.wifi4eu.abac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

@Entity
@Table(name = "WIF_LEGAL_ENTITY")
public class LegalEntity {

	//@ GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "mid")
	private Integer mid;

	@Column(name = "official_name", length = 400)
	private String officialName;

	@Column(name = "region", length = 400)
	private String region;

	@Column(name = "language_code", length = 3)
	private String languageCode;

	@Column(name = "country_code", length = 2)
	private String countryCode;

	@Column(name = "official_address", length = 400)
	private String officialAddress;

	@Column(name = "official_address_str_no", length = 20)
	private String officialAddressStrNo;

	@Column(name = "postal_code", length = 50)
	private String postalCode;

	@Column(name = "abac_fel_id", length = 50)
	private String abacFelId;

	@Column(name = "wf_status", length = 20)
	private String wfStatus;

	@Column(name = "date_created", length = 20)
	private String dateCreated;

	public LegalEntity() {
	}

	public LegalEntity(Integer id, String officialName) {
		this.id = id;
		this.officialName = officialName;
	}

	public LegalEntity(Integer id, String officialName, String idAbac, String status) {
		this.id = id;
		this.officialName = officialName;
		this.abacFelId = idAbac;
		this.wfStatus = status;
	}

	public LegalEntity(Integer id, Integer mid, String officialName, String region, String languageCode,
			String countryCode, String officialAddress, String officialAddressStrNo, String postalCode,
			String abacFelId, String wfStatus, String dateCreated) {
		super();
		this.id = id;
		this.mid = mid;
		this.officialName = officialName;
		this.region = region;
		this.languageCode = languageCode;
		this.countryCode = countryCode;
		this.officialAddress = officialAddress;
		this.officialAddressStrNo = officialAddressStrNo;
		this.postalCode = postalCode;
		this.abacFelId = abacFelId;
		this.wfStatus = wfStatus;
		this.dateCreated = dateCreated;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getOfficialName() {
		return officialName;
	}

	public void setOfficialName(String officialName) {
		this.officialName = officialName;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getOfficialAddress() {
		return officialAddress;
	}

	public void setOfficialAddress(String officialAddress) {
		this.officialAddress = officialAddress;
	}

	public String getOfficialAddressStrNo() {
		return officialAddressStrNo;
	}

	public void setOfficialAddressStrNo(String officialAddressStrNo) {
		this.officialAddressStrNo = officialAddressStrNo;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAbacFelId() {
		return abacFelId;
	}

	public void setAbacFelId(String abacFelId) {
		this.abacFelId = abacFelId;
	}

	public String getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(String wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@PrePersist
	protected void onCreate() {
		this.dateCreated = DateTimeUtils.getCurrentDateTime();
	}

	@Override
	public String toString() {
		return "LegalEntity [id=" + id + ", mid=" + mid + ", officialName=" + officialName + ", region=" + region
				+ ", languageCode=" + languageCode + ", countryCode=" + countryCode + ", officialAddress="
				+ officialAddress + ", officialAddressStrNo=" + officialAddressStrNo + ", postalCode=" + postalCode
				+ ", abacFelId=" + abacFelId + ", wfStatus=" + wfStatus + ", dateCreated=" + dateCreated + "]";
	}

}
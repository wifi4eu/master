package wifi4eu.wifi4eu.abac.data.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.ParameterMode;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

@Entity
@Table(name = "WIF_LEGAL_ENTITY")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "CREATE_LEF_IN_ABAC",
				procedureName = "CREATE_LEF_IN_ABAC",
				parameters = {
					@StoredProcedureParameter(mode = ParameterMode.IN, name = "LEGALENTITYID", type = Long.class)
				}),
		@NamedStoredProcedureQuery(name = "UPDATE_LEF_STATUS_FROM_ABAC",
				procedureName = "UPDATE_LEF_STATUS_FROM_ABAC")
})
public class LegalEntity {
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leIDGenerator")
	@SequenceGenerator(name = "leIDGenerator", sequenceName = "SEQ_LEGAL_ENTITY", allocationSize = 1)
	private Long id;

	@Column(name = "mid")
	private Long mid;

	@Column(name = "official_name", length = 400)
	private String officialName;

	@Column(name = "language_code", length = 3)
	private String languageCode;

	@Column(name = "country_code", length = 2)
	private String countryCode;

	@Column(name = "official_address", length = 400)
	private String officialAddress;

	@Column(name = "postal_code", length = 50)
	private String postalCode;

	@Column(name = "city", length = 400)
	private String city;

	@Column(name = "registration_number")
	private Long registrationNumber;

	@Column(name = "abac_fel_id", length = 50)
	private String abacFelId;

	@Column(name = "wf_status", length = 20)
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatus wfStatus;

	@Column(name = "date_created", length = 20)
	private Date dateCreated;

	@Column(name = "date_updated", length = 20)
	private Date dateUpdated;

	@Column(name = "signature_date", length = 20)
	private Date signatureDate;

	@Column(name = "user_imported", length = 50)
	private String userImported;

	@Column(name = "HERMES_FILE_ID", unique = true, nullable = true, length = 200)
	private String hermesFileId;

	@OneToMany(mappedBy = "legalEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Document> documents;

	@OneToMany(mappedBy = "legalEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@OrderBy("submitDate DESC")
	private List<LegalEntityAbacRequest> legalEntityAbacRequests = new ArrayList<LegalEntityAbacRequest>();

	public LegalEntity() {

	}

	public LegalEntity(Long id, Long mid, String officialName, String languageCode, String countryCode,
					   String officialAddress, String postalCode, String city, Long registrationNumber, String abacFelId,
					   AbacWorkflowStatus wfStatus, Date dateCreated, Date dateUpdated, Date signatureDate,
					   String userImported) {
		super();
		this.id = id;
		this.mid = mid;
		this.officialName = officialName;
		this.languageCode = languageCode;
		this.countryCode = countryCode;
		this.officialAddress = officialAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.registrationNumber = registrationNumber;
		this.abacFelId = abacFelId;
		this.wfStatus = wfStatus;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
		this.signatureDate = signatureDate;
		this.userImported = userImported;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public AbacWorkflowStatus getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatus wfStatus) {
		this.wfStatus = wfStatus;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	public Long getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(Long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getUserImported() {
		return userImported;
	}

	public void setUserImported(String userImported) {
		this.userImported = userImported;
	}

	public String getHermesFileId() {
		return hermesFileId;
	}

	public void setHermesFileId(String hermesFileId) {
		this.hermesFileId = hermesFileId;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<LegalEntityAbacRequest> getLegalEntityAbacRequests() {
		return legalEntityAbacRequests;
	}

	public void setLegalEntityAbacRequests(List<LegalEntityAbacRequest> legalEntityAbacRequests) {
		this.legalEntityAbacRequests = legalEntityAbacRequests;
	}

	public String getRejectionReason(){
		return !legalEntityAbacRequests.isEmpty() ? legalEntityAbacRequests.get(0).getRejectionReason() : null;
	}

	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();
	}

	@Override
	public String toString() {
		return "LegalEntity [id=" + id + ", mid=" + mid + ", officialName=" + officialName + ", languageCode="
				+ languageCode + ", countryCode=" + countryCode + ", officialAddress=" + officialAddress
				+ ", postalCode=" + postalCode + ", city=" + city + ", registrationNumber=" + registrationNumber
				+ ", abacFelId=" + abacFelId + ", wfStatus=" + wfStatus + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + ", signatureDate=" + signatureDate + ", userImported=" + userImported
				+ "]";
	}

}
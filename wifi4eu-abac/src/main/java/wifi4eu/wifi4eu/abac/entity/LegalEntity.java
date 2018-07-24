package wifi4eu.wifi4eu.abac.entity;

import wifi4eu.wifi4eu.abac.service.AbacWorkflowStatusEnum;
import wifi4eu.wifi4eu.abac.utils.DateTimeUtils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "WIF_LEGAL_ENTITY")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "CREATE_LEF_IN_ABAC",
				procedureName = "CREATE_LEF_IN_ABAC",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "LEGALENTITYID", type = Long.class)
				})
})
public class LegalEntity {
	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leIDGenerator")
	@SequenceGenerator(name = "leIDGenerator", sequenceName = "SEQ_LEGAL_ENTITY", allocationSize = 1)
	private Long id;

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
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatusEnum wfStatus;

	@Column(name = "date_created", length = 20)
	private String dateCreated;

	@OneToMany(
			mappedBy = "legalEntity",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private List<AbacBatchStatus> abacBatchStatusList;

	public LegalEntity() {
	}



	public LegalEntity(Long id, Integer mid, String officialName, String region, String languageCode,
			String countryCode, String officialAddress, String officialAddressStrNo, String postalCode,
			String abacFelId, AbacWorkflowStatusEnum wfStatus, String dateCreated) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public AbacWorkflowStatusEnum getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatusEnum wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<AbacBatchStatus> getAbacBatchStatusList() {
		return abacBatchStatusList;
	}

	public void setAbacBatchStatusList(List<AbacBatchStatus> abacBatchStatusList) {
		this.abacBatchStatusList = abacBatchStatusList;
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
package wifi4eu.wifi4eu.abac.data.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;

@Entity
@Table(name = "WIF_BANK_ACCOUNT")
public class BankAccount {

	@Id
	@Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bafIDGenerator")
	@SequenceGenerator(name = "bafIDGenerator", sequenceName = "SEQ_BANK_ACCOUNT", allocationSize = 1)
	private Long id;
	
	@Column(name = "baf_id")
	private Long bafId;
	
	@Column(name = "wf_status", length = 20)
	@Enumerated(EnumType.STRING)
	private AbacWorkflowStatus wfStatus;
	
	@Column(name = "account_name", length = 70)
	private String accountName;
	
	@Column(name = "address", length = 120)
	private String address;
	
	@Column(name = "city", length = 50)
	private String city;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "country_code")
	private Country country;
	
	@Column(name = "postal_code", length = 10)
	private String postalCode;

	@Column(name = "bank_name", length = 120)
	private String bankName;
	
	@Column(name = "bank_address", length = 120)
	private String bankAddress;
	
	@Column(name = "bank_city", length = 50)
	private String bankCity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_country_code")
	private Country bankCountry;
	
	@Column(name = "bank_postal_code", length = 10)
	private String bankPostalCode;
	
	@Column(name = "iban", length = 50)
	private String iban;
	
	@Column(name = "swift_code", length = 50)
	private String swiftCode;
	
	@Column(name = "abac_ref", length = 50)
	private String abacRef;
	
	@Column(name = "date_created", length = 20)
	private Date dateCreated;

	@Column(name = "date_updated", length = 20)
	private Date dateUpdated;
	
	@Column(name = "user_imported", length = 50)
	private String userImported;

	@Column(name = "date_exported", length = 20)
	private Date dateExported;
	
	@Column(name = "user_exported", length = 50)
	private String userExported;

	@Column(name = "ABAC_LATIN_NAME")
	private String abacLatinName;

	@Column(name = "ABAC_LATIN_ADDRESS")
	private String abacLatinAddress;
	
	@Column(name = "ABAC_LATIN_CITY")
	private String abacLatinCity;

	@Column(name = "ABAC_LATIN_BANK_NAME")
	private String abacLatinBankName;
	
	@Column(name = "ABAC_LATIN_BANK_ADDRESS")
	private String abacLatinBankAddress;
	
	@Column(name = "ABAC_LATIN_BANK_CITY")
	private String abacLatinBankCity;
	
	@Column(name = "BATCH_REF", length = 50)
	private String batchRef;
	
	@PrePersist
	protected void onCreate() {
		this.dateCreated = Calendar.getInstance().getTime();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBafId() {
		return bafId;
	}

	public void setBafId(Long bafId) {
		this.bafId = bafId;
	}

	public AbacWorkflowStatus getWfStatus() {
		return wfStatus;
	}

	public void setWfStatus(AbacWorkflowStatus wfStatus) {
		this.wfStatus = wfStatus;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getAbacRef() {
		return abacRef;
	}

	public void setAbacRef(String abacRef) {
		this.abacRef = abacRef;
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

	public String getUserImported() {
		return userImported;
	}

	public void setUserImported(String userImported) {
		this.userImported = userImported;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAbacLatinName() {
		return abacLatinName;
	}

	public void setAbacLatinName(String abacLatinName) {
		this.abacLatinName = abacLatinName;
	}

	public String getAbacLatinAddress() {
		return abacLatinAddress;
	}

	public void setAbacLatinAddress(String abacLatinAddress) {
		this.abacLatinAddress = abacLatinAddress;
	}

	public String getBatchRef() {
		return batchRef;
	}

	public void setBatchRef(String batchRef) {
		this.batchRef = batchRef;
	}

	public Date getDateExported() {
		return dateExported;
	}

	public void setDateExported(Date dateExported) {
		this.dateExported = dateExported;
	}

	public String getUserExported() {
		return userExported;
	}

	public void setUserExported(String userExported) {
		this.userExported = userExported;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public Country getBankCountry() {
		return bankCountry;
	}

	public void setBankCountry(Country bankCountry) {
		this.bankCountry = bankCountry;
	}

	public String getBankPostalCode() {
		return bankPostalCode;
	}

	public void setBankPostalCode(String bankPostalCode) {
		this.bankPostalCode = bankPostalCode;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	
	public String getAbacLatinCity() {
		return abacLatinCity;
	}

	public void setAbacLatinCity(String abacLatinCity) {
		this.abacLatinCity = abacLatinCity;
	}

	public String getAbacLatinBankName() {
		return abacLatinBankName;
	}

	public void setAbacLatinBankName(String abacLatinBankName) {
		this.abacLatinBankName = abacLatinBankName;
	}

	public String getAbacLatinBankAddress() {
		return abacLatinBankAddress;
	}

	public void setAbacLatinBankAddress(String abacLatinBankAddress) {
		this.abacLatinBankAddress = abacLatinBankAddress;
	}

	public String getAbacLatinBankCity() {
		return abacLatinBankCity;
	}

	public void setAbacLatinBankCity(String abacLatinBankCity) {
		this.abacLatinBankCity = abacLatinBankCity;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", bafId=" + bafId + ", wfStatus=" + wfStatus + ", accountName=" + accountName
				+ ", address=" + address + ", city=" + city + ", country=" + country + ", postalCode=" + postalCode
				+ ", bankName=" + bankName + ", bankAddress=" + bankAddress + ", bankCity=" + bankCity
				+ ", bankCountry=" + bankCountry + ", bankPostalCode=" + bankPostalCode + ", iban=" + iban
				+ ", swiftCode=" + swiftCode + ", abacRef=" + abacRef + ", dateCreated=" + dateCreated
				+ ", dateUpdated=" + dateUpdated + ", userImported=" + userImported + ", dateExported=" + dateExported
				+ ", userExported=" + userExported + ", abacLatinName=" + abacLatinName + ", abacLatinAddress="
				+ abacLatinAddress + ", abacLatinCity=" + abacLatinCity + ", abacLatinBankName=" + abacLatinBankName
				+ ", abacLatinBankAddress=" + abacLatinBankAddress + ", abacLatinBankCity=" + abacLatinBankCity
				+ ", batchRef=" + batchRef + "]";
	}
}

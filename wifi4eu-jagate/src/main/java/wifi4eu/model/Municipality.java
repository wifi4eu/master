package wifi4eu.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="MUNICIPALITY")
public class Municipality {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="ADDRESS_NUM")
	private String addressNumber;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="PO_BOX")
	private String poBox;
	
	@Column(name="CITY")
	private String postalCity;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COUNTRY_CODE")
	private Country country;
	
	@Column(name="JAGATE_KEY")
	private String jagateKey;
	
	@Column(name="FEL_ID")
	private String felID;
	
	@Column(name="JAGATE_CREATION_REQUEST_DATE")
	@Temporal(TemporalType.DATE)
	private Date jagateCreationRequestDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="LANGUAGE_CODE")
	private Language language;
	
	public Municipality() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getJagateKey() {
		return jagateKey;
	}

	public void setJagateKey(String jagateKey) {
		this.jagateKey = jagateKey;
	}

	public String getFelID() {
		return felID;
	}

	public void setFelID(String felID) {
		this.felID = felID;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getJagateCreationRequestDate() {
		return jagateCreationRequestDate;
	}

	public void setJagateCreationRequestDate(Date jagateCreationRequestDate) {
		this.jagateCreationRequestDate = jagateCreationRequestDate;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getPostalCity() {
		return postalCity;
	}

	public void setPostalCity(String postalCity) {
		this.postalCity = postalCity;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
}

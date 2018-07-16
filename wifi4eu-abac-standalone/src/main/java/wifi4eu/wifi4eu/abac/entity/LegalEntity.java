package wifi4eu.wifi4eu.abac.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @ Table(name = "ABAC_LEGAL_ENTITIES")
public class LegalEntity {

	@Id
	private Integer id;

	private String name;

	private String lang;

	private String region;

	private String country;

	private String code;

	private String address;

	private String nr;

	private String postalCode;

	public LegalEntity() {
	}

	public LegalEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public LegalEntity(Integer id, String name, String lang, String region, String country, String code, String address,
			String nr, String postalCode) {
		super();
		this.id = id;
		this.name = name;
		this.lang = lang;
		this.region = region;
		this.country = country;
		this.code = code;
		this.address = address;
		this.nr = nr;
		this.postalCode = postalCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNr() {
		return nr;
	}

	public void setNr(String nr) {
		this.nr = nr;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "LegalEntity [id=" + id + ", name=" + name + ", lang=" + lang + ", region=" + region + ", country="
				+ country + ", code=" + code + ", address=" + address + ", nr=" + nr + ", postalCode=" + postalCode
				+ "]";
	}

}
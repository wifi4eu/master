package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "WIF_COUNTRY")
public class Country {
	
	@Id
	@Column(name = "iso2_code", length = 2, unique = true)
	private String iso2Code;
	
	@JsonIgnore
	@Column(name = "iso3_code", length = 3)
	private String iso3Code;
	
	@Column(name = "name", length = 50)
	private String name;
	
	public Country() {
		
	}

	public Country(String iso2Code, String iso3Code, String name) {
		super();
		this.iso2Code = iso2Code;
		this.iso3Code = iso3Code;
		this.name = name;
	}

	public String getIso2Code() {
		return iso2Code;
	}

	public void setIso2Code(String iso2Code) {
		this.iso2Code = iso2Code;
	}

	public String getIso3Code() {
		return iso3Code;
	}

	public void setIso3Code(String iso3Code) {
		this.iso3Code = iso3Code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

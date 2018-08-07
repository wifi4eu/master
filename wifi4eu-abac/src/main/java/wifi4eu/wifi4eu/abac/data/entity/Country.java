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
	@Column(name = "cd", length = 2, unique = true)
	private String cd;
	
	@Column(name = "name", length = 50)
	private String name;
	
	@JsonIgnore
	@Column(name = "eu_member", length = 1)
	private String euMember;
	
	public Country() {
		
	}

	public Country(String cd, String name, String euMember) {
		this.cd = cd;
		this.name = name;
		this.euMember = euMember;
	}

	public String getCd() {
		return cd;
	}

	public void setCd(String cd) {
		this.cd = cd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEuMember() {
		return euMember;
	}

	public void setEuMember(String euMember) {
		this.euMember = euMember;
	}

}

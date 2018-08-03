package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WIF_COUNTRY")
public class Country {
	
	@Id
	@Column(name = "cd", length = 2, unique = true)
	private String cd;
	
	@Column(name = "name", length = 50)
	private String name;
	
	public Country() {
		
	}

	public Country(String cd, String name) {
		this.cd = cd;
		this.name = name;
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

}

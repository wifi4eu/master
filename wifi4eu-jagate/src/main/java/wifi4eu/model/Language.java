package wifi4eu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_LANGUAGE")
public class Language {

	@Id
	private String cd;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ACTIVE")
	private Boolean active;
	
	@Column(name="CCM2_CODE")
	private String ccm2Code;
	
	@Column(name="NATIVE_DESCRIPTIONS")
	private String nativeDescriptions;

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCcm2Code() {
		return ccm2Code;
	}

	public void setCcm2Code(String ccm2Code) {
		this.ccm2Code = ccm2Code;
	}

	public String getNativeDescriptions() {
		return nativeDescriptions;
	}

	public void setNativeDescriptions(String nativeDescriptions) {
		this.nativeDescriptions = nativeDescriptions;
	}
}

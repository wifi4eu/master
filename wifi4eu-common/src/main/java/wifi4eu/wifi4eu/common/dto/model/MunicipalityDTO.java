package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class MunicipalityDTO implements Serializable {
    private int id;
    private String name;
    private String address;
    private String addressNum;
    private String postalCode;
    private String country;
    
    private String jagateKey;
    private String felId;
    
    private int lauId;
    private List<RegistrationDTO> registrations;

    public MunicipalityDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddressNum() {
        return addressNum;
    }

    public void setAddressNum(String addressNum) {
        this.addressNum = addressNum;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getJagateKey() {
		return jagateKey;
	}

	public void setJagateKey(String jagateKey) {
		this.jagateKey = jagateKey;
	}

	public String getFelId() {
		return felId;
	}

	public void setFelId(String felId) {
		this.felId = felId;
	}

	public int getLauId() {
        return lauId;
    }

    public void setLauId(int lauId) {
        this.lauId = lauId;
    }

    public List<RegistrationDTO> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationDTO> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "MunicipalityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", addressNum='" + addressNum + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", lauId=" + lauId +
                ", registrations=" + registrations +
                '}';
    }
}

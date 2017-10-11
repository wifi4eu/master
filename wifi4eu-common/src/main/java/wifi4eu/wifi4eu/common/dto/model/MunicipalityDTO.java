package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class MunicipalityDTO {
    private int id;
    private String name;
    private String address;
    private int lauId;
    private List<RegistrationDTO> registrations;

    public MunicipalityDTO() {
    }

    public MunicipalityDTO(int id, String name, String address, int lauId, List<RegistrationDTO> registrations) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.lauId = lauId;
        this.registrations = registrations;
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
}

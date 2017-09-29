package wifi4eu.wifi4eu.common.dto.model;

public class MunicipalityDTO {
    int id;
    String name;
    String address;
    int lauId;

    public MunicipalityDTO() {
    }

    public MunicipalityDTO(int id, String name, String address, int lauId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.lauId = lauId;
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
}

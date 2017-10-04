package wifi4eu.wifi4eu.common.dto.model;

public class SuppliedRegionDTO {
    int id;
    int supplierId;
    int regionId;

    public SuppliedRegionDTO() {
    }

    public SuppliedRegionDTO(int id, int supplierId, int regionId) {
        this.id = id;
        this.supplierId = supplierId;
        this.regionId = regionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
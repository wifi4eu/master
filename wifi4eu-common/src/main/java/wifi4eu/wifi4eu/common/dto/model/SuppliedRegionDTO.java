package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

public class SuppliedRegionDTO implements Serializable{
    private int id;
    private int supplierId;
    private int regionId;

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

    @Override
    public String toString() {
        return "SuppliedRegionDTO{" +
                "id=" + id +
                ", supplierId=" + supplierId +
                ", regionId=" + regionId +
                '}';
    }
}
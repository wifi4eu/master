package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SuppliersCacheDTO implements Serializable {
    private List<String> suppliers;
    private Date dateCached;

    public SuppliersCacheDTO(List<String> suppliers, Date dateCached) {
        this.suppliers = suppliers;
        this.dateCached = dateCached;
    }

    public SuppliersCacheDTO() {
    }

    public List<String> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<String> suppliers) {
        this.suppliers = suppliers;
    }

    public Date getDateCached() {
        return dateCached;
    }

    public void setDateCached(Date dateCached) {
        this.dateCached = dateCached;
    }
}

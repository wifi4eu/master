package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SupplierListItem {

    @Id
    private Integer id;
    private String name;
    private String website;
    private String vat;
    private Integer status;
    private Integer numberRegistrations;

    public SupplierListItem() {
    }

    public SupplierListItem(Integer id, String name, String website, String vat, Integer status, Integer numberRegistrations) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.vat = vat;
        this.status = status;
        this.numberRegistrations = numberRegistrations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNumberRegistrations() {
        return numberRegistrations;
    }

    public void setNumberRegistrations(Integer numberRegistrations) {
        this.numberRegistrations = numberRegistrations;
    }
}

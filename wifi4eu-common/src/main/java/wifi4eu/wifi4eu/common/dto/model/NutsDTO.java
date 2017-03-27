package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;
import java.io.Serializable;

/**
 * Created by rgarcita on 08/02/2017.
 * Edited by rfguri on 27/03/2017.
 */
public class NutsDTO implements Serializable {

    private Long nutsId;
    private String code;
    private String name;
    private Long level;
    private String countryCode;
    private Long order;
    private Long sorting;
    private List<SupplierDTO> suppliers;

    public NutsDTO() {

    }

    public NutsDTO(Long nutsId, String code, String name, Long level, String countryCode, Long order, Long sorting, List<SupplierDTO> suppliers) {
        this.nutsId = nutsId;
        this.code = code;
        this.name = name;
        this.level = level;
        this.countryCode = countryCode;
        this.order = order;
        this.sorting = sorting;
        this.suppliers = suppliers;
    }

    public Long getNutsId() {
        return nutsId;
    }

    public void setNutsId(Long nutsId) {
        this.nutsId = nutsId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Long getSorting() {
        return sorting;
    }

    public void setSorting(Long sorting) {
        this.sorting = sorting;
    }

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }
}

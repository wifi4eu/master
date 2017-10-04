package wifi4eu.wifi4eu.common.dto.model;

public class NutsDTO {
    private int nutsId;
    private String code;
    private String label;
    private int level;
    private String countryCode;
    private int order;
    private int sorting;

    public NutsDTO() {
    }

    public NutsDTO(int nutsId, String code, String label, int level, String countryCode, int order, int sorting) {
        this.nutsId = nutsId;
        this.code = code;
        this.label = label;
        this.level = level;
        this.countryCode = countryCode;
        this.order = order;
        this.sorting = sorting;
    }

    public int getNutsId() {
        return nutsId;
    }

    public void setNutsId(int nutsId) {
        this.nutsId = nutsId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }
}
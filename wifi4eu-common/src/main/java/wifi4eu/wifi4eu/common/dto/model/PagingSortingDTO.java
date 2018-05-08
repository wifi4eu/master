package wifi4eu.wifi4eu.common.dto.model;

public class PagingSortingDTO {
    private Integer offset;
    private Integer count;
    private String orderField;
    private Integer orderType;

    public PagingSortingDTO() {
    }

    public PagingSortingDTO(Integer offset, Integer count, String orderField, Integer orderType) {
        this.offset = offset;
        this.count = count;
        this.orderField = orderField;
        this.orderType = orderType;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
}
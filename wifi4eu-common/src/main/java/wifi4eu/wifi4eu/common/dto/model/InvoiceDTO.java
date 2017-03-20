package wifi4eu.wifi4eu.common.dto.model;

public class InvoiceDTO {
    private Long invoiceId;
    private String name;
    private String serialNumber;
    private String productNumber;
    private String modelNumber;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long invoiceId, String name, String serialNumber, String productNumber, String modelNumber) {
        this.invoiceId = invoiceId;
        this.name = name;
        this.serialNumber = serialNumber;
        this.productNumber = productNumber;
        this.modelNumber = modelNumber;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
}
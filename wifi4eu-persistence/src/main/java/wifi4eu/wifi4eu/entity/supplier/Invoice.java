package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SUPP_CONTACTPERSON_T")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "INVOICE_ID")
    private Long invoiceId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;

    @Column(name = "PRODUCT_NUMBER")
    private String productNumber;

    @Column(name = "MODEL_NUMBER")
    private String modelNumber;

    public Invoice() {
    }

    public Invoice(Long invoiceId, String name, String serialNumber, String productNumber, String modelNumber) {
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
package wifi4eu.wifi4eu.entity.supplier;

import javax.persistence.*;

@Entity
@Table(name = "bank_account_document")
public class BankAccountDocument {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bank_account_id")
    private int bankAccountId;

    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "upload_time")
    private Long uploadTime;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "file_size")
    private int fileSize;

    @Column(name = "file_mime")
    private String fileMime;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "azure_uri")
    private String azureUri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public Long getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Long uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileMime() {
        return fileMime;
    }

    public void setFileMime(String fileMime) {
        this.fileMime = fileMime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAzureUri() {
        return azureUri;
    }

    public void setAzureUri(String azureUri) {
        this.azureUri = azureUri;
    }
}

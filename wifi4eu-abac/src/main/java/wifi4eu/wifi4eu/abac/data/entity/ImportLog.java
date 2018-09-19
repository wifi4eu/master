package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "WIF_IMPORT_LOG")
public class ImportLog {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "importLogIDGenerator")
    @SequenceGenerator(name = "importLogIDGenerator", sequenceName = "SEQ_IMPORT_LOG", allocationSize = 1)
    private Long id;

    @Column(name="FILENAME")
    private String fileName;

    @Column(name="IMPORT_DATE")
    private Date importDate;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="BATCH_REF")
    private String batchRef;

    @Column(name="ERRORS")
    private String errors;

    @PrePersist
    protected void onCreate() {
        this.importDate = Calendar.getInstance().getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBatchRef() {
        return batchRef;
    }

    public void setBatchRef(String batchRef) {
        this.batchRef = batchRef;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
}

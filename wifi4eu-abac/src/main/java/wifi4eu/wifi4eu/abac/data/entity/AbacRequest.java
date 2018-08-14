package wifi4eu.wifi4eu.abac.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "WIF_ABAC_REQUEST_PROCESS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "REQUEST_TYPE",
        columnDefinition = "REQUEST_TYPE"
)
public abstract class AbacRequest {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "abacBatchIDGenerator")
    @SequenceGenerator(name = "abacBatchIDGenerator", sequenceName = "SEQ_WIF_ABAC_STATUS", allocationSize = 1)
    private Integer id;

    @Column(name = "L_LOC_OBJ_FK")
    private String locObjForeignId;

    @Column(name = "L_QUE_ID", nullable = false, precision = 18, scale = 0)
    private Long lQueID;

    @Column(name = "SUBMIT_DATE", length = 20)
    private Date submitDate;

    @Column(name = "ERROR_MSG")
    private String errorMessage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocObjForeignId() {
        return locObjForeignId;
    }

    public void setLocObjForeignId(String locObjForeignId) {
        this.locObjForeignId = locObjForeignId;
    }

    public Long getlQueID() {
        return lQueID;
    }

    public void setlQueID(Long lQueID) {
        this.lQueID = lQueID;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "AbacRequest{" +
                "id=" + id +
                ", locObjForeignId='" + locObjForeignId + '\'' +
                ", lQueID=" + lQueID + '\'' +
                '}';
    }
}

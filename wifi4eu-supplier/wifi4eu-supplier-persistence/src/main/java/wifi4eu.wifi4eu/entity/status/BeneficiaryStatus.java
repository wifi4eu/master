package wifi4eu.wifi4eu.entity.status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "beneficiary_status")
public class BeneficiaryStatus {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="status", length = 75)
    private String status;

    @Column(name = "active", length = 20)
    private int active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    public BeneficiaryStatus(){

    }

    public BeneficiaryStatus(String status, int active, Date createdDate) {
        this.status = status;
        this.active = active;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "BeneficiaryStatus{" +
                "status='" + status + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}

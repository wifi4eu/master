package ec.europa.digit.euwifiops.euwifiops.entity.status;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="status")
public class Status {


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

    public Status(){

    }

    public Status(String status, int active, Date createdDate) {
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
        return "Status{" +
                "status='" + status + '\'' +
                ", active=" + active +
                ", createdDate=" + createdDate +
                '}';
    }
}

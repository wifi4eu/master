package wifi4eu.wifi4eu.entity.application;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;


@Entity
@Table(name = "application_invalidate_reason")
public class ApplicationInvalidateReason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @Column(name = "reason")
    private int reason;

    public ApplicationInvalidateReason() {
    }

    public ApplicationInvalidateReason(Integer id, Application application, int reason) {
        this.id = id;
        this.application = application;
        this.reason = reason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }

}

package wifi4eu.wifi4eu.entity.voucher;

import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "voucher_assignments")
public class VoucherAssignment {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "_user")
    private User user;

    @Column(name = "execution_date")
    private Long executionDate;

    @Column(name = "status")
    private Integer status;

    @OneToOne
    @JoinColumn(name = "call")
    private Call call;

    @Column(name = "notified_date")
    private Long notifiedDate;

    @OneToMany(mappedBy = "voucherAssignment", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<VoucherSimulation> voucherSimulations;

    public VoucherAssignment() {
    }

    public VoucherAssignment(Integer id, User user, Long executionDate, Integer status, Call call, Long notifiedDate, Set<VoucherSimulation> voucherSimulations) {
        this.id = id;
        this.user = user;
        this.executionDate = executionDate;
        this.status = status;
        this.call = call;
        this.notifiedDate = notifiedDate;
        this.voucherSimulations = voucherSimulations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Long executionDate) {
        this.executionDate = executionDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Long getNotifiedDate() {
        return notifiedDate;
    }

    public void setNotifiedDate(Long notifiedDate) {
        this.notifiedDate = notifiedDate;
    }

    public Set<VoucherSimulation> getVoucherSimulations() {
        return voucherSimulations;
    }

    public void setVoucherSimulations(Set<VoucherSimulation> voucherSimulations) {
        this.voucherSimulations = voucherSimulations;
    }

    public interface VoucherAssignmentGetIdAndNotificationDate {
        Integer getId();
        Long getNotifiedDate();
    }

}

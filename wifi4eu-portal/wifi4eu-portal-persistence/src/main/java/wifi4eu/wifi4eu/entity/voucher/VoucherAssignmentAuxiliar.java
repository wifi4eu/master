package wifi4eu.wifi4eu.entity.voucher;

import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;

@Entity
@Table(name = "voucher_assignments")
public class VoucherAssignmentAuxiliar {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "execution_date")
    private Long executionDate;

    @Column(name = "status")
    private Integer status;

    public VoucherAssignmentAuxiliar() {

    }

    public VoucherAssignmentAuxiliar(Long executionDate, Integer status) {
        this.executionDate = executionDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}

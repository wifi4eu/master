package wifi4eu.wifi4eu.entity.voucherManagement;

import wifi4eu.wifi4eu.entity.call.Call;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "voucher_management")
public class VoucherManagement {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "minimum")
    private Integer minimum;

    @Column(name = "maximum")
    private Integer maximum;

    @Column(name = "member_state")
    private String member_state;

    @ManyToOne
    @JoinColumn(name = "call_id")
    private Call voucherCall;

    public VoucherManagement(Integer id, Integer minimum, Integer maximum, String member_state, Call voucherCall) {
        this.id = id;
        this.minimum = minimum;
        this.maximum = maximum;
        this.member_state = member_state;
        this.voucherCall = voucherCall;
    }

    public VoucherManagement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public String getMember_state() {
        return member_state;
    }

    public void setMember_state(String member_state) {
        this.member_state = member_state;
    }

    public Call getVoucherCall() {
        return voucherCall;
    }

    public void setVoucherCall(Call voucherCall) {
        this.voucherCall = voucherCall;
    }
}
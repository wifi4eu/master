package wifi4eu.wifi4eu.common.dto.model;

import java.util.Date;

/**
 * Created by rgarcita on 23/02/2017.
 */
public class VoucherManagementDTO {

    private int id;
    private int call_id;
    private String member_state;
    private int minimum;
    private int maximum;

    public VoucherManagementDTO() {
    }

    public VoucherManagementDTO(int id, int call_id, String member_state, int minimum, int maximum) {
        this.id = id;
        this.call_id = call_id;
        this.member_state = member_state;
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCall_id() {
        return call_id;
    }

    public void setCall_id(int call_id) {
        this.call_id = call_id;
    }

    public String getMember_state() {
        return member_state;
    }

    public void setMember_state(String member_state) {
        this.member_state = member_state;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

}

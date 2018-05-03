package wifi4eu.wifi4eu.common.dto.model;

import java.util.Date;

/**
 * Created by rgarcita on 23/02/2017.
 */
public class VoucherManagementDTO {

    private int id;
    private int call_id;
    private String member_state;
    private String countryCode;
    private int minimum;
    private int maximum;
    private int reserve;

    public VoucherManagementDTO() {
    }

    public VoucherManagementDTO(int id, int call_id, String member_state, String countryCode, int minimum, int maximum, int reserve) {
        this.id = id;
        this.call_id = call_id;
        this.member_state = member_state;
        this.minimum = minimum;
        this.maximum = maximum;
        this.reserve = reserve;
        this.countryCode = countryCode;
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

    public int getReserve() {
        return reserve;
    }

    public void setReserve(int reserve) {
        this.reserve = reserve;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

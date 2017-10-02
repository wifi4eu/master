package wifi4eu.wifi4eu.entity.voucher;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rgarcita on 23/02/2017.
 */
@Entity
@Table(name="VOU_VOUCHER_T")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="VOUCHER_ID")
    private Long voucherId;

    @Column(name="USER_ID")
    private Long userId;

    @Column(name="LEGAL_ENTITY_ID")
    private Long legalEntityId;

    @Column(name="CALL_ID")
    private Long callId;

    @Temporal(TemporalType.DATE)
    @Column(name="CREATE_DATE")
    private Date createDate;

    @Column(name="COUNTRY_CODE")
    private String countryCode;

    @Column(name="NUTS3")
    private String nuts3;

    @Column(name="LAU1")
    private String lau1;

    @Column(name="LAU2")
    private String lau2;

    public Voucher(){}

    public Voucher(Long voucherId, Long userId, Long callId, Date createDate, String countryCode, String nuts3, String lau1, String lau2) {
        this.voucherId = voucherId;
        this.userId = userId;
        this.callId = callId;
        this.createDate = createDate;
        this.countryCode = countryCode;
        this.nuts3 = nuts3;
        this.lau1 = lau1;
        this.lau2 = lau2;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLegalEntityId() {
        return legalEntityId;
    }

    public void setLegalEntityId(Long legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNuts3() {
        return nuts3;
    }

    public void setNuts3(String nuts3) {
        this.nuts3 = nuts3;
    }

    public String getLau1() {
        return lau1;
    }

    public void setLau1(String lau1) {
        this.lau1 = lau1;
    }

    public String getLau2() {
        return lau2;
    }

    public void setLau2(String lau2) {
        this.lau2 = lau2;
    }
}

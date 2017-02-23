package wifi4eu.wifi4eu.common.dto.model;

import java.util.Date;

/**
 * Created by rgarcita on 23/02/2017.
 */
public class VoucherDTO {

    private Long voucherId;
    private Long userId;
    private Long legalEntityId;
    private Date createDate;
    private String countryCode;
    private String nuts3;
    private String lau1;
    private String lau2;

    public VoucherDTO(){}

    public VoucherDTO(Long voucherId, Long userId, Long legalEntityId, Date createDate, String countryCode, String nuts3, String lau1, String lau2) {
        this.voucherId = voucherId;
        this.userId = userId;
        this.legalEntityId = legalEntityId;
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

package wifi4eu.wifi4eu.common.dto.model;

public class ApplicationVoucherInfoDTO {
    private int callId;
    private int applicationId;
    private String municipalityName;
    private String countryName;
    private boolean voucherAwarded;

    public ApplicationVoucherInfoDTO() {
    }

    public ApplicationVoucherInfoDTO(int callId, int applicationId, String municipalityName, String countryName, boolean voucherAwarded) {
        this.callId = callId;
        this.applicationId = applicationId;
        this.municipalityName = municipalityName;
        this.countryName = countryName;
        this.voucherAwarded = voucherAwarded;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean isVoucherAwarded() {
        return voucherAwarded;
    }

    public void setVoucherAwarded(boolean voucherAwarded) {
        this.voucherAwarded = voucherAwarded;
    }
}
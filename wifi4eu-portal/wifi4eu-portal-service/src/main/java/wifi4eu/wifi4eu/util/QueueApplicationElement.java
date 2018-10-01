package wifi4eu.wifi4eu.util;

public class QueueApplicationElement {

    int callId;
    int userId;
    int registrationId;
    int municipalityId;
    long fileUploadTimestamp;
    long queueTimestamp;
    String ipAddress;

    public QueueApplicationElement() {
    }

    public QueueApplicationElement(int callId, int userId, int registrationId, int municipalityId, long fileUploadTimestamp, long queueTimestamp, String ipAddress) {
        this.callId = callId;
        this.userId = userId;
        this.registrationId = registrationId;
        this.municipalityId = municipalityId;
        this.fileUploadTimestamp = fileUploadTimestamp;
        this.queueTimestamp = queueTimestamp;
        this.ipAddress = ipAddress;
    }

    public int getCallId() {
        return callId;
    }

    public void setCallId(int callId) {
        this.callId = callId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    public long getFileUploadTimestamp() {
        return fileUploadTimestamp;
    }

    public void setFileUploadTimestamp(long fileUploadTimestamp) {
        this.fileUploadTimestamp = fileUploadTimestamp;
    }

    public long getQueueTimestamp() {
        return queueTimestamp;
    }

    public void setQueueTimestamp(long queueTimestamp) {
        this.queueTimestamp = queueTimestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}

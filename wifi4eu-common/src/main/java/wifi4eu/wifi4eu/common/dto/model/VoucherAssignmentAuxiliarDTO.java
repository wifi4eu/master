package wifi4eu.wifi4eu.common.dto.model;

public class VoucherAssignmentAuxiliarDTO {

    private Integer id;
    private Long executionDate;
    private Integer status;
    private Boolean hasPreListSaved;
    private Long preListExecutionDate;
    private Boolean hasFreezeListSaved;
    private Long freezeLisExecutionDate;
    private Long notifiedDate;

    public VoucherAssignmentAuxiliarDTO() {

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

    public Boolean getHasPreListSaved() {
        return hasPreListSaved;
    }

    public void setHasPreListSaved(Boolean hasPreListSaved) {
        this.hasPreListSaved = hasPreListSaved;
    }

    public Long getPreListExecutionDate() {
        return preListExecutionDate;
    }

    public void setPreListExecutionDate(Long preListExecutionDate) {
        this.preListExecutionDate = preListExecutionDate;
    }

    public Boolean getHasFreezeListSaved() {
        return hasFreezeListSaved;
    }

    public void setHasFreezeListSaved(Boolean hasFreezeListSaved) {
        this.hasFreezeListSaved = hasFreezeListSaved;
    }

    public Long getFreezeLisExecutionDate() {
        return freezeLisExecutionDate;
    }

    public void setFreezeLisExecutionDate(Long freezeLisExecutionDate) {
        this.freezeLisExecutionDate = freezeLisExecutionDate;
    }

    public Long getNotifiedDate() {
        return notifiedDate;
    }

    public void setNotifiedDate(Long notifiedDate) {
        this.notifiedDate = notifiedDate;
    }
}

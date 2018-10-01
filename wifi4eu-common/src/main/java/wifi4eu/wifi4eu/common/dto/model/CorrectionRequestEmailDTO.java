package wifi4eu.wifi4eu.common.dto.model;

public class CorrectionRequestEmailDTO {
    private Integer id;
    private Integer callId;
    private Long date;
    private Integer buttonPressedCounter;

    public CorrectionRequestEmailDTO() {
    }

    public CorrectionRequestEmailDTO(Integer id, Integer callId, Long date, Integer buttonPressedCounter) {
        this.id = id;
        this.callId = callId;
        this.date = date;
        this.buttonPressedCounter = buttonPressedCounter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCallId() {
        return callId;
    }

    public void setCallId(Integer callId) {
        this.callId = callId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getButtonPressedCounter() {
        return buttonPressedCounter;
    }

    public void setButtonPressedCounter(Integer buttonPressedCounter) {
        this.buttonPressedCounter = buttonPressedCounter;
    }
}
package wifi4eu.wifi4eu.entity.application;

import javax.persistence.*;

@Entity
@Table(name = "correction_requests_emails")
public class CorrectionRequestEmail {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "call")
    private Integer callId;

    @Column(name = "date")
    private Long date;

    @Column(name = "button_pressed_counter")
    private Integer buttonPressedCounter;

    public CorrectionRequestEmail() {
    }

    public CorrectionRequestEmail(Integer id, Integer callId, Long date, Integer buttonPressedCounter) {
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
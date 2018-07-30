package wifi4eu.wifi4eu.entity.call;

import javax.persistence.*;

@Entity
@Table(name = "calls")
public class CallCustom {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event")
    private String event;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "end_date")
    private Long endDate;

    private int voucherCompetitionState;


    public CallCustom() {

    }

    public CallCustom(Integer id, String event, Long startDate, Long endDate, int voucherCompetitionState) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
        this.voucherCompetitionState = voucherCompetitionState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public int getVoucherCompetitionState() {
        return voucherCompetitionState;
    }

    public void setVoucherCompetitionState(int voucherCompetitionState) {
        this.voucherCompetitionState = voucherCompetitionState;
    }
}

package wifi4eu.wifi4eu.entity.call;

import javax.persistence.*;

@Entity
@Table(name = "calls")
public class Call {
    @Id
    @SequenceGenerator(name = "call_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "call_seq")
    @Column(name = "id")
    Integer id;

    @Column(name = "event")
    String event;

    @Column(name = "start_date")
    Long startDate;

    @Column(name = "end_date")
    Long endDate;

    public Call() {
    }

    public Call(Integer id, String event, Long startDate, Long endDate) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
package wifi4eu.wifi4eu.entity.call;

import wifi4eu.wifi4eu.entity.timeline.Timeline;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "calls")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "event")
    private String event;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "end_date")
    private Long endDate;

    @OneToMany(mappedBy = "call")
    private List<Timeline> timelines;

    public Call() {
    }

    public Call(Integer id, String event, Long startDate, Long endDate, List<Timeline> timelines) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timelines = timelines;
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

    public List<Timeline> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<Timeline> timelines) {
        this.timelines = timelines;
    }
}
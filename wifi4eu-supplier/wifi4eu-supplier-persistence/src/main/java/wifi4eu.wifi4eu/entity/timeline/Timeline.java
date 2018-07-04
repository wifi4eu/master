package wifi4eu.wifi4eu.entity.timeline;

import wifi4eu.wifi4eu.entity.call.Call;

import javax.persistence.*;

@Entity
@Table(name = "timelines")
public class Timeline {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "call_id")
    private Call call;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Long startDate;

    @Column(name = "end_date")
    private Long endDate;

    public Timeline() {
    }

    public Timeline(Integer id, Call call, String description, Long startDate, Long endDate) {
        this.id = id;
        this.call = call;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
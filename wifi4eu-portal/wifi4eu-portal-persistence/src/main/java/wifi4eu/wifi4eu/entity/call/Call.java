package wifi4eu.wifi4eu.entity.call;

import wifi4eu.wifi4eu.entity.timeline.Timeline;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "calls")
public class Call {
    @Id
    @SequenceGenerator(name = "call_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "call_seq")
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

    @OneToMany(mappedBy = "voucherCall")
    private List<VoucherManagement> voucherManagements;


    public Call() {
    }

    public Call(Integer id, String event, Long startDate, Long endDate, List<Timeline> timelines, List<VoucherManagement> voucherManagements) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timelines = timelines;
        this.voucherManagements = voucherManagements;
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

    public List<VoucherManagement> getVoucherManagements() {
        return voucherManagements;
    }

    public void setVoucherManagements(List<VoucherManagement> voucherManagements) {
        this.voucherManagements = voucherManagements;
    }
}
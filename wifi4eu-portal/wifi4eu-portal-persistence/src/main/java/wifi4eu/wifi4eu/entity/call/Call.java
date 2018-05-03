package wifi4eu.wifi4eu.entity.call;

import wifi4eu.wifi4eu.entity.timeline.Timeline;
import wifi4eu.wifi4eu.entity.voucherManagement.VoucherManagement;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "calls")
public class Call {

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
    
    @Column(name = "budget")
    private Integer budget;

    @Column(name = "reserve")
    private Integer reserve;

    @Column(name = "number_vouchers")
    private Integer numberVouchers;

    @Column(name = "max_percent_country")
    private Integer maxPercentCountry;

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

    public Call(Integer id, String event, Long startDate, Long endDate, Integer budget, Integer numberVouchers, Integer reserve, Integer maxPercentCountry, List<Timeline> timelines, List<VoucherManagement> voucherManagements) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.numberVouchers = numberVouchers;
        this.reserve = reserve;
        this.maxPercentCountry = maxPercentCountry;
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

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getNumberVouchers() {
        return numberVouchers;
    }

    public void setNumberVouchers(Integer numberVouchers) {
        this.numberVouchers = numberVouchers;
    }

    public Integer getMaxPercentCountry() {
        return maxPercentCountry;
    }

    public void setMaxPercentCountry(Integer maxPercentCountry) {
        this.maxPercentCountry = maxPercentCountry;
    }

    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }
}
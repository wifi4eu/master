package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class CallDTO {
    private int id;
    private String event;
    private long startDate;
    private long endDate;
    private int budget;
    private int budgetVoucher;
    private List<TimelineDTO> timelines;
    private List<VoucherManagementDTO> voucherManagements;

    public CallDTO() {
    }

    public CallDTO(int id, String event, long startDate, long endDate, List<TimelineDTO> timelines, List<VoucherManagementDTO> voucherManagements) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
        this.timelines = timelines;
        this.voucherManagements = voucherManagements;
    }

    public CallDTO(int id, String event, long startDate, long endDate, int budget, int budgetVoucher, List<TimelineDTO> timelines, List<VoucherManagementDTO> voucherManagements) {
        this.id = id;
        this.event = event;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.timelines = timelines;
        this.budgetVoucher = budgetVoucher;
        this.voucherManagements = voucherManagements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public List<TimelineDTO> getTimelines() {
        return timelines;
    }

    public void setTimelines(List<TimelineDTO> timelines) {
        this.timelines = timelines;
    }

    public List<VoucherManagementDTO> getVoucherManagements() {
        return voucherManagements;
    }

    public void setVoucherManagements(List<VoucherManagementDTO> voucherManagements) {
        this.voucherManagements = voucherManagements;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getBudgetVoucher() {
        return budgetVoucher;
    }

    public void setBudgetVoucher(int budgetVoucher) {
        this.budgetVoucher = budgetVoucher;
    }
}
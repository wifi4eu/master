package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.Date;

public class AdminActionsDTO implements Serializable {

    private String action;
    private boolean isRunning;
    private Date startDate;

    public AdminActionsDTO() {
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

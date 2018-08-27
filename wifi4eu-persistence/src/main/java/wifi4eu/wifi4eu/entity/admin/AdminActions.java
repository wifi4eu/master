package wifi4eu.wifi4eu.entity.admin;

import wifi4eu.wifi4eu.entity.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin_actions")
public class AdminActions {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "action")
    private String action;

    @ManyToOne
    @JoinColumn(name = "_user")
    private User user;

    @Column(name = "is_running")
    private boolean isRunning;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    public AdminActions() {
    }

    public AdminActions(Integer id, String action, User user, boolean isRunning, Date startDate, Date endDate) {
        this.id = id;
        this.action = action;
        this.user = user;
        this.isRunning = isRunning;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

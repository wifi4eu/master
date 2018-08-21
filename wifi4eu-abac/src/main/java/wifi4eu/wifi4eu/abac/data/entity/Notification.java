package wifi4eu.wifi4eu.abac.data.entity;

import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.NotificationStatus;
import wifi4eu.wifi4eu.abac.data.enums.NotificationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "WIF_NOTIFICATION")
public class Notification {

    @Id
    @Column(name = "ID", unique = true, nullable = false, precision = 18, scale = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificationIDGenerator")
    @SequenceGenerator(name = "notificationIDGenerator", sequenceName = "SEQ_NOTIFICATION", allocationSize = 1)
    private Long id;

    @Column(name = "NOTIFICATION_TYPE", length = 100)
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    @Column(name="SEND_TO")
    private String sendTo;

    @Column(name="BATCH_REF")
    private String batchRef;

    @Column(name = "STATUS", length = 100)
    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getBatchRef() {
        return batchRef;
    }

    public void setBatchRef(String batchRef) {
        this.batchRef = batchRef;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }
}

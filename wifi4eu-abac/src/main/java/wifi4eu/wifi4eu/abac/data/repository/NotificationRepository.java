package wifi4eu.wifi4eu.abac.data.repository;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.abac.data.entity.Notification;
import wifi4eu.wifi4eu.abac.data.enums.NotificationStatus;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

    List<Notification> findAllByNotificationStatusEquals(NotificationStatus notificationStatus);
}

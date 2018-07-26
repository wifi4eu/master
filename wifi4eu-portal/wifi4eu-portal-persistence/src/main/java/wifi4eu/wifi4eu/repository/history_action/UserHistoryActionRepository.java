package wifi4eu.wifi4eu.repository.history_action;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import wifi4eu.wifi4eu.entity.history_action.UserHistoryAction;

import java.util.List;

public interface UserHistoryActionRepository extends Repository<UserHistoryAction, Integer> {
    @Query(value = "SELECT (lf.id) as id, (m.name) as municipality, ('benefPortal.myHistory.actionPerformed.supportingDocumentsUploaded') as actionPerformed, (lf.upload_time) as date FROM registrations r INNER JOIN registration_users ru ON ru.registration = r.id INNER JOIN users u ON u.id = ru._user INNER JOIN municipalities m ON m.id = r.municipality INNER JOIN legal_files lf ON lf.registration = r.id WHERE u.id = ?#{[0]}", nativeQuery = true)
    List<UserHistoryAction> findLegalFilesActionsHistoryByUserId(Integer userId);

    @Query(value = "SELECT (app.id) as id, (m.name) as municipality, ('benefPortal.myHistory.actionPerformed.applicationSubmitted') as actionPerformed, (app.date) as date FROM registrations r INNER JOIN registration_users ru ON ru.registration = r.id INNER JOIN users u ON u.id = ru._user INNER JOIN municipalities m ON m.id = r.municipality INNER JOIN applications app ON app.registration = r.id WHERE u.id = ?#{[0]} AND app.call_id = ?#{[1]}", nativeQuery = true)
    List<UserHistoryAction> findApplicationActionsHistoryByUserIdAndCallId(Integer userId, Integer callId);
}
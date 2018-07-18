package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.ApplyVoucher;

import java.util.List;

public interface ApplyVoucherRepository extends CrudRepository<ApplyVoucher,Integer> {

    @Query(value = "SELECT ru.registration as reg_id, m.id as mun_id, r.allFiles_flag as files_uploaded, r.upload_time as upload_time FROM registration_users ru INNER JOIN registrations r ON r.id = ru.registration INNER JOIN municipalities m ON m.id = r.municipality WHERE ru._user = ?1", nativeQuery = true)
    List<ApplyVoucher> findDataToApplyVoucher(int idUser);
}

package wifi4eu.wifi4eu.repository.beneficiary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryFinalListItem;

import java.util.List;

public interface BeneficiaryFinalListItemRepository extends JpaRepository<BeneficiaryFinalListItem, Integer> {

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?1",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalList(Integer callId);

    @Query(value = " SELECT count(*) FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "WHERE va.status = 3 and va.call = ?1",
            nativeQuery = true)
    Integer countBeneficiariesFromFinalList(Integer callId);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY name ASC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByNameASC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY name DESC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByNameDESC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY countryCode ASC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByCountryASC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY countryCode DESC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByCountryDESC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY registrationId ASC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByRegistrationIdASC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY registrationId DESC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByRegistrationIdDESC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY verifiedToSign ASC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByVerifiedToSignASC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY verifiedToSign DESC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByVerifiedToSignDESC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY dateSignature ASC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByDateSignatureASC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id  " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY dateSignature DESC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByDateSignatureDESC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY dateCounterSignature ASC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByDateCounterSignatureASC(Integer callId, String countryCode, String municipality, Integer page, Integer size);


    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "ga.date_signature AS dateSignature, " +
            "ga.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY dateCounterSignature DESC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByDateCounterSignatureDESC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "a.date_signature AS dateSignature, " +
            "a.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY status ASC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByStatusASC(Integer callId, String countryCode, String municipality, Integer page, Integer size);


    @Query(value = "SELECT a.id, " +
            "m.name AS name, " +
            "l.country_code AS countryCode, " +
            "a.registration AS registrationId, " +
            "cast (CASE WHEN (SELECT COUNT(*) FROM authorized_person_application where application_id = a.id) = 0 THEN 0 ELSE 1 END AS bit) AS verifiedToSign, " +
            "a.date_signature AS dateSignature, " +
            "a.date_counter_signature AS dateCounterSignature," +
            "l.id as lauId, " +
            "a._status AS status " +
            "FROM voucher_simulations vs " +
            "INNER JOIN voucher_assignments va ON vs.voucher_assignment = va.id " +
            "INNER JOIN municipalities m ON vs.municipality = m.id " +
            "INNER JOIN applications a ON vs.application = a.id " +
            "LEFT JOIN grant_agreement ga ON ga.application_id = a.id " +
            "INNER JOIN laus l ON m.lau = l.id " +
            "WHERE va.status = 3 and va.call = ?#{[0]} AND " +
            "l.country_code LIKE ?#{[1]} AND LOWER(name) LIKE LOWER(CONCAT('%',?#{[2]},'%'))" +
            "ORDER BY status DESC OFFSET ((?#{[3]})*?#{[4]}) ROWS FETCH NEXT ?#{[4]} ROWS ONLY",
            nativeQuery = true)
    List<BeneficiaryFinalListItem> findBeneficiariesFromFinalListOrderByStatusDESC(Integer callId, String countryCode, String municipality, Integer page, Integer size);

}
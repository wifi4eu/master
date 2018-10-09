package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;

import java.util.List;

public interface ExportImportRegistrationDataRepository extends CrudRepository<ExportImportRegistrationData,Integer> {

    @Query(value = "select distinct d from ExportImportRegistrationData d " +
            "inner join d.municipality.registrations r " +
            "inner join r.applications a " +
            "where d.abacReference is not null " +
            "and d.municipality.budgetaryCommitments is empty " +
            "and a.grantAgreements is not empty")
    List<ExportImportRegistrationData> findRegistrationDataForBudgetaryCommitment();

}

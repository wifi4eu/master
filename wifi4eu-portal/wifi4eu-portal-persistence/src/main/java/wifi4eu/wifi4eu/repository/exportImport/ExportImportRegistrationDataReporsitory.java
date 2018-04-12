package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;

public interface ExportImportRegistrationDataReporsitory extends CrudRepository<ExportImportRegistrationData,Integer> {
    @Query(value = "select \n" +
        "r.id as id, \n" +
        "r.id as euRank, \n" +
        "r.id as countryRank, \n" +
        "m.country  as countryName, \n" +
        "m.name as municipalityName, \n" +
        "r.id as issue, \n" +
        "r.id as numberOfRegistartions, \n" +
        "r.id as abacReference, \n" +
        "r.id as abacStandarName, \n" +
        "r.id as municipality \n" +
        "from \n" +
        "registrations as r \n" +
        "left join \n" +
        "municipalities as m on r.municipality = m.id \n" +
        "left join \n" +
        "users as u \n" +
        "on r._user = u.id \n" +
        "where u.type is not null and m.name is not null", nativeQuery = true)
    Iterable<ExportImportRegistrationData> findExportImport();
}

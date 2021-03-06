package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;

public interface ExportImportRegistrationDataRepository extends CrudRepository<ExportImportRegistrationData,Integer> {
    @Query(value = "select \n" +
        "r.municipality as id, \n" +
        "r.municipality as euRank, \n" +
        "r.municipality as countryRank, \n" +
        "m.country  as countryName, \n" +
        "m.name as municipalityName, \n" +
        "r.municipality as issue, \n" +
        "r.municipality as numberOfRegistartions, \n" +
        "m.name as abacReference, \n" +
        "m.name as abacStandarName, \n" +
        "r.municipality as municipality \n" +
        "from \n" +
        "registrations as r \n" +
        "left join \n" +
        "municipalities as m on r.municipality = m.id \n" +
        "left join \n" +
        "users as u \n" +
        "on r._user = u.id \n" +
        "where u.type is not null and m.name is not null", nativeQuery = true)
    Iterable<ExportImportRegistrationData> findExportImportRD();

}

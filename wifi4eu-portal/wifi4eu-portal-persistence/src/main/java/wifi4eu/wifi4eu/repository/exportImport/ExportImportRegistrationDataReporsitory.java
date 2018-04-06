package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportRegistrationData;
import wifi4eu.wifi4eu.entity.municipality.Municipality;

//public interface ExportImportRegistrationDataReporsitory{
public interface ExportImportRegistrationDataReporsitory extends CrudRepository<ExportImportRegistrationData,Integer> {
    @Query(value = "select \n" +
            "r.id as rId, \n" +
            "m.country as mCountry, \n" +
            "m.name as mName, \n" +
            "u.name as uName, \n" +
            "u.EcasEmail as uEcasEmail, \n" +
            "u.EcasUserName as uEcasUserName, \n" +
            "r.type as uType \n" +
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

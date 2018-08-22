package wifi4eu.wifi4eu.repository.exportImport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.exportImport.ExportImportBudgetaryCommitment;

public interface ExportImportBudgetaryCommitmentRepository extends CrudRepository<ExportImportBudgetaryCommitment,Integer> {
    @Query(value = "select \n" +
            "r.id as id, \n"+
            "m.name as mun_OfficialName, \n" +
            "m.address as mun_OfficialAddress, \n" +
            "o.name as org_Name, \n" +
            "o.type as org_TypeCode, \n" +
            "s.name as sup_Name, \n" +
            "s.account_number as sup_BankAccount, \n" +
            "r.id as reg_RegistartionNumber, \n" +
            "a.voucher_awarded as app_VoucherAwarded, \n" +
            "a.bc_status as app_BcStatus, \n" +
            "a.bc_export as app_BcExport, \n" +
            "a.bc_import as app_BcImport, \n" +
            "a.lef_status as app_LefStatus, \n" +
            "a.lef_export as app_LefExport, \n" +
            "a.lef_import as app_LefImport \n" +
            "from \n" +
            "registrations as r \n" +
            "left join \n" +
            "municipalities as m on r.municipality = m.id \n" +
            "left join \n" +
            "organizations as o on r.organisation_id = o.id \n" +
            "left join \n" +
            "users as u on r._user = u.id \n" +
            "left join \n" +
            "applications as a on r.id=a.registration \n" +
            "left join \n" +
            "suppliers s on a.supplier=s.id \n" +
            "where u.type is not null and m.name is not null", nativeQuery = true)
    Iterable<ExportImportBudgetaryCommitment> findExportImportBC();
}

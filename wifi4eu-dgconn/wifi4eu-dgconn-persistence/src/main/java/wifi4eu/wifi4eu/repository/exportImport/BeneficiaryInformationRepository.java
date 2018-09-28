package wifi4eu.wifi4eu.repository.exportImport;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;
import wifi4eu.wifi4eu.entity.exportImport.BeneficiaryInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BeneficiaryInformationRepository {

    @PersistenceContext
    private EntityManager entityManager;


    private static final String BENEFICIARY_INFO_QUERY = "select distinct r.id as id, "
            + "m.id as mun_id, "
            + "m.name as mun_name, "
            + "concat(m.address, ', ', m.address_num) as mun_address, "
            + "m.postal_code as mun_postalCode, "
            + "l.name2 as mun_city, "
            + "l.country_code as mun_countryCodeISO, "
            + "r.id as mun_registrationNumber, "

            // TODO: missing data mun_languageCodeISO.
            /*+ "m.mun_languageCodeISO as mun_languageCodeISO, "*/

            // This looks like an incorrect place to take these data from.
			/*+ "ga.id as doc_portalId, "
			+ "ga.document_language as mun_languageCodeISO, "
			+ "ga.date_signature as doc_date, "
			+ "ga.document_location as doc_location, "
			+ "'GRANT AGREEMENT' as doc_type, "*/

            + "lf.id as doc_portalId, "
            + "lf.file_name as doc_fileName, "
            + "lf.file_mime as doc_mimeType, "
            + "lf.upload_time as doc_date, "
            + "lf.type as doc_type, "
            + "lf.azure_uri as azureUri, "

            // TODO: missing data: ares_reference.
            /*+ "lf.ares_reference as ares_reference, "*/

            + "ma.abacReference as mun_abacReference, "
            + "ma.abacStandarName as mun_abacName, "
            + "va.call as mun_callNumber, "
            + "u.lang as user_lang "

            + "from applications as a "
            + "left join registrations as r on a.registration = r.id "
            + "left join municipalities as m on r.municipality = m.id "
            + "left join municipalities_abac as ma on ma.municipality = m.id "
            + "left join laus as l on m.lau = l.id "

//			+ "left join GRANT_AGREEMENT as ga on ga.application_id = a.id "
            + "inner join legal_files as lf on lf.registration = r.id and lf.type = 1 "

            + "inner join voucher_simulations as vs on vs.municipality = m.id "
            + "inner join voucher_assignments as va on va.id = vs.voucher_assignment "
            + "left join registration_users as ru on r.id = ru.registration "
            + "left join users as u on u.id = ru._user "
            + "where m.name is not null and va.status = 3 and ma.abacReference is null";


    public List<BeneficiaryInformation> getBeneficiariesInformationSignedAndNotCounterSigned() {
        List<Object[]> bcs = entityManager.createNativeQuery(BENEFICIARY_INFO_QUERY).getResultList();

        List<BeneficiaryInformation> beneficiaryInformations = new ArrayList<>();

        // TODO: this is a temp solution subject to change when we refactor out native sql queries
        if (CollectionUtils.isNotEmpty(bcs)) {
            for (Object[] object : bcs) {
                beneficiaryInformations.add(new BeneficiaryInformation(
                        (Integer) object[0],
                        object[1] != null ? (object[1] + "") : "",
                        (String) object[2],
                        (String) object[15],
                        (String) object[3],
                        (String) object[4],
                        (String) object[5],
                        (String) object[6],
                        (String) object[17],
                        object[7] != null ? ((Integer) object[7]).longValue() : null,
                        (String) object[14],
                        (Integer) object[16],
                        object[8] != null ? ((Integer) object[8]).longValue() : null,
                        (String) object[9],
                        (String) object[9],
                        (String) object[10],
                        object[11] != null ? new Date(((Long) object[11])) : null,
                        (Integer) object[12],
                        "",
                        "",
                        (String) object[13]
                ));
            };
        }

        return beneficiaryInformations;
    }

}

package wifi4eu.wifi4eu.service.beneficiary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.helper.StringPool;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.entity.beneficiary.BeneficiaryMyInstallation;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryMyInstallationRepository;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryMyInstallationRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class BeneficiaryMyInstallationRepositoryImpl implements BeneficiaryMyInstallationRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    private static final Logger logger = LoggerFactory.getLogger(BeneficiaryMyInstallationRepositoryImpl.class);

    public static final String BENEFICIARY_LIST_SQL = "SELECT a.id, m.name, m.country, a.select_supplier_date as selectSupplierDate, a" +
            ".bank_account_id as bankAccountId FROM municipalities m INNER JOIN registrations r ON r.municipality = m.id INNER JOIN applications a " +
            "ON a.registration = r.id WHERE r._status = 2";

    @Override
    public List<BeneficiaryMyInstallation> searchBeneficiariesListMyInstallation(Integer supplierId, String fieldOrder, String orderDirection, Integer page,
                                                                                 Integer rowsPerPage) {
        Query query = generateSqlBeneficiariesList(supplierId, fieldOrder, orderDirection, page, rowsPerPage);
        return query.getResultList();
    }

    private Query generateSqlBeneficiariesList(Integer supplierId, String fieldOrder, String orderDirection, Integer page, Integer rowsPerPage) {
        if (Validator.isNull(page)) {
            page = 1;
        }
        if (Validator.isNull(rowsPerPage)) {
            rowsPerPage = 5;
        }
        if (Validator.isEmpty(fieldOrder)) {
            fieldOrder = "id";
        }

        StringBuilder sqlBuilder = new StringBuilder(BENEFICIARY_LIST_SQL);
        //where
        sqlBuilder.append(StringPool.SPACE).append("AND a.supplier =").append(StringPool.SPACE).append(supplierId);
        //order
        sqlBuilder.append(StringPool.SPACE).append("ORDER BY").append(StringPool.SPACE).append(fieldOrder).append(StringPool.SPACE).append(orderDirection);
        //pagination
        sqlBuilder.append(StringPool.SPACE).append("OFFSET").append(StringPool.SPACE).append(page).append(StringPool.SPACE).append("ROWS FETCH NEXT").append(StringPool
                .SPACE).append(rowsPerPage).append(StringPool.SPACE).append("ROWS ONLY");

        logger.info("Query : " + sqlBuilder.toString());
        return entityManager.createNativeQuery(sqlBuilder.toString(), BeneficiaryMyInstallation.class);
    }
}

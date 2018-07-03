package wifi4eu.wifi4eu.service.installation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.installation.InstallationSite;
import wifi4eu.wifi4eu.repository.installation.InstallationSiteRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class InstallationSiteRepositoryImpl implements InstallationSiteRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    private final Logger _log = LoggerFactory.getLogger(InstallationSiteRepositoryImpl.class);

    @Override
    public List<InstallationSite> searchInstallationSitesByBeneficiary(int page, int delta, int id_beneficiary, String fieldName, String orderField) {
        Query query = generateSqlInstallationSites(page, delta, id_beneficiary, fieldName, orderField, false);
        return query.getResultList();
    }

    @Override
    public int countInstallationSitesByBeneficiary(int page, int delta, int id_beneficiary, String fieldName, String orderField) {
        Query query = generateSqlInstallationSites(page, delta, id_beneficiary, fieldName, orderField, true);
        return (int) query.getSingleResult();
    }

    private Query generateSqlInstallationSites(int page, int delta, int id_beneficiary, String fieldName, String orderField, boolean count) {
        String queryString = "SELECT i.number, i.id, i.name, i.domain_name FROM installation_site i INNER JOIN municipalities m ON m.id = i.id_municipality WHERE m.id = ?1";
        Query query = null;
        if (count) {
            queryString = "SELECT COUNT(i.name) FROM installation_site i INNER JOIN municipalities m ON m.id = i.id_municipality WHERE m.id = ?1";
        }

        StringBuilder sqlBuilder = new StringBuilder(queryString);
        query = entityManager.createNativeQuery(sqlBuilder.toString());
        if (!count) {
            sqlBuilder.append(" ")
                    .append("ORDER BY ")
                    .append("i." + fieldName)
                    .append(" ")
                    .append(orderField);

            sqlBuilder.append(" OFFSET ")
                    .append(page)
                    .append(" ROWS FETCH NEXT ")
                    .append(delta)
                    .append(" ROWS ONLY");
            query = entityManager.createNativeQuery(sqlBuilder.toString(), InstallationSite.class);
        }

        _log.info(sqlBuilder.toString());

        query.setParameter(1, id_beneficiary);

        return query;
    }

}

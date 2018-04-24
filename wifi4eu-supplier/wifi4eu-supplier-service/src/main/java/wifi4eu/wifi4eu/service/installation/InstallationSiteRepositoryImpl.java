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
    public List<InstallationSite> searchInstallationSitesByBeneficiary(int page, int delta, int id, String fieldName, String orderField) {

        String queryString = "SELECT i.id, i.name, i.domain_name FROM installation_site i INNER JOIN municipalities m ON m.id = i.id_municipality WHERE m.id = ?1";

        StringBuilder sqlBuilder = new StringBuilder(queryString);

        sqlBuilder.append(" ")
                .append("ORDER BY ")
                .append("i."+fieldName)
                .append(" ")
                .append(orderField);

        sqlBuilder.append(" OFFSET ")
                .append(page)
                .append(" ROWS FETCH NEXT ")
                .append(delta)
                .append(" ROWS ONLY");

        _log.info(sqlBuilder.toString());


        Query query = entityManager.createNativeQuery(sqlBuilder.toString(), InstallationSite.class);

        query.setParameter(1, id);

        return query.getResultList();

        /*String queryString = "SELECT * FROM installation_site";
        // Query query = entityManager.createNativeQuery(queryString, InstallationSite.class);
        Query query = entityManager.createNativeQuery(queryString);
        return query.getResultList();*/
    }

    @Override
    public int countInstallationSitesByBeneficiary(int id) {
        return 0;
    }
}

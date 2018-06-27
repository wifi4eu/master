package wifi4eu.wifi4eu.service.access_point;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;
import wifi4eu.wifi4eu.repository.access_point.AccessPointRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AccessPointRepositoryImpl implements AccessPointRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<AccessPoint> searchAccessPointByInstallationSite(int page, int delta, int id_installationSite, String fieldName, String orderField) {
        Query query = generateSqlAccessPoint(page,delta,id_installationSite,fieldName,orderField, false);
        return query.getResultList();
    }

    @Override
    public int countAccessPointByInstallationSite(int page, int delta, int id_installationSite, String fieldName, String orderField) {
        Query query = generateSqlAccessPoint(page,delta,id_installationSite,fieldName,orderField, true);
        return (int) query.getSingleResult();
    }

    private Query generateSqlAccessPoint(int page, int delta, int id_installationSite, String fieldName, String orderField, boolean count){
        Query query = null;
        String queryString = "SELECT a.* FROM access_points a WHERE a.id_installation_site = ?1";
        if (count){
            queryString = "SELECT COUNT(a.id) FROM access_points a WHERE a.id_installation_site = ?1";
        }

        StringBuilder sqlBuilder = new StringBuilder(queryString);
        query = entityManager.createNativeQuery(sqlBuilder.toString());
        if (!count) {
            sqlBuilder.append(" ")
                    .append("ORDER BY ")
                    .append("a." + fieldName)
                    .append(" ")
                    .append(orderField);

            sqlBuilder.append(" OFFSET ")
                    .append(page)
                    .append(" ROWS FETCH NEXT ")
                    .append(delta)
                    .append(" ROWS ONLY");
            query = entityManager.createNativeQuery(sqlBuilder.toString(), AccessPoint.class);
        }

        query.setParameter(1, id_installationSite);

        return query;
    }
}

package wifi4eu.wifi4eu.service.access_point;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.access_point.AccessPoint;
import wifi4eu.wifi4eu.repository.access_point.AccessPointRepositoryCustom;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class AccessPointRepositoryImpl implements AccessPointRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserService userService;

    private static final Logger _log = LoggerFactory.getLogger(AccessPointRepositoryImpl.class);

    @Override
    public List<AccessPoint> searchAccessPointByInstallationSite(int page, int delta, int id_installationSite, String fieldName, String orderField) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Searching access points by installation site with id " + id_installationSite);
        Query query = generateSqlAccessPoint(page, delta, id_installationSite, fieldName, orderField, false);
        return query.getResultList();
    }

    @Override
    public int countAccessPointByInstallationSite(int page, int delta, int id_installationSite, String fieldName, String orderField) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Counting access points by installation site with id " + id_installationSite);
        Query query = generateSqlAccessPoint(page, delta, id_installationSite, fieldName, orderField, true);
        return (int) query.getSingleResult();
    }

    private Query generateSqlAccessPoint(int page, int delta, int id_installationSite, String fieldName, String orderField, boolean count) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Generating sql for access points by installation site with id " + id_installationSite);
        Query query = null;
        String queryString = "SELECT a.* FROM access_points a WHERE a.id_installation_site = ?1";
        if (count) {
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
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Generated as: " + sqlBuilder.toString());
        query.setParameter(1, id_installationSite);

        return query;
    }
}

package wifi4eu.wifi4eu.repository.access_point;

import wifi4eu.wifi4eu.entity.access_point.AccessPoint;

import java.util.List;

public interface AccessPointRepositoryCustom {

    List<AccessPoint> searchAccessPointByInstallationSite(int page, int delta, int id_installationSite, String fieldName, String orderField);

    int countAccessPointByInstallationSite(int page, int delta, int id_installationSite, String fieldName, String orderField);

}

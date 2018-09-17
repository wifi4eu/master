package wifi4eu.wifi4eu.repository.application;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.application.Application;

public interface ApplicationRepository extends CrudRepository<Application, Integer> {

    Application findBySupplierIdAndRegistrationId(Integer suppliedId, Integer registrationId);
}
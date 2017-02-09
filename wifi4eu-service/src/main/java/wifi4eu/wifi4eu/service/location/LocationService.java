package wifi4eu.wifi4eu.service.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.location.NutsMapper;
import wifi4eu.wifi4eu.mapper.security.UserMapper;
import wifi4eu.wifi4eu.repository.location.LocationNutsRepository;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.service.security.SecurityService;

/**
 * Created by rgarcita on 08/02/2017.
 */
@Service
public class LocationService {

    private final static Logger logger = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    LocationNutsRepository locationNutsRepository;

    @Autowired
    NutsMapper nutsMapper;



}

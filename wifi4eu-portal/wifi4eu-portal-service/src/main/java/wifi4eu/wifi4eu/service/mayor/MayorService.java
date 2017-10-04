package wifi4eu.wifi4eu.service.mayor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.mayor.MayorMapper;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;

@Service
public class MayorService {
    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    MayorRepository mayorRepository;
}
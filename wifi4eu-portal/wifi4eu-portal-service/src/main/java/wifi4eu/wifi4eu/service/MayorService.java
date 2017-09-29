package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.MayorMapper;
import wifi4eu.wifi4eu.repository.MayorRepository;

public class MayorService {
    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    MayorRepository mayorRepository;
}
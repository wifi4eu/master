package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.LauMapper;
import wifi4eu.wifi4eu.repository.LauRepository;

public class LauService {
    @Autowired
    LauMapper lauMapper;

    @Autowired
    LauRepository lauRepository;
}
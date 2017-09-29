package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.NutsMapper;
import wifi4eu.wifi4eu.repository.NutsRepository;

public class NutsService {
    @Autowired
    NutsMapper nutsMapper;

    @Autowired
    NutsRepository nutsRepository;
}

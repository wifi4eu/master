package wifi4eu.wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import wifi4eu.wifi4eu.mapper.RepresentationMapper;
import wifi4eu.wifi4eu.repository.RepresentationRepository;

public class RepresentationService {
    @Autowired
    RepresentationMapper representationMapper;

    @Autowired
    RepresentationRepository representationRepository;
}
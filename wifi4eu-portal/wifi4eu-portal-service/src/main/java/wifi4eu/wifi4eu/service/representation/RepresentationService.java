package wifi4eu.wifi4eu.service.representation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.mapper.representation.RepresentationMapper;
import wifi4eu.wifi4eu.repository.representation.RepresentationRepository;

@Service
public class RepresentationService {
    @Autowired
    RepresentationMapper representationMapper;

    @Autowired
    RepresentationRepository representationRepository;
}
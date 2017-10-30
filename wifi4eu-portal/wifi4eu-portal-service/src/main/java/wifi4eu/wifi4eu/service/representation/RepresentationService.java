package wifi4eu.wifi4eu.service.representation;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.RepresentationDTO;
import wifi4eu.wifi4eu.mapper.representation.RepresentationMapper;
import wifi4eu.wifi4eu.repository.representation.RepresentationRepository;

import java.util.List;

@Service
public class RepresentationService {
    @Autowired
    RepresentationMapper representationMapper;

    @Autowired
    RepresentationRepository representationRepository;

    public List<RepresentationDTO> getAllRepresentations() {
        return representationMapper.toDTOList(Lists.newArrayList(representationRepository.findAll()));
    }

    public RepresentationDTO getRepresentationById(int representationId) {
        return representationMapper.toDTO(representationRepository.findOne(representationId));
    }

    public RepresentationDTO createRepresentation(RepresentationDTO representationDTO) {
        return representationMapper.toDTO(representationRepository.save(representationMapper.toEntity(representationDTO)));
    }

    public RepresentationDTO deleteRepresentation(int representationId) {
        RepresentationDTO representationDTO = representationMapper.toDTO(representationRepository.findOne(representationId));
        if (representationDTO != null) {
            representationRepository.delete(representationMapper.toEntity(representationDTO));
            return representationDTO;
        } else {
            return null;
        }
    }

    public RepresentationDTO getRepresentationByMayorId(int mayorId) {
        return representationMapper.toDTO(representationRepository.findOne(mayorId));
    }

    public List<RepresentationDTO> getRepresentationByMunicipalityId(int municipalityId) {
        return representationMapper.toDTOList(Lists.newArrayList(representationRepository.findByMunicipalityId(municipalityId)));
    }
}
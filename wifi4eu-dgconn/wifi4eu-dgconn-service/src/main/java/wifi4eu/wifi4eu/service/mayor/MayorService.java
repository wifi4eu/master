package wifi4eu.wifi4eu.service.mayor;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.mapper.mayor.MayorMapper;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;

import java.util.List;

@Service
public class MayorService {
    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    MayorRepository mayorRepository;

    public List<MayorDTO> getAllMayors() {
        return mayorMapper.toDTOList(Lists.newArrayList(mayorRepository.findAll()));
    }

    public MayorDTO getMayorById(int mayorId) {
        return mayorMapper.toDTO(mayorRepository.findOne(mayorId));
    }

    @Transactional
    public MayorDTO createMayor(MayorDTO mayorDTO) {
        return mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));
    }

    @Transactional
    public MayorDTO deleteMayor(int mayorId) {
        MayorDTO mayorDTO = mayorMapper.toDTO(mayorRepository.findOne(mayorId));
        if (mayorDTO != null) {
            mayorRepository.delete(mayorMapper.toEntity(mayorDTO));
            return mayorDTO;
        } else {
            return null;
        }
    }

    public MayorDTO getMayorByMunicipalityId(int municipalityId) {
        return mayorMapper.toDTO(mayorRepository.findByMunicipalityId(municipalityId));
    }
}
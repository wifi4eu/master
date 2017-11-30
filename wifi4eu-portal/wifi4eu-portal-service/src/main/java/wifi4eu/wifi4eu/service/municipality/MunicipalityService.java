package wifi4eu.wifi4eu.service.municipality;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.MunicipalityDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.mapper.municipality.MunicipalityMapper;
import wifi4eu.wifi4eu.repository.municipality.MunicipalityRepository;
import wifi4eu.wifi4eu.service.registration.RegistrationService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipalityService {
    @Autowired
    MunicipalityMapper municipalityMapper;

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    RegistrationService registrationService;

    public List<MunicipalityDTO> getAllMunicipalities() {
        return municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findAll()));
    }

    public MunicipalityDTO getMunicipalityById(int municipalityId) {
        return municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
    }

    @Transactional
    public MunicipalityDTO createMunicipality(MunicipalityDTO municipalityDTO) {
        return municipalityMapper.toDTO(municipalityRepository.save(municipalityMapper.toEntity(municipalityDTO)));
    }

    public MunicipalityDTO deleteMunicipality(int municipalityId) {
        MunicipalityDTO municipalityDTO = municipalityMapper.toDTO(municipalityRepository.findOne(municipalityId));
        if (municipalityDTO != null) {
            municipalityRepository.delete(municipalityMapper.toEntity(municipalityDTO));
            return municipalityDTO;
        } else {
            return null;
        }
    }

    public List<MunicipalityDTO> getMunicipalitiesByLauId(int lauId) {
        return municipalityMapper.toDTOList(Lists.newArrayList(municipalityRepository.findByLauId(lauId)));
    }

    public List<MunicipalityDTO> getMunicipalitiesByUserId(int userId) {
        List<MunicipalityDTO> municipalities = new ArrayList<>();
        List<RegistrationDTO> registrations = registrationService.getRegistrationsByUserId(userId);
        for (RegistrationDTO registration : registrations) {
            municipalities.add(getMunicipalityById(registration.getMunicipalityId()));
        }
        return municipalities;
    }
}
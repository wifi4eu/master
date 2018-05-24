package wifi4eu.wifi4eu.service.mayor;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.mapper.mayor.MayorMapper;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.List;

@Service
public class MayorService {
    @Autowired
    MayorMapper mayorMapper;

    @Autowired
    MayorRepository mayorRepository;

    @Autowired
    RegistrationService registrationService;

    @Autowired
    UserService userService;

    @Autowired
    PermissionChecker permissionChecker;

    public List<MayorDTO> getAllMayors() {
        return mayorMapper.toDTOList(Lists.newArrayList(mayorRepository.findAll()));
    }

    public MayorDTO getMayorById(int mayorId) {
        return mayorMapper.toDTO(mayorRepository.findOne(mayorId));
    }

    @Transactional
    public MayorDTO createMayor(MayorDTO mayorDTO) {

      MayorDTO resMayor = mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));

      MayorDTO mayorDTO1 = getMayorByMunicipalityId(mayorDTO.getMunicipalityId());
      if(mayorDTO1 != null) {
        resMayor.setEmail(mayorDTO1.getEmail());
      }

      return resMayor;
    }

    @Transactional
    public MayorDTO updateMayor(MayorDTO mayorDetails, String name, String surname) {
      
      mayorDetails.setName(name);
      mayorDetails.setSurname(surname);
      
      return mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDetails)));
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
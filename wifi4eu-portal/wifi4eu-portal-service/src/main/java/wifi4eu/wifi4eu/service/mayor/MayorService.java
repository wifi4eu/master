package wifi4eu.wifi4eu.service.mayor;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.RegistrationDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.entity.security.RightConstants;
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
        return mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));
    }

    @Transactional
    public MayorDTO updateMayor(MayorDTO mayorDTO) {
      
      int mayorId = mayorDTO.getId();

      MayorDTO mayorDetails = getMayorById(mayorId);
      
      UserContext userContext = UserHolder.getUser();
      UserDTO userDTO = userService.getUserByUserContext(userContext);
      
      RegistrationDTO registrationDTO =  registrationService.getRegistrationByMunicipalityId(mayorDetails.getMunicipalityId());
      
      if(userDTO.getId() != registrationDTO.getUserId()){
        throw new AccessDeniedException("");
      }
     
      //check permission
      permissionChecker.check(RightConstants.MAYORS_TABLE+mayorId);
      
      mayorDetails.setName(mayorDTO.getName());
      mayorDetails.setSurname(mayorDTO.getSurname());
      
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
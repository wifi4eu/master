package wifi4eu.wifi4eu.service.mayor;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.common.mapper.mayor.MayorMapper;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.security.PermissionChecker;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
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

    private final Logger _log = LogManager.getLogger(MayorService.class);

    public List<MayorDTO> getAllMayors() {
        return mayorMapper.toDTOList(Lists.newArrayList(mayorRepository.findAll()));
    }

    public MayorDTO getMayorById(int mayorId) {
        return mayorMapper.toDTO(mayorRepository.findOne(mayorId));
    }

    @Transactional
    public MayorDTO saveMayor(MayorDTO mayorDTO, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        MayorDTO resMayor = mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDTO)));

        MayorDTO mayorDTO1 = getMayorByMunicipalityId(mayorDTO.getMunicipalityId());
        if (mayorDTO1 != null) {
            resMayor.setEmail(mayorDTO1.getEmail());
        }
        _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Mayor created");
        return resMayor;
    }

    @Transactional
    public MayorDTO updateMayor(MayorDTO mayorDetails, String name, String surname) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        mayorDetails.setName(name);
        mayorDetails.setSurname(surname);

        _log.info("ECAS Username: " + userConnected.getEcasUsername() + " - Mayor updated");
        return mayorMapper.toDTO(mayorRepository.save(mayorMapper.toEntity(mayorDetails)));
    }

    @Transactional
    public MayorDTO deleteMayor(int mayorId, HttpServletRequest request) {
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        MayorDTO mayorDTO = mayorMapper.toDTO(mayorRepository.findOne(mayorId));
        if (mayorDTO != null) {
            mayorRepository.delete(mayorMapper.toEntity(mayorDTO));
            _log.log(Level.getLevel("BUSINESS"), "[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Mayor removed");
            return mayorDTO;
        } else {
            return null;
        }
    }

    public MayorDTO getMayorByMunicipalityId(int municipalityId) {
        return mayorMapper.toDTO(mayorRepository.findByMunicipalityId(municipalityId));
    }
}
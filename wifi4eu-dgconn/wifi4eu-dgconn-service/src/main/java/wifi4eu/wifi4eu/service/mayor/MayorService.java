package wifi4eu.wifi4eu.service.mayor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.MayorDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.mapper.mayor.MayorMapper;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.repository.mayor.MayorRepository;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;

@Service
public class MayorService {

    @Autowired
    private MayorMapper mayorMapper;

    @Autowired
    private MayorRepository mayorRepository;

    @Autowired
    private UserService userService;

    private static final Logger _log = LoggerFactory.getLogger(MayorService.class);

    public MayorDTO getMayorById(int mayorId) {
        return mayorMapper.toDTO(mayorRepository.findOne(mayorId));
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
            _log.info("[ " + RequestIpRetriever.getIp(request) + " ] - ECAS Username: " + userConnected.getEcasUsername() + " - Mayor removed");
            return mayorDTO;
        } else {
            return null;
        }
    }

    public MayorDTO getMayorByMunicipalityId(int municipalityId) {
        return mayorMapper.toDTO(mayorRepository.findByMunicipalityId(municipalityId));
    }
}
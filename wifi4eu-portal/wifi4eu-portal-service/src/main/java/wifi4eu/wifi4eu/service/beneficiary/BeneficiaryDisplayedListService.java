package wifi4eu.wifi4eu.service.beneficiary;

import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.mapper.beneficiary.BeneficiaryDisplayedListMapper;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryDisplayedListRepository;
import wifi4eu.wifi4eu.service.user.UserService;

@Service("beneficiary")
public class BeneficiaryDisplayedListService {

    @Autowired
    BeneficiaryDisplayedListMapper beneficiaryDisplayedListMapper;

    @Autowired
    BeneficiaryDisplayedListRepository beneficiaryDisplayedListRepository;

    @Autowired
    UserService userService;

    Logger _log = LogManager.getLogger(BeneficiaryDisplayedListService.class);

    public ResponseDTO findBeneficiariesList(){
        UserContext userContext = UserHolder.getUser();
        UserDTO userConnected = userService.getUserByUserContext(userContext);
        _log.debug("ECAS Username: " + userConnected.getEcasUsername() + " - Finding beneficiary list");
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        response.setData(beneficiaryDisplayedListMapper.toDTOList(Lists.newArrayList(beneficiaryDisplayedListRepository.findBeneficiariesList())));
        return response;
    }

}

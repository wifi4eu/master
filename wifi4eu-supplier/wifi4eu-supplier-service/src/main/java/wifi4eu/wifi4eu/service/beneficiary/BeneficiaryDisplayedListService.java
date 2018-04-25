package wifi4eu.wifi4eu.service.beneficiary;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.BeneficiaryDisplayedListDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.mapper.beneficiary.BeneficiaryDisplayedListMapper;
import wifi4eu.wifi4eu.repository.beneficiary.BeneficiaryDisplayedListRepository;

import javax.xml.ws.Response;
import java.util.List;

@Service("beneficiary")
public class BeneficiaryDisplayedListService {

    @Autowired
    BeneficiaryDisplayedListMapper beneficiaryDisplayedListMapper;

    @Autowired
    BeneficiaryDisplayedListRepository beneficiaryDisplayedListRepository;

    private final Logger _log = LoggerFactory.getLogger(BeneficiaryDisplayedListService.class);

    public ResponseDTO findBeneficiariesList(){
        ResponseDTO response = new ResponseDTO();
        response.setSuccess(true);
        response.setData(beneficiaryDisplayedListMapper.toDTOList(Lists.newArrayList(beneficiaryDisplayedListRepository.findBeneficiariesList())));
        return response;
    }

}

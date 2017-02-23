package wifi4eu.wifi4eu.service.call;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.PublicationCallDTO;
import wifi4eu.wifi4eu.mapper.call.PublicationCallMapper;
import wifi4eu.wifi4eu.repository.call.PublicationCallRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by rgarcita on 22/02/2017.
 */
@Service
public class CallService {

    Logger _log = LoggerFactory.getLogger(CallService.class);

    @Autowired
    PublicationCallRepository publicationCallRepository;

    @Autowired
    PublicationCallMapper publicationCallMapper;

    public PublicationCallDTO getActiveCall(){

        Date now = new Date();
        _log.debug("now: " + now);
        PublicationCallDTO activeCallDTO = null;

        List<PublicationCallDTO> callOpenDTOs = publicationCallMapper.toDTOList(publicationCallRepository.findByCallDateLessThanEqual(now));
        List<PublicationCallDTO> callNotClosedDTOs = publicationCallMapper.toDTOList(publicationCallRepository.findByClosingDateGreaterThanEqual(now));

        for(PublicationCallDTO callDTO:callOpenDTOs){
            if(callNotClosedDTOs.contains(callDTO)){
                activeCallDTO = callDTO;
                break;
            }
        }

        return activeCallDTO;

    }

    public List<PublicationCallDTO> getAllCalls(){

        return publicationCallMapper.toDTOList(Lists.newArrayList(publicationCallRepository.findAll()));

    }

    public PublicationCallDTO createCall(PublicationCallDTO publicationCallDTO){

        return publicationCallMapper.toDTO(publicationCallRepository.save(publicationCallMapper.toEntity(publicationCallDTO)));

    }

}

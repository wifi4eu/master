package wifi4eu.wifi4eu.service.call;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.mapper.call.CallMapper;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CallService {

    Logger _log = LoggerFactory.getLogger(CallService.class);

    @Autowired
    CallRepository callRepository;

    @Autowired
    CallMapper callMapper;


    public List<CallDTO> getAllCalls() {
        return callMapper.toDTOList(Lists.newArrayList(callRepository.findAll()));
    }

    public CallDTO getCallById(Long callId) {
        return callMapper.toDTO(callRepository.findOne(callId));
    }

    public CallDTO createCall(CallDTO callDTO) {
        return callMapper.toDTO(callRepository.save(callMapper.toEntity(callDTO)));
    }

    @Transactional
    public CallDTO deleteCall(Long callId) {
        CallDTO callDTO = callMapper.toDTO(callRepository.findOne(callId));
        callRepository.delete(callId);
        return callDTO;
    }

}

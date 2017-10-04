package wifi4eu.wifi4eu.service.call;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.mapper.call.CallMapper;
import wifi4eu.wifi4eu.repository.call.CallRepository;

import java.util.List;

@Service
public class CallService {
    @Autowired
    CallMapper callMapper;

    @Autowired
    CallRepository callRepository;

    public List<CallDTO> getAllCalls() {
        return callMapper.toDTOList(Lists.newArrayList(callRepository.findAll()));
    }

    public CallDTO getCallById(int callId) {
        return callMapper.toDTO(callRepository.findOne(callId));
    }

    public CallDTO createCall(CallDTO callDTO) {
        return callMapper.toDTO(callRepository.save(callMapper.toEntity(callDTO)));
    }

    public CallDTO deleteCall(int callId) {
        CallDTO callDTO = callMapper.toDTO(callRepository.findOne(callId));
        if (callDTO != null) {
            callRepository.delete(callMapper.toEntity(callDTO));
            return callDTO;
        } else {
            return null;
        }
    }
}
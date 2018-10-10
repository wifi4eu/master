package wifi4eu.wifi4eu.service.call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.common.mapper.call.CallMapper;
import wifi4eu.wifi4eu.repository.call.CallRepository;

import java.util.Date;
import java.util.List;

@Service
public class CallService {

    @Autowired
    private CallMapper callMapper;

    @Autowired
    private CallRepository callRepository;

    public List<CallDTO> getAllCalls() {
        return callMapper.toDTOList(callRepository.findAll());
    }

    public CallDTO getCallById(int callId) {
        return callMapper.toDTO(callRepository.findOne(callId));
    }

    public boolean isCallClosed(int callId) {
        CallDTO call = getCallById(callId);
        if (call != null) {
            long currentTime = new Date().getTime();
            if (call.getStartDate() < currentTime && currentTime > call.getEndDate()) {
                return true;
            }
        }
        return false;
    }
}
package wifi4eu.wifi4eu.service.call;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.CallDTO;
import wifi4eu.wifi4eu.entity.call.Call;
import wifi4eu.wifi4eu.common.mapper.call.CallMapper;
import wifi4eu.wifi4eu.common.mapper.voucherManagement.VoucherManagementMapper;
import wifi4eu.wifi4eu.repository.call.CallRepository;
import wifi4eu.wifi4eu.repository.voucherManagement.VoucherManagementRepository;

import java.util.Date;
import java.util.List;

@Service
public class CallService {
    @Autowired
    CallMapper callMapper;

    @Autowired
    CallRepository callRepository;

    @Autowired
    VoucherManagementRepository voucherManagementRepository;

    @Autowired
    VoucherManagementMapper voucherManagementMapper;

    public List<CallDTO> getAllCalls() {
        return callMapper.toDTOList(Lists.newArrayList(callRepository.findAll()));
    }

    public CallDTO getCallById(int callId) {
        return callMapper.toDTO(callRepository.findOne(callId));
    }

    public CallDTO getCurrentCall(){
        return callMapper.toDTO(callRepository.findCurrentCall());
    }

    public CallDTO getLastCallClosed(){
        List<Call> allCalls = callRepository.findAllOrderByOrderByEndDateDesc();
        for (Call call: allCalls ) {
            if(isCallClosed(call)){
                return callMapper.toDTO(call);
            }
        }
        return null;
    }

    public boolean isCallClosed(Call call) {
        if (call != null) {
            long currentTime = new Date().getTime();
            if (call.getStartDate() < currentTime && currentTime > call.getEndDate()) {
                return true;
            }
        }
        return false;
    }

    public Date getTime(){
        return new Date();
    }

//    public CallDTO createCall(CallDTO callDTO) {
//        CallDTO resCallDTO = callMapper.toDTO(callRepository.save(callMapper.toEntity(callDTO)));
//        VoucherManagementDTO voucherManagementDTO = new VoucherManagementDTO();
//        voucherManagementDTO.setCall_id(resCallDTO.getId());
//        voucherManagementRepository.save(voucherManagementMapper.toEntity(voucherManagementDTO));
//        return callMapper.toDTO(callRepository.findOne(resCallDTO.getId()));
//    }
//
//    public CallDTO deleteCall(int callId) {
//
//        //TODO: change to a logic delete
//        CallDTO callDTO = callMapper.toDTO(callRepository.findOne(callId));
//        if (callDTO != null) {
//            callRepository.delete(callMapper.toEntity(callDTO));
//            return callDTO;
//        } else {
//            return null;
//        }
//    }
}
package wifi4eu.wifi4eu.service.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.entity.application.ApplyVoucher;
import wifi4eu.wifi4eu.repository.application.ApplyVoucherRepository;

import java.util.List;

@Service
public class ApplyVoucherService {

    @Autowired
    ApplyVoucherRepository applyVoucherRepository;

    public List<ApplyVoucher> getDataForApplyVoucher(Integer callId, Integer userId){
        List<ApplyVoucher> applyVouchers;
        if(callId == 0){
            applyVouchers = applyVoucherRepository.findDataToApplyVoucherWithoutCall(userId);
        }else{
            applyVouchers = applyVoucherRepository.findDataToApplyVoucher(callId,userId);
        }
        return applyVouchers;
    }
}

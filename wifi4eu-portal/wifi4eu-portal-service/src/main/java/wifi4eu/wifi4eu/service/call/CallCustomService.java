package wifi4eu.wifi4eu.service.call;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.entity.call.CallCustom;
import wifi4eu.wifi4eu.repository.call.CallCustomRepository;

@Service
public class CallCustomService {

    @Autowired
    CallCustomRepository callCustomRepository;

    public CallCustom getCurrentCallCustomWithVoucherCompetitionState(){
        CallCustom callCustom = callCustomRepository.findCurrentCall();
        int voucherCompetitionState = 0;

        if (callCustom != null){
            if ((callCustom.getStartDate() - System.currentTimeMillis()) <= 0) {
                voucherCompetitionState = 2;
            } else {
                voucherCompetitionState = 1;
            }
        }
        callCustom.setVoucherCompetitionState(voucherCompetitionState);
        return callCustom;
    }
}

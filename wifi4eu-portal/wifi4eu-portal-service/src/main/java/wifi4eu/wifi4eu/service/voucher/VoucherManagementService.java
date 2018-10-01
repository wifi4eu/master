package wifi4eu.wifi4eu.service.voucher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.VoucherManagementDTO;
import wifi4eu.wifi4eu.mapper.voucherManagement.VoucherManagementMapper;
import wifi4eu.wifi4eu.repository.voucherManagement.VoucherManagementRepository;

import java.util.List;

@Service
public class VoucherManagementService {

    @Autowired
    VoucherManagementRepository voucherManagementRepository;

    @Autowired
    VoucherManagementMapper voucherManagementMapper;


    public List<VoucherManagementDTO> getVoucherManagementByCall(int callId) {
        return voucherManagementMapper.toDTOList(voucherManagementRepository.findAllByVoucherCallId(callId));
    }


}

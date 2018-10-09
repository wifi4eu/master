package wifi4eu.wifi4eu.service.voucher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.VoucherDTO;
import wifi4eu.wifi4eu.common.dto.security.UserDTO;
import wifi4eu.wifi4eu.common.mapper.security.UserMapper;
import wifi4eu.wifi4eu.common.mapper.voucher.VoucherMapper;
import wifi4eu.wifi4eu.repository.security.SecurityUserRepository;
import wifi4eu.wifi4eu.repository.voucher.VoucherRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by rgarcita on 23/02/2017.
 */
@Service
public class VoucherService {

    private final static Logger _log = LoggerFactory.getLogger(VoucherService.class);

    @Autowired
    VoucherRepository voucherRepository;

    @Autowired
    VoucherMapper voucherMapper;

    @Autowired
    SecurityUserRepository securityUserRepository;

    @Autowired
    UserMapper userMapper;

    public VoucherDTO create(VoucherDTO voucherDTO){

        /* validate voucher and userId are not null */
        if(voucherDTO != null && voucherDTO.getUserId()!=null){

            UserDTO userDTO = userMapper.toDTO(securityUserRepository.findByUserId(voucherDTO.getUserId()));

            /* validate user exist in wifi4eu */
            if(userDTO != null){
                voucherDTO.setCreateDate(new Date());
                voucherDTO = voucherMapper.toDTO(voucherRepository.save(voucherMapper.toEntity(voucherDTO)));
            }

        }

        return voucherDTO;

    }

    public VoucherDTO findByVoucherId(Long voucherId){

        return voucherMapper.toDTO(voucherRepository.findOne(voucherId));

    }

    public List<VoucherDTO> findByCallId(Long callId){

        return voucherMapper.toDTOList(voucherRepository.findByCallId(callId));

    }

}

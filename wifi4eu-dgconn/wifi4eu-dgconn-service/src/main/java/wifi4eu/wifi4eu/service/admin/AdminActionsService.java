package wifi4eu.wifi4eu.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.mapper.admin.AdminActionsMapper;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;

@Service
public class AdminActionsService {

    @Autowired
    AdminActionsRepository adminActionsRepository;

    @Autowired
    AdminActionsMapper adminActionsMapper;

    public AdminActionsDTO getByActionName(String action){
        return adminActionsMapper.toDTO(adminActionsRepository.findOneByAction(action));
    }

}

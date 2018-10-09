package wifi4eu.wifi4eu.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.mapper.admin.AdminActionsMapper;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;

import java.util.List;

@Service
public class AdminActionsService {

    @Autowired
    AdminActionsRepository adminActionsRepository;

    @Autowired
    AdminActionsMapper adminActionsMapper;

    public AdminActionsDTO getByActionName(String action){
        return adminActionsMapper.toDTO(adminActionsRepository.findOneByAction(action));
    }

    public List<AdminActionsDTO> getByActionsByName(String action){
        return adminActionsMapper.toDtoList(adminActionsRepository.findAllByAction(action));
    }

    public AdminActionsDTO getByActionNameAndUser(String action, Integer userId){
        return adminActionsMapper.toDTO(adminActionsRepository.findOneByActionAndUserId(action, userId));
    }

    public AdminActionsDTO updateAdminAction(AdminActionsDTO updatedAdminAction){
        return adminActionsMapper.toDTO(adminActionsRepository.save(adminActionsMapper.toEntity(updatedAdminAction)));
    }
}

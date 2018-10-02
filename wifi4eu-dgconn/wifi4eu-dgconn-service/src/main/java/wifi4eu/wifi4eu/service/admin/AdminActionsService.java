package wifi4eu.wifi4eu.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.AdminActionsDTO;
import wifi4eu.wifi4eu.common.dto.model.UserDTO;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.mapper.admin.AdminActionsMapper;
import wifi4eu.wifi4eu.repository.admin.AdminActionsRepository;

import java.util.Date;
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

    public AdminActionsDTO startByActionName(String action, UserDTO userDTO){
        AdminActionsDTO adminActionsDTO = getByActionName(action);

        if (Validator.isNull(adminActionsDTO)) {
            adminActionsDTO = new AdminActionsDTO();
            adminActionsDTO.setAction(action);
            adminActionsDTO.setStartDate(new Date());
            adminActionsDTO.setRunning(true);
            adminActionsDTO.setUser(userDTO);
            adminActionsDTO = updateAdminAction(adminActionsDTO);
        } else {
            if (adminActionsDTO.isRunning()) {
                throw new AppException("Action: " + action + " is running...");
            }
            adminActionsDTO.setStartDate(new Date());
            adminActionsDTO.setRunning(true);
            adminActionsDTO.setEndDate(null);
            adminActionsDTO.setUser(userDTO);
            adminActionsDTO = updateAdminAction(adminActionsDTO);
        }

        return adminActionsDTO;
    }

    public AdminActionsDTO endOK(AdminActionsDTO adminActionsDTO){
        adminActionsDTO.setRunning(false);
        adminActionsDTO.setEndDate(new Date());
        return updateAdminAction(adminActionsDTO);
    }

    public AdminActionsDTO endWithError(AdminActionsDTO adminActionsDTO, String action, UserDTO userDTO){
        if (Validator.isNotNull(adminActionsDTO)) {
            adminActionsDTO.setAction(action); //Maybe not needed
            adminActionsDTO.setStartDate(null);
            adminActionsDTO.setRunning(false);
            adminActionsDTO.setEndDate(null);
            adminActionsDTO.setUser(userDTO);
            adminActionsDTO = updateAdminAction(adminActionsDTO);
        }

        return adminActionsDTO;
    }

}

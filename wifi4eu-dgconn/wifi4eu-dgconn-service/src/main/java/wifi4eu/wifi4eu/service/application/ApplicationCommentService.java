package wifi4eu.wifi4eu.service.application;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.exception.AppException;
import wifi4eu.wifi4eu.entity.application.ApplicationComment;
import wifi4eu.wifi4eu.mapper.application.ApplicationCommentMapper;
import wifi4eu.wifi4eu.repository.application.ApplicationCommentRepository;
import wifi4eu.wifi4eu.service.user.UserService;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationCommentService {

    @Autowired
    ApplicationCommentRepository applicationCommentRepository;

    @Autowired
    ApplicationCommentMapper applicationCommentMapper;

    @Autowired
    ApplicationService applicationService;

    @Autowired
    UserService userService;

    public List<ApplicationCommentDTO> getApplicationCommentsByApplicationId(Integer applicationId){
        return applicationCommentMapper.toDTOList(applicationCommentRepository.findAllByApplicationId(applicationId));
    }

    public ResponseDTO getApplicationCommentsByApplicationIdPaginated(Integer applicationId, Pageable pageable){
        Page<ApplicationComment> page = applicationCommentRepository.findAllByApplicationId(applicationId, pageable);
        List<ApplicationCommentDTO> applicationCommentDTOS = applicationCommentMapper.toDTOList(page.getContent());
        return new ResponseDTO(true, applicationCommentDTOS, page.getTotalElements(), null);
    }

    public ApplicationCommentDTO createApplicationComment(ApplicationCommentDTO applicationCommentDTO){
        ApplicationDTO applicationDBO = applicationService.getApplicationById(applicationCommentDTO.getApplicationId());
        if(applicationDBO == null){
            throw new AppException("Application with ID:  " + applicationCommentDTO.getApplicationId() + " not found");
        }

        if(applicationCommentDTO.getComment().trim().equals("") || applicationCommentDTO.getComment().isEmpty() || applicationCommentDTO.getComment() == null){
            throw new AppException("Comment is empty");
        }
        applicationCommentDTO.setDatePosted(new Date().getTime());
        applicationCommentDTO.setUserId(userService.getUserByUserContext(UserHolder.getUser()).getId());
        ApplicationComment result = applicationCommentRepository.save(applicationCommentMapper.toEntity(applicationCommentDTO));
        return applicationCommentMapper.toDTO(result);
    }

}

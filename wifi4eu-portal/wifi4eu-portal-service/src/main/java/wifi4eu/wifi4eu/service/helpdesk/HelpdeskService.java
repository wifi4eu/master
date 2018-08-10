package wifi4eu.wifi4eu.service.helpdesk;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskCommentMapper;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskIssueMapper;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskCommentRepository;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskIssueRepository;

@Service
public class HelpdeskService {
    Logger _log = LogManager.getLogger(HelpdeskService.class);

    @Autowired
    HelpdeskIssueMapper helpdeskIssueMapper;

    @Autowired
    HelpdeskIssueRepository helpdeskIssueRepository;

    @Autowired
    HelpdeskCommentMapper helpdeskCommentMapper;

    @Autowired
    HelpdeskCommentRepository helpdeskCommentRepository;

    public List<HelpdeskIssueDTO> getAllHelpdeskIssues() {
        return helpdeskIssueMapper.toDTOList(Lists.newArrayList(helpdeskIssueRepository.findAll()));
    }

    public HelpdeskIssueDTO getHelpdeskIssueById(int helpdeskIssueId) {
        return helpdeskIssueMapper.toDTO(helpdeskIssueRepository.findOne(helpdeskIssueId));
    }

    public List<HelpdeskIssueDTO> getAllHelpdeskIssueNoSubmited(){
        return helpdeskIssueMapper.toDTOList(helpdeskIssueRepository.findAllByTicketFalse());
    }

    public HelpdeskIssueDTO createHelpdeskIssue(HelpdeskIssueDTO helpdeskIssueDTO) {
    	if (helpdeskIssueDTO.getId() != 0) {
    		_log.warn("Call to a create method with id set, the value has been removed ({})", helpdeskIssueDTO.getId());
    		helpdeskIssueDTO.setId(0);	
    	}

        return helpdeskIssueMapper.toDTO(helpdeskIssueRepository.save(helpdeskIssueMapper.toEntity(helpdeskIssueDTO)));

/*        if (helpdeskIssueDTO.getComments() != null && helpdeskIssueDTO.getComments().isEmpty()) {
        } else {
            Integer helpdeskIssueId = helpdeskIssueDTO.getId();
            List<HelpdeskCommentDTO> originalComments = helpdeskIssueDTO.getComments();
            List<HelpdeskCommentDTO> correctComments = new ArrayList<>();
            if (helpdeskIssueId == 0) {
                helpdeskIssueDTO.setComments(null);
                helpdeskIssueDTO = helpdeskIssueMapper.toDTO(helpdeskIssueRepository.save(helpdeskIssueMapper.toEntity(helpdeskIssueDTO)));
                helpdeskIssueId = helpdeskIssueDTO.getId();
            }
            for (HelpdeskCommentDTO comment: originalComments) {
                comment.setIssueId(helpdeskIssueId);
                correctComments.add(comment);
            }
            helpdeskIssueDTO.setComments(correctComments);
            return helpdeskIssueMapper.toDTO(helpdeskIssueRepository.save(helpdeskIssueMapper.toEntity(helpdeskIssueDTO)));
        }*/
    }

    public HelpdeskIssueDTO deleteHelpdeskIssue(int helpdeskIssueId) {
        HelpdeskIssueDTO helpdeskIssueDTO = helpdeskIssueMapper.toDTO(helpdeskIssueRepository.findOne(helpdeskIssueId));
        if (helpdeskIssueDTO != null) {
            helpdeskIssueRepository.delete(helpdeskIssueMapper.toEntity(helpdeskIssueDTO));
            return helpdeskIssueDTO;
        } else {
            return null;
        }
    }

    public List<HelpdeskCommentDTO> getAllHelpdeskComments() {
        return helpdeskCommentMapper.toDTOList(Lists.newArrayList(helpdeskCommentRepository.findAll()));
    }

    public HelpdeskCommentDTO getHelpdeskCommentById(int helpdeskCommentId) {
        return helpdeskCommentMapper.toDTO(helpdeskCommentRepository.findOne(helpdeskCommentId));
    }

    public HelpdeskCommentDTO createHelpdeskComment(HelpdeskCommentDTO helpdeskCommentDTO) {
        if (helpdeskCommentDTO.getId() != 0) {
            _log.warn("Call to a create method with id set, the value has been removed ({})", helpdeskCommentDTO.getId());
            helpdeskCommentDTO.setId(0);    
        }        
        return helpdeskCommentMapper.toDTO(helpdeskCommentRepository.save(helpdeskCommentMapper.toEntity(helpdeskCommentDTO)));
    }

    public HelpdeskCommentDTO deleteHelpdeskComment(int helpdeskCommentId) {
        HelpdeskCommentDTO helpdeskCommentDTO = helpdeskCommentMapper.toDTO(helpdeskCommentRepository.findOne(helpdeskCommentId));
        if (helpdeskCommentDTO != null) {
            helpdeskCommentRepository.delete(helpdeskCommentMapper.toEntity(helpdeskCommentDTO));
            return helpdeskCommentDTO;
        } else {
            return null;
        }
    }
}
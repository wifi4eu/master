package wifi4eu.wifi4eu.service.helpdesk;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskComment;
import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskIssue;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskCommentMapper;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskIssueMapper;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskCommentRepository;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskIssueRepository;

import java.util.Date;
import java.util.List;

@Service
public class HelpdeskService {
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

    public HelpdeskIssueDTO createHelpdeskIssue(HelpdeskIssueDTO helpdeskIssueDTO) {
        return helpdeskIssueMapper.toDTO(helpdeskIssueRepository.save(helpdeskIssueMapper.toEntity(helpdeskIssueDTO)));
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
package wifi4eu.wifi4eu.service.helpdesk;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskDTO;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskCommentMapper;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskMapper;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskCommentRepository;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskRepository;

import java.util.List;

@Service
public class HelpdeskService {

    Logger _log = LoggerFactory.getLogger(HelpdeskService.class);

    @Autowired
    HelpdeskRepository helpdeskRepository;

    @Autowired
    HelpdeskMapper helpdeskMapper;

    @Autowired
    HelpdeskCommentRepository helpdeskCommentRepository;

    @Autowired
    HelpdeskCommentMapper helpdeskCommentMapper;

    public List<HelpdeskDTO> getAllHelpdeskIssues() {
        return helpdeskMapper.toDTOList(Lists.newArrayList(helpdeskRepository.findAll()));
    }

    public HelpdeskDTO getHelpdeskIssue(Long issueId) {
        return helpdeskMapper.toDTO(helpdeskRepository.findOne(issueId));
    }

    public HelpdeskDTO createHelpdeskIssue(HelpdeskDTO helpdeskDTO) {
        return helpdeskMapper.toDTO(helpdeskRepository.save(helpdeskMapper.toEntity(helpdeskDTO)));
    }

    public List<HelpdeskCommentDTO> getHelpdeskIssueComments(Long issueId) {
        return helpdeskCommentMapper.toDTOList(Lists.newArrayList(helpdeskCommentRepository.findByIssueId(issueId)));
    }

}

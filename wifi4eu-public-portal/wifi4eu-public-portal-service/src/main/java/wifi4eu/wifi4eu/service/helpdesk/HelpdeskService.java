package wifi4eu.wifi4eu.service.helpdesk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskIssueMapper;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskIssueRepository;

@Service
public class HelpdeskService {
    @Autowired
    HelpdeskIssueMapper helpdeskIssueMapper;

    @Autowired
    HelpdeskIssueRepository helpdeskIssueRepository;

    public HelpdeskIssueDTO createHelpdeskIssue(HelpdeskIssueDTO helpdeskIssueDTO) {
        return helpdeskIssueMapper.toDTO(helpdeskIssueRepository.save(helpdeskIssueMapper.toEntity(helpdeskIssueDTO)));
    }
}
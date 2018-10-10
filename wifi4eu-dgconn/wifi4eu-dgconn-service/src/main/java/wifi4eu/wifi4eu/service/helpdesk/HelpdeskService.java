package wifi4eu.wifi4eu.service.helpdesk;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskIssueDTO;
import wifi4eu.wifi4eu.common.mapper.helpdesk.HelpdeskIssueMapper;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskIssueRepository;

import java.util.List;

@Service
public class HelpdeskService {
    private static final Logger _log = LoggerFactory.getLogger(HelpdeskService.class);

    @Autowired
    private HelpdeskIssueMapper helpdeskIssueMapper;

    @Autowired
    private HelpdeskIssueRepository helpdeskIssueRepository;

    public List<HelpdeskIssueDTO> getAllHelpdeskIssues() {
        return helpdeskIssueMapper.toDTOList(Lists.newArrayList(helpdeskIssueRepository.findAll()));
    }

    public HelpdeskIssueDTO getHelpdeskIssueById(int helpdeskIssueId) {
        return helpdeskIssueMapper.toDTO(helpdeskIssueRepository.findOne(helpdeskIssueId));
    }

    public HelpdeskIssueDTO createHelpdeskIssue(HelpdeskIssueDTO helpdeskIssueDTO) {
    	if (helpdeskIssueDTO.getId() != 0) {
    		_log.warn("Call to a create method with id set, the value has been removed ({})", helpdeskIssueDTO.getId());
    		helpdeskIssueDTO.setId(0);	
    	}
        return helpdeskIssueMapper.toDTO(helpdeskIssueRepository.save(helpdeskIssueMapper.toEntity(helpdeskIssueDTO)));
    }
}
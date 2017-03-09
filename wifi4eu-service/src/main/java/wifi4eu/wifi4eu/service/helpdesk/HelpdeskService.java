package wifi4eu.wifi4eu.service.helpdesk;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.HelpdeskDTO;
import wifi4eu.wifi4eu.mapper.helpdesk.HelpdeskMapper;
import wifi4eu.wifi4eu.repository.helpdesk.HelpdeskRepository;
import wifi4eu.wifi4eu.service.call.CallService;

import java.util.List;

@Service
public class HelpdeskService {

    Logger _log = LoggerFactory.getLogger(CallService.class);

    @Autowired
    HelpdeskRepository helpdeskRepository;

    @Autowired
    HelpdeskMapper helpdeskMapper;


    public List<HelpdeskDTO> getAllHelpdeskIssues() {
        return helpdeskMapper.toDTOList(Lists.newArrayList(helpdeskRepository.findAll()));
    }

    public HelpdeskDTO getHelpdeskIssue(Long issueId) {
        return helpdeskMapper.toDTO(helpdeskRepository.findOne(issueId));
    }

    public HelpdeskDTO createHelpdeskIssue(HelpdeskDTO helpdeskDTO) {
        return helpdeskMapper.toDTO(helpdeskRepository.save(helpdeskMapper.toEntity(helpdeskDTO)));
    }

}

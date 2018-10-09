package wifi4eu.wifi4eu.service.timeline;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.common.mapper.timeline.TimelineMapper;
import wifi4eu.wifi4eu.repository.timeline.TimelineRepository;

import java.util.List;

/**
 * Created by rgarcita on 02/03/2017.
 */
@Service
public class TimelineService {
    private final static Logger _log = LoggerFactory.getLogger(TimelineService.class);

    @Autowired
    TimelineRepository timelineRepository;

    @Autowired
    TimelineMapper timelineMapper;


    public List<TimelineDTO> getAllTimelines() {
        return timelineMapper.toDTOList(Lists.newArrayList(timelineRepository.findAll()));
    }

    public TimelineDTO createTimeline(TimelineDTO timelineDTO) {
        return timelineMapper.toDTO(timelineRepository.save(timelineMapper.toEntity(timelineDTO)));
    }

    // @Transactional
    public TimelineDTO deleteTimeline(TimelineDTO timelineDTO) {
        _log.info("luciaaaaaaaaaaa:::::::::::::::::::::::::::::::::::::::" + timelineDTO.getTimelineId().toString());
        timelineRepository.delete(timelineDTO.getTimelineId());
        return timelineDTO;
    }

}

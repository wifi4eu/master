package wifi4eu.wifi4eu.service.timeline;

import com.google.common.collect.Lists;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.mapper.timeline.TimelineMapper;
import wifi4eu.wifi4eu.repository.timeline.TimelineRepository;
import wifi4eu.wifi4eu.service.thread.ThreadMessageService;

import java.util.List;

@Service
public class TimelineService {
    Logger _log = LogManager.getLogger(TimelineService.class);

    @Autowired
    TimelineMapper timelineMapper;

    @Autowired
    TimelineRepository timelineRepository;

    public List<TimelineDTO> getAllTimelines() {
        return timelineMapper.toDTOList(Lists.newArrayList(timelineRepository.findAll()));
    }

    public TimelineDTO getTimelineById(int timelineId) {
        return timelineMapper.toDTO(timelineRepository.findOne(timelineId));
    }

    public TimelineDTO createTimeline(TimelineDTO timelineDTO) {
    	if (timelineDTO.getId() != 0) {
    		_log.warn("Call to a create method with id set, the value has been removed ({})", timelineDTO.getId());
    		timelineDTO.setId(0);	
    	}
        return timelineMapper.toDTO(timelineRepository.save(timelineMapper.toEntity(timelineDTO)));
    }

    public TimelineDTO deleteTimeline(int timelineId) {
        TimelineDTO timelineDTO = timelineMapper.toDTO(timelineRepository.findOne(timelineId));
        if (timelineDTO != null) {
            timelineRepository.delete(timelineMapper.toEntity(timelineDTO));
            return timelineDTO;
        } else {
            return null;
        }
    }
}
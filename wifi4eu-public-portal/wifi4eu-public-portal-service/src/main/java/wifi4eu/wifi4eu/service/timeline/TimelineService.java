package wifi4eu.wifi4eu.service.timeline;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.mapper.timeline.TimelineMapper;
import wifi4eu.wifi4eu.repository.timeline.TimelineRepository;

import java.util.List;

@Service
public class TimelineService {
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
package wifi4eu.wifi4eu.mapper.timeline;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;

import wifi4eu.wifi4eu.entity.timeline.Timeline;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class TimelineMapperImpl implements TimelineMapper {

    @Override

    public TimelineDTO toDTO(Timeline entity) {

        if ( entity == null ) {

            return null;
        }

        TimelineDTO timelineDTO = new TimelineDTO();

        timelineDTO.setTimelineId( entity.getTimelineId() );

        timelineDTO.setStartDate( entity.getStartDate() );

        timelineDTO.setEndDate( entity.getEndDate() );

        timelineDTO.setEvent( entity.getEvent() );

        return timelineDTO;
    }

    @Override

    public Timeline toEntity(TimelineDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Timeline timeline = new Timeline();

        timeline.setTimelineId( vo.getTimelineId() );

        timeline.setStartDate( vo.getStartDate() );

        timeline.setEndDate( vo.getEndDate() );

        timeline.setEvent( vo.getEvent() );

        return timeline;
    }

    @Override

    public List<TimelineDTO> toDTOList(List<Timeline> list) {

        if ( list == null ) {

            return null;
        }

        List<TimelineDTO> list_ = new ArrayList<TimelineDTO>();

        for ( Timeline timeline : list ) {

            list_.add( toDTO( timeline ) );
        }

        return list_;
    }

    @Override

    public List<Timeline> toEntityList(List<TimelineDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Timeline> list_ = new ArrayList<Timeline>();

        for ( TimelineDTO timelineDTO : list ) {

            list_.add( toEntity( timelineDTO ) );
        }

        return list_;
    }
}


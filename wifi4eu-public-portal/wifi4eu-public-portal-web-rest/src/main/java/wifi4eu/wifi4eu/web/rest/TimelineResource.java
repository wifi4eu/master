package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.service.timeline.TimelineService;

import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/timeline", description = "Timeline object REST API services")
@RequestMapping("timeline")
public class TimelineResource {
    @Autowired
    private TimelineService timelineService;

    Logger _log = LoggerFactory.getLogger(TimelineResource.class);

    @ApiOperation(value = "Get all the timeline entries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<TimelineDTO> allTimelines() {
        return timelineService.getAllTimelines();
    }

    @ApiOperation(value = "Get timeline by specific id")
    @RequestMapping(value = "/{timelineId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public TimelineDTO getTimelineById(@PathVariable("timelineId") final Integer timelineId) {
        _log.info("getTimelineById: " + timelineId);
        return timelineService.getTimelineById(timelineId);
    }
}
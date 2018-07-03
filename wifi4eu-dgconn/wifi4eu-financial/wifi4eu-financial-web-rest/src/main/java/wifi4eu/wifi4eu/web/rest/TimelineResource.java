package wifi4eu.wifi4eu.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wifi4eu.wifi4eu.common.dto.model.TimelineDTO;
import wifi4eu.wifi4eu.common.dto.rest.ErrorDTO;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.service.timeline.TimelineService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by rgarcita on 02/03/2017.
 */

@CrossOrigin(origins = "*")
@Controller
@Api(value = "/timeline", description = "Timeline services")
@RequestMapping("timeline")
public class TimelineResource {

    Logger _log = LoggerFactory.getLogger(CallResource.class);

    @Autowired
    private TimelineService timelineService;

    @ApiOperation(value = "Get all the timeline entries")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<TimelineDTO> allTimelines() {

        return timelineService.getAllTimelines();
    }

    @ApiOperation(value = "create Timeline")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseDTO createTimeline(@RequestBody final TimelineDTO timelineDTO, final HttpServletResponse response) {

        /* TODO: validate user rights, only DG Connect users can create a Call */


        try {
            TimelineDTO resTimeline = timelineService.createTimeline(timelineDTO);
            return new ResponseDTO(true, resTimeline, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }

    }


    @ApiOperation(value = "delete Timeline")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseDTO deleteTimeline(@RequestBody final TimelineDTO timelineDTO, final HttpServletResponse response) {
        try {
            TimelineDTO resTimeline = timelineService.deleteTimeline(timelineDTO);
            return new ResponseDTO(true, resTimeline, null);
        } catch (Exception e) {
            ErrorDTO errorDTO = new ErrorDTO(0, e.getMessage());
            return new ResponseDTO(false, null, errorDTO);
        }
    }

}

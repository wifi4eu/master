package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wifi4eu.wifi4eu.abac.data.entity.MonitoringRow;
import wifi4eu.wifi4eu.abac.service.MonitoringService;

@RestController
@RequestMapping(path = "monitor")
public class MonitoringController {
	
	private final Logger log = LoggerFactory.getLogger(MonitoringController.class);
	
	private MonitoringService monitoringService;
	
	@Autowired
	public MonitoringController(MonitoringService monitoringService) {
		this.monitoringService = monitoringService;
	}
	
	@RequestMapping(value = "data", method = RequestMethod.GET, produces = "application/json")
	public List<MonitoringRow> monitoringData() throws IOException {
		log.info("monitoringData");

		return  monitoringService.getMonitoringData();
	}

}

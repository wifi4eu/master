package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wifi4eu.wifi4eu.abac.data.dto.IMonitoringRowProjection;
import wifi4eu.wifi4eu.abac.data.dto.MonitoringRow;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.service.MonitoringService;

@RestController
@RequestMapping(path = "monitor")
public class MonitoringController {
	
	private MonitoringService monitoringService;
	
	@Autowired
	public MonitoringController(MonitoringService monitoringService) {
		this.monitoringService = monitoringService;
	}
	
	@RequestMapping(value = "data", method = RequestMethod.GET, produces = "application/json")
	public ArrayList<MonitoringRow> data() throws IOException {
		ArrayList<MonitoringRow> result = new ArrayList<MonitoringRow>();
		List<IMonitoringRowProjection> data = monitoringService.getMonitoringData();
		for(IMonitoringRowProjection row : data) {
			result.add(new MonitoringRow(row));
		}
		
		return result;
	}
	
	@RequestMapping(value = "countries", method = RequestMethod.GET, produces = "application/json")
	public List<Country> countries() throws IOException {
		return  monitoringService.getCountries();
	}

}

package wifi4eu.wifi4eu.abac.rest;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wifi4eu.wifi4eu.abac.data.Constants;
import wifi4eu.wifi4eu.abac.data.dto.BAFMonitoringRow;
import wifi4eu.wifi4eu.abac.data.dto.MonitoringRow;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.entity.ImportLog;
import wifi4eu.wifi4eu.abac.service.MonitoringService;

@RestController
@RequestMapping(path = "monitor")
public class MonitoringController {
	
	private MonitoringService monitoringService;
	
	@Autowired
	public MonitoringController(MonitoringService monitoringService) {
		this.monitoringService = monitoringService;
	}

	@PreAuthorize ("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "data", method = RequestMethod.GET, produces = Constants.MIME_TYPE_REST_RESPONE)
	public List<MonitoringRow> data() throws IOException {
		return monitoringService.getMonitoringData();
	}
	
	@PreAuthorize ("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "bafData", method = RequestMethod.GET, produces = Constants.MIME_TYPE_REST_RESPONE)
	public List<BAFMonitoringRow> bafData() throws IOException {
		return monitoringService.getBAFMonitoringData();
	}

	@PreAuthorize ("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "countries", method = RequestMethod.GET, produces = Constants.MIME_TYPE_REST_RESPONE)
	public List<Country> countries() throws IOException {
		return  monitoringService.getCountries();
	}
	
	@PreAuthorize ("hasRole('ROLE_INEA_OFFICER')")
	@RequestMapping(value = "errorLog/{batchRef}", method = RequestMethod.GET, produces = Constants.MIME_TYPE_PLAIN_TEXT_RESPONSE)
	@ResponseBody
	public String errorLog(@PathVariable String batchRef) throws IOException {
		String result="";
		List<ImportLog> importLogs = monitoringService.getImportLogByBatchRef(batchRef);
		for(ImportLog importLog : importLogs) {
			result = result.concat(importLog.getErrors()).concat("\n");
		}
		return result;
	}
}

package wifi4eu.wifi4eu.web.rest;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wifi4eu.wifi4eu.service.migration.AzureMigrationService;

@Controller
@RequestMapping(value = "/azure", method = RequestMethod.GET)
public class AzureMigrationResource {

	@Autowired
	private AzureMigrationService azureMigrationService;

	@RequestMapping(value = "/blob", method = RequestMethod.GET)
	public void migrate() {
		Executors.newSingleThreadExecutor().execute(azureMigrationService);
		
		//azureMigrationService.migrate();
	}
}
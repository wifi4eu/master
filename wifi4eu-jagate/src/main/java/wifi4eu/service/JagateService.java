package wifi4eu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.adapter.AbacClient;
import wifi4eu.model.Municipality;

@Service
public class JagateService {

	@Autowired AbacClient abacClient;
	
	public void sync(Municipality municipality) {
		//abacClient.requestFelCreationOrUpdate(municipality);
	}

}

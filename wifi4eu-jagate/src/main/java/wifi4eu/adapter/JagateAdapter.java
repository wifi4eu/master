package wifi4eu.adapter;

import org.springframework.stereotype.Component;

import wifi4eu.model.Municipality;

@Component
public class JagateAdapter {
	
	public void createLegalEntity(Municipality municipality) {
		System.out.println(municipality.getName());
		//TODO Insert call to jagate
	}
}

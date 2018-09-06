package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;

@Service
public class ECASUserService {

	private final Logger log = LoggerFactory.getLogger(ECASUserService.class);
	
	public String getCurrentUsername() {
		String currentEcasUserName = null;
		try {
			DetailedUser currentEcasUser = SubjectUtil.getCurrentEcasUser();
			currentEcasUserName=currentEcasUser.getUid();
		} catch (SubjectNotFoundException e) {
			log.error("ERROR while trying to retrieve the current user", e);
		}
		return currentEcasUserName;
	}
}

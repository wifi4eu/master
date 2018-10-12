package wifi4eu.wifi4eu.abac.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.cec.digit.ecas.client.jaas.DetailedUser;
import eu.cec.digit.ecas.client.jaas.SubjectNotFoundException;
import eu.cec.digit.ecas.client.jaas.SubjectUtil;
import wifi4eu.wifi4eu.abac.data.entity.Role;
import wifi4eu.wifi4eu.abac.data.entity.User;
import wifi4eu.wifi4eu.abac.data.repository.UserRepository;
import wifi4eu.wifi4eu.abac.rest.vo.UserDetailsVO;

@Service
public class ECASUserService {

	private final Logger log = LoggerFactory.getLogger(ECASUserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
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
	
	public UserDetailsVO getCurrentUserDetails() {
		UserDetailsVO result=null;
		try {
			DetailedUser currentEcasUser = SubjectUtil.getCurrentEcasUser();
			User user=userRepository.findFirstByUserNameEquals(currentEcasUser.getUid());
			result=new UserDetailsVO(currentEcasUser.getUid(), currentEcasUser.getFirstName(), currentEcasUser.getLastName(), currentEcasUser.getEmail(), convertRoles(user.getRoles()));
		} catch (SubjectNotFoundException e) {
			log.error("ERROR while trying to retrieve the current user", e);
		}
		return result;
	}
	
	private ArrayList<String> convertRoles(List<Role> roles){
		ArrayList<String> result = new ArrayList<String>();
		for(Role role: roles) {
			result.add(role.getName());
		}
		return result;
	}
}

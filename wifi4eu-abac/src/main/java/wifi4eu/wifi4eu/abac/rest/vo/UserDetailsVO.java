package wifi4eu.wifi4eu.abac.rest.vo;

import java.util.List;

public class UserDetailsVO {

	private String userId;
	private String email;
	private String firstName;
	private String lastName;
	private String fullName;
	private List<String> roles;
	
	public UserDetailsVO(String userId, String firstName, String lastName, String email, List<String> roles) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		if(firstName != null && lastName != null){
			this.fullName = firstName + " " + lastName;
		}
		this.roles = roles;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}

package wifi4eu.wifi4eu.abac.rest.vo;

public class UserDetailsVO {

	private String userId;
	private String firstName;
	private String lastName;
	private String fullName;
	
	public UserDetailsVO(String userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		if(firstName != null && lastName != null){
			this.fullName = firstName + " " + lastName;
		}
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
}

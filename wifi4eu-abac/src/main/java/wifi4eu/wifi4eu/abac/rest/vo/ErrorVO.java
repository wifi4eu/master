package wifi4eu.wifi4eu.abac.rest.vo;

public class ErrorVO {

    private Integer errorCode=null;
    private String errorMessage=null;
    
    public String toJSON(){
    	return "{\"errorCode\":"+errorCode+", \"errorMessage\": \""+errorMessage+"\"}";
    }
    
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}	
}

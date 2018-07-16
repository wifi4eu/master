package wifi4eu.wifi4eu.abac.rest.vo;

public class ResponseVO {
	
	 private Boolean success=null;
	 private String data=null;
	 private ErrorVO error=null;
	 private Integer xtotalCount=null;
	 
	 public String toJson() {
		 return "{\"success\":"+success+", \"data\":\""+data+"\", \"error\":"+(error==null?error:error.toJSON())+", \"xtotalCount\":"+xtotalCount+"}";
	 }
	 
	 public Boolean getSuccess() {
		return success;
	 }
	 public void setSuccess(Boolean success) {
		this.success = success;
	 }
	 public String getData() {
		return data;
	 }
	 public void setData(String data) {
		this.data = data;
	 }
	 public ErrorVO getError() {
		return error;
	 }
	 public void setError(ErrorVO error) {
		this.error = error;
	 }
	 public Integer getXtotalCount() {
		return xtotalCount;
	 }
	 public void setXtotalCount(Integer xtotalCount) {
		this.xtotalCount = xtotalCount;
	 }
}

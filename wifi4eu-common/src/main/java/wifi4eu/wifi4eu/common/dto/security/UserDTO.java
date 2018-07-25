package wifi4eu.wifi4eu.common.dto.security;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class UserDTO implements Serializable {

    private long userId;
    private String email;
    private String password;
    private Date createDate;
    private Date accessDate;
    private long userType;
    private long userTypeId;

    public UserDTO(){}

    public UserDTO(long userId, String email, String password, Date createDate, Date accessDate, long userType, long userTypeId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        this.accessDate = accessDate;
        this.userType = userType;
        this.userTypeId = userTypeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Date accessDate) {
        this.accessDate = accessDate;
    }

    public long getUserType() {
        return userType;
    }

    public void setUserType(long userType) {
        this.userType = userType;
    }

    public long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String toString(){

        StringBuffer result = new StringBuffer();

        result.append("userId: " + this.userId);
        result.append("email: " + this.email);
        result.append("password:" + this.password);
        result.append("createDate: " + this.createDate);
        result.append("accessDate" + this.accessDate);

        return result.toString();
    }
}

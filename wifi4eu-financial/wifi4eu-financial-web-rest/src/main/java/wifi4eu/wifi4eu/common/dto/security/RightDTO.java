package wifi4eu.wifi4eu.common.dto.security;

import java.util.List;
import java.io.Serializable;

public class RightDTO implements Serializable{
    private int id;
    private int userId;
    private String rightdesc;
    private int type;

    public RightDTO() {
    }

    public RightDTO(int id, int userId, String rightdesc, int type) {
        this.id = id;
        this.userId = userId;
        this.rightdesc = rightdesc;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRightdesc() {
        return rightdesc;
    }

    public void setRightdesc(String rightdesc) {
        this.rightdesc = rightdesc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

package wifi4eu.wifi4eu.common.dto.security;

import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long perId;
    private String userId;
    private Date dtDeb;
    private Date dtFin;
    private List<RoleDTO> roles;

    public UserDTO() {
    }

    public UserDTO(Long perId, String userId, Date dtDeb, Date dtFin, List<RoleDTO> roleDTOs) {
        this.perId = perId;
        this.userId = userId;
        this.dtDeb = dtDeb;
        this.dtFin = dtFin;
        this.roles = roleDTOs;
    }

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDtDeb() {
        return dtDeb;
    }

    public void setDtDeb(Date dtDeb) {
        this.dtDeb = dtDeb;
    }

    public Date getDtFin() {
        return dtFin;
    }

    public void setDtFin(Date dtFin) {
        this.dtFin = dtFin;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}

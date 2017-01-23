package wifi4eu.wifi4eu.common.dto.security;

import java.util.List;
import java.io.Serializable;

public class RightDTO implements Serializable{
    private Long rightId;
    private String name;
    private List<RoleDTO> roles;

    public RightDTO() {
    }

    public RightDTO(String name) {
        this.name = name;
    }

    public RightDTO(Long rightId, String name) {
        this.rightId = rightId;
        this.name = name;
    }

    public RightDTO(Long rightId, String name, List<RoleDTO> roleDTOs) {
        this.rightId = rightId;
        this.name = name;
        this.roles = roleDTOs;
    }

    public Long getRightId() {
        return rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDTO> roles) {
        this.roles = roles;
    }
}

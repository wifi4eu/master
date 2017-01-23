package wifi4eu.wifi4eu.common.dto.security;

import java.util.List;
import java.io.Serializable;

public class RoleDTO implements Serializable {
    private Long roleId;
    private String name;

    private List<RightDTO> rights;

    public RoleDTO() {
    }

    public RoleDTO(String name) {
        this.name = name;
    }

    public RoleDTO(Long roleId, String name, List<RightDTO> rightDTOs) {
        this.roleId = roleId;
        this.name = name;
        this.rights = rightDTOs;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RightDTO> getRights() {
        return rights;
    }

    public void setRights(List<RightDTO> rights) {
        this.rights = rights;
    }
}

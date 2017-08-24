package wifi4eu.wifi4eu.mapper.security;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.security.RoleDTO;

import wifi4eu.wifi4eu.entity.security.Role;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class RoleMapperImpl implements RoleMapper {

    @Autowired

    private RightMapper rightMapper;

    @Override

    public RoleDTO toDTO(Role entity) {

        if ( entity == null ) {

            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        if ( entity.getRoleId() != null ) {

            roleDTO.setRoleId( entity.getRoleId() );
        }

        roleDTO.setName( entity.getName() );

        roleDTO.setRights( rightMapper.toDTOList( entity.getRights() ) );

        return roleDTO;
    }

    @Override

    public Role toEntity(RoleDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Role role = new Role();

        role.setRoleId( vo.getRoleId() );

        role.setName( vo.getName() );

        role.setRights( rightMapper.toEntityList( vo.getRights() ) );

        return role;
    }

    @Override

    public List<RoleDTO> toDTOList(List<Role> list) {

        if ( list == null ) {

            return null;
        }

        List<RoleDTO> list_ = new ArrayList<RoleDTO>();

        for ( Role role : list ) {

            list_.add( toDTO( role ) );
        }

        return list_;
    }

    @Override

    public List<Role> toEntityList(List<RoleDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Role> list_ = new ArrayList<Role>();

        for ( RoleDTO roleDTO : list ) {

            list_.add( toEntity( roleDTO ) );
        }

        return list_;
    }
}


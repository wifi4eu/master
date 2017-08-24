package wifi4eu.wifi4eu.mapper.security;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.security.UserDTO;

import wifi4eu.wifi4eu.entity.security.User;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class UserMapperImpl implements UserMapper {

    @Autowired

    private RoleMapper roleMapper;

    @Override

    public UserDTO toDTO(User entity) {

        if ( entity == null ) {

            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserId( entity.getUserId() );

        userDTO.setEmail( entity.getEmail() );

        userDTO.setPassword( entity.getPassword() );

        userDTO.setCreateDate( entity.getCreateDate() );

        userDTO.setAccessDate( entity.getAccessDate() );

        userDTO.setRoles( roleMapper.toDTOList( entity.getRoles() ) );

        userDTO.setUserType( entity.getUserType() );

        userDTO.setUserTypeId( entity.getUserTypeId() );

        return userDTO;
    }

    @Override

    public User toEntity(UserDTO vo) {

        if ( vo == null ) {

            return null;
        }

        User user = new User();

        user.setUserId( vo.getUserId() );

        user.setEmail( vo.getEmail() );

        user.setPassword( vo.getPassword() );

        user.setCreateDate( vo.getCreateDate() );

        user.setAccessDate( vo.getAccessDate() );

        user.setRoles( roleMapper.toEntityList( vo.getRoles() ) );

        user.setUserType( vo.getUserType() );

        user.setUserTypeId( vo.getUserTypeId() );

        return user;
    }

    @Override

    public List<UserDTO> toDTOList(List<User> list) {

        if ( list == null ) {

            return null;
        }

        List<UserDTO> list_ = new ArrayList<UserDTO>();

        for ( User user : list ) {

            list_.add( toDTO( user ) );
        }

        return list_;
    }

    @Override

    public List<User> toEntityList(List<UserDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<User> list_ = new ArrayList<User>();

        for ( UserDTO userDTO : list ) {

            list_.add( toEntity( userDTO ) );
        }

        return list_;
    }
}


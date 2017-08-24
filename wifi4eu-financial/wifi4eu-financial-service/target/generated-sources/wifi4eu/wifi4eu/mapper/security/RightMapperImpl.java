package wifi4eu.wifi4eu.mapper.security;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.security.RightDTO;

import wifi4eu.wifi4eu.entity.security.Right;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class RightMapperImpl implements RightMapper {

    @Autowired

    private RoleMapper roleMapper;

    @Override

    public RightDTO toDTO(Right entity) {

        if ( entity == null ) {

            return null;
        }

        RightDTO rightDTO = new RightDTO();

        rightDTO.setRightId( entity.getRightId() );

        rightDTO.setName( entity.getName() );

        return rightDTO;
    }

    @Override

    public Right toEntity(RightDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Right right = new Right();

        right.setRightId( vo.getRightId() );

        right.setName( vo.getName() );

        right.setRoles( roleMapper.toEntityList( vo.getRoles() ) );

        return right;
    }

    @Override

    public List<RightDTO> toDTOList(List<Right> list) {

        if ( list == null ) {

            return null;
        }

        List<RightDTO> list_ = new ArrayList<RightDTO>();

        for ( Right right : list ) {

            list_.add( toDTO( right ) );
        }

        return list_;
    }

    @Override

    public List<Right> toEntityList(List<RightDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Right> list_ = new ArrayList<Right>();

        for ( RightDTO rightDTO : list ) {

            list_.add( toEntity( rightDTO ) );
        }

        return list_;
    }
}


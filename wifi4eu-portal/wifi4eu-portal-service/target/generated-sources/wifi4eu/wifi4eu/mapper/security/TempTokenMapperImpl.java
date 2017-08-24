package wifi4eu.wifi4eu.mapper.security;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.security.TempTokenDTO;

import wifi4eu.wifi4eu.entity.security.TempToken;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class TempTokenMapperImpl implements TempTokenMapper {

    @Override

    public TempTokenDTO toDTO(TempToken entity) {

        if ( entity == null ) {

            return null;
        }

        TempTokenDTO tempTokenDTO = new TempTokenDTO();

        tempTokenDTO.setId( entity.getId() );

        tempTokenDTO.setToken( entity.getToken() );

        tempTokenDTO.setEmail( entity.getEmail() );

        tempTokenDTO.setCreateDate( entity.getCreateDate() );

        tempTokenDTO.setExpiryDate( entity.getExpiryDate() );

        tempTokenDTO.setUserId( entity.getUserId() );

        return tempTokenDTO;
    }

    @Override

    public TempToken toEntity(TempTokenDTO dto) {

        if ( dto == null ) {

            return null;
        }

        TempToken tempToken = new TempToken();

        tempToken.setId( dto.getId() );

        tempToken.setToken( dto.getToken() );

        tempToken.setEmail( dto.getEmail() );

        tempToken.setUserId( dto.getUserId() );

        tempToken.setCreateDate( dto.getCreateDate() );

        tempToken.setExpiryDate( dto.getExpiryDate() );

        return tempToken;
    }

    @Override

    public List<TempTokenDTO> toDTOList(List<TempToken> list) {

        if ( list == null ) {

            return null;
        }

        List<TempTokenDTO> list_ = new ArrayList<TempTokenDTO>();

        for ( TempToken tempToken : list ) {

            list_.add( toDTO( tempToken ) );
        }

        return list_;
    }

    @Override

    public List<TempToken> toEntityList(List<TempTokenDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<TempToken> list_ = new ArrayList<TempToken>();

        for ( TempTokenDTO tempTokenDTO : list ) {

            list_.add( toEntity( tempTokenDTO ) );
        }

        return list_;
    }
}


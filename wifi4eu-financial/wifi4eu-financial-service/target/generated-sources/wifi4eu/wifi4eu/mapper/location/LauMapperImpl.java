package wifi4eu.wifi4eu.mapper.location;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.LauDTO;

import wifi4eu.wifi4eu.entity.location.Lau;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class LauMapperImpl implements LauMapper {

    @Override

    public LauDTO toDTO(Lau entity) {

        if ( entity == null ) {

            return null;
        }

        LauDTO lauDTO = new LauDTO();

        lauDTO.setLauId( entity.getLauId() );

        lauDTO.setCountryCode( entity.getCountryCode() );

        lauDTO.setNuts3( entity.getNuts3() );

        lauDTO.setLau1( entity.getLau1() );

        lauDTO.setLau2( entity.getLau2() );

        lauDTO.setChange( entity.getChange() );

        lauDTO.setName1( entity.getName1() );

        lauDTO.setName2( entity.getName2() );

        lauDTO.setPop( entity.getPop() );

        lauDTO.setArea( entity.getArea() );

        return lauDTO;
    }

    @Override

    public Lau toEntity(LauDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Lau lau = new Lau();

        lau.setLauId( vo.getLauId() );

        lau.setCountryCode( vo.getCountryCode() );

        lau.setNuts3( vo.getNuts3() );

        lau.setLau1( vo.getLau1() );

        lau.setLau2( vo.getLau2() );

        lau.setChange( vo.getChange() );

        lau.setName1( vo.getName1() );

        lau.setName2( vo.getName2() );

        lau.setPop( vo.getPop() );

        lau.setArea( vo.getArea() );

        return lau;
    }

    @Override

    public List<LauDTO> toDTOList(List<Lau> list) {

        if ( list == null ) {

            return null;
        }

        List<LauDTO> list_ = new ArrayList<LauDTO>();

        for ( Lau lau : list ) {

            list_.add( toDTO( lau ) );
        }

        return list_;
    }

    @Override

    public List<Lau> toEntityList(List<LauDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Lau> list_ = new ArrayList<Lau>();

        for ( LauDTO lauDTO : list ) {

            list_.add( toEntity( lauDTO ) );
        }

        return list_;
    }
}


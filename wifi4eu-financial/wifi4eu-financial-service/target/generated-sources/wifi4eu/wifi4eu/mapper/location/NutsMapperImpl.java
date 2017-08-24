package wifi4eu.wifi4eu.mapper.location;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.NutsDTO;

import wifi4eu.wifi4eu.entity.location.Nuts;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class NutsMapperImpl implements NutsMapper {

    @Override

    public NutsDTO toDTO(Nuts entity) {

        if ( entity == null ) {

            return null;
        }

        NutsDTO nutsDTO = new NutsDTO();

        nutsDTO.setNutsId( entity.getNutsId() );

        nutsDTO.setCode( entity.getCode() );

        nutsDTO.setName( entity.getName() );

        nutsDTO.setLevel( entity.getLevel() );

        nutsDTO.setCountryCode( entity.getCountryCode() );

        nutsDTO.setOrder( entity.getOrder() );

        nutsDTO.setSorting( entity.getSorting() );

        return nutsDTO;
    }

    @Override

    public Nuts toEntity(NutsDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Nuts nuts = new Nuts();

        nuts.setNutsId( vo.getNutsId() );

        nuts.setCode( vo.getCode() );

        nuts.setName( vo.getName() );

        nuts.setLevel( vo.getLevel() );

        nuts.setCountryCode( vo.getCountryCode() );

        nuts.setOrder( vo.getOrder() );

        nuts.setSorting( vo.getSorting() );

        return nuts;
    }

    @Override

    public List<NutsDTO> toDTOList(List<Nuts> list) {

        if ( list == null ) {

            return null;
        }

        List<NutsDTO> list_ = new ArrayList<NutsDTO>();

        for ( Nuts nuts : list ) {

            list_.add( toDTO( nuts ) );
        }

        return list_;
    }

    @Override

    public List<Nuts> toEntityList(List<NutsDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Nuts> list_ = new ArrayList<Nuts>();

        for ( NutsDTO nutsDTO : list ) {

            list_.add( toEntity( nutsDTO ) );
        }

        return list_;
    }
}


package wifi4eu.wifi4eu.mapper.beneficiary;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.MayorDTO;

import wifi4eu.wifi4eu.entity.beneficiary.Mayor;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class MayorMapperImpl implements MayorMapper {

    @Override

    public MayorDTO toDTO(Mayor entity) {

        if ( entity == null ) {

            return null;
        }

        MayorDTO mayorDTO = new MayorDTO();

        if ( entity.getMayorId() != null ) {

            mayorDTO.setMayorId( entity.getMayorId() );
        }

        mayorDTO.setTreatment( entity.getTreatment() );

        mayorDTO.setName( entity.getName() );

        mayorDTO.setSurname( entity.getSurname() );

        mayorDTO.setEmail( entity.getEmail() );

        if ( entity.getLegalEntityId() != null ) {

            mayorDTO.setLegalEntityId( entity.getLegalEntityId() );
        }

        return mayorDTO;
    }

    @Override

    public Mayor toEntity(MayorDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Mayor mayor = new Mayor();

        mayor.setMayorId( vo.getMayorId() );

        mayor.setTreatment( vo.getTreatment() );

        mayor.setName( vo.getName() );

        mayor.setSurname( vo.getSurname() );

        mayor.setEmail( vo.getEmail() );

        mayor.setLegalEntityId( vo.getLegalEntityId() );

        return mayor;
    }

    @Override

    public List<MayorDTO> toDTOList(List<Mayor> list) {

        if ( list == null ) {

            return null;
        }

        List<MayorDTO> list_ = new ArrayList<MayorDTO>();

        for ( Mayor mayor : list ) {

            list_.add( toDTO( mayor ) );
        }

        return list_;
    }

    @Override

    public List<Mayor> toEntityList(List<MayorDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Mayor> list_ = new ArrayList<Mayor>();

        for ( MayorDTO mayorDTO : list ) {

            list_.add( toEntity( mayorDTO ) );
        }

        return list_;
    }
}


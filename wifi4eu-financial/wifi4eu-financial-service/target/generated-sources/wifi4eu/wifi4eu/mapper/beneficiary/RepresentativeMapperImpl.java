package wifi4eu.wifi4eu.mapper.beneficiary;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.RepresentativeDTO;

import wifi4eu.wifi4eu.entity.beneficiary.Representative;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class RepresentativeMapperImpl implements RepresentativeMapper {

    @Override

    public RepresentativeDTO toDTO(Representative entity) {

        if ( entity == null ) {

            return null;
        }

        RepresentativeDTO representativeDTO = new RepresentativeDTO();

        representativeDTO.setRepresentativeId( entity.getRepresentativeId() );

        representativeDTO.setTreatment( entity.getTreatment() );

        representativeDTO.setName( entity.getName() );

        representativeDTO.setSurname( entity.getSurname() );

        representativeDTO.setMunicipalityRole( entity.getMunicipalityRole() );

        representativeDTO.setEmail( entity.getEmail() );

        representativeDTO.setMayorId( entity.getMayorId() );

        return representativeDTO;
    }

    @Override

    public Representative toEntity(RepresentativeDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Representative representative = new Representative();

        representative.setRepresentativeId( vo.getRepresentativeId() );

        representative.setTreatment( vo.getTreatment() );

        representative.setName( vo.getName() );

        representative.setSurname( vo.getSurname() );

        representative.setMunicipalityRole( vo.getMunicipalityRole() );

        representative.setEmail( vo.getEmail() );

        if ( vo.getMayorId() != null ) {

            representative.setMayorId( vo.getMayorId() );
        }

        return representative;
    }

    @Override

    public List<RepresentativeDTO> toDTOList(List<Representative> list) {

        if ( list == null ) {

            return null;
        }

        List<RepresentativeDTO> list_ = new ArrayList<RepresentativeDTO>();

        for ( Representative representative : list ) {

            list_.add( toDTO( representative ) );
        }

        return list_;
    }

    @Override

    public List<Representative> toEntityList(List<RepresentativeDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Representative> list_ = new ArrayList<Representative>();

        for ( RepresentativeDTO representativeDTO : list ) {

            list_.add( toEntity( representativeDTO ) );
        }

        return list_;
    }
}


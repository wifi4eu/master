package wifi4eu.wifi4eu.mapper.beneficiary;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.LegalEntityDTO;

import wifi4eu.wifi4eu.entity.beneficiary.LegalEntity;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class LegalEntityMapperImpl implements LegalEntityMapper {

    @Override

    public LegalEntityDTO toDTO(LegalEntity entity) {

        if ( entity == null ) {

            return null;
        }

        LegalEntityDTO legalEntityDTO = new LegalEntityDTO();

        legalEntityDTO.setLegalEntityId( entity.getLegalEntityId() );

        legalEntityDTO.setCountryCode( entity.getCountryCode() );

        legalEntityDTO.setMunicipalityCode( entity.getMunicipalityCode() );

        legalEntityDTO.setAddress( entity.getAddress() );

        legalEntityDTO.setAddressNum( entity.getAddressNum() );

        legalEntityDTO.setPostalCode( entity.getPostalCode() );

        if ( entity.isLegalCheckbox1() != null ) {

            legalEntityDTO.setLegalCheckbox1( entity.isLegalCheckbox1() );
        }

        if ( entity.isLegalCheckbox2() != null ) {

            legalEntityDTO.setLegalCheckbox2( entity.isLegalCheckbox2() );
        }

        if ( entity.isLegalCheckbox3() != null ) {

            legalEntityDTO.setLegalCheckbox3( entity.isLegalCheckbox3() );
        }

        if ( entity.getAbacStatus() != null ) {

            legalEntityDTO.setAbacStatus( entity.getAbacStatus() );
        }

        return legalEntityDTO;
    }

    @Override

    public LegalEntity toEntity(LegalEntityDTO vo) {

        if ( vo == null ) {

            return null;
        }

        LegalEntity legalEntity = new LegalEntity();

        legalEntity.setLegalEntityId( vo.getLegalEntityId() );

        legalEntity.setCountryCode( vo.getCountryCode() );

        legalEntity.setMunicipalityCode( vo.getMunicipalityCode() );

        legalEntity.setAddress( vo.getAddress() );

        legalEntity.setAddressNum( vo.getAddressNum() );

        legalEntity.setPostalCode( vo.getPostalCode() );

        legalEntity.setLegalCheckbox1( vo.isLegalCheckbox1() );

        legalEntity.setLegalCheckbox2( vo.isLegalCheckbox2() );

        legalEntity.setLegalCheckbox3( vo.isLegalCheckbox3() );

        legalEntity.setAbacStatus( vo.isAbacStatus() );

        return legalEntity;
    }

    @Override

    public List<LegalEntityDTO> toDTOList(List<LegalEntity> list) {

        if ( list == null ) {

            return null;
        }

        List<LegalEntityDTO> list_ = new ArrayList<LegalEntityDTO>();

        for ( LegalEntity legalEntity : list ) {

            list_.add( toDTO( legalEntity ) );
        }

        return list_;
    }

    @Override

    public List<LegalEntity> toEntityList(List<LegalEntityDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<LegalEntity> list_ = new ArrayList<LegalEntity>();

        for ( LegalEntityDTO legalEntityDTO : list ) {

            list_.add( toEntity( legalEntityDTO ) );
        }

        return list_;
    }
}


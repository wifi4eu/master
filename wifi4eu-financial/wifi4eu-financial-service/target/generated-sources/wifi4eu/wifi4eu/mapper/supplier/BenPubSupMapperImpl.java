package wifi4eu.wifi4eu.mapper.supplier;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.BenPubSupDTO;

import wifi4eu.wifi4eu.entity.supplier.BenPubSup;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class BenPubSupMapperImpl implements BenPubSupMapper {

    @Override

    public BenPubSupDTO toDTO(BenPubSup entity) {

        if ( entity == null ) {

            return null;
        }

        BenPubSupDTO benPubSupDTO = new BenPubSupDTO();

        benPubSupDTO.setBenPubSubId( entity.getBenPubSubId() );

        benPubSupDTO.setBeneficiaryId( entity.getBeneficiaryId() );

        benPubSupDTO.setPublicationId( entity.getPublicationId() );

        benPubSupDTO.setAwarded( entity.isAwarded() );

        benPubSupDTO.setSupplierId( entity.getSupplierId() );

        benPubSupDTO.setBudgetCommited( entity.isBudgetCommited() );

        benPubSupDTO.setBudgetLinked( entity.isBudgetLinked() );

        benPubSupDTO.setLastAbacMessage( entity.getLastAbacMessage() );

        benPubSupDTO.setDate( entity.getDate() );

        benPubSupDTO.setAbacStatus( entity.isAbacStatus() );

        return benPubSupDTO;
    }

    @Override

    public BenPubSup toEntity(BenPubSupDTO vo) {

        if ( vo == null ) {

            return null;
        }

        BenPubSup benPubSup = new BenPubSup();

        benPubSup.setBenPubSubId( vo.getBenPubSubId() );

        benPubSup.setBeneficiaryId( vo.getBeneficiaryId() );

        benPubSup.setPublicationId( vo.getPublicationId() );

        benPubSup.setAwarded( vo.isAwarded() );

        benPubSup.setSupplierId( vo.getSupplierId() );

        benPubSup.setBudgetCommited( vo.isBudgetCommited() );

        benPubSup.setBudgetLinked( vo.isBudgetLinked() );

        benPubSup.setLastAbacMessage( vo.getLastAbacMessage() );

        benPubSup.setDate( vo.getDate() );

        benPubSup.setAbacStatus( vo.isAbacStatus() );

        return benPubSup;
    }

    @Override

    public List<BenPubSupDTO> toDTOList(List<BenPubSup> list) {

        if ( list == null ) {

            return null;
        }

        List<BenPubSupDTO> list_ = new ArrayList<BenPubSupDTO>();

        for ( BenPubSup benPubSup : list ) {

            list_.add( toDTO( benPubSup ) );
        }

        return list_;
    }

    @Override

    public List<BenPubSup> toEntityList(List<BenPubSupDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<BenPubSup> list_ = new ArrayList<BenPubSup>();

        for ( BenPubSupDTO benPubSupDTO : list ) {

            list_.add( toEntity( benPubSupDTO ) );
        }

        return list_;
    }
}


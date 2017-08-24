package wifi4eu.wifi4eu.mapper.supplier;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.SupplierDTO;

import wifi4eu.wifi4eu.entity.supplier.Supplier;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class SupplierMapperImpl implements SupplierMapper {

    @Override

    public SupplierDTO toDTO(Supplier entity) {

        if ( entity == null ) {

            return null;
        }

        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setSupplierId( entity.getSupplierId() );

        supplierDTO.setName( entity.getName() );

        supplierDTO.setAddress( entity.getAddress() );

        supplierDTO.setVat( entity.getVat() );

        supplierDTO.setBic( entity.getBic() );

        supplierDTO.setAccountNumber( entity.getAccountNumber() );

        supplierDTO.setWebsite( entity.getWebsite() );

        supplierDTO.setContactName( entity.getContactName() );

        supplierDTO.setContactSurname( entity.getContactSurname() );

        supplierDTO.setContactPhonePrefix( entity.getContactPhonePrefix() );

        supplierDTO.setContactPhoneNumber( entity.getContactPhoneNumber() );

        supplierDTO.setContactEmail( entity.getContactEmail() );

        supplierDTO.setLegalCheck1( entity.isLegalCheck1() );

        supplierDTO.setLegalCheck2( entity.isLegalCheck2() );

        supplierDTO.setCreateDate( entity.getCreateDate() );

        supplierDTO.setNutsIds( entity.getNutsIds() );

        supplierDTO.setLogo( entity.getLogo() );

        if ( entity.getAbacStatus() != null ) {

            supplierDTO.setAbacStatus( entity.getAbacStatus() );
        }

        return supplierDTO;
    }

    @Override

    public Supplier toEntity(SupplierDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Supplier supplier = new Supplier();

        supplier.setSupplierId( vo.getSupplierId() );

        supplier.setName( vo.getName() );

        supplier.setAddress( vo.getAddress() );

        supplier.setVat( vo.getVat() );

        supplier.setBic( vo.getBic() );

        supplier.setAccountNumber( vo.getAccountNumber() );

        supplier.setWebsite( vo.getWebsite() );

        supplier.setContactName( vo.getContactName() );

        supplier.setContactSurname( vo.getContactSurname() );

        supplier.setContactPhonePrefix( vo.getContactPhonePrefix() );

        supplier.setContactPhoneNumber( vo.getContactPhoneNumber() );

        supplier.setContactEmail( vo.getContactEmail() );

        supplier.setLegalCheck1( vo.isLegalCheck1() );

        supplier.setLegalCheck2( vo.isLegalCheck2() );

        supplier.setCreateDate( vo.getCreateDate() );

        supplier.setNutsIds( vo.getNutsIds() );

        supplier.setLogo( vo.getLogo() );

        supplier.setAbacStatus( vo.isAbacStatus() );

        return supplier;
    }

    @Override

    public List<SupplierDTO> toDTOList(List<Supplier> list) {

        if ( list == null ) {

            return null;
        }

        List<SupplierDTO> list_ = new ArrayList<SupplierDTO>();

        for ( Supplier supplier : list ) {

            list_.add( toDTO( supplier ) );
        }

        return list_;
    }

    @Override

    public List<Supplier> toEntityList(List<SupplierDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Supplier> list_ = new ArrayList<Supplier>();

        for ( SupplierDTO supplierDTO : list ) {

            list_.add( toEntity( supplierDTO ) );
        }

        return list_;
    }
}


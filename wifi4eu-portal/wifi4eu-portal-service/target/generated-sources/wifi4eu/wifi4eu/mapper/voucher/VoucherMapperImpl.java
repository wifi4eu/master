package wifi4eu.wifi4eu.mapper.voucher;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.VoucherDTO;

import wifi4eu.wifi4eu.entity.voucher.Voucher;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class VoucherMapperImpl implements VoucherMapper {

    @Override

    public VoucherDTO toDTO(Voucher entity) {

        if ( entity == null ) {

            return null;
        }

        VoucherDTO voucherDTO = new VoucherDTO();

        voucherDTO.setVoucherId( entity.getVoucherId() );

        voucherDTO.setUserId( entity.getUserId() );

        voucherDTO.setLegalEntityId( entity.getLegalEntityId() );

        voucherDTO.setCreateDate( entity.getCreateDate() );

        voucherDTO.setCountryCode( entity.getCountryCode() );

        voucherDTO.setNuts3( entity.getNuts3() );

        voucherDTO.setLau1( entity.getLau1() );

        voucherDTO.setLau2( entity.getLau2() );

        return voucherDTO;
    }

    @Override

    public Voucher toEntity(VoucherDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Voucher voucher = new Voucher();

        voucher.setVoucherId( vo.getVoucherId() );

        voucher.setUserId( vo.getUserId() );

        voucher.setLegalEntityId( vo.getLegalEntityId() );

        voucher.setCreateDate( vo.getCreateDate() );

        voucher.setCountryCode( vo.getCountryCode() );

        voucher.setNuts3( vo.getNuts3() );

        voucher.setLau1( vo.getLau1() );

        voucher.setLau2( vo.getLau2() );

        return voucher;
    }

    @Override

    public List<VoucherDTO> toDTOList(List<Voucher> list) {

        if ( list == null ) {

            return null;
        }

        List<VoucherDTO> list_ = new ArrayList<VoucherDTO>();

        for ( Voucher voucher : list ) {

            list_.add( toDTO( voucher ) );
        }

        return list_;
    }

    @Override

    public List<Voucher> toEntityList(List<VoucherDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Voucher> list_ = new ArrayList<Voucher>();

        for ( VoucherDTO voucherDTO : list ) {

            list_.add( toEntity( voucherDTO ) );
        }

        return list_;
    }
}


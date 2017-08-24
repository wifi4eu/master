package wifi4eu.wifi4eu.mapper.supplier;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.AccessPointDTO;

import wifi4eu.wifi4eu.entity.supplier.AccessPoint;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class AccessPointMapperImpl implements AccessPointMapper {

    @Override

    public AccessPointDTO toDTO(AccessPoint entity) {

        if ( entity == null ) {

            return null;
        }

        AccessPointDTO accessPointDTO = new AccessPointDTO();

        accessPointDTO.setAccessPointId( entity.getAccessPointId() );

        accessPointDTO.setName( entity.getName() );

        accessPointDTO.setSerialNumber( entity.getSerialNumber() );

        accessPointDTO.setProductName( entity.getProductName() );

        accessPointDTO.setModelNumber( entity.getModelNumber() );

        accessPointDTO.setInstallationId( entity.getInstallationId() );

        accessPointDTO.setIndoor( entity.getIndoor() );

        return accessPointDTO;
    }

    @Override

    public AccessPoint toEntity(AccessPointDTO vo) {

        if ( vo == null ) {

            return null;
        }

        AccessPoint accessPoint = new AccessPoint();

        accessPoint.setAccessPointId( vo.getAccessPointId() );

        accessPoint.setName( vo.getName() );

        accessPoint.setSerialNumber( vo.getSerialNumber() );

        accessPoint.setProductName( vo.getProductName() );

        accessPoint.setModelNumber( vo.getModelNumber() );

        accessPoint.setInstallationId( vo.getInstallationId() );

        accessPoint.setIndoor( vo.getIndoor() );

        return accessPoint;
    }

    @Override

    public List<AccessPointDTO> toDTOList(List<AccessPoint> list) {

        if ( list == null ) {

            return null;
        }

        List<AccessPointDTO> list_ = new ArrayList<AccessPointDTO>();

        for ( AccessPoint accessPoint : list ) {

            list_.add( toDTO( accessPoint ) );
        }

        return list_;
    }

    @Override

    public List<AccessPoint> toEntityList(List<AccessPointDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<AccessPoint> list_ = new ArrayList<AccessPoint>();

        for ( AccessPointDTO accessPointDTO : list ) {

            list_.add( toEntity( accessPointDTO ) );
        }

        return list_;
    }
}


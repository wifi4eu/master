package wifi4eu.wifi4eu.mapper.audit;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.audit.AuditDataDTO;

import wifi4eu.wifi4eu.entity.audit.AuditData;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class AuditMapperImpl implements AuditMapper {

    @Override

    public AuditDataDTO toDTO(AuditData entity) {

        if ( entity == null ) {

            return null;
        }

        AuditDataDTO auditDataDTO = new AuditDataDTO();

        auditDataDTO.setRequestEndpoint( entity.getRequestEndpoint() );

        auditDataDTO.setRequestMethod( entity.getRequestMethod() );

        auditDataDTO.setRequestBody( entity.getRequestBody() );

        auditDataDTO.setResponseBody( entity.getResponseBody() );

        auditDataDTO.setUserId( entity.getUserId() );

        return auditDataDTO;
    }

    @Override

    public AuditData toEntity(AuditDataDTO vo) {

        if ( vo == null ) {

            return null;
        }

        AuditData auditData = new AuditData();

        auditData.setRequestEndpoint( vo.getRequestEndpoint() );

        auditData.setRequestMethod( vo.getRequestMethod() );

        auditData.setRequestBody( vo.getRequestBody() );

        auditData.setResponseBody( vo.getResponseBody() );

        auditData.setUserId( vo.getUserId() );

        return auditData;
    }

    @Override

    public List<AuditDataDTO> toDTOList(List<AuditData> list) {

        if ( list == null ) {

            return null;
        }

        List<AuditDataDTO> list_ = new ArrayList<AuditDataDTO>();

        for ( AuditData auditData : list ) {

            list_.add( toDTO( auditData ) );
        }

        return list_;
    }

    @Override

    public List<AuditData> toEntityList(List<AuditDataDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<AuditData> list_ = new ArrayList<AuditData>();

        for ( AuditDataDTO auditDataDTO : list ) {

            list_.add( toEntity( auditDataDTO ) );
        }

        return list_;
    }
}


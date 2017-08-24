package wifi4eu.wifi4eu.mapper.helpdesk;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.HelpdeskDTO;

import wifi4eu.wifi4eu.entity.helpdesk.Helpdesk;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class HelpdeskMapperImpl implements HelpdeskMapper {

    @Override

    public HelpdeskDTO toDTO(Helpdesk entity) {

        if ( entity == null ) {

            return null;
        }

        HelpdeskDTO helpdeskDTO = new HelpdeskDTO();

        helpdeskDTO.setIssueId( entity.getIssueId() );

        helpdeskDTO.setPortal( entity.getPortal() );

        helpdeskDTO.setTopic( entity.getTopic() );

        helpdeskDTO.setMemberState( entity.getMemberState() );

        helpdeskDTO.setDate( entity.getDate() );

        helpdeskDTO.setAssignedTo( entity.getAssignedTo() );

        helpdeskDTO.setStatus( entity.getStatus() );

        helpdeskDTO.setFrom( entity.getFrom() );

        helpdeskDTO.setIssueSummary( entity.getIssueSummary() );

        return helpdeskDTO;
    }

    @Override

    public Helpdesk toEntity(HelpdeskDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Helpdesk helpdesk = new Helpdesk();

        helpdesk.setIssueId( vo.getIssueId() );

        helpdesk.setPortal( vo.getPortal() );

        helpdesk.setTopic( vo.getTopic() );

        helpdesk.setMemberState( vo.getMemberState() );

        helpdesk.setDate( vo.getDate() );

        helpdesk.setAssignedTo( vo.getAssignedTo() );

        helpdesk.setStatus( vo.getStatus() );

        helpdesk.setFrom( vo.getFrom() );

        helpdesk.setIssueSummary( vo.getIssueSummary() );

        return helpdesk;
    }

    @Override

    public List<HelpdeskDTO> toDTOList(List<Helpdesk> list) {

        if ( list == null ) {

            return null;
        }

        List<HelpdeskDTO> list_ = new ArrayList<HelpdeskDTO>();

        for ( Helpdesk helpdesk : list ) {

            list_.add( toDTO( helpdesk ) );
        }

        return list_;
    }

    @Override

    public List<Helpdesk> toEntityList(List<HelpdeskDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Helpdesk> list_ = new ArrayList<Helpdesk>();

        for ( HelpdeskDTO helpdeskDTO : list ) {

            list_.add( toEntity( helpdeskDTO ) );
        }

        return list_;
    }
}


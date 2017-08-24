package wifi4eu.wifi4eu.mapper.helpdesk;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.HelpdeskCommentDTO;

import wifi4eu.wifi4eu.entity.helpdesk.HelpdeskComment;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class HelpdeskCommentMapperImpl implements HelpdeskCommentMapper {

    @Override

    public HelpdeskCommentDTO toDTO(HelpdeskComment entity) {

        if ( entity == null ) {

            return null;
        }

        HelpdeskCommentDTO helpdeskCommentDTO = new HelpdeskCommentDTO();

        helpdeskCommentDTO.setCommentId( entity.getCommentId() );

        helpdeskCommentDTO.setType( entity.getType() );

        helpdeskCommentDTO.setComment( entity.getComment() );

        helpdeskCommentDTO.setCommentDate( entity.getCommentDate() );

        helpdeskCommentDTO.setIssueId( entity.getIssueId() );

        return helpdeskCommentDTO;
    }

    @Override

    public HelpdeskComment toEntity(HelpdeskCommentDTO vo) {

        if ( vo == null ) {

            return null;
        }

        HelpdeskComment helpdeskComment = new HelpdeskComment();

        helpdeskComment.setCommentId( vo.getCommentId() );

        helpdeskComment.setType( vo.getType() );

        helpdeskComment.setComment( vo.getComment() );

        helpdeskComment.setCommentDate( vo.getCommentDate() );

        helpdeskComment.setIssueId( vo.getIssueId() );

        return helpdeskComment;
    }

    @Override

    public List<HelpdeskCommentDTO> toDTOList(List<HelpdeskComment> list) {

        if ( list == null ) {

            return null;
        }

        List<HelpdeskCommentDTO> list_ = new ArrayList<HelpdeskCommentDTO>();

        for ( HelpdeskComment helpdeskComment : list ) {

            list_.add( toDTO( helpdeskComment ) );
        }

        return list_;
    }

    @Override

    public List<HelpdeskComment> toEntityList(List<HelpdeskCommentDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<HelpdeskComment> list_ = new ArrayList<HelpdeskComment>();

        for ( HelpdeskCommentDTO helpdeskCommentDTO : list ) {

            list_.add( toEntity( helpdeskCommentDTO ) );
        }

        return list_;
    }
}


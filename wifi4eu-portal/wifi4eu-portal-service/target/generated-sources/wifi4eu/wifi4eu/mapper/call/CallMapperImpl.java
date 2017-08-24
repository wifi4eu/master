package wifi4eu.wifi4eu.mapper.call;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.CallDTO;

import wifi4eu.wifi4eu.entity.call.Call;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:11+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class CallMapperImpl implements CallMapper {

    @Override

    public CallDTO toDTO(Call entity) {

        if ( entity == null ) {

            return null;
        }

        CallDTO callDTO = new CallDTO();

        callDTO.setCallId( entity.getCallId() );

        callDTO.setStartDate( entity.getStartDate() );

        callDTO.setEndDate( entity.getEndDate() );

        callDTO.setEvent( entity.getEvent() );

        return callDTO;
    }

    @Override

    public Call toEntity(CallDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Call call = new Call();

        call.setCallId( vo.getCallId() );

        call.setStartDate( vo.getStartDate() );

        call.setEndDate( vo.getEndDate() );

        call.setEvent( vo.getEvent() );

        return call;
    }

    @Override

    public List<CallDTO> toDTOList(List<Call> list) {

        if ( list == null ) {

            return null;
        }

        List<CallDTO> list_ = new ArrayList<CallDTO>();

        for ( Call call : list ) {

            list_.add( toDTO( call ) );
        }

        return list_;
    }

    @Override

    public List<Call> toEntityList(List<CallDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Call> list_ = new ArrayList<Call>();

        for ( CallDTO callDTO : list ) {

            list_.add( toEntity( callDTO ) );
        }

        return list_;
    }
}


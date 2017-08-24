package wifi4eu.wifi4eu.mapper.supplier;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import wifi4eu.wifi4eu.common.dto.model.InstallationDTO;

import wifi4eu.wifi4eu.entity.supplier.Installation;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-08-24T08:54:50+0200",

    comments = "version: 1.1.0.Beta2, compiler: javac, environment: Java 1.8.0_102 (Oracle Corporation)"

)

@Component

public class InstallationMapperImpl implements InstallationMapper {

    @Override

    public InstallationDTO toDTO(Installation entity) {

        if ( entity == null ) {

            return null;
        }

        InstallationDTO installationDTO = new InstallationDTO();

        installationDTO.setInstallationId( entity.getInstallationId() );

        installationDTO.setNip( entity.getNip() );

        return installationDTO;
    }

    @Override

    public Installation toEntity(InstallationDTO vo) {

        if ( vo == null ) {

            return null;
        }

        Installation installation = new Installation();

        installation.setInstallationId( vo.getInstallationId() );

        installation.setNip( vo.getNip() );

        return installation;
    }

    @Override

    public List<InstallationDTO> toDTOList(List<Installation> list) {

        if ( list == null ) {

            return null;
        }

        List<InstallationDTO> list_ = new ArrayList<InstallationDTO>();

        for ( Installation installation : list ) {

            list_.add( toDTO( installation ) );
        }

        return list_;
    }

    @Override

    public List<Installation> toEntityList(List<InstallationDTO> list) {

        if ( list == null ) {

            return null;
        }

        List<Installation> list_ = new ArrayList<Installation>();

        for ( InstallationDTO installationDTO : list ) {

            list_.add( toEntity( installationDTO ) );
        }

        return list_;
    }
}


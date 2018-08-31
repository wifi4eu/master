package wifi4eu.wifi4eu.mapper.registration.legal_files;

import org.mapstruct.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.entity.registration.*;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class LegalFilesMapper {

	public LegalFileDTO toDTO(LegalFile entity) {
        if ( entity == null ) {
            return null;
        }

        LegalFileDTO legalFileDTO = new LegalFileDTO();

        if ( entity.getId() != null ) {
            legalFileDTO.setId( entity.getId() );
        }
        legalFileDTO.setRegistration( entity.getRegistration() );
        if ( entity.getFileData() != null ) {
            legalFileDTO.setFileData( new String(entity.getFileData(), StandardCharsets.UTF_8) );
        }
        legalFileDTO.setFileType( entity.getFileType() );
        legalFileDTO.setUploadTime( entity.getUploadTime() );
        legalFileDTO.setUserId( entity.getUserId() );
        legalFileDTO.setFileSize( entity.getFileSize() );
        legalFileDTO.setFileMime( entity.getFileMime() );
        legalFileDTO.setFileName( entity.getFileName() );

        return legalFileDTO;		
	}
	
	public LegalFile toEntity(LegalFileDTO vo) {
        if ( vo == null ) {
            return null;
        }

        LegalFile legalFile = new LegalFile();

        legalFile.setId( vo.getId() );
        legalFile.setRegistration( vo.getRegistration() );
        if ( vo.getFileData() != null ) {
            byte[] fileData = vo.getFileData().getBytes(StandardCharsets.UTF_8);
            legalFile.setFileData( Arrays.copyOf( fileData, fileData.length ) );
        }
        legalFile.setFileType( vo.getFileType() );
        legalFile.setUploadTime( vo.getUploadTime() );
        legalFile.setUserId( vo.getUserId() );
        legalFile.setFileSize( vo.getFileSize() );
        legalFile.setFileMime( vo.getFileMime() );
        legalFile.setFileName( vo.getFileName() );

        return legalFile;
	}
	
	public abstract List<LegalFileDTO> toDTOList(List<LegalFile> list);
	public abstract List<LegalFile> toEntityList(List<LegalFileDTO> list);
}

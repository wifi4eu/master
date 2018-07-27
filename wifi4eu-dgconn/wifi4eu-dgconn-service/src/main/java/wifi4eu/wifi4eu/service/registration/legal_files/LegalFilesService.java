package wifi4eu.wifi4eu.service.registration.legal_files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.mapper.registration.legal_files.*;
import wifi4eu.wifi4eu.repository.registration.legal_files.*;

@Service("legalFilesService")
public class LegalFilesService {

	private final Logger _log = LogManager.getLogger(LegalFilesService.class);

	@Autowired
	LegalFilesRepository legalFilesRepository;

	@Autowired
	LegalFilesMapper legalFilesMapper;

	public LegalFileDTO getLegalFileByRegistrationIdFileType(Integer registrationId, Integer fileType) {
		return legalFilesMapper.toDTO(legalFilesRepository.findByRegistrationAndFileType(registrationId, fileType));
	}

    public static String getBase64Data(String base64String) {
        String base64Data = null;
        if (base64String != null) {
            if (base64String.startsWith("data:") && base64String.indexOf(";base64,") != -1) {
                base64Data = base64String.substring(base64String.indexOf(";base64,") + 8);
            }
        }
        return base64Data;
    }

	public static String getMimeType(String base64String) {
		String mimeType = null;
		if (base64String != null) {
			if (base64String.startsWith("data:") && base64String.indexOf(";base64") != -1) {
				mimeType = base64String.substring(5, (base64String.indexOf(";base64")));
			}
		}
		return mimeType;
	}

	public static String getValidFileExtension(String base64String) {
		String fileExtension = null;
		if (base64String != null) {
			String mimeType = getMimeType(base64String);
			switch (mimeType) {
				case "application/pdf":
					fileExtension = ".pdf";
					break;
				case "image/png":
					fileExtension = ".png";
					break;
				case "image/jpg":
					fileExtension = ".jpg";
					break;
				case "image/jpeg":
					fileExtension = ".jpeg";
					break;
			}
		}
		return fileExtension;
	}

	public Iterable<Object> getUploadTimesAllFiles (Integer registrationId){
		return legalFilesRepository.findUploadedTimeByRegistrationId(registrationId);
	}
}
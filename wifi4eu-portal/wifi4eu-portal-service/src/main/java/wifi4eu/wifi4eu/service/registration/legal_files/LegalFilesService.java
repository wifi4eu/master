package wifi4eu.wifi4eu.service.registration.legal_files;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;
import wifi4eu.wifi4eu.common.dto.model.*;
import wifi4eu.wifi4eu.common.dto.rest.ResponseDTO;
import wifi4eu.wifi4eu.common.ecas.UserHolder;
import wifi4eu.wifi4eu.common.security.UserContext;
import wifi4eu.wifi4eu.common.utils.RequestIpRetriever;
import wifi4eu.wifi4eu.entity.registration.LegalFile;
import wifi4eu.wifi4eu.entity.registration.RegistrationUsers;
import wifi4eu.wifi4eu.mapper.registration.legal_files.*;
import wifi4eu.wifi4eu.repository.registration.RegistrationUsersRepository;
import wifi4eu.wifi4eu.repository.registration.legal_files.*;
import wifi4eu.wifi4eu.service.registration.RegistrationService;
import wifi4eu.wifi4eu.service.user.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("legalFilesService")
public class LegalFilesService {

	private final Logger _log = LogManager.getLogger(LegalFilesService.class);

	@Autowired
	LegalFilesRepository legalFilesRepository;

	@Autowired
	LegalFilesMapper legalFilesMapper;

	@Autowired
	RegistrationService registrationService;

	@Autowired
    UserService userService;


	/**
	 * Checks if the user has permission to modify the legal file requested.
	 *
	 * @param registrationId
	 * @param userId
	 * @param legalFile
	 * @return true if user has permission to access to the legal file
	 */
	public boolean hasUserPermissionForLegalFile (Integer registrationId, Integer userId, Integer legalFile){
		if(registrationService.checkUserWithRegistration(registrationId, userId)){
			if(legalFile != null && legalFilesRepository.findByIdAndUserId(legalFile, userId) != null){
				return true;
			}
		}
		return false;
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

}
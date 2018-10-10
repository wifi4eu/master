package wifi4eu.wifi4eu.service.grantAgreement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.common.dto.model.ApplicationDTO;
import wifi4eu.wifi4eu.common.dto.model.GrantAgreementDTO;
import wifi4eu.wifi4eu.common.helper.Validator;
import wifi4eu.wifi4eu.common.service.azureblobstorage.AzureBlobConnector;
import wifi4eu.wifi4eu.entity.grantAgreement.GrantAgreement;
import wifi4eu.wifi4eu.common.mapper.grantAgreement.GrantAgreementMapper;
import wifi4eu.wifi4eu.repository.grantAgreement.GrantAgreementRepository;
import wifi4eu.wifi4eu.service.application.ApplicationService;

import java.util.List;

@Service
public class GrantAgreementService {

    @Autowired
    private AzureBlobConnector azureBlobConnector;

    @Autowired
    private GrantAgreementRepository agreementRepository;

    @Autowired
    private GrantAgreementMapper grantAgreementMapper;

    @Autowired
    private ApplicationService applicationService;

    public GrantAgreementDTO getGrantAgreementByApplicationId(Integer applicationId) {
        //TODO fix as the db allows more than on grant agreement
        List<GrantAgreement> grantAgreementList = agreementRepository.findByApplicationId(applicationId);
        if (grantAgreementList == null) {
            return null;
        }
        return grantAgreementMapper.toDTO(grantAgreementList.get(0));
    }

    public GrantAgreementDTO getGrantAgreementByCallAndRegistrationId(Integer registrationId, Integer callId) {
        ApplicationDTO applicationDTO = applicationService.getApplicationByCallIdAndRegistrationId(callId, registrationId);
        return getGrantAgreementByApplicationId(applicationDTO.getId());
    }

    public byte[] downloadGrantAgreementSigned(GrantAgreementDTO grantAgreementDTO) {
        byte[] fileBytes = null;
        try {
            if(Validator.isNotNull(grantAgreementDTO)){
                if(Validator.isNotNull(grantAgreementDTO.getDocumentLocationCounterSigned())){
                    fileBytes = azureBlobConnector.downloadGrantAgreementSigned(grantAgreementDTO.getDocumentLocationCounterSigned());
                }
                else if(Validator.isNotNull(grantAgreementDTO.getDocumentLanguage())){
                    fileBytes = azureBlobConnector.downloadGrantAgreementSigned(grantAgreementDTO.getDocumentLocation());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }

}


package wifi4eu.wifi4eu.abac.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.AbacWorkflowStatus;
import wifi4eu.wifi4eu.abac.data.enums.DocumentType;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;
import wifi4eu.wifi4eu.abac.utils.XCharacterDecoder;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

import javax.transaction.Transactional;

@Service
public class LegalEntityService {

	public static final int ABAC_NAME_MAX_CHARS = 35;
	private final Logger log = LoggerFactory.getLogger(LegalEntityService.class);

	@Autowired
	private LegalEntityRepository legalEntityRepository;

	@Autowired
	private LegalEntityCSVFileParser legalEntityCSVFileParser;

	@Autowired
	private CountryService countryService;

	public LegalEntityService() {
	}

	public LegalEntity getLegalEntityByMunicipalityPortalId(Long mid) {
		return legalEntityRepository.findByMid(mid);
	}

	public LegalEntity saveLegalEntity(LegalEntity legalEntity) {
		//clean-up the name sent to ABAC
		if(StringUtils.isEmpty(legalEntity.getAbacLatinName())){
			legalEntity.setAbacLatinName(StringUtils.abbreviate(XCharacterDecoder.decode(legalEntity.getOfficialName()), ABAC_NAME_MAX_CHARS));
		}else{
			legalEntity.setAbacLatinName(StringUtils.abbreviate(legalEntity.getAbacLatinName(),ABAC_NAME_MAX_CHARS));
		}

		//clean-up the address sent to ABAC
		legalEntity.setAbacLatinAddress(XCharacterDecoder.decode(legalEntity.getOfficialAddress()));

		//save Municipality
		return legalEntityRepository.save(legalEntity);
	}

	public LegalEntity mapLegalEntityCSVToEntity(LegalEntityInformationCSVRow legalEntityInformationCSVRow) {
		LegalEntity legalEntity = new LegalEntity();

		legalEntity.setMid(legalEntityInformationCSVRow.getMid());
		legalEntity.setOfficialName(legalEntityInformationCSVRow.getOfficialName());
		legalEntity.setAbacLatinName(legalEntityInformationCSVRow.getAbacLatinName());
		legalEntity.setOfficialAddress(legalEntityInformationCSVRow.getOfficialAddress());
		legalEntity.setPostalCode(legalEntityInformationCSVRow.getPostalCode());
		legalEntity.setCity(legalEntityInformationCSVRow.getCity());
		legalEntity.setLanguageCode(legalEntityInformationCSVRow.getLanguageCode());
		legalEntity.setRegistrationNumber(legalEntityInformationCSVRow.getRegistrationNumber());
		legalEntity.setAbacFelId(legalEntityInformationCSVRow.getAbacReference());
		legalEntity.setCallNumber(legalEntityInformationCSVRow.getCallNumber());

		Country country = countryService.getCountryByISOCode(legalEntityInformationCSVRow.getCountryCode());
		legalEntity.setCountry(country);

		return legalEntity;
	}

	public Boolean isBatchProcessed(String batchRef){
		List<AbacWorkflowStatus> finishedStatuses = new ArrayList<>();
		finishedStatuses.add(AbacWorkflowStatus.ABAC_VALID);
		finishedStatuses.add(AbacWorkflowStatus.ABAC_REJECTED);
		finishedStatuses.add(AbacWorkflowStatus.ABAC_ERROR);
		finishedStatuses.add(AbacWorkflowStatus.ABAC_FINISH);

		Long pending = legalEntityRepository.countAllByWfStatusNotInAndBatchRefEquals(finishedStatuses, batchRef);

		return pending.equals(0L);
	}

	@Transactional
	public void checkLegalEntityReadyForAbac(){
		List<LegalEntity> legalEntitiesWaitingForAres = legalEntityRepository.findAllByWfStatusIn(Arrays.asList(AbacWorkflowStatus.IMPORTED, AbacWorkflowStatus.WAITING_FOR_ARES));
		//check if there is a AREs reference present and is true than the LE is ready to be submitted to ABAC
		for(LegalEntity legalEntity:legalEntitiesWaitingForAres){
			if(!legalEntity.getDocumentsStoredInAres(DocumentType.IDENTIFICATION_FORM).isEmpty()){
				legalEntity.setWfStatus(AbacWorkflowStatus.READY_FOR_ABAC);
				legalEntityRepository.save(legalEntity);
			}else{
                legalEntity.setWfStatus(AbacWorkflowStatus.WAITING_FOR_ARES);
                legalEntityRepository.save(legalEntity);
            }
		}
	}

	public List<LegalEntity> getAllByBatchRef(String batchRef){
        return legalEntityRepository.findAllByBatchRefEquals(batchRef);
    }

	public List<LegalEntity> getLegalEntitiesProcessedInAbac() {
		return legalEntityRepository.findLegalEntitiesProcessedInAbac();
	}
}

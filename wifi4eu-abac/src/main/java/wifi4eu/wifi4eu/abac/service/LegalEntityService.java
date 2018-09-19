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

	//TODO This should be refactored to use javax validation.
	private void validate(LegalEntity legalEntity) {
		if (legalEntity.getMid() == null) throw new RuntimeException("Municipality ID is empty");
		if (StringUtils.isEmpty(legalEntity.getOfficialName())) throw new RuntimeException("Official Name is empty");
		if (StringUtils.isEmpty(legalEntity.getOfficialAddress())) throw new RuntimeException("Official Address is empty");
		if (legalEntity.getRegistrationNumber() == null) throw new RuntimeException("Registration Number is empty");
		if (legalEntity.getCountry() == null) throw new RuntimeException("Country is empty or invalid");
		if (legalEntity.getCallNumber() == null) throw new RuntimeException("Call Number is empty");
		if (legalEntity.getPostalCode() != null && legalEntity.getPostalCode().length() > 10) throw new RuntimeException("Postal code should be up to 10 digits");
	}

	public LegalEntity getLegalEntityByMunicipalityPortalIdOrOfficialNameIgnoreCase(Long mid, String officialName) {
		return legalEntityRepository.findByMidOrOfficialNameIgnoreCase(mid, officialName);
	}

	public LegalEntity saveLegalEntity(LegalEntity legalEntity) {

		validate(legalEntity);

		//clean-up the name sent to ABAC
		if(StringUtils.isEmpty(legalEntity.getAbacLatinName())){
			legalEntity.setAbacLatinName(XCharacterDecoder.decode(legalEntity.getOfficialName()));
		}else{
			legalEntity.setAbacLatinName(legalEntity.getAbacLatinName());
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

	public List<LegalEntity> getAllLegalEntitiesForExport() {
		return legalEntityRepository.findLegalEntitiesProcessedInAbac();
	}

	public LegalEntity getLegalEntityByMunicipalityPortalId(Long municipalityPortalId) {
		return legalEntityRepository.findByMid(municipalityPortalId);
	}
}

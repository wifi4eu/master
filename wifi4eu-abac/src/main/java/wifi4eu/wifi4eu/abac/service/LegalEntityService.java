package wifi4eu.wifi4eu.abac.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.Country;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

@Service
public class LegalEntityService {

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
		return legalEntityRepository.save(legalEntity);
	}

	public String exportLegalEntityFile() {
		log.info("exportLegalEntityFile");
		List<LegalEntity> legalEntities = legalEntityRepository.findLegalEntitiesProcessedInAbac();
		String csvFile = legalEntityCSVFileParser.exportLegalEntitiesToCSV(legalEntities);
		return csvFile;
	}

	public LegalEntity mapLegalEntityCSVToEntity(LegalEntityInformationCSVRow legalEntityInformationCSVRow) {
		LegalEntity legalEntity = new LegalEntity();

		legalEntity.setMid(legalEntityInformationCSVRow.getMid());
		legalEntity.setOfficialName(legalEntityInformationCSVRow.getOfficialName());
		legalEntity.setOfficialAddress(legalEntityInformationCSVRow.getOfficialAddress());
		legalEntity.setPostalCode(legalEntityInformationCSVRow.getPostalCode());
		legalEntity.setCity(legalEntityInformationCSVRow.getCity());
		legalEntity.setLanguageCode(legalEntityInformationCSVRow.getLanguageCode());
		legalEntity.setRegistrationNumber(legalEntityInformationCSVRow.getRegistrationNumber());
		legalEntity.setAbacFelId(legalEntityInformationCSVRow.getAbacReference());

		Country country = countryService.getCountryByISOCode(legalEntityInformationCSVRow.getCountryCode());
		legalEntity.setCountry(country);

		return legalEntity;
	}
}

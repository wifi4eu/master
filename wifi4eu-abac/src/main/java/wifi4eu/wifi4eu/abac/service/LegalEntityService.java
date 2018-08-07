package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.dto.LegalEntityInformationCSVRow;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.enums.LegalEntityImportCSVColumn;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;
import wifi4eu.wifi4eu.abac.utils.csvparser.AbstractCSVFileParser;
import wifi4eu.wifi4eu.abac.utils.csvparser.LegalEntityCSVFileParser;

import java.util.List;

@Service
public class LegalEntityService {

	private final Logger log = LoggerFactory.getLogger(LegalEntityService.class);

	@Autowired
	private LegalEntityRepository legalEntityRepository;

	@Autowired
	private LegalEntityCSVFileParser legalEntityCSVFileParser;

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

		log.info("recovering list of items");
		List<LegalEntity> legalEntities = legalEntityRepository.findLegalEntitiesProcessedInAbac();

		log.info("parsing list of items");
		String csvFile = legalEntityCSVFileParser.exportLegalEntitiesToCSV(legalEntities);
		return csvFile;
	}

	public LegalEntity mapLegalEntityCSVToEntity(LegalEntityInformationCSVRow legalEntityInformationCSVRow) {
		LegalEntity legalEntity = new LegalEntity();

		legalEntityInformationCSVRow.setMid(legalEntityInformationCSVRow.getMid());
		legalEntityInformationCSVRow.setOfficialName(legalEntityInformationCSVRow.getOfficialName());
		legalEntityInformationCSVRow.setOfficialAddress(legalEntityInformationCSVRow.getOfficialAddress());
		legalEntityInformationCSVRow.setPostalCode(legalEntityInformationCSVRow.getPostalCode());
		legalEntityInformationCSVRow.setCity(legalEntityInformationCSVRow.getCity());
		legalEntityInformationCSVRow.setCountryCode(legalEntityInformationCSVRow.getCountryCode());
		legalEntityInformationCSVRow.setLanguageCode(legalEntityInformationCSVRow.getLanguageCode());
		legalEntityInformationCSVRow.setRegistrationNumber(legalEntityInformationCSVRow.getRegistrationNumber());

		return legalEntity;
	}
}

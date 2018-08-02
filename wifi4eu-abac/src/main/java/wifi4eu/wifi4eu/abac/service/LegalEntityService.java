package wifi4eu.wifi4eu.abac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wifi4eu.wifi4eu.abac.data.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.data.repository.LegalEntityRepository;
import wifi4eu.wifi4eu.abac.utils.CSVFileParser;

import java.util.List;

@Service
public class LegalEntityService {

	private final Logger log = LoggerFactory.getLogger(LegalEntityService.class);

	@Autowired
	private LegalEntityRepository legalEntityRepository;

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
		CSVFileParser csvFileParser = new CSVFileParser();
		String csvFile = csvFileParser.exportLegalEntitiesToCSV(legalEntities);
		return csvFile;
	}
}

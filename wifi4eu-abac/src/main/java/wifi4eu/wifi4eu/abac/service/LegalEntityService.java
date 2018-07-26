package wifi4eu.wifi4eu.abac.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import wifi4eu.wifi4eu.abac.entity.AbacLefStatus;
import wifi4eu.wifi4eu.abac.entity.AbacRequest;
import wifi4eu.wifi4eu.abac.entity.Document;
import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.repository.AbacRequestRepository;
import wifi4eu.wifi4eu.abac.repository.AbacStatusRepository;
import wifi4eu.wifi4eu.abac.repository.DocumentRepository;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;
import wifi4eu.wifi4eu.abac.utils.ParserCSV2Entity;

@Service
public class LegalEntityService {

	private static int FIRST_PAGE = 0;

	private final Logger log = LoggerFactory.getLogger(LegalEntityService.class);

	@Autowired
	private LegalEntityRepository legalEntityRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Autowired
	private AbacIntegrationService abacIntegrationService;

	@Autowired
	AbacRequestRepository abacRequestRepository;

	@Autowired
	AbacStatusRepository abacStatusRepository;

	public LegalEntityService() {
	}

	// @ Transactional
	public void importLegalEntityFile(MultipartFile file) throws IOException {
		log.info("importLegalEntityFile");

		byte[] contentBytes = file.getBytes();

		log.info("recovering list of items");
		ParserCSV2Entity<LegalEntity> parser = new ParserCSV2Entity();
		List<LegalEntity> items = parser.parseCSV2Entity(contentBytes, LegalEntity.class);

		log.info("printing list of items");
		for (LegalEntity legalEntity : items) {
			// TODO jlopezri temporal assigment of a sample file
			//Document sampleDocument = documentRepository.findById(Long.valueOf(0)).get();
			//legalEntity.setSignatureFile(sampleDocument);
			//log.info("Using sample document: " + sampleDocument.getId() + ":" + sampleDocument.getName());
			//documentRepository.save(sampleDocument);
			legalEntity.getAbacRequestList().clear();			
			log.info("Item recovered: " + legalEntity.toString());
			legalEntityRepository.save(legalEntity);
		}

		log.info("storing list of items");
	}

	// @ Transactional
	public void importLegalEntityContent(String content) throws IOException {
		log.info("importLegalEntityContent");

		byte[] contentBytes = content.getBytes();

		log.info("recovering list of items");
		ParserCSV2Entity<LegalEntity> parser = new ParserCSV2Entity();
		List<LegalEntity> items = parser.parseCSV2Entity(contentBytes, LegalEntity.class);

		log.info("printing list of items");
		for (LegalEntity legalEntity : items) {
			log.info("Item recovered: " + legalEntity.toString());
			// Override status
			legalEntity.setWfStatus(AbacWorkflowStatusEnum.READY_FOR_ABAC);
			legalEntityRepository.save(legalEntity);
		}

		log.info("storing list of items");
	}

	public String showLegalEntityFile() {
		log.info("showLegalEntityFile");

		log.info("recovering list of items");
		Iterable<LegalEntity> list = legalEntityRepository.findAll();

		log.info("parsing list of items");
		StringBuilder data = new StringBuilder();

		boolean first = true;
		data.append("<table style=\"width:100%\" border=\"1\">");
		data.append("<tr>");

		// headers
		String headers[] = new String[] { "id", "mid", "officialName", "region", "languageCode", "countryCode",
				"officialAddress", "officialAddressStrNo", "postalCode", "abacFelId", "wfStatus", "dateCreated" };
		for (String header : headers) {
			data.append("<th>").append(header).append("</th>");
		}
		data.append("\r\n");

		// data
		for (LegalEntity legalEntity : list) {
			data.append("</tr><tr>\r\n");
			data.append("<td>").append(legalEntity.getId()).append("</td>");
			data.append("<td>").append(legalEntity.getMid()).append("</td>");
			data.append("<td>").append(legalEntity.getOfficialName()).append("</td>");
			data.append("<td>").append(legalEntity.getCity()).append("</td>");
			data.append("<td>").append(legalEntity.getLanguageCode()).append("</td>");
			data.append("<td>").append(legalEntity.getCountryCode()).append("</td>");
			data.append("<td>").append(legalEntity.getOfficialAddress()).append("</td>");
			data.append("<td>").append(legalEntity.getPostalCode()).append("</td>");
			data.append("<td>").append(legalEntity.getAbacFelId()).append("</td>");
			data.append("<td>").append(legalEntity.getWfStatus()).append("</td>");
			data.append("<td>").append(legalEntity.getDateCreated()).append("</td>");
		}
		data.append("</tr>");
		data.append("</table>");

		return data.toString();
	}

	public String exportLegalEntityFile() {
		log.info("exportLegalEntityFile");

		log.info("recovering list of items");
		List<LegalEntity> list = legalEntityRepository.findLegalEntitiesProcessedInAbac();

		log.info("parsing list of items");
		String data = parseLegalEntity2String(list);
		// log.info("data: " + data);

		return data;
	}

	/**
	 * Send the legal entities with status READY_FOR_ABAC, limited to a maximum
	 * of @maxRecords
	 * 
	 * @param maxRecords
	 */
	public void findAndSendLegalEntitiesReadyToABAC(Integer maxRecords) {
		Pageable pageable = PageRequest.of(FIRST_PAGE, maxRecords);
		List<LegalEntity> legalEntities = legalEntityRepository
				.findByWfStatusOrderByDateCreated(AbacWorkflowStatusEnum.READY_FOR_ABAC, pageable);

		if (!legalEntities.isEmpty()) {
			log.info(String.format("Found %s legal entities ready to be sent to ABAC...", legalEntities.size()));
		}

		for (LegalEntity legalEntity : legalEntities) {
			sendLegalEntityToABAC(legalEntity);
		}
	}

	private void sendLegalEntityToABAC(LegalEntity legalEntity) {
		// Requet the creation of the legal entity in ABAC
		abacIntegrationService.createLegalEntityInAbac(legalEntity);
	}

	@Transactional(Transactional.TxType.REQUIRES_NEW)
	public void updateLegalEntityCreationStatus(List<AbacLefStatus> abacLefStatuses) {

		for (AbacLefStatus abacLefStatus : abacLefStatuses) {
			AbacRequest abacRequest = abacRequestRepository.findByLocObjForeignId(abacLefStatus.getLocObjForeignId());

			if (!abacLefStatus.getStatus().equals(abacRequest.getLegalEntity().getWfStatus())) {
				abacRequest.getLegalEntity().setWfStatus(abacLefStatus.getStatus());
				abacRequest.getLegalEntity().setAbacFelId(abacLefStatus.getLegalEntityKey());
				legalEntityRepository.save(abacRequest.getLegalEntity());
			}
		}
	}

	/**
	 * NOTE: temporal workaround, should be defined in a generic parser or a mapper
	 */
	private String parseLegalEntity2String(List<LegalEntity> list) {
		String separator = "|";
		String headers[] = new String[] { "id", "mid", "officialName", "abacFelId", "wfStatus" };
		StringBuilder data = new StringBuilder();

		// headers
		boolean first = true;
		for (String header : headers) {
			if (first) {
				data.append(header);
				first = false;
			} else {
				data.append(separator).append(header);
			}
		}
		data.append("\r\n");

		// data
		if (list != null && !list.isEmpty()) {
			for (LegalEntity legalEntity : list) {
				data.append(legalEntity.getId()).append(separator).append(legalEntity.getMid()).append(separator)
						.append(legalEntity.getOfficialName()).append(separator).append(legalEntity.getAbacFelId())
						.append(separator).append(legalEntity.getWfStatus()).append("\r\n");
			}
		}
		data.append("\r\n");

		return data.toString();
	}

	public void updateLegalEntitiesStatuses() {
		legalEntityRepository.updateFinancialLegalEntitiesStatuses();
	}
}

package wifi4eu.wifi4eu.abac.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.repository.LegalEntityRepository;
import wifi4eu.wifi4eu.abac.utils.ParserCSV2Entity;

@Service
public class LegalEntityService {

	private final Logger log = LoggerFactory.getLogger(LegalEntityService.class);

	private LegalEntityRepository legalEntityrepository;

	@Autowired
	public LegalEntityService(LegalEntityRepository legalEntityrepository) {
		this.legalEntityrepository = legalEntityrepository;
	}

	// @ Transactional
	public void importLegalEntityFile(MultipartFile file) throws IOException {
		log.info("importLegalEntityFile");

		byte[] contentBytes = file.getBytes();

		// TODO do stuff
		log.info("recovering list of items");
		ParserCSV2Entity<LegalEntity> parser = new ParserCSV2Entity();
		List<LegalEntity> items = parser.parseCSV2Entity(contentBytes, LegalEntity.class);

		log.info("printing list of items");
		for (LegalEntity legalEntity : items) {
			log.info("Item recovered: " + legalEntity.toString());
			// legalEntityrepository.save(legalEntity);
		}

		log.info("storing list of items");
		// TODO

	}

	public String exportLegalEntityFile() {
		log.info("exportLegalEntityFile");

		log.info("recovering list of items");
		List<LegalEntity> list = legalEntityrepository.findLegalEntitiesWithIdAbac();

		log.info("parsing list of items");
		// TODO do stuff
		// String data = "id|name|idAbac|status\r\n" + "1,Buje,ABAC-CODE-1,0\r\n" +
		// "2,Frontignan,ABAC-CODE-2,0\r\n" + "3,Oleiros,ABAC-CODE-3,0\r\n" +
		// "4,Madrid,ABAC-CODE-4,0\r\n";
		String data = parseLegalEntity2String(list);
		log.info("data: " + data);

		return data;
	}

	/**
	 * NOTE: temporal workaround, should be defined in a generic parser or a mapper
	 */
	private String parseLegalEntity2String(List<LegalEntity> list) {
		String separator = "|";
		String headers[] = new String[] { "id", "name", "idAbac", "status" };
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
				data.append(legalEntity.getId()).append(separator).append(legalEntity.getName()).append(separator)
						.append(legalEntity.getIdAbac()).append(separator).append(legalEntity.getStatus())
						.append("\r\n");
			}
		}

		return data.toString();
	}

}

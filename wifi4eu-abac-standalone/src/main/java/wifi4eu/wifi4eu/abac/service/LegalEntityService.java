package wifi4eu.wifi4eu.abac.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import wifi4eu.wifi4eu.abac.entity.LegalEntity;
import wifi4eu.wifi4eu.abac.utils.ParserCSV2Entity;

@Service
public class LegalEntityService {

	private final Logger log = LoggerFactory.getLogger(LegalEntityService.class);

	// @ Transactional
	public void importLegalEntityFile(MultipartFile file) throws IOException {
		log.info("importLegalEntityFile");

		byte[] contentBytes = file.getBytes();

		// TODO do stuff
		log.info("recovering list of items");
		ParserCSV2Entity<LegalEntity> parser =  new ParserCSV2Entity();
		List<LegalEntity> items = parser.parseCSV2Entity(contentBytes, LegalEntity.class);
		
		log.info("printing list of items");
		for (LegalEntity legalEntity : items) {
			log.info("Item recovered: " + legalEntity.toString());
		}
		
		log.info("storing list of items");
		// TODO
		
	}

	public String exportLegalEntityFile() {
		log.info("exportLegalEntityFile");
		
		// TODO do stuff
		String data = "idWifi4eu,name,idAbac,status\r\n"
				+ "1,Buje,ABAC-CODE-1,0\r\n"
				+ "2,Frontignan,ABAC-CODE-2,0\r\n"
				+ "3,Oleiros,ABAC-CODE-3,0\r\n"
				+ "4,Madrid,ABAC-CODE-4,0\r\n";

		return data;
	}

}

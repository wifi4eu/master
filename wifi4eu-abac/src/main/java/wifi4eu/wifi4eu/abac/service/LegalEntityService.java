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

		log.info("recovering list of items");
		ParserCSV2Entity<LegalEntity> parser = new ParserCSV2Entity();
		List<LegalEntity> items = parser.parseCSV2Entity(contentBytes, LegalEntity.class);

		log.info("printing list of items");
		for (LegalEntity legalEntity : items) {
			log.info("Item recovered: " + legalEntity.toString());
			legalEntityrepository.save(legalEntity);
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
			legalEntityrepository.save(legalEntity);
		}

		log.info("storing list of items");
	}

	public String showLegalEntityFile() {
		log.info("showLegalEntityFile");

		log.info("recovering list of items");
		Iterable<LegalEntity> list = legalEntityrepository.findAll();

		log.info("parsing list of items");
		StringBuilder data = new StringBuilder();

		boolean first = true;
		data.append("<table style=\"width:100%\" border=\"1\">\r\n");
		data.append("<tr>\r\n");

		// headers
		String headers[] = new String[] { "id", "name", "lang", "region", "country", "code", "address", "nr",
				"postalCode", "idAbac", "status" };
		for (String header : headers) {
			data.append("<th>").append(header).append("</th>\r\n");
		}

		// data
		for (LegalEntity legalEntity : list) {
			data.append("</tr><tr>\r\n");
			data.append("<td>").append(legalEntity.getId()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getName()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getLang()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getRegion()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getCountry()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getCode()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getAddress()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getNr()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getPostalCode()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getIdAbac()).append("</td>\r\n");
			data.append("<td>").append(legalEntity.getStatus()).append("</td>\r\n");
		}
		data.append("</tr>\r\n");
		data.append("</table>\r\n");

		return data.toString();
	}

	public String exportLegalEntityFile() {
		log.info("exportLegalEntityFile");

		log.info("recovering list of items");
		List<LegalEntity> list = legalEntityrepository.findLegalEntitiesWithIdAbac();

		log.info("parsing list of items");
		String data = parseLegalEntity2String(list);
		// log.info("data: " + data);

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

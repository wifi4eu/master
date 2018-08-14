package wifi4eu.wifi4eu.abac.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.repository.LegalCommitmentRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class LegalCommitmentService {

	private final Logger log = LoggerFactory.getLogger(LegalCommitmentService.class);

	private LegalCommitmentRepository legalCommitmentyRepository;

	@Autowired
	public LegalCommitmentService(LegalCommitmentRepository legalCommitmentyRepository) {
		this.legalCommitmentyRepository = legalCommitmentyRepository;
	}

	// @ Transactional
	public void importLegalCommitmentContent(String content) throws IOException {
		log.info("importLegalCommitmentContent");

		// TODO jlopezri pending implementation

		log.info("importLegalCommitmentContent - finished");
	}
}

package wifi4eu.wifi4eu.abac.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wifi4eu.wifi4eu.abac.data.repository.BudgetaryCommitmentRepository;
import wifi4eu.wifi4eu.abac.data.repository.LegalCommitmentRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import wifi4eu.wifi4eu.abac.data.entity.BudgetaryCommitment;
import wifi4eu.wifi4eu.abac.data.entity.ExportFile;
import wifi4eu.wifi4eu.abac.data.entity.LegalCommitment;

@Service
public class LegalCommitmentService {

	private final Logger log = LoggerFactory.getLogger(LegalCommitmentService.class);
	
	@Autowired
	private LegalCommitmentRepository legalCommitmentyRepository;
	
	public LegalCommitment getByMunicipalityPortalId(Long municipalityPortalId) {
		return legalCommitmentyRepository.findByLegalEntityMid(municipalityPortalId);
	}

	public ExportFile exportLegalCommitmentContent(String filenameOutput) {
		log.info("exportLegalCommitmentContent");

		// TODO jlopezri sample files to create
		int maxFiles = 10;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try (ZipOutputStream zos = new ZipOutputStream(baos)) {
			// TODO jlopezri here the countersigned document should be recovered, since it
			byte[] sampleCSV = generateCSVFile();
			ZipEntry csvEntry = new ZipEntry(filenameOutput + ".csv");
			zos.putNextEntry(csvEntry);
			zos.write(sampleCSV);
			zos.closeEntry();

			for (int i = 0; i < maxFiles; i++) {
				// TODO jlopezri here the countersigned document should be recovered, since it
				// doesn't exist, it is mocked with a dummy PDF file
				String sampleName = "countersignedFile" + (i+1);
				byte[] sampleData = generatePDFFile(i+1);

				ZipEntry pdfEntry = new ZipEntry(sampleName + ".pdf");
				zos.putNextEntry(pdfEntry);
				zos.write(sampleData);
				zos.closeEntry();
			}			
		} catch (IOException ex) {
			log.error("Could not generate a zip file for export");
		} catch (DocumentException ex) {
			log.error("Could not generate PDF file");
		}

		ExportFile file = new ExportFile();
		file.setFilename(filenameOutput + ".zip");
		file.setMimetype("application/zip");
		file.setData(baos.toByteArray());

		log.info("exportLegalCommitmentContent - finished");
		return file;
	}

	/**
	 * Generates a dummy CSV file.
	 * 
	 * @param fileNumber
	 * @return
	 * @throws DocumentException
	 */
	private byte[] generateCSVFile() throws DocumentException {
		String sample = "sep=|\r\n" + "id|mun_OfficialName|mun_OfficialAddress|reg_RegistrationNumber\r\n"
				+ "1|Barcelona|C\\Aragón,6\r\n" + "2|Barcelona|C\\Aragón,7\r\n" + "3|Madrid|C\\Bravo Murillo,8";

		return sample.getBytes();
	}

	/**
	 * Generates a dummy PDF file.
	 * 
	 * @param fileNumber
	 * @return
	 * @throws DocumentException
	 */
	private byte[] generatePDFFile(int fileNumber) throws DocumentException {
		Document document = new Document();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, outputStream);
		document.open();
		String docName = "PDF Document" + fileNumber;
		document.addTitle(docName);
		document.addSubject(docName);
		document.add(new Paragraph(docName));
		document.close();

		return outputStream.toByteArray();
	}

}

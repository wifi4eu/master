package wifi4eu.wifi4eu.abac.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipFileWriter {

	private final Logger log = LoggerFactory.getLogger(ZipFileWriter.class);

	private ByteArrayOutputStream byteOutputStream;
	private ZipOutputStream zipOutputStream;

	private String zipFileName;

	public ZipFileWriter(String zipFilename) {
		this.zipFileName = zipFilename;
		byteOutputStream = new ByteArrayOutputStream();
		zipOutputStream = new ZipOutputStream(byteOutputStream);
	}

	public void addFile(FileDTO fileDTO) throws IOException {
		log.info("Adding file {} to zip", fileDTO.getFileName());
		ZipEntry zipEntry = new ZipEntry(fileDTO.getFileName());
		zipOutputStream.putNextEntry(zipEntry);
		zipOutputStream.write(fileDTO.getContent(), 0, fileDTO.getContent().length);
		zipOutputStream.closeEntry();
	}

	public FileDTO finishAndReturnZipfile() throws IOException {
		FileDTO fileDTO = new FileDTO();

		zipOutputStream.finish();
		fileDTO.setFileName(this.zipFileName);
		fileDTO.setContent(byteOutputStream.toByteArray());
		fileDTO.setSize(new Long(fileDTO.getContent().length));
		byteOutputStream.close();
		zipOutputStream.close();

		return fileDTO;
	}
}

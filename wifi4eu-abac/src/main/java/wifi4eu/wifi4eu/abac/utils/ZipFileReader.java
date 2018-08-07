package wifi4eu.wifi4eu.abac.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wifi4eu.wifi4eu.abac.data.dto.FileDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileReader {

	private final Logger log = LoggerFactory.getLogger(ZipFileReader.class);

	private ZipInputStream zipInputStream;

	public ZipFileReader(byte[] file) {
		ByteArrayInputStream fileInputStream = new ByteArrayInputStream(file);
		zipInputStream = new ZipInputStream(fileInputStream);
	}

	public FileDTO nextFile() {

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		try {
			ZipEntry zipEntry = zipInputStream.getNextEntry();
			if (zipEntry != null) {
				int len;
				byte[] buffer = new byte[1024];
				while ((len = zipInputStream.read(buffer)) > 0) outputStream.write(buffer, 0, len);
				byte[] bytes = outputStream.toByteArray();
				outputStream.close();
				return new FileDTO(zipEntry.getName(), zipEntry.getSize(), bytes);

			} else {
				zipInputStream.closeEntry();
				zipInputStream.close();
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

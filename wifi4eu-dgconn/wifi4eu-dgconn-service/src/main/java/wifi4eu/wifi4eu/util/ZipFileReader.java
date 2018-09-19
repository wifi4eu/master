package wifi4eu.wifi4eu.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.FileTime;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipFileReader implements AutoCloseable {

    private static final int BUFFER_SIZE = 2048;

    private final ZipInputStream zipInputStream;

    public ZipFileReader(InputStream zipFileInputStream) {
        zipInputStream = new ZipInputStream(zipFileInputStream);
    }

    public ZipFileEntry nextEntry() throws IOException {

        ZipFileEntry zipFileEntry = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ZipEntry zipEntry = zipInputStream.getNextEntry();
        if (zipEntry != null) {
            int bytesRead;
            byte[] buffer = new byte[BUFFER_SIZE];
            while ((bytesRead = zipInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            zipFileEntry = new ZipFileEntry(zipEntry.getName(), outputStream.toByteArray(), zipEntry.getLastModifiedTime());
        }

        return zipFileEntry;
    }

    public void close() throws IOException {
        zipInputStream.close();
    }

    public static final class ZipFileEntry {

        private String name;

        private byte[] content;

        private FileTime lastModifiedTime;

        public ZipFileEntry(String name, byte[] content, FileTime lastModifiedTime) {
            this.name = name;
            this.content = content;
            this.lastModifiedTime = lastModifiedTime;
        }

        public String getName() {
            return name;
        }

        public FileTime getLastModifiedTime() {
            return lastModifiedTime;
        }

        public byte[] getContent() {
            return content;
        }

    }
}
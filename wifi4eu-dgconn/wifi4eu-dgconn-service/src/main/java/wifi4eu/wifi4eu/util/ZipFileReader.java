package wifi4eu.wifi4eu.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
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
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        if (zipEntry != null) {
            zipFileEntry = readData(zipEntry);
        }
        zipInputStream.closeEntry();

        return zipFileEntry;
    }

    public ZipFileEntry getFileEntry(String name) throws IOException {
        Objects.requireNonNull(name);

        ZipFileEntry zipFileEntry = null;
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            if (zipEntry.getName().equals(name)) {
                zipFileEntry = readData(zipEntry);
                zipInputStream.closeEntry();
                break;
            }
            zipInputStream.closeEntry();
        }

        return zipFileEntry;
    }

    public void close() throws IOException {
        zipInputStream.close();
    }

    private ZipFileEntry readData(ZipEntry zipEntry) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int bytesRead;
        byte[] buffer = new byte[BUFFER_SIZE];
        while ((bytesRead = zipInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return new ZipFileEntry(zipEntry.getName(), outputStream.toByteArray(), zipEntry.getLastModifiedTime());
    }

    public static final class ZipFileEntry {

        private String name;

        private byte[] content;

        private FileTime lastModifiedTime;

        ZipFileEntry(String name, byte[] content, FileTime lastModifiedTime) {
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
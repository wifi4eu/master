package wifi4eu.wifi4eu.service.exportImport;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface ExportImportAbacService {

    boolean importLegalEntitiesFromAbac(InputStream fileDataStream) throws IOException;

    ByteArrayOutputStream exportLegalEntities() throws IOException;

    @Deprecated
    void exportRegistrationData() throws Exception;

    boolean importDgBudgList(InputStream inputStream) throws Exception;

    byte[] exportBudgetaryCommitment() throws IOException;

    boolean importBudgetaryCommitment(InputStream fileDataStream) throws IOException;

    boolean importLegalCommitment(InputStream inputStream) throws IOException;

    ByteArrayOutputStream exportLegalCommitment() throws IOException;

}

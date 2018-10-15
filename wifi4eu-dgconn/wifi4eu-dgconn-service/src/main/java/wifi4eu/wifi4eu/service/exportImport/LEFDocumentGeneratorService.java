package wifi4eu.wifi4eu.service.exportImport;

import wifi4eu.wifi4eu.entity.municipality.Municipality;

import java.io.OutputStream;

public interface LEFDocumentGeneratorService {

    OutputStream generateLefPdf(Municipality municipality, OutputStream os);
}

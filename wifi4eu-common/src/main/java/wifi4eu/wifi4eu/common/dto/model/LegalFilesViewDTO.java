package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;
import java.util.List;

public class LegalFilesViewDTO implements Serializable {

    private List<LegalFileDTO> arrayOfFiles;

    public LegalFilesViewDTO(){

    }

    public LegalFilesViewDTO(List<LegalFileDTO> arrayOfFiles) {
        this.arrayOfFiles = arrayOfFiles;
    }

    public List<LegalFileDTO> getArrayOfFiles() {
        return arrayOfFiles;
    }

    public void setArrayOfFiles(List<LegalFileDTO> arrayOfFiles) {
        this.arrayOfFiles = arrayOfFiles;
    }
}

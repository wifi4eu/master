package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

/**
 * Created by rgarcita on 09/02/2017.
 */
public class BeneficiaryDTO implements Serializable{

    private MayorDTO mayorDTO;
    private RepresentativeDTO representativeDTO;
    private LegalEntityDTO legalEntityDTO;

    public BeneficiaryDTO (){}

    public BeneficiaryDTO(MayorDTO mayorDTO, RepresentativeDTO representativeDTO, LegalEntityDTO legalEntityDTO) {
        this.mayorDTO = mayorDTO;
        this.representativeDTO = representativeDTO;
        this.legalEntityDTO = legalEntityDTO;
    }

    public MayorDTO getMayorDTO() {
        return mayorDTO;
    }

    public void setMayorDTO(MayorDTO mayorDTO) {
        this.mayorDTO = mayorDTO;
    }

    public RepresentativeDTO getRepresentativeDTO() {
        return representativeDTO;
    }

    public void setRepresentativeDTO(RepresentativeDTO representativeDTO) {
        this.representativeDTO = representativeDTO;
    }

    public LegalEntityDTO getLegalEntityDTO() {
        return legalEntityDTO;
    }

    public void setLegalEntityDTO(LegalEntityDTO legalEntityDTO) {
        this.legalEntityDTO = legalEntityDTO;
    }
}

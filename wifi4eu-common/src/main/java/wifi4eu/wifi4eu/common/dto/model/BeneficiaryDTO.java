package wifi4eu.wifi4eu.common.dto.model;

import java.io.Serializable;

/**
 * Created by rgarcita on 09/02/2017.
 */
public class BeneficiaryDTO implements Serializable{

    private MayorDTO mayorDTO;
    private RepresentativeDTO representativeDTO;
    private LegalEntityDTO legalEntityDTO;
    private boolean isRepresented;

    public BeneficiaryDTO (){}

    public BeneficiaryDTO(MayorDTO mayorDTO, RepresentativeDTO representativeDTO, LegalEntityDTO legalEntityDTO, boolean isRepresented) {
        this.mayorDTO = mayorDTO;
        this.representativeDTO = representativeDTO;
        this.legalEntityDTO = legalEntityDTO;
        this.isRepresented = isRepresented;
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

    public boolean isRepresented() {
        return isRepresented;
    }

    public void setRepresented(boolean represented) {
        isRepresented = represented;
    }
}

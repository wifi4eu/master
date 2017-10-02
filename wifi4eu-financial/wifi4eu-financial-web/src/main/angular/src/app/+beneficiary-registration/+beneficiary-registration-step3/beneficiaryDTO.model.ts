/**
 * Created by roger on 2/16/17.
 */
import {MayorDTO} from "./mayorDTO.model";
import {LegalEntityDTO} from "./legalEntityDTO.model";

export class BeneficiaryDTO {
    mayorDTO: MayorDTO;
    legalEntityDTO: LegalEntityDTO;

    constructor() {
        this.mayorDTO = new MayorDTO();
        this.legalEntityDTO = new LegalEntityDTO();
    }
}
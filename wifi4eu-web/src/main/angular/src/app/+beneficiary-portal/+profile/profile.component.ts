import {Component} from "@angular/core";
import {ProfileService} from "./profile.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {LocalStorageService} from "angular-2-local-storage";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {RepresentativeDTOBase} from "../../shared/swagger/model/RepresentativeDTO";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";
import {LegalEntityDTOBase} from "../../shared/swagger/model/LegalEntityDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {ResponseDTO} from "../../shared/swagger/model/ResponseDTO";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {BeneficiaryDetails} from "../../shared/models/beneficiary-details.model";

@Component({
    selector: 'beneficiary-profile-component',
    templateUrl: 'profile.component.html',
    providers: [ProfileService, BeneficiaryApi, NutsApi, LauApi, UserApi]
})
export class BeneficiaryProfileComponent {
    private beneficiary: BeneficiaryDTOBase;
    private beneficiaryModal: BeneficiaryDTOBase;
    private displayPassword: boolean;
    private displayLegal: boolean;
    private displayMayor: boolean;
    private displayRepresentative: boolean;
    private mayorEmailMatches: boolean;
    private user;
    private beneficiaryDetails: BeneficiaryDetails;
    private newPassword: string;
    private repeatNewPassword: string;
    private currentPassword: string;
    private countryNuts: NutsDTOBase;
    private municipalityLau: LauDTOBase;
    private nutsSuggestions: NutsDTOBase[];
    private lauSuggestions: LauDTOBase[];

    constructor(private profileService: ProfileService, private uxService: UxService, private localStorage: LocalStorageService, private beneficiaryApi: BeneficiaryApi, private nutsApi: NutsApi, private lauApi: LauApi, private userApi: UserApi) {
        this.beneficiaryDetails = new BeneficiaryDetails();
        // this.newPassword = "";
        // this.repeatNewPassword = "";
        // this.currentPassword = "";
        this.beneficiary = new BeneficiaryDTOBase();
        this.beneficiary.mayorDTO = new MayorDTOBase();
        this.beneficiary.representativeDTO = new RepresentativeDTOBase();
        this.beneficiary.legalEntityDTO = new LegalEntityDTOBase();

        this.beneficiaryModal = new BeneficiaryDTOBase();
        this.beneficiaryModal.mayorDTO = new MayorDTOBase();
        this.beneficiaryModal.representativeDTO = new RepresentativeDTOBase();
        this.beneficiaryModal.legalEntityDTO = new LegalEntityDTOBase();

        this.countryNuts = new NutsDTOBase();
        this.municipalityLau = new LauDTOBase();
        this.displayPassword = false;
        this.displayLegal = false;
        this.displayMayor = false;
        this.displayRepresentative = false;
        this.mayorEmailMatches = false;

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        if (this.user != null) {
            switch (this.user.userType) {
                // The user is a mayor
                case 2:
                    this.beneficiaryApi.getMayorById(this.user.userTypeId).subscribe(
                        mayor => {
                            if (mayor != null) {
                                this.beneficiary.represented = false;
                                this.beneficiary.mayorDTO = mayor;
                                this.beneficiary.representativeDTO = null;
                                this.beneficiaryApi.getLegalEntity(this.beneficiary.mayorDTO.legalEntityId).subscribe(
                                    entity => {
                                        this.beneficiary.legalEntityDTO = entity;
                                        this.nutsApi.findNutsByLevel(0).subscribe(
                                            (nuts: NutsDTOBase[]) => {
                                                for (let i = 0; i < nuts.length; i++) {
                                                    if (this.beneficiary.legalEntityDTO.countryCode == nuts[i].countryCode) {
                                                        this.countryNuts = nuts[i];
                                                        break;
                                                    }
                                                }
                                            }
                                        );
                                        this.lauApi.findLauByLau2(this.beneficiary.legalEntityDTO.municipalityCode).subscribe(
                                            (lau: LauDTOBase) => {
                                                this.municipalityLau = lau;
                                                this.copyModalData();
                                            }
                                        );
                                    }
                                );
                            } else {
                                this.beneficiary = new BeneficiaryDTOBase();
                            }
                        }, error => {
                            console.log(error);
                        }
                    );
                    break;
                // The user is a representative of a mayor
                case 3:
                    this.beneficiaryApi.getRepresentativeById(this.user.userTypeId).subscribe(
                        representative => {
                            if (representative != null) {
                                this.beneficiary.represented = true;
                                this.beneficiary.representativeDTO = representative;
                                this.beneficiaryApi.getMayorById(this.beneficiary.representativeDTO.mayorId).subscribe(
                                    mayor => {
                                        if (mayor != null) {
                                            this.beneficiary.mayorDTO = mayor;
                                            this.beneficiaryApi.getLegalEntity(this.beneficiary.mayorDTO.legalEntityId).subscribe(
                                                entity => {
                                                    this.beneficiary.legalEntityDTO = entity;
                                                    this.nutsApi.findNutsByLevel(0).subscribe(
                                                        (nuts: NutsDTOBase[]) => {
                                                            for (let i = 0; i < nuts.length; i++) {
                                                                if (this.beneficiary.legalEntityDTO.countryCode == nuts[i].countryCode) {
                                                                    this.countryNuts = nuts[i];
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                    );
                                                    this.lauApi.findLauByLau2(this.beneficiary.legalEntityDTO.municipalityCode).subscribe(
                                                        (lau: LauDTOBase) => {
                                                            this.municipalityLau = lau;
                                                            this.copyModalData();
                                                        }
                                                    );
                                                }
                                            );
                                        } else {
                                            this.beneficiary = new BeneficiaryDTOBase();
                                        }
                                    }
                                );
                            } else {
                                this.beneficiary = new BeneficiaryDTOBase();
                            }
                        }, error => {
                            console.log(error);
                        }
                    );
                    break;
            }
        }
    }

    updateInfo() {
        this.beneficiaryApi.update(this.user.userTypeId, this.beneficiaryModal).subscribe(
            (beneficiary: ResponseDTO) => {
                this.beneficiary = beneficiary.data;
                this.closeModal();
            }, error => {
                console.log(error);
            }
        );
    }

    updateLegalEntity() {
        this.beneficiaryModal.legalEntityDTO.countryCode = this.countryNuts.countryCode;
        this.beneficiaryModal.legalEntityDTO.municipalityCode = this.municipalityLau.lau2;
        this.updateInfo();
    }

    changingPassword() {
        this.copyModalData();
        this.displayPassword = true;
    }

    legalEntityEdit() {
        this.copyModalData();
        this.displayLegal = true;
    }

    mayorEdit() {
        this.copyModalData();
        this.displayMayor = true;
    }

    representativeEdit() {
        this.copyModalData();
        this.displayRepresentative = true;
    }

    checkPassword() {
        return this.beneficiaryDetails.newPassword === this.beneficiaryDetails.repeatNewPassword;
    }

    filterNuts(event) {
        this.nutsApi.findNutsByLevel(0).subscribe(
            nuts => {
                this.nutsSuggestions = this.filterCountries(event.query, nuts)
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get nuts, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get nuts', error);
            }
        );
    }

    filterCountries(query, nuts: NutsDTOBase[]) {
        let filteredNuts: NutsDTOBase[] = [];
        for (let i = 0; i < nuts.length; i++) {
            let nut = nuts[i];
            nut.name = nut.name.toLowerCase();
            if (nut.name.indexOf(query.toLowerCase()) == 0) {
                nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1);
                filteredNuts.push(nut);
            }
        }
        return filteredNuts;
    }

    filterLaus(event) {
        this.lauApi.findLauByCountryCode(this.countryNuts.countryCode).subscribe(
            laus => this.lauSuggestions = this.filterMunicipalities(event.query, laus)
        );
    }

    filterMunicipalities(query, laus: LauDTOBase[]) {
        let filteredLaus: LauDTOBase[] = [];

        for (let i = 0; i < laus.length; i++) {
            let lau = laus[i];
            if (lau.name1 != null) {
                if (lau.name1.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                    filteredLaus.push(lau);
                }
            }
        }
        return filteredLaus;
    }

    emptyModal() {
        this.beneficiaryDetails.currentPassword = "";
        this.beneficiaryDetails.newPassword = "";
        this.beneficiaryDetails.repeatNewPassword = "";
    }

    closeModal() {
        this.displayPassword = false;
        this.displayLegal = false;
        this.displayMayor = false;
        this.displayRepresentative = false;
        this.emptyModal();
    }

    copyModalData() {
        this.beneficiaryModal = new BeneficiaryDTOBase();
        if (this.beneficiary != null) {
            this.beneficiaryModal.mayorDTO = Object.assign({}, this.beneficiary.mayorDTO);
            this.beneficiaryModal.mayorDTO.repeatEmail = this.beneficiaryModal.mayorDTO.email;
            this.beneficiaryModal.legalEntityDTO = Object.assign({}, this.beneficiary.legalEntityDTO);
            if (this.beneficiary.representativeDTO != null) {
                this.beneficiaryModal.representativeDTO = Object.assign({}, this.beneficiary.representativeDTO);
                this.beneficiaryModal.representativeDTO.mayorRepeatEmail = this.beneficiaryModal.representativeDTO.email;
            }
            this.beneficiaryModal.represented = this.beneficiary.represented;
            this.mayorEmailMatches = true;
        }
    }

    checkIfMayorEmailMatches() {
        this.mayorEmailMatches = false;
        if (this.beneficiaryModal.mayorDTO.email === this.beneficiaryModal.mayorDTO.repeatEmail) {
            this.mayorEmailMatches = true;
        }
    }


    changePassword() {
        let passwords: string = '{"currentPassword" : "' + this.beneficiaryDetails.currentPassword + '", "newPassword" : "' + this.beneficiaryDetails.newPassword + '"}';

        this.userApi.changePassword(this.user.userId, passwords).subscribe(
            (response: ResponseDTO) => {
                if (response.success == true) {
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'Password changed succesfully!'
                    });
                    this.user = response.data;
                    this.closeModal();

                } else {
                    this.uxService.growl({
                        severity: 'warn',
                        summary: 'WARNING',
                        detail: response.data
                    });
                    this.emptyModal();
                }
            }, error => {
                console.log(error);
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Contact your administrator'
                });
            }
        )
    }
}

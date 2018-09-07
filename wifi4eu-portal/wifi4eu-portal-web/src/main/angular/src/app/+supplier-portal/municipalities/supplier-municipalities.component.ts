import {Component, Input} from "@angular/core";
import {LocalStorageService} from "angular-2-local-storage";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {LauDTO} from "../../shared/swagger/model/LauDTO";
import {NutsDTO} from "../../shared/swagger/model/NutsDTO";
import { SharedService } from "../../shared/shared.service";
import {UserDTO} from "../../shared/swagger/model/UserDTO";

@Component({selector: 'supplier-municipalities-component', templateUrl: 'supplier-municipalities.component.html', providers: [SupplierApi, BeneficiaryApi, CallApi, NutsApi, LauApi]})
export class SupplierMunicipalitiesComponent {
    private user: UserDTO;
    private awardedMunicipalities: AwardedMunicipality[];
    private filteredAwardedMunicipalities: AwardedMunicipality[];
    private selectedMeMunicipalities: AwardedMunicipality[];
    private filteredSelectedMeMunicipalities: AwardedMunicipality[];
    private filterInput: string = '';
    private filtering: boolean = false;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi, private nutsApi: NutsApi, private lauApi: LauApi) {
        this.awardedMunicipalities = [];
        this.filteredAwardedMunicipalities = [];
        this.selectedMeMunicipalities = [];
        this.filteredAwardedMunicipalities = [];

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }

    ngOnInit() {
        if (this.user != null) {          
            // this.beneficiaryApi.getAwardedMunicipalities().subscribe(
            //     (municipalities: LegalEntityDTO[]) => {
            //         for (let i = 0; i < municipalities.length; i++) {
            //             let municipality = municipalities[i];
            //             let awardedMunicipality = new AwardedMunicipality();
            //             this.lauApi.findLauByLau2AndCountryCode(municipality.municipalityCode, municipality.countryCode).subscribe(
            //                 (lau: LauDTO) => {
            //                     awardedMunicipality.setMunicipalityName(lau.name1);
            //                     this.nutsApi.findNutsByCode(municipality.countryCode).subscribe(
            //                         (nut: NutsDTO) => {
            //                             nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1).toLowerCase();
            //                             awardedMunicipality.setCountryName(nut.name);
            //                             this.awardedMunicipalities.push(awardedMunicipality);
            //                         }
            //                     );
            //                 }
            //             );
            //         }
            //     }
            // );
            // this.callApi.allCalls().subscribe(
            //     calls => {
            //         let currentCall = calls[0];
            //         this.supplierApi.getSelectedMeBySupplierId(this.user.userTypeId).subscribe(
            //             (municipalities: LegalEntityDTO[]) => {
            //                 for (let i = 0; i < municipalities.length; i++) {
            //                     let municipality = municipalities[i];
            //                     this.beneficiaryApi.findByBeneficiaryIdAndPublicationId(municipality.legalEntityId, currentCall.callId).subscribe(
            //                         (installation: BenPubSupDTO) => {
            //                             let selectedMunicipality = new AwardedMunicipality();
            //                             selectedMunicipality.setInstallationId(installation.benPubSubId);
            //                             this.lauApi.findLauByLau2AndCountryCode(municipality.municipalityCode, municipality.countryCode).subscribe(
            //                                 (lau: LauDTO) => {
            //                                     selectedMunicipality.setMunicipalityName(lau.name1);
            //                                     this.nutsApi.findNutsByCode(municipality.countryCode).subscribe(
            //                                         (nut: NutsDTO) => {
            //                                             selectedMunicipality.setCountryName(nut.name);
            //                                             this.selectedMeMunicipalities.push(selectedMunicipality);
            //                                         }
            //                                     );
            //                                 }
            //                             );
            //                         }
            //                     );
            //                 }
            //             }
            //         );
            //     }
            // );
        }
    }

    filterSearch() {
        this.filteredAwardedMunicipalities = [];
        this.filteredSelectedMeMunicipalities = [];
        if (this.filterInput != null && this.filterInput != '') {
            this.filtering = true;
            for (let i = 0; i < this.awardedMunicipalities.length; i++) {
                if (this.awardedMunicipalities[i].getCountryName().toLowerCase().includes(this.filterInput.toLowerCase()) ||
                    this.awardedMunicipalities[i].getMunicipalityName().toLowerCase().includes(this.filterInput.toLowerCase())) {
                    this.filteredAwardedMunicipalities.push(this.awardedMunicipalities[i]);
                }
            }
            for (let i = 0; i < this.selectedMeMunicipalities.length; i++) {
                if (this.selectedMeMunicipalities[i].getCountryName().toLowerCase().includes(this.filterInput.toLowerCase()) ||
                    this.selectedMeMunicipalities[i].getMunicipalityName().toLowerCase().includes(this.filterInput.toLowerCase())) {
                    this.filteredSelectedMeMunicipalities.push(this.selectedMeMunicipalities[i]);
                }
            }
        } else {
            this.filtering = false;
        }
    }
}

export class AwardedMunicipality {
    private municipalityName: string;
    private countryName: string;
    private installationId: number;

    public getMunicipalityName() {
        return this.municipalityName;
    }

    public setMunicipalityName(value: string) {
        this.municipalityName = value;
    }

    public getCountryName() {
        return this.countryName;
    }

    public setCountryName(value: string) {
        this.countryName = value;
    }

    public getInstallationId() {
        return this.installationId;
    }

    public setInstallationId(value: number) {
        this.installationId = value;
    }
}

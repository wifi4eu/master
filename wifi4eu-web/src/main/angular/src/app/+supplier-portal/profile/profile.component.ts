import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierDetails} from "../../shared/models/supplier-details.model";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {LocalStorageService} from "angular-2-local-storage";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    templateUrl: 'profile.component.html', providers: [SupplierApi, LauApi, NutsApi]
})

export class SupplierProfileComponent {
    private nutsCountry: NutsDTOBase;
    private lauMunicipality: LauDTOBase;
    private supplierData: SupplierDTOBase;
    private selectedSupplierData: SupplierDTOBase;
    private supplierDetails: SupplierDetails;
    private display: boolean;
    private displayContact: boolean;
    private displayCompany: boolean;
    private displayLegal: boolean;
    private user;
    private nutsModalInitial: NutsDTOBase;
    private lausModalInitial: NutsDTOBase;
    private nutsSuggestions: NutsDTOBase[];
    private lausSuggestions: LauDTOBase[];

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private lauApi: LauApi, private nutsApi: NutsApi, private uxService: UxService) {
        this.supplierDetails = new SupplierDetails();
        this.display = false;
        this.displayContact = false;
        this.displayCompany = false;
        this.displayLegal = false;
        this.user;
        this.supplierData = new SupplierDTOBase();
        this.nutsCountry = new NutsDTOBase();
        this.lauMunicipality = new LauDTOBase();

        let u = this.localStorage.get('user');

        this.user = u ? JSON.parse(u.toString()) : null;

        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.userTypeId).subscribe(
                response => {
                    this.supplierData = response;
                    let partNuts = this.supplierData.nutsIds.split(",");
                    this.nutsApi.findNutsByLevel(0).subscribe(
                        (nuts: NutsDTOBase[]) => {
                            for (let i = 0; i < nuts.length; i++) {
                                if (partNuts[0] == nuts[i].countryCode) {
                                    this.nutsCountry = nuts[i];
                                    break;
                                }
                            }
                        }
                    );
                    this.lauApi.findLauByNuts3(partNuts[1]).subscribe(
                        result => {
                            let laus = result;
                            this.lauMunicipality = laus[0];
                        },
                        error => {
                            console.log(error);
                        }
                    );
                },
                error => {
                    console.log(error);
                }
            );
        }

        this.selectedSupplierData = new SupplierDTOBase();
        this.selectedSupplierData = Object.assign({}, this.supplierData);

    }

    openModal() {
        this.display = true;
    }

    emptyModal(){
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        console.log("SE EJECUTA EMPTYMODEL");
    }

    displayContactModal() {
        this.displayContact = true;
        
    }

    displayCompanyModal() {
        this.displayCompany = true;
    }

    displayLegalModal() {
        this.nutsModalInitial = this.nutsCountry;
        this.lausModalInitial = this.lauMunicipality;
        this.displayLegal = true;
    }

    closeModal() {
        this.display = false;
        this.displayLegal = false;
        this.displayCompany = false;
        this.displayContact = false;
        this.nutsCountry = this.nutsModalInitial;
        this.lauMunicipality = this.lausModalInitial;

    }

    checkPassword() {
        return this.supplierDetails.newPassword === this.supplierDetails.repeatNewPassword;
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
        this.lauApi.findLauByCountryCode(this.nutsCountry.countryCode).subscribe(
            laus => this.lausSuggestions = this.filterMunicipalities(event.query, laus)
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

    saveSupplierChanges() {
        this.supplierApi.saveSupplier(this.selectedSupplierData).subscribe(
            savedSupplier => {
                this.supplierData = savedSupplier;
                this.display = false;
                this.displayLegal = false;
                this.displayCompany = false;
                this.displayContact = false;
            }, error => {
                console.log(error);
            }
        );
    }
}
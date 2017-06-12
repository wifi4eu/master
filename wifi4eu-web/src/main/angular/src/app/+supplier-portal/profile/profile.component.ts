import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SelectItem} from "primeng/primeng";
import {SupplierDetails} from "../../shared/models/supplier-details.model";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {LocalStorageService} from "angular-2-local-storage";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsDTO, NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UserDTO} from "../../shared/swagger/model/UserDTO";
import {ResponseDTO} from "../../shared/swagger/model/ResponseDTO";
import {UserApi} from "../../shared/swagger/api/UserApi";

@Component({
    templateUrl: 'profile.component.html', providers: [SupplierApi, LauApi, NutsApi, UserApi]
})

export class SupplierProfileComponent {
    private supplierData: SupplierDTOBase;
    private selectedSupplierData: SupplierDTOBase;
    private supplierDetails: SupplierDetails;
    private display: boolean;
    private displayContact: boolean;
    private displayCompany: boolean;
    private displayLegal: boolean;
    private user: UserDTO;
    private countries: NutsDTO[];
    private provinces: NutsDTO[];
    private selectedCountries: NutsDTO[];
    private selectedProvinces: NutsDTO[];
    private allCountries: SelectItem[];
    private supplierTempLogo: any;
    private uploadedFiles: any[] = [];
    private nutsCountry: NutsDTOBase;
    private lauMunicipality: LauDTOBase;
    private nutsModalInitial: NutsDTOBase;
    private lausModalInitial: LauDTOBase;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private lauApi: LauApi, private nutsApi: NutsApi, private uxService: UxService, private userApi: UserApi) {
        this.supplierDetails = new SupplierDetails();
        this.display = false;
        this.displayContact = false;
        this.displayCompany = false;
        this.displayLegal = false;
        this.supplierData = new SupplierDTOBase();
        this.nutsCountry = new NutsDTOBase();
        this.lauMunicipality = new LauDTOBase();
        this.selectedSupplierData = new SupplierDTOBase();
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.allCountries = [];
        this.countries = [];
        this.provinces = [];


        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }

    ngOnInit() {
        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.userTypeId).subscribe(
                response => {
                    this.supplierData = response;
                    let partNuts = this.supplierData.nutsIds.split(",");
                    for (let i = 0; i < partNuts.length; i++) {
                        this.nutsApi.findNutsByCode(partNuts[i]).subscribe(
                            (nuts: NutsDTO) => {
                                if (nuts.level == 0) {
                                    this.countries.push(nuts);
                                } else if (nuts.level == 3) {
                                    this.provinces.push(nuts);
                                }
                            }
                        )
                    }
                }, error => {
                    console.log(error);
                }
            );
        }
        this.nutsApi.findNutsByLevel(0).subscribe(
            (nuts: NutsDTO[]) => {
                for (let nut of nuts) {
                    let selectedItem = {
                        label: ' ' + nut.name,
                        value: nut
                    };
                    this.allCountries.push(selectedItem);
                }
            }
        );
    }

    openModal() {
        this.display = true;
    }

    displayContactModal() {
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.nutsModalInitial = this.nutsCountry;
        this.lausModalInitial = this.lauMunicipality;
        this.displayContact = true;
    }

    displayCompanyModal() {
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.nutsModalInitial = this.nutsCountry;
        this.lausModalInitial = this.lauMunicipality;
        this.displayCompany = true;
    }

    displayLegalModal() {
        this.selectedSupplierData = Object.assign({}, this.supplierData);
        this.nutsModalInitial = this.nutsCountry;
        this.lausModalInitial = this.lauMunicipality;
        this.displayLegal = true;
        console.log(this.selectedCountries);
        console.log(this.allCountries);
    }

    closeModal() {
        this.display = false;
        this.displayLegal = false;
        this.displayCompany = false;
        this.displayContact = false;
        this.nutsCountry = this.nutsModalInitial;
        this.lauMunicipality = this.lausModalInitial;
        this.selectedSupplierData = Object.assign({}, this.supplierData);
    }

    checkPassword() {
        return this.supplierDetails.newPassword === this.supplierDetails.repeatNewPassword;
    }

    saveSupplierChanges() {
        this.supplierApi.saveSupplier(this.selectedSupplierData).subscribe(
            (savedSupplier: ResponseDTO) => {
                this.supplierData = savedSupplier.data;
                this.display = false;
                this.displayLegal = false;
                this.displayCompany = false;
                this.displayContact = false;
            }, error => {
                console.log(error);
            }
        );
    }


    onSelect(event) {
        if (event && event.files && event.files.length > 0) {
            if (event) {
                this.supplierTempLogo = event.files[0];
                let reader = new FileReader();

                reader.onload = (e) => {
                    this.selectedSupplierData.logo = reader.result;
                };
                reader.readAsDataURL(event.files[0]);
            }
        }
    }

    onMultiSelectChange(event) {
        if (event.value.length > 0) {
            let country: NutsDTO = event.value[event.value.length - 1];

            if (this.selectedCountries.length > 0) {
                this.selectedCountries.splice(0, this.selectedCountries.length);
            }
            for (let country of event.value) {
                this.selectedCountries.push(country);
            }

            this.nutsApi.findNutsByLevel(3).subscribe(
                (nuts: NutsDTO[]) => {
                    this.provinces[country.name.toUpperCase()] = [];
                    for (let nut of nuts) {
                        if (country.countryCode === nut.countryCode) {
                            this.provinces[country.name.toUpperCase()].push(nut);
                        }
                    }
                }
            );
        }
    }

    updateNutsAndLau() {
        this.selectedSupplierData.nutsIds = "";
        this.selectedSupplierData.nutsIds += this.nutsCountry.countryCode;
        this.selectedSupplierData.nutsIds += "," + this.lauMunicipality.lau2;
    }

    emptyPasswordModal() {
        this.supplierDetails.currentPassword = "";
        this.supplierDetails.newPassword = "";
        this.supplierDetails.repeatNewPassword = "";
    }

    changePassword() {
        let passwords: string = '{"currentPassword" : "' + this.supplierDetails.currentPassword + '", "newPassword" : "' + this.supplierDetails.newPassword + '"}';

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
                    this.emptyPasswordModal();
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
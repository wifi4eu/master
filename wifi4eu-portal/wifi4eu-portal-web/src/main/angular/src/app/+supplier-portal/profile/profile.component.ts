import {Component, Input, Output, EventEmitter, ViewChild} from "@angular/core";
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
import {Observable} from 'rxjs/Rx';
import {SuppliedRegionDTO} from "../../shared/swagger/model/SuppliedRegionDTO";


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
    private suppliedRegion: SuppliedRegionDTO[];
    private user: UserDTO;
    private countriesList: string[];
    private provincesList: string[];
    private countries: NutsDTO[];
    private provinces: NutsDTO[];
    private selectedCountries: NutsDTO[];
    private selectedProvinces: NutsDTO[];
    private allCountries: SelectItem[];
    private isLogoUploaded: boolean = false;
    private logoUrl: FileReader = new FileReader();
    private logoFile: File;
    private nutsCountry: NutsDTOBase;
    private lauMunicipality: LauDTOBase;
    private nutsModalInitial: NutsDTOBase;
    private lausModalInitial: LauDTOBase;
    @ViewChild('logoInput') logoInput: any;

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
        this.selectedCountries = [];
        this.selectedProvinces = [];
        this.allCountries = [];
        this.countries = [];
        this.provinces = [];
        this.countriesList = [];
        this.provincesList = [];

        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }

    ngOnInit() {
        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.id).subscribe(
                (data: SupplierDTOBase) => {
                    let supplierNuts = data.suppliedRegions;

                    console.log("supplerNuts: ", supplierNuts);
                }, error => {
                    console.log(error);
                }
            );
        }
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
        this.checkCountries();
    }

    checkCountries() {
        this.nutsApi.getNutsByLevel(0).subscribe(
            (nuts: NutsDTO[]) => {
                for (let nut of nuts) {
                    let selectedItem = {
                        label: ' ' + nut.label,
                        value: nut
                    };
                    this.allCountries.push(selectedItem);
                    if (this.countries.some(function (e) {
                            return e.label == nut.label;
                        })) {
                        this.selectedCountries.push(selectedItem.value);
                    }
                }
            }
        );
    }

    closeModal() {
        this.display = false;
        this.displayLegal = false;
        this.displayCompany = false;
        this.displayContact = false;
        this.clearLogoFile();
        this.nutsCountry = this.nutsModalInitial;
        this.lauMunicipality = this.lausModalInitial;
        this.selectedSupplierData = Object.assign({}, this.supplierData);
    }

    checkPassword() {
        return this.supplierDetails.newPassword === this.supplierDetails.repeatNewPassword;
    }

    saveSupplierChanges() {
        if (this.isLogoUploaded) {
            this.selectedSupplierData.logo = this.logoUrl.result;
        }
        this.supplierApi.createSupplier(this.selectedSupplierData).subscribe(
            (savedSupplier: ResponseDTO) => {
                this.supplierData = savedSupplier.data;
                this.display = false;
                this.displayLegal = false;
                this.displayCompany = false;
                this.displayContact = false;
                this.clearLogoFile();
            }, error => {
                console.log(error);
            }
        );
    }

    onSelect(event) {
        this.isLogoUploaded = false;
        if (event.target && event.target.files && event.target.files.length > 0) {
            this.logoUrl.readAsDataURL(event.target.files["0"]);
            this.logoFile = event.target.files["0"];
            let subscription = Observable.interval(500).map((x) => {
            }).subscribe((x) => {
                if (this.logoUrl.result != "") {
                    this.isLogoUploaded = true;
                    subscription.unsubscribe();
                }
            });
        }
    }

    clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.logoFile = null;
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

            this.nutsApi.getNutsByLevel(3).subscribe(
                (nuts: NutsDTO[]) => {
                    this.provinces[country.label.toUpperCase()] = [];
                    for (let nut of nuts) {
                        if (country.countryCode === nut.countryCode) {
                            this.provinces[country.label.toUpperCase()].push(nut);
                        }
                    }
                }
            );
        }
    }

    updateNutsAndLau() {

    }

    emptyPasswordModal() {
        this.supplierDetails.currentPassword = "";
        this.supplierDetails.newPassword = "";
        this.supplierDetails.repeatNewPassword = "";
    }

    changePassword() {

    }
}
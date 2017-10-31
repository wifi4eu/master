import {Component, ViewChild} from "@angular/core";
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import {Observable} from "rxjs/Observable";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";

@Component({
    selector: 'supplier-profile', templateUrl: 'profile.component.html', providers: [SupplierApi, NutsApi]
})

export class SupplierProfileComponent {
    private supplier: SupplierDTOBase = new SupplierDTOBase();
    private editedSupplier: SupplierDTOBase = new SupplierDTOBase();
    private displayContact: boolean = false;
    private displayCompany: boolean = false;
    private displayChangePassword: boolean = false;
    private selectedCountriesNames: string[] = [];
    private supportedRegions: NutsDTOBase[][] = [];
    private submittingData = false;
    private currentPassword: string = '';
    private newPassword: string = '';
    private repeatNewPassword: string = '';
    private passwordsMatch: boolean = false;
    private isLogoUploaded: boolean = false;
    private logoUrl: FileReader = new FileReader();
    private logoFile: File;
    @ViewChild('logoInput') private logoInput: any;

    constructor(private supplierApi: SupplierApi, private nutsApi: NutsApi, private uxService: UxService) {
        // Get a random supplier from the DB for testing purposes
        this.supplierApi.allSuppliers().subscribe(
            (suppliers: SupplierDTOBase[]) => {
                this.supplier = suppliers[Math.floor(Math.random() * suppliers.length)];
                Object.assign(this.editedSupplier, this.supplier);
                this.nutsApi.getNutsByLevel(0).subscribe(
                    (countries: NutsDTOBase[]) => {
                        for (let suppliedRegion of this.supplier.suppliedRegions) {
                            this.nutsApi.getNutsById(suppliedRegion.regionId).subscribe(
                                (region: NutsDTOBase) => {
                                    for (let country of countries) {
                                        if (region.countryCode == country.countryCode) {
                                            if (!this.supportedRegions[country.label]) {
                                                this.selectedCountriesNames.push(country.label);
                                                this.supportedRegions[country.label] = [];
                                            }
                                            this.supportedRegions[country.label].push(region);
                                            break;
                                        }
                                    }
                                }
                            );
                        }
                    }
                );
            }
        );
    }

    displayModal(name: string) {
        switch (name) {
            case 'contact':
                this.displayContact = true;
                break;
            case 'company':
                this.displayCompany = true;
                break;
            case 'password':
                this.displayChangePassword = true;
                break;
        }
    }

    closeModal() {
        this.displayContact = false;
        this.displayCompany = false;
        this.displayChangePassword = false;
        this.currentPassword = '';
        this.newPassword = '';
        this.repeatNewPassword = '';
        this.passwordsMatch = false;
        this.clearLogoFile();
        Object.assign(this.editedSupplier, this.supplier);
    }

    saveSupplierChanges() {
        this.submittingData = true;
        this.supplierApi.createSupplier(this.editedSupplier).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.supplier = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    changeLogo(event) {
        if (event.target.files.length > 0) {
            this.logoFile = event.target.files[0];
            let imageStatus = "";
            let image = new Image();
            image.onload = function () {
                imageStatus = "correct";
            };
            image.onerror = function () {
                imageStatus = "wrong";
            };
            image.src = URL.createObjectURL(this.logoFile);
            let subscription = Observable.interval(200).subscribe(
                x => {
                    switch(imageStatus) {
                        case "correct":
                            this.uploadCorrect();
                            subscription.unsubscribe();
                            break;
                        case "wrong":
                            this.uploadWrong();
                            subscription.unsubscribe();
                            break;
                    }
                }
            );
        }
    }

    uploadCorrect() : any {
        this.logoUrl.readAsDataURL(this.logoFile);
        let subscription = Observable.interval(200).subscribe(
            x => {
                if (this.logoUrl.result != "") {
                    this.editedSupplier.logo = this.logoUrl.result;
                    this.isLogoUploaded = true;
                    subscription.unsubscribe();
                }
            }
        );
    }

    uploadWrong() : any {
        this.clearLogoFile();
        this.uxService.growl({
            severity: 'error',
            summary: 'ERROR',
            detail: 'The file you uploaded is not a valid image file.'
        });
    }

    clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.logoFile = null;
        this.editedSupplier.logo = null;
    }

    checkPasswordsMatch() {
        if (this.newPassword.length > 0 && this.newPassword == this.repeatNewPassword) {
            this.passwordsMatch = true;
        } else {
            this.passwordsMatch = false;
        }
    }
}
import { Component, ViewChild } from "@angular/core";
import { LocalStorageService } from "angular-2-local-storage";
import { Observable } from "rxjs/Observable";
import { SharedService } from "../../shared/shared.service";
import { UserApi } from "../../shared/swagger/api/UserApi";
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";

@Component({
    selector: 'supplier-profile',
    templateUrl: 'profile.component.html',
    providers: [UserApi, SupplierApi, NutsApi]
})

export class SupplierProfileComponent {
    private user: UserDTOBase = new UserDTOBase();
    private supplier: SupplierDTOBase = new SupplierDTOBase();
    private editedSupplier: SupplierDTOBase = new SupplierDTOBase();
    private supportedRegions: NutsDTOBase[][] = [];
    private selectedCountriesNames: string[] = [];
    private displayContact: boolean = false;
    private displayCompany: boolean = false;
    private withdrawingRegistration: boolean = false;
    private withdrawnSuccess: boolean = false;
    private submittingData: boolean = false;
    private isLogoUploaded: boolean = false;
    private deletingLogo: boolean = false;
    private logoUrl: FileReader = new FileReader();
    private logoFile: File;
    @ViewChild('logoInput') private logoInput: any;
    private regionsToRender: NutsDTOBase[] = [];

    constructor(private localStorageService: LocalStorageService, private sharedService: SharedService, private supplierApi: SupplierApi, private nutsApi: NutsApi, private userApi: UserApi) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
                (supplier: SupplierDTOBase) => {
                    if (supplier != null) {
                        this.supplier = supplier;
                        Object.assign(this.editedSupplier, this.supplier);
                        this.nutsApi.getNutsByLevel(0).subscribe(
                            (countries: NutsDTOBase[]) => {
                                this.supplier.suppliedRegions;
                                for(let country of countries) {
                                    let regions = this.supplier.suppliedRegions.filter(x => x.regionId.countryCode == country.countryCode );
                                    regions.map((filtered) => {
                                        if (!this.supportedRegions[country.label]) {
                                            this.selectedCountriesNames.push(country.label);
                                            this.supportedRegions[country.label] = [];
                                        }
                                        this.supportedRegions[country.label].push(filtered.regionId);
                                    });
                                }
                                this.regionsToRender = this.supportedRegions[this.selectedCountriesNames[0]];
                            }
                        );
                    }
                }
            );
        }
    }

    private selectCountry (event, tableReference) {
        let name = this.selectedCountriesNames[event.index];
        this.regionsToRender = this.supportedRegions[name];
        tableReference.reset();
    }

    private displayModal(name: string) {
        switch (name) {
            case 'contact':
                this.displayContact = true;
                break;
            case 'company':
                this.displayCompany = true;
                break;
            case 'password':
                this.userApi.ecasChangePassword().subscribe(
                    (response: ResponseDTOBase) => {
                        if (response.success) {
                            window.location.href = response.data;
                        }
                    }, error => {
                        console.log(error);
                    }
                );
                break;
        }
    }

    private closeModal() {
        this.displayContact = false;
        this.displayCompany = false;
        this.deletingLogo = false;
        this.clearLogoFile();
        Object.assign(this.editedSupplier, this.supplier);
    }

    private saveContactChanges() {
        this.submittingData = true;
        this.supplierApi.updateContactDetails(this.editedSupplier).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.supplier = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    private saveDetailsChanges() {
        this.submittingData = true;
        this.supplierApi.updateSupplierDetails(this.editedSupplier).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.supplier = response.data;
                    this.closeModal();
                    this.submittingData = false;
                }
            }
        );
    }

    private changeLogo(event) {
        if (event.target.files.length > 0) {
            this.logoFile = event.target.files[0];
            if (this.logoFile.size > 2560000) {
                this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 2.5 MB.', 'benefPortal.file.toobig.maxsize', 'warn', {size: '2.5 MB'});
                this.clearLogoFile();
                return;
            }
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
                    switch (imageStatus) {
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

    private uploadCorrect(): any {
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

    private uploadWrong(): any {
        this.clearLogoFile();
        this.sharedService.growlTranslation('The file you uploaded is not a valid image file.', 'shared.imageUpload.error', 'error');
    }

    private clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.logoFile = null;
        this.editedSupplier.logo = null;
    }

    private withdrawRegistration() {
        if (!this.withdrawingRegistration && !this.withdrawnSuccess) {
            this.withdrawingRegistration = true;
            this.userApi.deleteUser(this.user.id).subscribe(
                (data: ResponseDTOBase) => {
                    if (data.success) {
                        this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.withdrawRegistration.Success', 'success');
                        this.sharedService.logout();
                        this.withdrawingRegistration = false;
                        this.withdrawnSuccess = true;
                    }
                }, error => {
                    this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'benefPortal.beneficiary.withdrawRegistration.Failure', 'error');
                    this.withdrawingRegistration = false;
                    this.withdrawnSuccess = false;
                }
            );
        }
    }

    private deleteLogo() {
        this.deletingLogo = true;
        this.clearLogoFile();
    }
}
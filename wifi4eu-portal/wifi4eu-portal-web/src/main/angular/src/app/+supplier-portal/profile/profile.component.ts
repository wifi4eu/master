import {Component, ViewChild} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {Observable} from "rxjs/Observable";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {LocalStorageService} from "angular-2-local-storage";
import {TranslateService} from "ng2-translate";
import {UserThreadsDTOBase} from "../../shared/swagger/model/UserThreadsDTO";
import {UserThreadsApi} from "../../shared/swagger/api/UserThreadsApi";
import {SharedService} from "../../shared/shared.service";
import {UserApi} from "../../shared/swagger/api/UserApi";

@Component({
    selector: 'supplier-profile',
    templateUrl: 'profile.component.html',
    providers: [SupplierApi, NutsApi, UserThreadsApi, UserApi]
})

export class SupplierProfileComponent {
    private user: UserDTOBase = new UserDTOBase();
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
    private userThreads: UserThreadsDTOBase = new UserThreadsDTOBase();
    private threadId: number;
    private hasDiscussion: boolean = false;
    @ViewChild('logoInput') private logoInput: any;

    constructor(private router: Router, private route: ActivatedRoute, private sharedService: SharedService, private userThreadsApi: UserThreadsApi, private supplierApi: SupplierApi, private nutsApi: NutsApi, private uxService: UxService, private localStorageService: LocalStorageService, private translateService: TranslateService, private userApi: UserApi) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            if (this.user.type == 1) {
                this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
                    (supplier: SupplierDTOBase) => {
                        this.supplier = supplier;
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
                this.userThreadsApi.getThreadsByUserId(this.user.id).subscribe(
                    (userThreads: UserThreadsDTOBase[]) => {
                        this.userThreads = userThreads[0];
                        this.threadId = userThreads[0].threadId;
                        this.hasDiscussion = true;
                    }, error => {
                        console.log("service error: ", error);
                    }
                );

            } else {
                let translatedString = 'You are not allowed to view this page.';
                this.translateService.get('shared.error.notallowed').subscribe(
                    (translation: string) => {
                        translatedString = translation;
                    }
                );
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: translatedString
                });
                this.router.navigateByUrl('/home');
            }
        } else {
            let translatedString = 'You are not logged in!';
            this.translateService.get('shared.error.notloggedin').subscribe(
                (translation: string) => {
                    translatedString = translation;
                }
            );
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: translatedString
            });
            this.router.navigateByUrl('/home');
        }
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
        this.displayChangePassword = false;
        this.currentPassword = '';
        this.newPassword = '';
        this.repeatNewPassword = '';
        this.passwordsMatch = false;
        this.clearLogoFile();
        Object.assign(this.editedSupplier, this.supplier);
    }

    private saveSupplierChanges() {
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

    private changeLogo(event) {
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
        this.uxService.growl({
            severity: 'error',
            summary: 'ERROR',
            detail: 'The file you uploaded is not a valid image file.'
        });
    }

    private clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.logoFile = null;
        this.editedSupplier.logo = null;
    }

    private checkPasswordsMatch() {
        if (this.newPassword.length > 0 && this.newPassword == this.repeatNewPassword) {
            this.passwordsMatch = true;
        } else {
            this.passwordsMatch = false;
        }
    }

    private preventPaste(event: any) {
        return false;
    }

    private goToDiscussion() {
        this.userThreadsApi.getThreadsByUserId(this.user.id).subscribe(
            (userThreads: UserThreadsDTOBase[]) => {
                console.log("userThreads1:::: ", userThreads);
                this.userThreads = userThreads[0];
                this.threadId = userThreads[0].threadId;
                console.log("userThreads", this.userThreads);
                console.log("threadId", this.threadId);
                this.router.navigate(['../discussion-forum/', this.threadId], {relativeTo: this.route});
            }, error => {
                console.log("service error: ", error);
            }
        );
    }

    private withdrawRegistration() {
        this.userApi.deleteUser(this.user.id).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.withdrawRegistration.Success', 'success');
                    this.sharedService.logout();
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'benefPortal.beneficiary.withdrawRegistration.Failure', 'error');
            }
        );
    }
}
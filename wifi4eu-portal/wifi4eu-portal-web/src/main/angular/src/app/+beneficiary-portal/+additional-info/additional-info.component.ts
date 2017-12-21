import { Component, ViewChild } from "@angular/core";
import { Router } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { Observable } from "rxjs/Observable";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { SharedService } from "../../shared/shared.service";

@Component({
    selector: 'additional-info-component',
    templateUrl: 'additional-info.component.html',
    providers: [MunicipalityApi]
})

export class AdditionalInfoComponent {
    private user: UserDTOBase;
    private municipality: MunicipalityDTOBase;
    private registration: RegistrationDTOBase;
    private documentFiles: File[] = [];
    private documentUrls: string[] = [];
    private reader: FileReader = new FileReader();
    private allFilesUploaded: boolean = false;
    @ViewChild('document1') private document1: any;
    @ViewChild('document2') private document2: any;
    @ViewChild('document3') private document3: any;
    @ViewChild('document4') private document4: any;
    private displayConfirmingData: boolean = false;

    constructor(private localStorageService: LocalStorageService, private municipalityApi: MunicipalityApi, private registrationApi: RegistrationApi, private sharedService: SharedService, private router: Router) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.municipalityApi.getMunicipalitiesByUserId(this.user.id).subscribe(
                (municipalities: MunicipalityDTOBase[]) => {
                    if (municipalities.length > 0) {
                        this.municipality = municipalities[0];
                        this.registrationApi.getRegistrationByUserAndMunicipality(this.user.id, this.municipality.id).subscribe(
                            (registration: RegistrationDTOBase) => {
                                this.registration = registration;
                            }
                        );
                    }
                }, error => {
                    console.log(error);
                }
            );
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    private uploadFile(event: any, index: number = 0) {
        if (event.target.files[0]) {
            if (event.target.files[0].size > 2048000) {
                this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 2 MB.', 'file.toobig.maxsize', 'warn', {size: "2 MB"});
                this.removeFile(index);
                return;
            }
            this.documentFiles[index] = event.target.files[0];
            this.reader.readAsDataURL(this.documentFiles[index]);
            let subscription = Observable.interval(200).subscribe(
                x => {
                    if (this.reader.result != "") {
                        this.documentUrls[index] = this.reader.result;
                        if (this.documentUrls[0] && this.documentUrls[1] && this.documentUrls[2] && this.documentUrls[3]) {
                            this.allFilesUploaded = true;
                        } else {
                            this.allFilesUploaded = false;
                        }
                        subscription.unsubscribe();
                    }
                }
            );
        } else {
            this.removeFile(index);
        }
    }

    private removeFile(index: number) {
        this.documentFiles[index] = null;
        this.documentUrls[index] = '';
        this.allFilesUploaded = false;
        switch (index) {
            case 0:
                this.document1.nativeElement.value = '';
                break;
            case 1:
                this.document2.nativeElement.value = '';
                break;
            case 2:
                this.document3.nativeElement.value = '';
                break;
            case 3:
                this.document4.nativeElement.value = '';
                break;
        }
    }

    private onSubmit() {
        if (this.documentUrls[0]) {
            this.registration.legalFile1 = this.documentUrls[0];
        }
        if (this.documentUrls[1]) {
            this.registration.legalFile2 = this.documentUrls[1];
        }
        if (this.documentUrls[2]) {
            this.registration.legalFile3 = this.documentUrls[2];
        }
        if (this.documentUrls[3]) {
            this.registration.legalFile4 = this.documentUrls[3];
        }
        this.displayConfirmingData = true;
        this.registrationApi.createRegistration(this.registration).subscribe(
            (response: ResponseDTOBase) => {
                this.displayConfirmingData = false;
                if (response.success) {
                    this.sharedService.growlTranslation('Your registration was successfully updated.', 'registration.update.success', 'success');
                    this.registration = response.data;
                } else {
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'registration.update.error', 'error');
                }
            }, error => {
                this.displayConfirmingData = false;
                this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'registration.update.error', 'error');
            }
        );
    }
}
import { Component } from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { Observable } from "rxjs/Observable";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../shared/swagger/model/MunicipalityDTO";
import { MunicipalityApi } from "../../shared/swagger/api/MunicipalityApi";
import { RegistrationDTOBase } from "../../shared/swagger/model/RegistrationDTO";
import { RegistrationApi } from "../../shared/swagger/api/RegistrationApi";
import { SharedService } from "../../shared/shared.service";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";

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

    constructor(private localStorageService: LocalStorageService, private municipalityApi: MunicipalityApi, private registrationApi: RegistrationApi, private sharedService: SharedService, private router: Router) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.municipalityApi.getMunicipalitiesByUserId(this.user.id).subscribe(
                (municipalities: MunicipalityDTOBase[]) => {
                    console.log(municipalities);
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
        if (event.target.files.length > 0) {
            this.documentFiles[index] = event.target.files[0];
            this.reader.readAsDataURL(this.documentFiles[index]);
            let subscription = Observable.interval(200).subscribe(
                x => {
                    if (this.reader.result != "") {
                        this.documentUrls[index] = this.reader.result;
                        console.log(this.documentFiles);
                        console.log(this.documentUrls);
                        subscription.unsubscribe();
                    }
                }
            );
        }
    }

    private onSubmit(form: NgForm) {
        console.log(form);
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
        this.registrationApi.createRegistration(this.registration).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.sharedService.growlTranslation('Your registration was successfully updated.', 'registration.update.success', 'success');
                    this.registration = response.data;
                } else {
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'registration.update.error', 'error');
                }
            }, error => {

            }
        );
    }
}
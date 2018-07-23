import {Component, ViewChild} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {Observable} from "rxjs/Observable";
import {SharedService} from "../../../shared/shared.service";
import { UserDTOBase } from "../../../shared/swagger/model/UserDTO";
import { MunicipalityDTOBase } from "../../../shared/swagger/model/MunicipalityDTO";
import { MayorDTOBase } from "../../../shared/swagger/model/MayorDTO";
import { ThreadDTOBase } from "../../../shared/swagger/model/ThreadDTO";
import { UserThreadsDTOBase } from "../../../shared/swagger/model/UserThreadsDTO";
import { RegistrationApi, MayorApi, MunicipalityApi, RegistrationDTOBase, UserApi, ThreadApi, UserThreadsApi } from "../../../shared/swagger";




@Component({
    selector: 'sign-grant-agreement.component',
    templateUrl: 'sign-grant-agreement.component.html',
    providers: [MunicipalityApi, MayorApi, RegistrationApi, UserApi]
})

export class SignGrantAgreementComponent {

    private user: UserDTOBase = new UserDTOBase;
    private users: UserDTOBase[] = [];
    private municipalities: MunicipalityDTOBase[] = [];
    private mayors: MayorDTOBase[] = [];
    private editedUser: UserDTOBase = new UserDTOBase();
    private editedMunicipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private editedMayor: MayorDTOBase = new MayorDTOBase();
    private currentEditIndex: number = 0;
    private displayUser: boolean = false;
    private displayMunicipality: boolean = false;
    private displayMayor: boolean = false;
    private displayLanguageModal: boolean = false;
    private submittingData = false;
    private isRegisterHold: boolean = false;
    private withdrawingRegistration: boolean = false;
    private withdrawnSuccess: boolean = false;
    private threadId: number;
    private hasDiscussion: boolean[] = [];
    private discussionThreads: ThreadDTOBase[] = [];
    private allDocumentsUploaded: boolean[] = [];
    private documentUploaded: boolean = false;
    private oneRegsitration: boolean = false;
    private oneRegistrationNumber: number = 0;
    private userThreads: ThreadDTOBase [] = [];
    private threadsByUser : UserThreadsDTOBase[] = [];


    constructor(private userApi: UserApi, private registrationApi: RegistrationApi, private mayorApi: MayorApi, private municipalityApi: MunicipalityApi, private sharedService: SharedService, private router: Router, private route: ActivatedRoute, private localStorageService: LocalStorageService) {

        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            this.userApi.getUserById(this.user.id).subscribe(
                (user: UserDTOBase) => {
                    if (this.user != null) {
                        this.user = user;
                        if (this.user.type == 2 || this.user.type == 3) {
                            Object.assign(this.editedUser, this.user);
                            this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
                                (registrations: RegistrationDTOBase[]) => {
                                    if (registrations.length == 1) {
                                        this.oneRegsitration = true;
                                        this.oneRegistrationNumber = registrations[0].municipalityId;
                                        if (registrations[0].allFilesFlag == 1) {
                                            this.documentUploaded = true;
                                        }
                                    } else {
                                        this.oneRegsitration = false;
                                    }
                                    for (let registration of registrations) {
                                        if (registration.municipalityId == 0){
                                            continue;
                                        }
                                        this.allDocumentsUploaded.push(registration.allFilesFlag == 1);
                                        this.isRegisterHold = (registration.status == 0); // 0 status is HOLD
                                        this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                                            (municipality: MunicipalityDTOBase) => {
                                                this.mayorApi.getMayorByMunicipalityId(municipality.id).subscribe(
                                                    (mayor: MayorDTOBase) => {
                                                        this.municipalities.push(municipality);
                                                        this.mayors.push(mayor);
                                                    }
                                                );
                                            }
                                        );
                                        this.userApi.getUsersFromRegistration(registration.id).subscribe(
                                            (users: UserDTOBase[]) => {
                                                    this.users = users;
                                            }
                                        );
                                    }
                                }
                            );
                        } else {
                            this.sharedService.growlTranslation('You are not allowed to view this page.', 'shared.error.notallowed', 'warn');
                            this.router.navigateByUrl('/home');
                        }
                    }
                }, error => {
                    this.localStorageService.remove('user');
                    this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later."', 'shared.error.api.generic', 'error');
                }
            );
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    private goToSignGrantAgreement(){
        this.router.navigate(['../grant-agreement/sing-grant-agreement'], { relativeTo: this.route });
    }
    
    
    private goBackToProfile(){
        this.router.navigate(['../'], {relativeTo: this.route});
    }
}
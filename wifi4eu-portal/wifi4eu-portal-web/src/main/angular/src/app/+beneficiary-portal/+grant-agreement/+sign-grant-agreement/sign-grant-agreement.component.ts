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
import { RegistrationApi, MayorApi, MunicipalityApi, RegistrationDTOBase, UserApi, ThreadApi, UserThreadsApi, ApplicationApi, CallApi, CallDTOBase, ApplicationDTOBase } from "../../../shared/swagger";




@Component({
    selector: 'sign-grant-agreement.component',
    templateUrl: 'sign-grant-agreement.component.html',
    providers: [MunicipalityApi, MayorApi, RegistrationApi, UserApi, CallApi, ApplicationApi]
})

export class SignGrantAgreementComponent {

    private user: UserDTOBase = new UserDTOBase;
    private mayor: MayorDTOBase;
    private municipality: MunicipalityDTOBase;
    private call: CallDTOBase;
    private application: ApplicationDTOBase
    private authorizedUser: UserDTOBase;


    constructor(private callApi: CallApi, private applicationApi: ApplicationApi, private userApi: UserApi, private registrationApi: RegistrationApi, private mayorApi: MayorApi, private municipalityApi: MunicipalityApi, private sharedService: SharedService, private router: Router, private route: ActivatedRoute, private localStorageService: LocalStorageService) {

        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        let registrationId =  22443;
        if (this.user != null) {
            this.callApi.getCallById(1).subscribe(
                (call: CallDTOBase) =>{
                    this.call = call;
                    this.applicationApi.getApplicationByCallIdAndRegistrationId(this.call.id, registrationId).subscribe(
                        (application: ApplicationDTOBase) => {
                            this.application = application;
                            this.userApi.getUserById(this.application.authorizedPerson).subscribe(
                                (user: UserDTOBase) => {
                                    this.authorizedUser = user;
                                }, error => {
                                    console.log(error);
                                }
                            );
                        }, error => {
                            console.log(error);
                        }
                    );
                }, error =>{
                    console.log(error);
                }
            );
           
            this.registrationApi.getRegistrationById(registrationId).subscribe(
                (registration: RegistrationDTOBase) => {
                    this.municipalityApi.getMunicipalityById(registration.municipalityId).subscribe(
                        (municipality: MunicipalityDTOBase) =>{
                            this.municipality = municipality;
                            this.mayorApi.getMayorByMunicipalityId(registration.municipalityId).subscribe(
                                (mayor: MayorDTOBase) => {
                                    this.mayor = mayor;
                                }, error => {
                                    console.log(error);
                                    
                                }
                            );
                        }, error => {
                            console.log(error);
                            
                        }
                    );
                }, error => {
                    console.log(error);
                });    
        }
    }

    private goToSignGrantAgreement(){
        this.router.navigate(['../grant-agreement/sing-grant-agreement'], { relativeTo: this.route });
    }
    
    
    private goBackToProfile(){
        this.router.navigate(['../'], {relativeTo: this.route});
    }
}
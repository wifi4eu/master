// May be erased??
// RegistrationDTO

import { Component } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { SharedService } from "../../shared/shared.service";
import { UserDTOBase, UserApi, RegistrationApi, RegistrationDTO } from "../../shared/swagger";



@Component({
    selector: 'grant-agreement.component',
    templateUrl: 'grant-agreement.component.html',
    providers: [UserApi, RegistrationApi]
})

export class GrantAgreementComponent {
    private user: UserDTOBase;
    // private registrationUsers : Array<Object> = [];
    private registrationUser : Object = {};
    
    // May be erased?
    // private registrationsList: Array<RegistrationDTO>;
    private registration : RegistrationDTO;
    private registrations : Array<RegistrationDTO> = [];
    private monsterDTO : Object = {};
    private monsterArray : Array<Object> = [];

    constructor( 
        private sharedService: SharedService, 
        private router: Router, 
        private route: ActivatedRoute,
        private localStorage: LocalStorageService,
        private userApi: UserApi,

        // May be erase??
        private registrationApi: RegistrationApi
    ) {
    
        /* Authenticate user */
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        
        if(this.user) {
            /* this.userApi.getUsersFromRegistration().subscribe(

            ); */

            // FAKE DA USERS --------------------------------------------------
            this.registrationApi.getRegistrationsByUserId(this.user.id, new Date().getTime()).subscribe(
                (registrations) => {
                    if(registrations) {
                        this.registrations.push(this.registration);
                        registrations.forEach(registration => {
                            this.monsterDTO = {}
                            if(registration == registrations[0]) {
                                this.monsterDTO["type"] = 0; 
                                this.monsterDTO["name"] = "Manolo"; 
                                this.monsterDTO["surname"] = "Puertas"; 
                                this.monsterDTO["email"] = "manpuertas@hinojosa.es"; 
                                this.monsterDTO["euLogin"] = 0;
                                this.monsterDTO["documents"] = 0;
                                this.monsterDTO["authorised"] = 0;
                            }
                            if(registration == registrations[1]) {
                                this.monsterDTO["type"] = 1; 
                                this.monsterDTO["name"] = "Juan"; 
                                this.monsterDTO["surname"] = "Sintierra"; 
                                this.monsterDTO["email"] = "juansintierra@tavertetenlasmontañas.es"; 
                                this.monsterDTO["euLogin"] = 1;
                                this.monsterDTO["documents"] = 1;
                                this.monsterDTO["authorised"] = 1;
                            }
                            this.monsterArray.push(this.monsterDTO);
                        });
                    }
                    console.log("Monster Array", this.monsterArray);
                                        
                }
            );

        }
    }

    private goToSignGrantAgreement(){
        this.router.navigate(['../grant-agreement/sign-grant-agreement'], { relativeTo: this.route });
    }
    
}
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
import { RegistrationApi, MayorApi, MunicipalityApi, RegistrationDTOBase, UserApi, ThreadApi, UserThreadsApi, ApplicationApi, CallApi, CallDTOBase, ApplicationDTOBase, GrantAgreementApi, ApplicationauthorizedPersonApi, ApplicationAuthorizedPersonDTOBase, GrantAgreementDTOBase } from "../../../shared/swagger";
import * as FileSaver from 'file-saver';
import {UxEuLanguages, UxLanguage} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import { lang } from "moment";



@Component({
    selector: 'sign-grant-agreement.component',
    templateUrl: 'sign-grant-agreement.component.html',
    providers: [UxLanguage, UxEuLanguages, MunicipalityApi, MayorApi, RegistrationApi, UserApi, CallApi, ApplicationApi, GrantAgreementApi, ApplicationauthorizedPersonApi]
})

export class SignGrantAgreementComponent {

    private user: UserDTOBase = new UserDTOBase;
    private mayor: MayorDTOBase;
    private municipality: MunicipalityDTOBase;
    private call: CallDTOBase;
    private application: ApplicationDTOBase
    private authorizedUser: UserDTOBase;
    private languageCodeArray: string[] =["en","bg","cs","da","de","et","el","es","fr","it","lv","lt","hu","mt","nl","pl","pt","ro","sk","sl","fi","sv","hr","ga"];
    private languagesArray: UxEuLanguages[] =[];
    private inputGrantAgreement: GrantAgreementDTOBase = new GrantAgreementDTOBase();
    private language: String = '';

    constructor(private applicationAuthorizedPersonApi: ApplicationauthorizedPersonApi, private uxEuLanguages: UxEuLanguages, private uxLanguage: UxLanguage, private grantAgreementApi: GrantAgreementApi, private callApi: CallApi, private applicationApi: ApplicationApi, private userApi: UserApi, private registrationApi: RegistrationApi, private mayorApi: MayorApi, private municipalityApi: MunicipalityApi, private sharedService: SharedService, private router: Router, private route: ActivatedRoute, private localStorageService: LocalStorageService) {
        
        this.languagesArray = UxEuLanguages.getLanguages(this.languageCodeArray);

  
    
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        //TODO GET REGISTRATION ID FROM ROUTING
        let registrationId =  23446;
        if (this.user != null) {
            this.applicationApi.getApplicationByRegistrationId(registrationId).subscribe(
                (application: ApplicationDTOBase) =>{
                    this.callApi.getCallById(application.callId).subscribe(
                        (call: CallDTOBase) =>{
                            this.call = call;
                            this.applicationApi.getApplicationByCallIdAndRegistrationId(this.call.id, registrationId).subscribe(
                                (application: ApplicationDTOBase) => {
                                    this.application = application;
                                    this.applicationAuthorizedPersonApi.findByApplicationAndUserId(this.application.id, this.user.id).subscribe(
                                        (applicationAuthorized: ApplicationAuthorizedPersonDTOBase  ) =>{
                                            if(applicationAuthorized != null){
                                                this.userApi.getUserById(applicationAuthorized['authorized_person']).subscribe(
                                                    (user: UserDTOBase) => {
                                                        this.authorizedUser = user;
                                                        this.inputGrantAgreement.applicationId = this.application.id;
                                                        this.inputGrantAgreement.documentLanguage = "en";
                                                        this.grantAgreementApi.createGrantAgreement(this.inputGrantAgreement).subscribe(
                                                            (grantAgreement: GrantAgreementDTOBase) =>{
                                                                this.inputGrantAgreement = grantAgreement;
                                                                this.languagesArray.forEach((lang: UxLanguage, index) => {
                                                                    if(lang.code == this.inputGrantAgreement.documentLanguage){
                                                                        this.language = lang.label;
                                                                        return;
                                                                    }
                                                                })
                                                           
                                                            }, error =>{
                                                                console.log(error);
                                                            }
                                                        );
                                                    }, error => {
                                                        console.log(error);
                                                    }
                                                
                                                );
                                            }
                                        }, error =>{
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

    private downladPDF(){
        this.grantAgreementApi.downloadGrantAgreementPdf().subscribe(          
            (response) => {
                let blob = new Blob([response], {type: 'application/pdf'});
                FileSaver.saveAs(blob, 'grantAgreementPdf.pdf');
                this.sharedService.growlTranslation("Your file have been downloaded correctly!", "dgconn.dashboard.card.messageDownload", "success");              
            }, error => {
                this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
            }
        );
    }

    private updateLanguage(event){
        this.inputGrantAgreement.documentLanguage = event;
        
       this.grantAgreementApi.createGrantAgreement(this.inputGrantAgreement).subscribe(
            (grantAgreement: GrantAgreementDTOBase) =>{
                this.languagesArray = UxEuLanguages.getLanguages(this.languageCodeArray);
                this.inputGrantAgreement = grantAgreement;
                let language = this.languagesArray.filter(x => x['code'] == event);
                this.language =  language[0]['label'];
                /* this.inputGrantAgreement.documentLanguage */
            }, error =>{
                console.log(error);
            }
        );
    }

}
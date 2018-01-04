import {Component} from "@angular/core";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {ThreadApi} from "../../shared/swagger/api/ThreadApi";
import {ThreadmessagesApi} from "../../shared/swagger/api/ThreadmessagesApi";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";
import {ThreadDTOBase} from "../../shared/swagger/model/ThreadDTO";
import {ThreadMessageDTOBase} from "../../shared/swagger/model/ThreadMessageDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SharedService} from "../../shared/shared.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserThreadsApi} from "../../shared/swagger/api/UserThreadsApi";
import {UserThreadsDTO, UserThreadsDTOBase} from "../../shared/swagger/model/UserThreadsDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import index from "@angular/cli/lib/cli";
import {isNumber} from "util";

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [UserThreadsApi, ThreadApi, BeneficiaryApi, ThreadmessagesApi, UserApi, RegistrationApi, MunicipalityApi]
})

export class DiscussionComponent {
    private thread: ThreadDTOBase = new ThreadDTOBase();
    private municipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private municipalities: MunicipalityDTOBase[] = [];
    private user: UserDTOBase = new UserDTOBase();
    private messageAuthors: RegistrationDTOBase[] = [];
    private message: string = '';
    private displayMessage: boolean = false;
    private displayMediation: boolean = false;
    private mediationBlocked: boolean = false;
    private showAlert: boolean = false;
    private registration: RegistrationDTOBase[] = [];
    private lauId: number;
    private threadId: number;
    private hasMessages: boolean = false;
    private hasAuthor: boolean = false;
    private counter: number = 0;


    constructor(private route: ActivatedRoute, private municipalityApi: MunicipalityApi, private threadApi: ThreadApi, private threadMessagesApi: ThreadmessagesApi, private registrationApi: RegistrationApi, private userApi: UserApi, private localStorageService: LocalStorageService, private sharedService: SharedService, private router: Router) {

        this.route.params.subscribe(params => this.threadId = params['threadId']);

        this.thread.messages = [];
        this.hasAuthor = false;


        this.threadApi.getThreadById(this.threadId).subscribe(
            thread => {
                this.thread = thread;
                if (this.thread.messages.length > 0) {
                    this.hasMessages = true;
                }
            },
            error => {
                console.log(error);
            }
        );


        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            if (this.user.type == 2 || this.user.type == 3) {
                this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                    (registration: RegistrationDTOBase[]) => {
                        this.registration = registration;
                        this.municipalityApi.getMunicipalityById(this.registration[0].municipalityId).subscribe(
                            (municipality: MunicipalityDTOBase) => {
                                this.municipality = municipality;
                                this.lauId = this.municipality.lauId;
                                this.municipalityApi.getMunicipalitiesByLauId(this.lauId).subscribe(
                                    (municipalities: MunicipalityDTOBase[]) => {
                                        for (var i = 0; i < municipalities.length; i++) {
                                            if (this.municipality.id != municipalities[i].id) {
                                                this.municipalities.push(municipalities[i]);
                                                this.registrationApi.getRegistrationsByMunicipalityId(municipalities[i].id).subscribe(
                                                    (registrations: RegistrationDTOBase[]) => {
                                                        this.messageAuthors.push(registrations[0]);
                                                        this.counter++;
                                                        if (this.counter >= this.municipalities.length) {
                                                            this.hasAuthor = true;
                                                        }
                                                    }, error => {
                                                        console.log(error);
                                                    }
                                                )
                                                ;
                                            }
                                        }

                                    }, error => {
                                        console.log(error);
                                    }
                                );
                            }, error => {
                                console.log(error);
                            }
                        );

                    }
                    ,
                    error => {
                        console.log(error);
                    }
                );
            } else {
                this.sharedService.growlTranslation('You are not allowed to view this page.', 'error.notallowed', 'warn');
                this.router.navigateByUrl('/home');
            }
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    ngOnInit() {
        this.messageAuthors = [];
    }


    private newMessage() {
        this.displayMessage = true;
        this.message = '';
    }

    private sendMessage() {
        let newMessage = new ThreadMessageDTOBase();
        newMessage.createDate = new Date().getTime();
        newMessage.message = this.message;
        newMessage.authorId = this.user.id;
        newMessage.threadId = this.threadId;
        this.threadMessagesApi.createThreadMessage(newMessage).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.thread.messages.push(response.data);
                    // this.messageAuthors.push(this.user);
                    this.hasMessages = true;
                    this.sharedService.growlTranslation('The message was successfully sent!', 'thread.message.success', 'success');
                } else {
                    this.sharedService.growlTranslation('An error occurred while trying to send the message. Please, try again later.', 'thread.message.error', 'error');
                }
                this.displayMessage = false;
            }, error => {
                this.sharedService.growlTranslation('An error occurred while trying to send the message. Please, try again later.', 'thread.message.error', 'error');
                this.displayMessage = false;
            }
        );
    }

    private askMediation() {
        this.mediationBlocked = true;
        this.showAlert = true;
        window.scrollTo(0, 0);
        this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
            (registrations: RegistrationDTOBase[]) => {
                for (let registration of registrations) {
                    registration.status = 0;
                    this.registrationApi.createRegistration(registration).subscribe(
                        (data: ResponseDTOBase) => {
                            if (data.success) {
                                this.sharedService.growlTranslation('Your request for mediation has been submited successfully. WIFI4EU mediation service will soon intervene in this conversation.', 'discussion.growl', 'success');
                            }
                        }, error => {
                            this.sharedService.growlTranslation('Your request for mediation could not be submited due to an error. Please, try again later.', 'discussion.growl.error', 'error');
                        }
                    );
                }
            }
        );
    }

    private deleteApplication() {
        this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
            (registrations: RegistrationDTOBase[]) => {
                let registrationCount = 0;
                for (let registration of registrations) {
                    registration.status = 1;
                    this.registrationApi.createRegistration(registration).subscribe(
                        (data: ResponseDTOBase) => {
                            if (data.success) {
                                registrationCount++;
                                if (registrationCount >= registrations.length) {
                                    this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'beneficiary.deleteApplication.Success', 'success');
                                    this.sharedService.logout();
                                    this.router.navigateByUrl('/home');
                                }
                            }
                        }, error => {
                            this.sharedService.growlTranslation('An error occurred and your applications could not be deleted.', 'beneficiary.deleteApplication.Failure', 'error');
                        }
                    );
                }
            }
        );
    }

    private editApplication() {
        this.router.navigateByUrl('/beneficiary-portal/profile');
    }

    private closeModal() {
        this.displayMessage = false;
        this.displayMediation = false;
    }

}
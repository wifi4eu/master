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
import {Router} from "@angular/router";

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [ThreadApi, BeneficiaryApi, ThreadmessagesApi, UserApi, RegistrationApi]
})

export class DiscussionComponent {
    private thread: ThreadDTOBase = new ThreadDTOBase();
    private municipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private municipalities: MunicipalityDTOBase[] = [];
    private user: UserDTOBase = new UserDTOBase();
    private users: UserDTOBase[] = [];
    private messageAuthors: UserDTOBase[] = [];
    private message: string = '';
    private displayMessage: boolean = false;
    private displayMediation: boolean = false;
    private mediationBlocked: boolean = false;
    private showAlert: boolean = false;

    constructor(private threadApi: ThreadApi, private beneficiaryApi: BeneficiaryApi, private threadMessagesApi: ThreadmessagesApi, private registrationApi: RegistrationApi, private userApi: UserApi, private localStorageService: LocalStorageService, private sharedService: SharedService, private router: Router) {
        this.thread.messages = [];
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            if (this.user.type == 2 || this.user.type == 3) {
                this.threadApi.getUserThreads(this.user.id).subscribe(
                    (threads: ThreadDTOBase[]) => {
                        this.thread = threads[0];
                        this.beneficiaryApi.getBeneficiariesByThreadId(this.thread.id).subscribe(
                            (beneficiaries: BeneficiaryDTOBase[]) => {
                                for (let beneficiary of beneficiaries) {
                                    for (let municipality of beneficiary.municipalities) {
                                        if (municipality.lauId == this.thread.lauId) {
                                            if (beneficiary.user.id == this.user.id) {
                                                this.municipality = municipality;
                                            } else {
                                                this.users.push(beneficiary.user);
                                                this.municipalities.push(municipality);
                                            }
                                        }
                                    }
                                }
                                for (let message of this.thread.messages) {
                                    if (message.authorId == this.user.id) {
                                        this.messageAuthors.push(this.user);
                                    } else {
                                        this.userApi.getUserById(message.authorId).subscribe(
                                            (user: UserDTOBase) => {
                                                this.messageAuthors.push(user);
                                            }
                                        );
                                    }
                                }
                            }, error => {
                                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later."', 'error.api.generic', 'warn');
                                this.router.navigateByUrl('/home');
                            }
                        );
                    }, error => {
                        this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later."', 'error.api.generic', 'warn');
                        this.router.navigateByUrl('/home');
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

    private newMessage() {
        this.displayMessage = true;
        this.message = '';
    }

    private sendMessage() {
        let newMessage = new ThreadMessageDTOBase();
        newMessage.createDate = new Date().getTime();
        newMessage.message = this.message;
        newMessage.authorId = this.user.id;
        newMessage.threadId = this.thread.id;
        this.threadMessagesApi.createThreadMessage(newMessage).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.thread.messages.push(response.data);
                    this.messageAuthors.push(this.user);
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
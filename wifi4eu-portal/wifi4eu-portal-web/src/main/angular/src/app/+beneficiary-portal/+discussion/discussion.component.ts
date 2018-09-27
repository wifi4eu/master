import {Component} from "@angular/core";
import {animate, style, transition, trigger} from "@angular/animations";
import {ActivatedRoute, Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {ThreadApi} from "../../shared/swagger/api/ThreadApi";
import {ThreadDTOBase} from "../../shared/swagger/model/ThreadDTO";
import {UserThreadsApi} from "../../shared/swagger/api/UserThreadsApi";
import {UserThreadsDTOBase} from "../../shared/swagger/model/UserThreadsDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {SharedService} from "../../shared/shared.service";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {ThreadmessagesApi} from "../../shared/swagger/api/ThreadmessagesApi";
import {ThreadMessageDTOBase} from "../../shared/swagger/model/ThreadMessageDTO";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {isEmpty} from "rxjs/operator/isEmpty";

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [ThreadApi, UserThreadsApi, RegistrationApi, MunicipalityApi, ThreadmessagesApi, UserApi],
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({opacity: 0}),
                    animate('200ms', style({opacity: 1}))
                ]),
                transition(':leave', [
                    style({opacity: 1}),
                    animate('200ms', style({opacity: 0}))
                ])
            ]
        )
    ]
})

export class DiscussionComponent {
    private user: UserDTOBase;
    private thread: ThreadDTOBase;
    private myRegistration: RegistrationDTOBase;
    private myMunicipality: MunicipalityDTOBase;
    private otherRegistrations: RegistrationDTOBase[] = [];
    private otherMunicipalities: MunicipalityDTOBase[] = [];
    private displayMessage: boolean = false;
    private displayMediation: boolean = false;
    private displayMediationAlert: boolean = false;
    private sendingMessage = false;
    private messageSentSuccess = false;
    private withdrawingRegistration: boolean = false;
    private withdrawnSuccess: boolean = false;
    private message: string = '';
    private municipalityName: String = "";

    constructor(private localStorageService: LocalStorageService, private route: ActivatedRoute, private threadApi: ThreadApi, private userThreadsApi: UserThreadsApi, private registrationApi: RegistrationApi, private municipalityApi: MunicipalityApi, private threadmessagesApi: ThreadmessagesApi, private userApi: UserApi, private sharedService: SharedService, private router: Router) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            if (this.user.type == 2 || this.user.type == 3) {
                let threadId;
                this.route.params.subscribe(params => threadId = params['threadId']);
                if (threadId != null) {
                    this.threadApi.getThreadById(threadId, new Date().getTime()).subscribe(
                        (thread: ThreadDTOBase) => {
                            if (thread != null) {
                                this.thread = thread;
                                this.userThreadsApi.getUserThreadsByThreadId(this.thread.id, new Date().getTime()).subscribe(
                                    (userThreads: UserThreadsDTOBase[]) => {
                                        let allowUser = false;
                                        if (userThreads.length > 1) {
                                            for (let userThread of userThreads) {
                                                if (userThread.userId == this.user.id) {
                                                    allowUser = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (allowUser) {
                                            for (let userThread of userThreads) {
                                                this.registrationApi.getRegistrationByUserThreadId(userThread.id).subscribe(
                                                    (registration: RegistrationDTOBase) => {
                                                        if (registration != null) {
                                                            this.municipalityApi.getMunicipalityThreadById(registration.municipalityId).subscribe(
                                                                (municipality: MunicipalityDTOBase) => {
                                                                    if (municipality != null) {
                                                                        if (userThread.userId == this.user.id) {
                                                                            this.myMunicipality = municipality;
                                                                            this.myRegistration = registration;
                                                                            this.municipalityName = this.myMunicipality.name;

                                                                        } else {
                                                                            this.otherMunicipalities.push(municipality);
                                                                            this.otherRegistrations.push(registration);
                                                                        }
                                                                    }
                                                                }
                                                            );
                                                        }
                                                    }
                                                );
                                            }
                                        } else {
                                            this.sharedService.growlTranslation('You are not allowed to view this page.', 'shared.error.notallowed', 'warn');
                                            this.router.navigateByUrl('/beneficiary-portal/profile');
                                        }
                                    }
                                );
                            }
                        }
                    );
                } else {
                    this.sharedService.growlTranslation('You are not allowed to view this page.', 'shared.error.notallowed', 'warn');
                    this.router.navigateByUrl('/beneficiary-portal/profile');
                }
            }
        } else {
            this.sharedService.growlTranslation('You are not allowed to view this page.', 'shared.error.notallowed', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    private editRegistration() {
        this.router.navigateByUrl('/beneficiary-portal/profile');
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

    private newMessage() {
        this.sendingMessage = false;
        this.displayMessage = true;
        this.displayMediation = false;
        this.message = '';
    }

    private sendMessage() {
        if (!this.sendingMessage) {
            this.sendingMessage = true;
            this.messageSentSuccess = false;
            let newMessage = new ThreadMessageDTOBase();
            newMessage.createDate = new Date().getTime();
            newMessage.message = this.message;
            newMessage.authorId = this.user.id;
            newMessage.threadId = this.thread.id;
            this.threadmessagesApi.createThreadMessage(newMessage).subscribe(
                (response: ResponseDTOBase) => {
                    if (response.success) {
                        this.thread.messages.push(response.data);
                        this.sharedService.growlTranslation('The message was successfully sent!', 'discussionForum.thread.message.success', 'success');
                        this.messageSentSuccess = true;
                        this.sendingMessage = false;
                    } else {
                        this.sharedService.growlTranslation('An error occurred while trying to send the message. Please, try again later.', 'discussionForum.thread.message.error', 'error');
                        this.messageSentSuccess = false;
                        this.sendingMessage = false;
                    }
                    this.displayMessage = false;
                }, error => {
                    this.sharedService.growlTranslation('An error occurred while trying to send the message. Please, try again later.', 'discussionForum.thread.message.error', 'error');
                    this.messageSentSuccess = false;
                    this.sendingMessage = false;
                    this.displayMessage = false;
                }
            );
        }
    }

    private closeModal() {
        this.sendingMessage = false;
        this.displayMessage = false;
        this.displayMediation = false;
    }

    //COMMENTED BY ORDER OF BERT 06/09/2018

    /*private askMediation() {
        this.displayMediationAlert = true;
        window.scrollTo(0, 0);
        this.threadApi.askMediationThread(this.thread.id).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.thread.mediation = true;
                    this.sharedService.growlTranslation('Your request for mediation has been submited successfully. WIFI4EU mediation service will soon intervene in this conversation.', 'discussionForum.discussion.growl', 'success');
                } else {
                    this.sharedService.growlTranslation('Your request for mediation could not be submited due to an error. Please, try again later.', 'discussionForum.discussion.growl.error', 'error');
                }
            },
            error => {
                this.sharedService.growlTranslation('Your request for mediation could not be submited due to an error. Please, try again later.', 'discussionForum.discussion.growl.error', 'error');
            }
        );
    }*/
}
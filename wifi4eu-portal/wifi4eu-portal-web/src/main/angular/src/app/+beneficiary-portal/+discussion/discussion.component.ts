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
import { trigger, style, animate, transition } from '@angular/animations';


@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [UserThreadsApi, ThreadApi, BeneficiaryApi, ThreadmessagesApi, UserApi, RegistrationApi, MunicipalityApi],
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
    private registrations: RegistrationDTOBase[] = [];
    private lauId: number;
    private threadId: number;
    private hasMessages: boolean = false;
    private hasAuthor: boolean = false;
    private counter: number = 0;

    private hasMediation: boolean = false;

    private isSendMessage: boolean = false;
    private isSendedMessage: boolean = false;

    constructor(private route: ActivatedRoute, private municipalityApi: MunicipalityApi, private threadApi: ThreadApi, private threadMessagesApi: ThreadmessagesApi, private registrationApi: RegistrationApi, private userApi: UserApi, private localStorageService: LocalStorageService, private sharedService: SharedService, private router: Router) {
        this.route.params.subscribe(params => this.threadId = params['threadId']);
        this.thread.messages = [];
        this.messageAuthors = [];
        this.hasAuthor = false;

        this.threadApi.getThreadById(this.threadId).subscribe(
            (thread: ThreadDTOBase) => {
                this.thread = thread;
                this.hasMediation = this.thread.mediation;
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
                    (registrations: RegistrationDTOBase[]) => {
                        this.registrations = registrations;
                        this.municipalityApi.getMunicipalityById(this.registrations[0].municipalityId).subscribe(
                            (municipality: MunicipalityDTOBase) => {
                                this.municipality = municipality;
                                this.lauId = this.municipality.lauId;
                                this.municipalityApi.getMunicipalitiesByLauId(this.lauId).subscribe(
                                    (municipalities: MunicipalityDTOBase[]) => {
                                        for (let i = 0; i < municipalities.length; i++) {
                                            if (this.municipality.id != municipalities[i].id) {
                                                this.registrationApi.getRegistrationByMunicipalityId(municipalities[i].id).subscribe(
                                                    (registration: RegistrationDTOBase) => {
                                                        if (registration) {
                                                            this.municipalities.push(municipalities[i]);
                                                            this.messageAuthors.push(registrations[0]);
                                                            this.counter++;
                                                            if (this.counter >= this.municipalities.length) {
                                                                this.hasAuthor = true;
                                                            }
                                                        }
                                                    }, error => {
                                                        console.log(error);
                                                    }
                                                );
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
                    }, error => {
                        console.log(error);
                    }
                );
            } else {
                this.sharedService.growlTranslation('You are not allowed to view this page.', 'shared.error.notallowed', 'warn');
                this.router.navigateByUrl('/home');
            }
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    private newMessage() {
        if(this.hasMediation){
          return;
        }
        this.isSendMessage = false;
        this.displayMessage = true;
        this.message = '';
    }

    private sendMessage() {
        if(this.hasMediation){
          return;
        }
        this.isSendMessage = true;
        let newMessage = new ThreadMessageDTOBase();
        newMessage.createDate = new Date().getTime();
        newMessage.message = this.message;
        newMessage.authorId = this.user.id;
        newMessage.threadId = this.threadId;
        this.isSendedMessage = false;
        this.threadMessagesApi.createThreadMessage(newMessage).subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.isSendedMessage = true;
                    this.thread.messages.push(response.data);
                    // this.messageAuthors.push(this.user);
                    this.hasMessages = true;
                    this.sharedService.growlTranslation('The message was successfully sent!', 'discussionForum.thread.message.success', 'success');
                } else { 
                    this.isSendedMessage = false;
                    this.sharedService.growlTranslation('An error occurred while trying to send the message. Please, try again later.', 'discussionForum.thread.message.error', 'error');
                }
                this.displayMessage = false;
            }, error => {
                this.sharedService.growlTranslation('An error occurred while trying to send the message. Please, try again later.', 'discussionForum.thread.message.error', 'error');
                this.displayMessage = false;
            }
        );
    }

    private askMediation() {
        this.mediationBlocked = true;
        this.showAlert = true;
        window.scrollTo(0, 0);
        if(this.hasMediation){
          return;
        }
        this.threadApi.askMediationThread(this.thread.id).subscribe(
          (response: ResponseDTOBase) => {
            if(response.success){
              this.hasMediation = response.data.mediation;
              if(response.data.mediation){
                this.sharedService.growlTranslation('Your request for mediation has been submited successfully. WIFI4EU mediation service will soon intervene in this conversation.', 'discussionForum.discussion.growl', 'success');
              }
            }
          },
          error => {
            this.sharedService.growlTranslation('Your request for mediation could not be submited due to an error. Please, try again later.', 'discussionForum.discussion.growl.error', 'error');
          }
        )
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
                                    this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.deleteApplication.Success', 'success');
                                    this.sharedService.logout();
                                    this.router.navigateByUrl('/home');
                                }
                            }
                        }, error => {
                            this.sharedService.growlTranslation('An error occurred and your applications could not be deleted.', 'benefPortal.beneficiary.deleteApplication.Failure', 'error');
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
      this.isSendMessage = false;
        this.displayMessage = false;
        this.displayMediation = false;
    }

}
import {Component} from "@angular/core";

import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {ThreadApi} from "../../shared/swagger/api/ThreadApi";
import {ThreadDTOBase} from "../../shared/swagger/model/ThreadDTO";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {ThreadMessageDTOBase} from "../../shared/swagger/model/ThreadMessageDTO";
import {ThreadmessagesApi} from "../../shared/swagger/api/ThreadmessagesApi";
import {ResponseDTO} from "../../shared/swagger/model/ResponseDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";


@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [UserApi, RegistrationApi, MunicipalityApi, ThreadApi, ThreadmessagesApi]
})
export class DiscussionComponent {
    private user: UserDTOBase = new UserDTOBase();
    private users: UserDTOBase[] = [];
    private municipality: MunicipalityDTOBase = new MunicipalityDTOBase();
    private registrations: RegistrationDTOBase[] = [];
    private thread: ThreadDTOBase = new ThreadDTOBase();
    private displayMessage: boolean = false;
    private displayMediation: boolean = false;
    private mediationButton: boolean = false;
    private showAlert: boolean = false;
    private message: string = "";


    constructor(private municipalityApi: MunicipalityApi, private registrationApi: RegistrationApi, private threadApi: ThreadApi, private threadMessagesApi: ThreadmessagesApi, private userApi: UserApi, private uxService: UxService) {
        this.thread.messages = [];
    }

    ngOnInit() {
        this.userApi.getUserById(100).subscribe(
            (user: UserDTOBase) => {
                this.user = user;
                this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                    (registrations: RegistrationDTOBase[]) => {
                        this.registrations = registrations;
                        for (let registration of registrations) {
                            this.userApi.getUserById(registration.userId).subscribe(
                                (user: UserDTOBase) => {
                                    this.users.push(user);
                                }, error5 => {
                                    console.log(error5);
                                }
                            );
                        }
                        this.municipalityApi.getMunicipalityById(registrations[0].municipalityId).subscribe(
                            (municipality: MunicipalityDTOBase) => {
                                this.municipality = municipality;
                                this.threadApi.getThreadByMunicipalityId(this.municipality.id).subscribe(
                                    (thread: ThreadDTOBase) => {
                                        this.thread = thread;
                                    }, error4 => {
                                        console.log(error4);
                                    }
                                );
                            }, error3 => {
                                console.log(error3);
                            }
                        );
                    }, error2 => {
                        console.log(error2);
                    }
                );
            }, error => {
                console.log(error);
            }
        );

    }

    newMessage() {
        this.displayMessage = true;
        this.message = "";
    }

    sendMessage() {
        let newMessage = new ThreadMessageDTOBase();
        newMessage.createDate = new Date().getTime();
        newMessage.message = this.message;
        newMessage.authorId = this.user.id;
        newMessage.threadId = this.thread.id;
        this.threadMessagesApi.createThreadMessage(newMessage).subscribe(
            (response: ResponseDTO) => {
                if (response.success) {
                    this.thread.messages.push(response.data);
                    this.uxService.growl({
                        severity: 'success',
                        summary: 'SUCCESS',
                        detail: 'The message was successfully sent!'
                    });
                } else {
                    this.uxService.growl({
                        severity: 'error',
                        summary: 'ERROR',
                        detail: 'The message could not be successfully sent.'
                    });
                }
                this.displayMessage = false;
            }, error => {
                console.log(error);
                this.uxService.growl({
                    severity: 'error',
                    summary: 'ERROR',
                    detail: 'Something went wrong while trying to send the message.'
                });
                this.displayMessage = false;
            }
        );
    }


    closeModal() {
        this.displayMessage = false;
        this.displayMediation = false;
    }

    newMediation() {
        this.displayMediation = true;
    }

    askMediation() {
        this.mediationButton = true;
        this.showAlert = true;
        window.scrollTo(0, 0)
    }

    displayAuthorData(authorId: number, field: string) {
        for (let user of this.users) {
            if (user.id = authorId) {
                return user[field];
            }
        }
    }

}
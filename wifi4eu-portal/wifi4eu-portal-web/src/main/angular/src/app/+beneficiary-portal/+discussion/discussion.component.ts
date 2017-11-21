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
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {LocalStorageService} from "angular-2-local-storage";
import {TranslateService} from "ng2-translate";
import {Router} from "@angular/router";


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


    constructor(private municipalityApi: MunicipalityApi, private registrationApi: RegistrationApi, private threadApi: ThreadApi, private threadMessagesApi: ThreadmessagesApi, private userApi: UserApi, private uxService: UxService, private localStorageService: LocalStorageService, private translateService: TranslateService, private router: Router) {
        this.thread.messages = [];
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            if (this.user.type == 2 || this.user.type == 3) {
                this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
                    (registrations: RegistrationDTOBase[]) => {
                        this.registrations = registrations;
                        for (let registration of registrations) {
                            this.userApi.getUserById(registration.userId).subscribe(
                                (user: UserDTOBase) => {
                                    this.users.push(user);
                                }, error => {
                                    console.log(error);
                                }
                            );
                        }
                        this.municipalityApi.getMunicipalityById(registrations[0].municipalityId).subscribe(
                            (municipality: MunicipalityDTOBase) => {
                                this.municipality = municipality;
                                this.threadApi.getThreadByLauId(this.municipality.lauId).subscribe(
                                    (thread: ThreadDTOBase) => {
                                        if (thread != null) {
                                            this.thread = thread;
                                        }
                                    }, error4 => {
                                        console.log(error4);
                                    }
                                );
                            }, error2 => {
                                console.log(error2);
                            }
                        );
                    }, error3 => {
                        console.log(error3);
                    }
                );
            } else {
                let translatedString = 'You are not allowed to view this page.';
                this.translateService.get('error.notallowed').subscribe(
                    (translation: string) => {
                        translatedString = translation;
                    }
                );
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: translatedString
                });
                this.router.navigateByUrl('/home');
            }
        } else {
            let translatedString = 'You are not logged in!';
            this.translateService.get('error.notloggedin').subscribe(
                (translation: string) => {
                    translatedString = translation;
                }
            );
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: translatedString
            });
            this.router.navigateByUrl('/home');
        }
    }

    private newMessage() {
        this.displayMessage = true;
        this.message = "";
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


    private closeModal() {
        this.displayMessage = false;
        this.displayMediation = false;
    }

    private askMediation() {
        this.mediationButton = true;
        this.showAlert = true;
        window.scrollTo(0, 0);
        this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
            (registrations: RegistrationDTOBase[]) => {
                for (let registration of registrations) {
                    registration.status = 0;
                    this.registrationApi.createRegistration(registration).subscribe(
                        (data: ResponseDTOBase) => {
                            if (data.success) {
                                let translatedString = 'Your request for mediation has been submited successfully. WIFI4EU mediation service will soon intervene in this conversation.';
                                this.translateService.get('discussion.growl').subscribe(
                                    (translation: string) => {
                                        translatedString = translation;
                                    }
                                );
                                this.uxService.growl({
                                    severity: 'success',
                                    summary: 'SUCCESS',
                                    detail: translatedString
                                });
                            }
                        }, error => {
                            let translatedString = 'Your request for mediation could not be submited due to an error. Please, try again later.';
                            this.translateService.get('discussion.growl.error').subscribe(
                                (translation: string) => {
                                    translatedString = translation;
                                }
                            );
                            this.uxService.growl({
                                severity: 'error',
                                summary: 'ERROR',
                                detail: translatedString
                            });
                        }
                    );
                }
            }
        );
    }

    private displayAuthorData(authorId: number, field: string) {
        for (let user of this.users) {
            if (user.id = authorId) {
                return user[field];
            }
        }
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
                                    let translatedString = 'Your applications were succesfully deleted.';
                                    this.translateService.get('beneficiary.deleteApplication.Success').subscribe(
                                        (translation: string) => {
                                            translatedString = translation;
                                        }
                                    );
                                    this.uxService.growl({
                                        severity: 'success',
                                        summary: 'SUCCESS',
                                        detail: translatedString
                                    });
                                }
                            }
                        }, error => {
                            let translatedString = 'Your applications were succesfully deleted.';
                            this.translateService.get('beneficiary.deleteApplication.Failure').subscribe(
                                (translation: string) => {
                                    translatedString = translation;
                                }
                            );
                            this.uxService.growl({
                                severity: 'error',
                                summary: 'ERROR',
                                detail: translatedString
                            });
                        }
                    );
                }
            }
        );
    }
}
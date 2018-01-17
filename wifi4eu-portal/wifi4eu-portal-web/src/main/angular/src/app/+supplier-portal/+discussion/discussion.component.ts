import {Component} from "@angular/core";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {ThreadApi} from "../../shared/swagger/api/ThreadApi";
import {ThreadmessagesApi} from "../../shared/swagger/api/ThreadmessagesApi";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {RegistrationApi} from "../../shared/swagger/api/RegistrationApi";
import {ThreadDTOBase} from "../../shared/swagger/model/ThreadDTO";
import {ThreadMessageDTOBase} from "../../shared/swagger/model/ThreadMessageDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {RegistrationDTOBase} from "../../shared/swagger/model/RegistrationDTO";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {SharedService} from "../../shared/shared.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserThreadsApi} from "../../shared/swagger/api/UserThreadsApi";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {UserThreadsDTOBase} from "../../shared/swagger/model/UserThreadsDTO";

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [UserThreadsApi, ThreadApi, ThreadmessagesApi, UserApi, RegistrationApi, SupplierApi]
})

export class DiscussionComponent {
    private thread: ThreadDTOBase = new ThreadDTOBase();
    private suppliers: SupplierDTOBase[] = [];
    private ownSupplier: SupplierDTOBase = new SupplierDTOBase();
    private user: UserDTOBase = new UserDTOBase();
    private messageAuthors: RegistrationDTOBase[] = [];
    private message: string = '';
    private displayMessage: boolean = false;
    private displayMediation: boolean = false;
    private mediationBlocked: boolean = false;
    private showAlert: boolean = false;
    private threadId: number;
    private hasMessages: boolean = false;
    private hasAuthor: boolean = false;
    private counter: number = 1;
    private userThreads: UserThreadsDTOBase [] = [];
    private otherSuppliers: SupplierDTOBase [] = [];


    constructor(private userThreadsApi: UserThreadsApi, private supplierApi: SupplierApi, private route: ActivatedRoute, private threadApi: ThreadApi, private threadMessagesApi: ThreadmessagesApi, private registrationApi: RegistrationApi, private localStorageService: LocalStorageService, private sharedService: SharedService, private router: Router) {

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
            if (this.user.type == 1) {
                /*GET DATA FROM API TO PRINT ON HTML*/
                this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
                    (mySupplier: SupplierDTOBase) => {
                        this.ownSupplier = mySupplier;

                    }, error => {
                        console.log(error);
                    }
                );

                this.userThreadsApi.getUsersByThreadId(this.threadId).subscribe(
                    (userThread: UserThreadsDTOBase[]) => {
                        for (var i = 0; i < userThread.length; i++) {
                            this.userThreads = userThread;
                            this.supplierApi.getSupplierByUserId(this.userThreads[i].userId).subscribe(
                                (suppliers: SupplierDTOBase) => {
                                    if (this.user.id != suppliers.userId) {
                                        this.otherSuppliers.push(suppliers);
                                        console.log(this.otherSuppliers);
                                        this.counter++;
                                        if (this.counter >= this.userThreads.length) {
                                            this.hasAuthor = true;
                                        }
                                    }
                                }, error => {
                                    console.log(error);
                                }
                            );
                        }
                        console.log(this.userThreads);
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
                    this.sharedService.growlTranslation('The message was successfully sent!', 'discussionForum.thread.message.success', 'success');
                } else {
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
        this.registrationApi.getRegistrationsByUserId(this.user.id).subscribe(
            (registrations: RegistrationDTOBase[]) => {
                for (let registration of registrations) {
                    registration.status = 0;
                    this.registrationApi.createRegistration(registration).subscribe(
                        (data: ResponseDTOBase) => {
                            if (data.success) {
                                this.sharedService.growlTranslation('Your request for mediation has been submited successfully. WIFI4EU mediation service will soon intervene in this conversation.', 'discussionForum.discussion.growl', 'success');
                            }
                        }, error => {
                            this.sharedService.growlTranslation('Your request for mediation could not be submited due to an error. Please, try again later.', 'discussionForum.discussion.growl.error', 'error');
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
        this.displayMessage = false;
        this.displayMediation = false;
    }

}
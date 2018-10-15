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
import { trigger, style, animate, transition } from '@angular/animations';

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [UserThreadsApi, ThreadApi, ThreadmessagesApi, UserApi, RegistrationApi, SupplierApi, UserApi],
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

    private hasMediation: boolean = false;

    private isSendMessage: boolean = false;
    private isSendedMessage: boolean = false;

    constructor(private userThreadsApi: UserThreadsApi, private supplierApi: SupplierApi, private route: ActivatedRoute, private threadApi: ThreadApi, private threadMessagesApi: ThreadmessagesApi, private registrationApi: RegistrationApi, private userApi: UserApi, private localStorageService: LocalStorageService, private sharedService: SharedService, private router: Router) {

        this.route.params.subscribe(params => this.threadId = params['threadId']);

        this.thread.messages = [];
        this.hasAuthor = false;


        this.threadApi.getThreadById(this.threadId).subscribe(
            (thread : ThreadDTOBase) => {
                this.thread = thread;
                this.hasMediation = thread.mediation;
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
                this.supplierApi.getSupplierByUserId(this.user.id, new Date().getTime()).subscribe(
                    (mySupplier: SupplierDTOBase) => {
                        this.ownSupplier = mySupplier;

                    }, error => {
                        console.log(error);
                    }
                );

                this.userThreadsApi.getUserThreadsByThreadId(this.threadId).subscribe(
                    (userThread: UserThreadsDTOBase[]) => {
                        for (var i = 0; i < userThread.length; i++) {
                            this.userThreads = userThread;
                            this.supplierApi.getSupplierByUserId(this.userThreads[i].userId, new Date().getTime()).subscribe(
                                (suppliers: SupplierDTOBase) => {
                                    this.supplierApi.getUserIdFromSupplier(this.ownSupplier.id).subscribe(
                                        (supplierId : number) =>{
                                            for(let i = 0 ; i < suppliers; i++){
                                                if(supplierId == suppliers[i].id){
                                                    this.otherSuppliers.push(suppliers);
                                                    console.log(this.otherSuppliers);
                                                    this.counter++;
                                                    if (this.counter >= this.userThreads.length) {
                                                        this.hasAuthor = true;
                                                    }
                                                }
                                            }
                                        }, error=>{
                                            console.log(error);
                                            
                                        }


                                    );
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

    //COMMENTED BY ORDER OF BERT 06/09/2018

    /*private askMediation() {
        this.mediationBlocked = true;
        this.showAlert = true;
        window.scrollTo(0, 0);
        if(this.hasMediation){
          return;
        }
        this.threadApi.askMediationThread(this.thread.id).subscribe(
          (response: ResponseDTOBase) => {
            if(response.success){
              console.log(response.success);
              this.hasMediation = response.data.mediation;
              if(response.data.mediation){
                this.sharedService.growlTranslation('Your request for mediation has been submited successfully. WIFI4EU mediation service will soon intervene in this conversation.', 'discussionForum.discussionForum.discussion.growl', 'success');              }
            }
          },
          error => {
            this.sharedService.growlTranslation('Your request for mediation could not be submited due to an error. Please, try again later.', 'discussionForum.discussion.growl.error', 'error');          }
        )
    }*/

    private editRegistration() {
        this.router.navigateByUrl('/supplier-portal/profile');
    }

    private withdrawRegistration() {
        this.userApi.deleteUser(this.user.id).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.sharedService.growlTranslation('Your applications were succesfully deleted.', 'benefPortal.beneficiary.withdrawRegistration.Success', 'success');
                    this.sharedService.logout();
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred an your applications could not be deleted.', 'benefPortal.beneficiary.withdrawRegistration.Failure', 'error');
            }
        );
    }

    //COMMENTED BY ORDER OF BERT 06/09/2018

    /*private closeModal() {
        this.isSendMessage = false;
        this.displayMessage = false;
        this.displayMediation = false;
    }*/

}
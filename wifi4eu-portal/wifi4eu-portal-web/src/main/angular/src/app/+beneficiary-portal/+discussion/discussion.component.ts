import {Component, Input} from "@angular/core";

import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {LauApi} from "app/shared/swagger";
import {RepresentationApi} from "../../shared/swagger/api/RepresentationApi";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MayorApi} from "app/shared/swagger/api/MayorApi";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {ThreadApi} from "../../shared/swagger/api/ThreadApi";
import {ThreadDTOBase} from "../../shared/swagger/model/ThreadDTO";
import {ThreadmessagesApi} from "../../shared/swagger/api/ThreadmessagesApi";
import {ThreadMessageDTOBase} from "../../shared/swagger/model/ThreadMessageDTO";


@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [MunicipalityApi, LauApi, RepresentationApi, MayorApi, ThreadApi, ThreadmessagesApi]
})
export class DiscussionComponent {
    private displayMessage: boolean;
    private showAccordion: boolean;
    private message: string;
    private subject: string;
    private messageList: string[];
    private representationList: any[];
    private displayMediation: boolean;
    private municipality: MunicipalityDTOBase;
    private mayor: MayorDTOBase;
    private lau: LauDTOBase;
    private mediationButton: boolean;
    private showAlert: boolean;
    private thread: any [];
    private messagesOnDB: ThreadMessageDTOBase;

    constructor(private municipalityApi: MunicipalityApi, private lauApi: LauApi, private representationApi: RepresentationApi, private mayorApi: MayorApi, private threadmessagesApi: ThreadmessagesApi, private threadApi: ThreadApi) {
        this.municipality = new MunicipalityDTOBase();
        this.displayMessage = false;
        this.message = "";
        this.subject = "";
        this.messageList = [];
        this.displayMediation = false;
        this.showAccordion = false;
        this.mediationButton = false;
        this.representationList = [];
        this.mayor = new MayorDTOBase();
        this.thread = [];

        this.lau = new LauDTOBase();
        this.showAlert = false;
    }

    ngOnInit() {
        this.municipalityApi.getMunicipalityById(10).subscribe(
            data => {
                this.municipality = data;

                this.threadApi.getThreadBymMunicipalityId(this.municipality.id).subscribe(
                    thread => {
                        this.thread = thread;
                        for (let i = 0; i < this.thread.length; i++) {
                            this.threadmessagesApi.getThreadMessageById(this.thread[i].id).subscribe(
                                threadMessages => {
                                    this.messagesOnDB = threadMessages;
                                    console.log("THREAD MESSAGES::::::::::", threadMessages);

                                }, error5 => {
                                    console.log(error5);
                                }
                            );

                        }
                    }, error4 => {
                        console.log(error4);
                    }
                );

                this.representationApi.getRepresentationByMunicipalityId(this.municipality.id).subscribe(
                    representation => {
                        this.representationList = representation;

                        for (let i = 0; i < this.representationList.length; i++) {
                            this.mayorApi.getMayorById(this.representationList[i].mayorId).subscribe(
                                mayor => {
                                    this.mayor = mayor;

                                }, error3 => {
                                    console.log(error3);
                                }
                            );
                        }
                    }
                    ,
                    error2 => {
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
        this.messageList.push(this.message);
        this.displayMessage = false;
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

}
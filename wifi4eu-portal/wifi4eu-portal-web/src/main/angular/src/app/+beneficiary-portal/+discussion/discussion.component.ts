import {Component} from "@angular/core";
import {ThreadDTOBase} from "../../shared/swagger/model/ThreadDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {LauApi} from "app/shared/swagger";
import {RepresentationApi} from "../../shared/swagger/api/RepresentationApi";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {MayorApi} from "app/shared/swagger/api/MayorApi";
import {RepresentationDTOBase} from "../../shared/swagger/model/RepresentationDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";

@Component({
    selector: 'discussion-component',
    templateUrl: 'discussion.component.html',
    providers: [MunicipalityApi, LauApi, RepresentationApi, MayorApi]
})
export class DiscussionComponent {
    private displayMessage: boolean;
    private showAccordion: boolean;
    // private representation: RepresentationDTOBase;
    private user: UserDTOBase;
    private message: string;
    private subject: string;
    private messageList: string[];
    private displayMediation: boolean;
    private thread: ThreadDTOBase;
    private municipality: MunicipalityDTOBase;
    private mayor: MayorDTOBase;
    private lau: LauDTOBase;
    private mediationButton: boolean;
    private showAlert: boolean;

    private postalCode: string;
    private number: string;


    constructor(private municipalityApi: MunicipalityApi, private lauApi: LauApi, private representationApi: RepresentationApi, private mayorApi: MayorApi) {
        this.displayMessage = false;
        this.message = "";
        this.subject = "";
        this.messageList = [];
        this.displayMediation = false;
        this.showAccordion = false;
        this.mediationButton = false;

        // this.thread.municipalityId

        this.municipality = new MunicipalityDTOBase();
        this.municipality.lauId = 1;
        this.municipality.address = "Diagonal";

        this.mayor = new MayorDTOBase();
        this.mayor.name = "John";
        this.mayor.surname = "Smith";

        this.lau = new LauDTOBase();
        this.lau.name1 = "Barcelona";
        this.lau.countryCode = "Spain";

        this.postalCode = "08022";
        this.number = "605";

        this.showAlert = false;


        /*
        this.municipalityApi.getMunicipalityById(2).subscribe(
            data => {
                this.municipality = data;
                this.representationApi.getRepresentationByMayorId(2).subscribe(
                    representation => {
                        this.representation = representation;
                        this.mayorApi.getMayorById(this.representation.mayorId).subscribe(
                            mayor => {
                                this.mayor = mayor;
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
        */
    }

    newMessage() {
        this.displayMessage = true;
        this.message = "";
        this.subject = "";
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
import {Component, Input, EventEmitter, OnInit, Output} from "@angular/core";
import {SharedService} from "../../shared/shared.service";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {VoucherManagementDTO} from "../../shared/swagger/model/VoucherManagementDTO";
import {CallDTO} from "../../shared/swagger/model/CallDTO";
import {MunicipalityApi} from "../../shared/swagger/api/MunicipalityApi";
import {ResponseDTOBase} from "../../shared/swagger/model/ResponseDTO";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";

@Component({
    templateUrl: 'voucher.component.html', providers: [CallApi, MunicipalityApi, ApplicationApi]
})

export class DgConnVoucherComponent {
    private calls: CallDTO[];
    private municipalities: number;
    private applications: number;
    private displayMessage: boolean = false;

    constructor(private municipalityApi: MunicipalityApi, private callApi: CallApi, private applicationApi: ApplicationApi) {
        this.municipalityApi.getMunicipalitiesCountGroupedByLauId().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.municipalities = response.data.length;
                }
            }, error => {
                console.log(error);
            }
        );
        this.callApi.allCalls().subscribe(
            calls => {
                this.calls = calls;
                console.log(this.calls[0].voucherManagements[0]);
            },
            error => console.log(error)
        );
        this.applicationApi.allApplications().subscribe(
            applications => {
                this.applications = applications.length;

            }, error => {
                console.log(error);
            }
        );

    }

    displayInfo() {
        this.displayMessage = true;
    }


}
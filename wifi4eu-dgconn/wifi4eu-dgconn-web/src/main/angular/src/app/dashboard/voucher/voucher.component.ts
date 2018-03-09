import {Component} from "@angular/core";
import {CallApi} from "../../shared/swagger/api/CallApi";
import {CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {ApplicationApi} from "../../shared/swagger/api/ApplicationApi";
import {ApplicationVoucherInfoDTOBase} from "../../shared/swagger/model/ApplicationVoucherInfoDTO";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";

@Component({
    templateUrl: 'voucher.component.html', providers: [CallApi, ApplicationApi, NutsApi]
})

export class DgConnVoucherComponent {
    private calls: CallDTOBase[] = [];
    private applicationsInfo: ApplicationVoucherInfoDTOBase[][] = [];
    private shownApplicationsInfo: ApplicationVoucherInfoDTOBase[] = [];
    private countries: NutsDTOBase[] = [];
    private chosenCountry: string = null;
    private totalRequests: number = 0;
    private displayMessage: boolean = false;

    constructor(private callApi: CallApi, private applicationApi: ApplicationApi, private nutsApi: NutsApi) {
        this.callApi.allCalls().subscribe(
            (calls: CallDTOBase[]) => {
                this.calls = calls;
                for (let call of this.calls) {
                    this.applicationsInfo[call.id] = [];
                    this.applicationApi.getApplicationsVoucherInfoByCall(call.id).subscribe(
                        (info: ApplicationVoucherInfoDTOBase[]) => {
                            if (info != null) {
                                this.applicationsInfo[call.id] = info;
                                this.totalRequests += info.length;
                                for (let item of info) {
                                    this.shownApplicationsInfo.push(item);
                                }
                            }
                        }
                    );
                }
            }
        );
        this.nutsApi.getNutsByLevel(0).subscribe(
            (countries: NutsDTOBase[]) => {
                this.countries = countries;
            }
        );
    }

    private displayInfo() {
        this.displayMessage = true;
    }

    private chooseCountryApplicationsInfo() {
        this.shownApplicationsInfo = [];
        for (let call of this.applicationsInfo) {
            if (call != null) {
                for (let application of call) {
                    if (this.chosenCountry != null && this.chosenCountry != "-") {
                        if (application.countryName.toLowerCase() == this.chosenCountry.toLowerCase()) {
                            this.shownApplicationsInfo.push(application);
                        }
                    } else {
                        this.shownApplicationsInfo.push(application);
                    }
                }
            }
        }
    }
}
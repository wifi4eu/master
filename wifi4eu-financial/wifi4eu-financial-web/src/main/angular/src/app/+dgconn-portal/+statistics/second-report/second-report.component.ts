import {Component} from "@angular/core";
import {LegalEntityDTO} from "../../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";
import {HelpdeskApi} from "../../../shared/swagger/api/HelpdeskApi";
import {HelpdeskIssueDTO} from "../../../shared/swagger/model/HelpdeskIssueDTO";
import {setFlagsFromString} from "v8";

@Component({templateUrl: 'second-report.component.html', providers: [HelpdeskApi]})
export class DgConnSecondReportComponent {
    private helpdeskIssues: HelpdeskIssueDTO[];
    private dataReady: boolean = false;
    private totalIssues: Array<any> = [];
    private pendingIssueArray: Array<any> = [];


    public lineChartData: Array<any> = [];
    public lineChartLabels: Array<any> = [];
    public lineChartType: string = 'line';
    public tableData;


    // events
    public chartClicked(e: any): void {
        console.log(e);
    }

    public chartHovered(e: any): void {
        console.log(e);
    }


    constructor(private helpdeskApi: HelpdeskApi) {
        this.lineChartLabels = [];
        this.totalIssues = [];
        this.pendingIssueArray = [];
        this.getHelpdesk();
        this.tableData = [];
    }

    getHelpdesk() {
        this.helpdeskApi.allHelpdeskIssues().subscribe(
            data => {
                this.helpdeskIssues = data;
                let countriesCountArray = [];
                let pendingCountArray = [];
                this.helpdeskIssues.forEach((helpdesk: HelpdeskIssueDTO) => {
                    if (countriesCountArray[helpdesk.memberState]) {
                        countriesCountArray[helpdesk.memberState] += 1;
                        //if (helpdesk.status == "Pending") {
                            //pendingCountArray[helpdesk.memberState] += 1;
                        //}
                    }
                    else {
                        countriesCountArray[helpdesk.memberState] = 1
                        pendingCountArray[helpdesk.memberState] = 0;
                        //if (helpdesk.status == "Pending") {
                            //pendingCountArray[helpdesk.memberState] = 1;
                        //}
                    }
                });


                for (let countryInfo in countriesCountArray) {
                    this.lineChartLabels.push(countryInfo);
                    this.totalIssues.push(countriesCountArray[countryInfo]);
                    this.pendingIssueArray.push(pendingCountArray[countryInfo]);
                    let total = {data: this.totalIssues, label: 'Total Issues'};
                    let pending = {data: this.pendingIssueArray, label: 'Pending Issues'};
                    this.lineChartData = [total, pending];
                    let item = {
                        label: countryInfo,
                        pending: pendingCountArray[countryInfo],
                        value: countriesCountArray[countryInfo]
                    };
                    this.tableData.push(item);
                }
                this.dataReady = true;
            },

            error => {
                error => console.log(error);
            }
        );
    }
}




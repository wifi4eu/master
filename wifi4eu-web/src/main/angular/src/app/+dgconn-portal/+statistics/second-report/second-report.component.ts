import {Component} from "@angular/core";
import {LegalEntityDTO} from "../../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";
import {HelpdeskApi} from "../../../shared/swagger/api/HelpdeskApi";
import {HelpdeskDTO} from "../../../shared/swagger/model/HelpdeskDTO";

@Component({templateUrl: 'second-report.component.html', providers: [HelpdeskApi]})
export class DgConnSecondReportComponent {
    // Doughnut
    public doughnutChartLabels: string[] = [];
    public doughnutChartData: number[] = [];
    public doughnutChartType: string = 'doughnut';
    private helpdeskIssues: HelpdeskDTO[];
    private dataReady: boolean = false;

    // events
    public chartClicked(e: any): void {
        console.log(e);
    }

    public chartHovered(e: any): void {
        console.log(e);
    }

    constructor(private helpdeskApi: HelpdeskApi) {
        this.getHelpdesk()
    }

    getHelpdesk() {
        this.helpdeskApi.allHelpdeskIssues().subscribe(
            data => {
                this.helpdeskIssues = data;
                let countriesCountArray = [];
                this.helpdeskIssues.forEach((helpdesk: HelpdeskDTO) => {
                    if (countriesCountArray[helpdesk.memberState]) {
                        countriesCountArray[helpdesk.memberState] += 1;
                    }
                    else {
                        countriesCountArray[helpdesk.memberState] = 1
                    }
                })
                for (let countryInfo in countriesCountArray) {
                    this.doughnutChartLabels.push(countryInfo);
                    this.doughnutChartData.push(countriesCountArray[countryInfo])
                }
                this.dataReady = true;
            },


            error => {
                error => console.log(error);
            }
        );
    }

}



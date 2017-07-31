import {Component} from "@angular/core";
import {LegalEntityDTO} from "../../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";

@Component({templateUrl: 'first-report.component.html', providers: [BeneficiaryApi]})
export class DgConnFirstReportComponent {
    // Doughnut
    public doughnutChartLabels: string[] = [];
    public doughnutChartData: number[] = [];
    public doughnutChartType: string = 'doughnut';
    private legalEntities: LegalEntityDTO[];
    private dataReady: boolean = false;
    public tableData;

    // events
    public chartClicked(e: any): void {
        console.log(e);
    }

    public chartHovered(e: any): void {
        console.log(e);
    }

    constructor(private beneficiaryApi: BeneficiaryApi) {
        this.getLegalEntities();
    }


    getLegalEntities() {
        this.beneficiaryApi.getLegalEntities().subscribe(
            data => {
                this.legalEntities = data;
                let countriesCountArray = [];
                this.legalEntities.forEach((legalEntity: LegalEntityDTO) => {
                    if (countriesCountArray[legalEntity.countryCode]) {
                        countriesCountArray[legalEntity.countryCode] += 1;
                    }
                    else {
                        countriesCountArray[legalEntity.countryCode] = 1;
                    }
                });
                this.tableData = [];
                for (let countryInfo in countriesCountArray) {
                    this.doughnutChartLabels.push(countryInfo);
                    this.doughnutChartData.push(countriesCountArray[countryInfo]);
                    let item = {
                        label: countryInfo,
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



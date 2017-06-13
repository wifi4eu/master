import {Component} from "@angular/core";
import {LegalEntityDTO} from "../../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";

@Component({templateUrl: 'fourth-report.component.html', providers: [BeneficiaryApi]})
export class DgConnFourthReportComponent {
    // Doughnut
    public doughnutChartLabels: string[] = [];
    public doughnutChartData: number[] = [];
    public doughnutChartType: string = 'doughnut';
    private dataReady: boolean = false;
    private legalEntities: LegalEntityDTO[];

    // events
    public chartClicked(e: any): void {
        console.log(e);
    }

    public chartHovered(e: any): void {
        console.log(e);
    }

    constructor(private beneficiaryApi: BeneficiaryApi) {
        this.getAwardedMunicipalities();
    }

    getAwardedMunicipalities() {
        this.beneficiaryApi.getAwardedMunicipalities().subscribe(
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

                for (let countryInfo in countriesCountArray) {
                    this.doughnutChartLabels.push(countryInfo);
                    this.doughnutChartData.push(countriesCountArray[countryInfo]);
                }
                this.dataReady = true;
            },
            error => {
                error => console.log(error);
            }
        )
    }
}
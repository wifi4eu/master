/**
 * Created by lviverof on 14/06/2017.
 */
import {Component} from "@angular/core";
import {LegalEntityDTO} from "../../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../../shared/swagger/api/BeneficiaryApi";

@Component({templateUrl: 'fourth-report.component.html', providers: [BeneficiaryApi]})
export class DgConnFourthReportComponent {
    // Doughnut
    public doughnutChartLabels: string[] = [];
    public doughnutChartData: number[] = [];
    public doughnutChartType: string = 'doughnut';
    private legalEntities: LegalEntityDTO[];
    private dataReady: boolean = false;

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
        );
    }
}



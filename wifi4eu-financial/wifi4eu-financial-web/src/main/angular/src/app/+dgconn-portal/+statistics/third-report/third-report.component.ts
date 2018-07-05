import {Component} from "@angular/core";
import {SupplierApi} from "../../../shared/swagger/api/SupplierApi";
import {SupplierDTO} from "../../../shared/swagger/model/SupplierDTO";
import {splitAtColon} from "@angular/compiler/src/util";
import {forEach} from "@angular/router/src/utils/collection";


@Component({templateUrl: 'third-report.component.html', providers: [SupplierApi]})
export class DgConnThirdReportComponent {
    // Doughnut
    public doughnutChartLabels: string[] = [];
    public doughnutChartData: number[] = [];
    public doughnutChartType: string = 'doughnut';
    private suppliers: SupplierDTO[];
    private dataReady: boolean = false;
    public tableData;


    // events
    public chartClicked(e: any): void {
        console.log(e);
    }

    public chartHovered(e: any): void {
        console.log(e);
    }

    constructor(private supplierApi: SupplierApi) {
        this.getAllSuppliers();
        this.tableData = [];
    }

    getAllSuppliers() {

        this.supplierApi.allSuppliers().subscribe(
            data => {
                let countriesCountArray = [];
                this.suppliers = data;

                this.suppliers.forEach((supplier: SupplierDTO) => {

                    //let nutsIds = supplier.nutsIds;
                    //if (nutsIds && nutsIds.length > 0 && nutsIds.includes(";")) {
                        //let r = nutsIds.split(';');
                        //let labels = r[0].split(',');
                        //for (let i = 0; i < labels.length; i++) {

                            //if (countriesCountArray[labels[i]]) {
                              //  countriesCountArray[labels[i]] += 1;
                            //} else {
                                //countriesCountArray[labels[i]] = 1;
                            //}
                        //}
                    //}
                });

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

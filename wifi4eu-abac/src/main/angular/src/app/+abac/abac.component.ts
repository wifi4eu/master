import {Component} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';
import {FinancialApi} from "../shared/swagger/api/FinancialApi";
import {ExportImportApi} from "../shared/swagger/api/ExportImportApi";
import {SharedService} from "../shared/shared.service";
import {CallApi} from "../shared/swagger/api/CallApi";
import {ResponseDTO} from "../shared/swagger/model/ResponseDTO";
import {TranslateService} from "ng2-translate";


@Component({
    templateUrl: './abac.component.html',
    providers: [CallApi, FinancialApi, ExportImportApi]
})
export class AbacComponent {
    private exportEnabled: boolean;
    private jsonFile: File;

    constructor(private http: Http, private financialApi: FinancialApi, private exportImportApi: ExportImportApi, private sharedService: SharedService, private translateService: TranslateService) {
        this.exportEnabled = false;
    }

    importLegalEntityF(event) {
            this.exportEnabled = false;
            if (event && event.target && event.target.files && event.target.files.length == 1) {
                this.jsonFile = event.target.files['0'];
                let reader = new FileReader();
                reader.onload = (e) => {
                     var myWindow =window.open("http://localhost:7001/wifi4eu-financial/alertImport.jsp","mywindow","status=1,width=350,height=150");
                    //var myWindow =window.open("http://wlts0275.cc.cec.eu.int:1043/wifi4eu-financial/alertImport.jsp","mywindow","status=1,width=350,height=150");
                    this.exportImportApi.importLegalEntityF(reader.result).subscribe(
                        (response: ResponseDTO) => {
                            if (response.success) {
                                this.exportEnabled = true;
                                //this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                                //this.translateService.get("dgconn.dashboard.card.messageImport").subscribe(
                                myWindow.close();
                                window.alert("Import succesful!");
                                this.exportLegalEntityFBCValidate();
                            } else {
                                myWindow.close();
                                window.alert("Import failed!");
                            }
                        }, error => {
                            console.log(error);
                            myWindow.close();
                            window.alert("Import failed! Make sure that the file you are uploading has the correct format.");
                        }
                    );
                }
                reader.readAsText(this.jsonFile);
                //reader.readAsBinaryString(this.excelFile);

            }
    }

    importBudgetaryCommitment(event) {
        this.exportEnabled = false;
        if (event && event.target && event.target.files && event.target.files.length == 1) {
            this.jsonFile = event.target.files['0'];
            let reader = new FileReader();
            reader.onload = (e) => {
                var myWindow =window.open("http://localhost:7001/wifi4eu-financial/alertImport.jsp","mywindow","status=1,width=350,height=150");
                //var myWindow =window.open("http://wlts0275.cc.cec.eu.int:1043/wifi4eu-financial/alertImport.jsp","mywindow","status=1,width=350,height=150");
                this.exportImportApi.importBudgetaryCommitment(reader.result).subscribe(
                    (response: ResponseDTO) => {
                        if (response.success) {
                            this.exportEnabled = true;
                            //this.sharedService.growlTranslation("Your file have been imported correctly!", "dgconn.dashboard.card.messageImport", "success");
                            //this.translateService.get("dgconn.dashboard.card.messageImport").subscribe(
                            myWindow.close();
                            window.alert("Import succesful!");
                        } else {
                            myWindow.close();
                            window.alert("Import failed!");
                        }
                    }, error => {
                        console.log(error);
                        myWindow.close();
                        window.alert("Import failed! Make sure that the file you are uploading has the correct format.");
                    }
                );
            }
            reader.readAsText(this.jsonFile);
            //reader.readAsBinaryString(this.excelFile);
        }
    }

    exportLegalEntityFBCValidate() {
            var myWindow =window.open("http://localhost:7001/wifi4eu-financial/alertExport.jsp","mywindow","status=1,width=350,height=150");
            //var myWindow =window.open("http://wlts0275.cc.cec.eu.int:1043/wifi4eu-financial/alertExport.jsp","mywindow","status=1,width=350,height=150");
            this.exportImportApi.exportLegalEntityFBCValidate().subscribe(
                (response: ResponseDTO) => {
                    if (response.success) {
                        let blob = new Blob([response.data], {type: 'application/json'});
                        FileSaver.saveAs(blob, "ExportLefValidate.json");
                        myWindow.close();
                        window.alert("Export succesful!");
                    } else {
                        myWindow.close();
                        window.alert("Export failed!");
                    }
                }, error => {
                    console.log(error);
                    myWindow.close();
                    window.alert("Something went wrong.");
                }
            );
    }


    /*exportJson() {
        this.financialApi.exportAbacInformation().subscribe(
            (response: ResponseDTO) => {
                if (response.success) {
                    let blob = new Blob([response.data], {type: 'application/json'});
                    FileSaver.saveAs(blob, "financial_abac_export.json");
                    window.alert("Export succesful!");
                } else {
                    //window.alert("Export failed!");
                }
            }, error => {
                console.log(error);
                window.alert("Something went wrong.");
            }
        );
    }

    onFileSelection(event) {
        this.exportEnabled = false;
        if (event && event.target && event.target.files && event.target.files.length == 1) {
            this.jsonFile = event.target.files['0'];
            let reader = new FileReader();
            debugger;
            reader.onload = (e) => {
                this.financialApi.importAbacInformation(reader.result).subscribe(
                    (response: ResponseDTO) => {
                        if (response.success) {
                            this.exportEnabled = true;
                            window.alert("Import succesful!");
                        } else {
                            window.alert("Import failed!");
                        }
                    }, error => {
                        console.log(error);
                        window.alert("Import failed! Make sure that the file you are uploading has the correct format.");
                    }
                );
            };
            reader.readAsText(this.jsonFile);
        }
    }*/

    /*leSearch() {
        this.financialApi.leSearch().subscribe(
            (response: ResponseDTO) => {
                if (response.success) {
                    window.alert("LE Search OK!");
                } else {
                    window.alert("KO!");
                }
                console.log(response);
            }, error => {
                console.log(error);
                window.alert("");
            }
        )

    }

    bcSearch() {
        this.financialApi.bcSearch().subscribe(
            (response: ResponseDTO) => {
                if (response.success) {
                    window.alert("BC Search OK!");
                } else {
                    window.alert("BC Search KO!");
                }
                console.log(response);
            }, error => {
                console.log(error);
                window.alert(error);
            }
        )

    }


    leCreate() {
        this.financialApi.leCreate().subscribe(
            (response: ResponseDTO) => {
                if (response.success) {
                    window.alert("LE Create OK!");
                } else {
                    window.alert("LE Create KO!");
                }
                console.log(response);
            }, error => {
                console.log(error);
                window.alert("");
            }
        )

    }


    bcCreate() {
        this.financialApi.bcCreate().subscribe(
            (response: ResponseDTO) => {
                if (response.success) {
                    window.alert("BC Create OK!");
                } else {
                    window.alert("BC Create KO!");
                }
                console.log(response);
            }, error => {
                console.log(error);
                window.alert("");
            }
        )

    }


    lcCreate() {
        this.financialApi.lcCreate().subscribe(
            (response: ResponseDTO) => {
                if (response.success) {
                    window.alert("LC Create OK!");
                } else {
                    window.alert("LC Create KO!");
                }
                console.log(response);
            }, error => {
                console.log(error);
                window.alert("");
            }
        )

    }*/

}




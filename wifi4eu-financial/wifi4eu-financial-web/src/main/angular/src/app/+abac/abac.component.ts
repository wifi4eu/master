import {Component} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';
import {FinancialApi} from "../shared/swagger/api/FinancialApi";
import {ResponseDTO} from "../shared/swagger/model/ResponseDTO";


@Component({
	templateUrl: './abac.component.html',
	providers: [FinancialApi]
})
export class AbacComponent {
	private exportEnabled: boolean;
	private jsonFile: File;


	constructor(private http: Http, private financialApi: FinancialApi) {
		this.exportEnabled = false;
	}

	exportJson() {
		this.financialApi.exportJson().subscribe(
			(response:ResponseDTO) => {
				if (response.success) {
                    let blob = new Blob([response.data], { type: 'application/json' });
                    FileSaver.saveAs(blob, "financial_abac_export.json");
                    window.alert("Export succesful!");
				} else {
                    window.alert("Export failed!");
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

            reader.onload = (e) => {
            	this.financialApi.importJson(reader.result).subscribe(
					(response : ResponseDTO) => {
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
    }
}




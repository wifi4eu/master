import {Component} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from "@angular/http";
import {Observable} from "rxjs";
import * as FileSaver from 'file-saver';
import {FinancialApi} from "../shared/swagger/api/FinancialApi";


@Component({
	templateUrl: './abac.component.html',
	providers: [FinancialApi]
})
export class AbacComponent {
	private importUrl: string;
	private exportUrl: string;
	private exportEnabled: boolean;
	private jsonFile: File;


	constructor(private http: Http, private financialApi: FinancialApi) {
		this.importUrl = 'api/financial/importJson';
		this.exportUrl = 'api/financial/exportJson';
		this.exportEnabled = false;
	}

	exportJson() {
		this.http.get(this.exportUrl).subscribe(
			response => {
				let abacResponse = JSON.parse(response['_body']);
				if (abacResponse['success'] & abacResponse!['success']) {

					let blob = new Blob([abacResponse['data']], {type: 'application/json'});
					FileSaver.saveAs(blob, 'export.json');
				}
				window.alert(abacResponse['message']);
			}, error => {
				console.log(error);
				window.alert('Something went wrong');
			}
		);

	}

    onFileSelection(event) {
        this.exportEnabled = false;
        if (event && event.target && event.target.files && event.target.files.length == 1) {
            this.jsonFile = event.target.files['0'];
            let reader = new FileReader();
            console.log("IN");

            reader.onload = (e) => {
            	this.financialApi.importJson(reader.result).subscribe(
            		response => {
                        this.exportEnabled = true;
            			console.log("OK");
            			console.log(response);
					}, error => {
            			console.log("pringao");
            			console.log(error);
					}
				);
            };
            reader.readAsText(this.jsonFile);
        }
    }

	// onFileSelection(event) {
	// 	this.exportEnabled = false;
	// 	if (event && event.target && event.target.files && event.target.files.length == 1) {
	// 		this.jsonFile = event.target.files['0'];
	// 		let reader = new FileReader();
	// 		console.log("IN");
    //
	// 		reader.onload = (e) => {
	// 			this.http.post(this.importUrl, reader.result).subscribe(
	// 				response => {
	// 					// let abacResponse = JSON.parse(response['_body']);
	// 					// if (abacResponse['success']) {
	// 					this.exportEnabled = true;
	// 					console.log("OK!");
	// 					console.log("Response: ", response);
	// 					console.log(typeof response);
    //
	// 					// }
	// 					// window.alert(abacResponse['message']);
	// 				}, error => {
	// 					console.log(error);
	// 					window.alert('Something went wrong');
	// 					console.log("Crash 2");
	// 				}
	// 			);
	// 		};
	// 		reader.readAsText(this.jsonFile);
	// 	}
	// }
}




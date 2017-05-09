import { Component, Input, OnInit } from "@angular/core";
import { AbacApi } from "../shared/swagger/api/AbacApi";
import * as FileSaver from 'file-saver';

@Component({
	templateUrl: 'abac.component.html',
	providers: [AbacApi]
})
export class AbacComponent {
	private isExportSuccessful : boolean = false;
	private isAbacValidationSuccessful : boolean = false;

	private hasRequestedExport : boolean = false;
	private hasSubmitedForValidation : boolean = false;
	
	private isLoading : boolean = false;

	constructor(private abacApi : AbacApi){}

	onExportButton() {
		console.log("onExportButton");
		this.abacApi.exportAbacInformation().subscribe(
            data => {
				console.log("on Data");
				console.log(data);
				let blob = new Blob([JSON.stringify(data)], { type: 'application/json' });
				FileSaver.saveAs(blob, "abacExportInformation.json");  
            },
            error => {
				console.log("on error received");
				console.log(error);
            }
        );
	}

	onGetVoucherButton() {
		console.log("onGetVoucherButton");
	}

	onFileChange(event) {
		console.log("onFileChange");
		console.log(event);
		if(event && event.target && event.target.files && event.target.files.length == 1) {
			let file : File = event.target.files["0"];
			console.log(file.name);
			//TODO Do something
		}
	}

}
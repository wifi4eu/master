import { Component, Input, OnInit } from "@angular/core";
import { AbacApi } from "../shared/swagger/api/AbacApi";
import { CallApi } from "../shared/swagger/api/CallApi";
import * as FileSaver from 'file-saver';

@Component({
	templateUrl: 'abac.component.html',
	providers: [AbacApi, CallApi]
})
export class AbacComponent implements OnInit {
	private isExportSuccessful : boolean = false;
	private isImportSuccessful : boolean = false;

	private showExportIcon : boolean = false;
	private showImportIcon : boolean = false;

	private isExportLoading : boolean = false;
	private isImportLoading : boolean = false;

	private publications : Array<Object> = [];
	private tableAppliers : any;

	private exportErrorMessage : string;
	private importErrorMessage : string;

	constructor(private abacApi : AbacApi, private callApi : CallApi){}

	ngOnInit() {
		this.getAllPublications();
	}

	getAllPublications() {
		this.callApi.allCalls().subscribe(
            data => {
				for (let i = 0; i < data.length; i++) {
					this.publications.push({
						key: data[i].callId,
						value: data[i].event
					});
				}
			},
            error => {
				console.log("Failed to present current publications");
            }
		);
	}

	onExportButton() {
		this.isExportLoading = true;
		this.isExportSuccessful = false;
		this.showExportIcon = false;
		this.exportErrorMessage = "";

		this.abacApi.exportAbacInformation().subscribe(
            data => {
				if (data['success']) {
					let blob = new Blob([data['data']], { type: 'application/json' });
					FileSaver.saveAs(blob, "portal_abac_export.json");

					this.isExportLoading = false;
					this.isExportSuccessful = true;
					this.showExportIcon = true;
				} else {
					this.exportErrorMessage = data['error']['errorMessage'];
					this.isExportLoading = false;
					this.isExportSuccessful = false;
					this.showExportIcon = true;
				}
            },
            error => {
				this.isExportLoading = false;
				this.isExportSuccessful = false;
				this.showExportIcon = true;
				console.log("Could not export. Contact your administrator");
            }
        );
	}

	onPublicationChange(selectedKey) {
		this.abacApi.getPublicationAppliersInfo(selectedKey).subscribe(
            data => {
				console.log(data);
				if (data && data['success']) {
					this.tableAppliers = JSON.parse(data['data']);
					console.log(this.tableAppliers);
				}
            },
            error => {
				console.log("Error. Contact your administrator");
            }
        );
	}

	onFileSelection(event) {
		if(event && event.target && event.target.files && event.target.files.length == 1) {
			this.isImportLoading = true;
			this.isImportSuccessful = false;
			this.showImportIcon = false;
			this.importErrorMessage = "";

			let file : File = event.target.files["0"];
			
			let reader = new FileReader();
			reader.onload = (e) => {
				this.abacApi.importAbacInformation(reader.result).subscribe(
					data => {
						if (data['success']) {
							this.isImportLoading = false;
							this.isImportSuccessful = true;
							this.showImportIcon = true;
						} else {
							this.importErrorMessage = data['error']['errorMessage'];
							this.isImportLoading = false;
							this.isImportSuccessful = false;
							this.showImportIcon = true;
						}
					},
					error => {
						this.isImportLoading = false;
						this.isImportSuccessful = false;
						this.showImportIcon = true;
					}
				);
            };

			reader.readAsText(file);
		}
	}

}
import { Component, Input, OnChanges, OnInit, ViewChild } from "@angular/core";
import { RegistrationDTOBase, UserDTOBase, RegistrationApi, ResponseDTOBase, LegalFileDTOBase } from "../../shared/swagger";
import { SharedService } from "../../shared/shared.service";
import { Observable } from "rxjs/Observable";

@Component({
    selector: 'legal-files-component',
    templateUrl: 'legal-files.component.html',
    providers: [RegistrationApi]
})

export class LegalFilesComponent implements OnChanges, OnInit {

    // municipality : MunicipalityDTOBase = {};
    private documentUrls: string[] = [];
    private documentFiles: File[] = [];
    private reader: FileReader = new FileReader();

    // Booleans
    private deleteBlocker: boolean = false;
    private filesUploaded: boolean = false;
    private doc1: boolean = false;
    private doc2: boolean = false;
    private doc3: boolean = false;
    private doc4: boolean = false;

    // new
    userLegalFiles : Array<LegalFileDTOBase>;
    legalFile1 : any;
    legalFile2 : any;
    legalFile3 : any;
    legalFile4 : any;

    @Input("user") user : UserDTOBase;
    @Input("registration") registration : RegistrationDTOBase

    @ViewChild('document1') private document1: any;
    @ViewChild('document2') private document2: any;
    @ViewChild('document3') private document3: any;
    @ViewChild('document4') private document4: any;

    constructor(
        private sharedService: SharedService,
        private registrationApi: RegistrationApi
    ) {
    }
    
    ngOnInit() {

        this.registrationApi.getHistoryAll(this.registration.id).subscribe(
            (responseDTO : ResponseDTOBase) => {
                this.userLegalFiles = responseDTO.data;
                if(this.userLegalFiles) {
                    
                    // Separate legal files 
                    this.userLegalFiles.forEach(file => {
                        switch(file.fileType) {
                            case 1:
                            this.legalFile1 = file;
                            break;
                            case 2:
                            this.legalFile2 = file;
                            break;
                            case 3:
                            this.legalFile3 = file;
                            break;
                            case 4:
                            this.legalFile4 = file;
                            break;
                        }
                    });

                    // Check if file exists and therefore user can delete it 
                    if (!this.legalFile1.size || !this.legalFile3.size) {
                        this.deleteBlocker = true;
                    } else {
                        this.deleteBlocker = false;
                    }
                    
                    console.log("Size of legal file 1 is ", this.legalFile1);
                }
            }
        );

    }

    
    private uploadFile(event: any, index: number = 0) {
        if (this.registration.allFilesFlag != 1) {
            this.filesUploaded = true;
            if (event.target.files[0]) {
                if (event.target.files[0].size > 1024000) {
                    this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 1 MB.', 'benefPortal.file.toobig.maxsize', 'warn', { size: '1 MB' });
                    this.removeFile(index);
                    return;
                }
                if (event.target.files[0].type == "application/pdf" || event.target.files[0].type == "image/png" || event.target.files[0].type == "image/jpg" || event.target.files[0].type == "image/jpeg") {
                    this.documentFiles[index] = event.target.files[0];
                    this.reader.readAsDataURL(this.documentFiles[index]);
                    let subscription = Observable.interval(200).subscribe(
                        x => {
                            if (this.reader.result != "") {
                                this.documentUrls[index] = this.reader.result;
                                this.filesUploaded = true;
                                switch (index) {
                                    case 0:
                                        this.doc1 = true;
                                        break;
                                        case 1:
                                        this.doc2 = true;
                                        break;
                                        case 2:
                                        this.doc3 = true;
                                        break;
                                        case 3:
                                        this.doc4 = true;
                                        break;
                                    }
                                    subscription.unsubscribe();
                                }
                        }
                    );
                } else {
                    this.sharedService.growlTranslation('Please, select a valid file.', 'shared.incorrectFormat', 'warn');
                    this.filesUploaded = false;
                }
            } else {
                this.removeFile(index);
            }
        } else {
            this.sharedService.growlTranslation('You can\'t upload documents right now', 'shared.cantUploadDocs', 'error');
            this.filesUploaded = false;
            
        }
    }
    
    private removeFile(index: number) {
        this.documentFiles[index] = null;
        this.filesUploaded = false;
        this.documentUrls[index] = '';
        switch (index) {
            case 0:
            this.document1.nativeElement.value = '';
            this.doc1 = false;
            break;
            case 1:
            this.document2.nativeElement.value = '';
            this.doc2 = false;
            break;
            case 2:
                this.document3.nativeElement.value = '';
                this.doc3 = false;
                break;
                case 3:
                this.document4.nativeElement.value = '';
                this.doc4 = false;
                break;
        }
        if (this.doc1 || this.doc2 || this.doc3 || this.doc4) {
            this.filesUploaded = true;
        }
        // this.checkFirstDocuments();
    }
    

    ngOnChanges() {
        
    }
}

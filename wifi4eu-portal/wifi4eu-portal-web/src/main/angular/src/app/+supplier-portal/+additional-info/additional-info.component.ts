import { Component, ViewChild } from "@angular/core";
import { Router } from "@angular/router";
import { LocalStorageService } from "angular-2-local-storage";
import { Observable } from "rxjs/Observable";
import { UserDTOBase } from "../../shared/swagger/model/UserDTO";
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";
import { SupplierApi } from "../../shared/swagger/api/SupplierApi";
import { ResponseDTOBase } from "../../shared/swagger/model/ResponseDTO";
import { SharedService } from "../../shared/shared.service";

@Component({
    selector: 'supplier-additional-info-component',
    templateUrl: 'additional-info.component.html',
    providers: [SupplierApi]
})

export class AdditionalInfoComponent {
    private user: UserDTOBase;
    private supplier: SupplierDTOBase;
    private documentFiles: File[] = [];
    private documentUrls: string[] = [];
    private reader: FileReader = new FileReader();
    private allFilesUploaded: boolean = false;
    @ViewChild('document1') private document1: any;
    @ViewChild('document2') private document2: any;
    private displayConfirmingData: boolean = false;

    constructor(private localStorageService: LocalStorageService, private supplierApi: SupplierApi, private sharedService: SharedService, private router: Router) {
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        if (this.user != null) {
            if (this.user.type == 1) {
                this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
                    (supplier: SupplierDTOBase) => {
                        this.supplier = supplier;
                    }
                );
            }
        } else {
            this.sharedService.growlTranslation('You are not logged in!', 'shared.error.notloggedin', 'warn');
            this.router.navigateByUrl('/home');
        }
    }

    private uploadFile(event: any, index: number = 0) {
        if (event.target.files[0]) {
            if (event.target.files[0].size > 1024000) {
                this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 1 MB.', 'benefPortal.file.toobig.maxsize', 'warn', {size: '1 MB'});
                this.removeFile(index);
                return;
            }
            this.documentFiles[index] = event.target.files[0];
            this.reader.readAsDataURL(this.documentFiles[index]);
            let subscription = Observable.interval(200).subscribe(
                x => {
                    if (this.reader.result != "") {
                        this.documentUrls[index] = this.reader.result;
                        if (this.documentUrls[0] && this.documentUrls[1]) {
                            this.allFilesUploaded = true;
                        } else {
                            this.allFilesUploaded = false;
                        }
                        subscription.unsubscribe();
                    }
                }
            );
        } else {
            this.removeFile(index);
        }
    }

    private removeFile(index: number) {
        this.documentFiles[index] = null;
        this.documentUrls[index] = '';
        this.allFilesUploaded = false;
        switch (index) {
            case 0:
                this.document1.nativeElement.value = '';
                break;
            case 1:
                this.document2.nativeElement.value = '';
                break;
        }
    }

    private onSubmit() {
        if (this.documentUrls[0]) {
            this.supplier.legalFile1 = this.documentUrls[0];
        }
        if (this.documentUrls[1]) {
            this.supplier.legalFile2 = this.documentUrls[1];
        }
        this.displayConfirmingData = true;
        this.supplierApi.updateSupplier(this.supplier).subscribe(
            (response: ResponseDTOBase) => {
                this.displayConfirmingData = false;
                if (response.success) {
                    this.sharedService.growlTranslation('Your registration was successfully updated.', 'shared.registration.update.success', 'success');
                    this.supplier = response.data;
                } else {
                    this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
                }
            }, error => {
                this.displayConfirmingData = false;
                this.sharedService.growlTranslation('An error occurred and your registration could not be updated.', 'shared.registration.update.error', 'error');
            }
        );
    }
}
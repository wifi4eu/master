import {Component, EventEmitter, Input, Output, ViewChild} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {Observable} from "rxjs/Rx";
import {SharedService} from "../../shared/shared.service";

@Component({
    selector: 'supplier-registration-step1', templateUrl: 'supplier-registration-step1.component.html'
})

export class SupplierRegistrationStep1Component {
    @Input('supplier') private supplier: SupplierDTOBase;
    @Output() private supplierChange: EventEmitter<SupplierDTOBase>;
    @Output() private onNext: EventEmitter<any>;
    @Input('logoUrl') private logoUrl: FileReader;
    @Output() private logoUrlChange: EventEmitter<FileReader>;
    @ViewChild('logoInput') private logoInput: any;
    private logoFile: File;
    private websitePattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\\/\\/([wW][wW][wW]\\.)?))?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,256}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    private buttonEnabled: boolean = false;

    constructor(private sharedService: SharedService) {
        this.supplierChange = new EventEmitter<SupplierDTOBase>();
        this.logoUrlChange = new EventEmitter<FileReader>();
        this.onNext = new EventEmitter<any>();
    }

    private submit() {
        this.supplierChange.emit(this.supplier);
        this.logoUrlChange.emit(this.logoUrl);
        this.onNext.emit();
    }

    private changeLogo(event) {
        if (event.target.files.length > 0) {
            this.logoFile = event.target.files[0];
            if (this.logoFile.size > 2560000) {
                this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 2.5 MB.', 'benefPortal.file.toobig.maxsize', 'warn', {size: '2.5 MB'});
                this.clearLogoFile();
                return;
            }
            if (this.logoFile.type != "image/png" && this.logoFile.type != "image/jpg" && this.logoFile.type != "image/jpeg") {
                this.uploadWrong();
                return;
            }
            let imageStatus = "";
            let image = new Image();
            image.onload = function () {
                imageStatus = "correct";
            };
            image.onerror = function () {
                imageStatus = "wrong";
            };
            image.src = URL.createObjectURL(this.logoFile);
            let subscription = Observable.interval(200).subscribe(
                x => {
                    switch (imageStatus) {
                        case "correct":
                            this.uploadCorrect();
                            subscription.unsubscribe();
                            break;
                        case "wrong":
                            this.uploadWrong();
                            subscription.unsubscribe();
                            break;
                    }
                }
            );
        }
    }

    private uploadCorrect(): any {
        this.logoUrl.readAsDataURL(this.logoFile);
        let subscription = Observable.interval(200).subscribe(
            x => {
                if (this.logoUrl.result != "") {
                    this.supplier.logo = this.logoUrl.result;
                    subscription.unsubscribe();
                }
            }
        );
    }

    private uploadWrong(): any {
        this.clearLogoFile();
        this.sharedService.growlTranslation('The file you uploaded is not a valid image file.', 'shared.growl.fileNotValid', 'error');
    }

    private clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.logoFile = null;
        this.supplier.logo = null;
    }

    private checkButtonEnabled(event){
            if(this.supplier.name != null && this.supplier.address != null 
            && this.supplier.accountNumber != null && this.supplier.bic != null
            && this.supplier.vat != null && this.supplier.name.trim() != "" && this.supplier.address.trim() != "" 
                && this.supplier.accountNumber.trim() != "" && this.supplier.bic.trim() != "" && this.supplier.vat.trim() != ""){
                    this.buttonEnabled = true;
            }
    }
}

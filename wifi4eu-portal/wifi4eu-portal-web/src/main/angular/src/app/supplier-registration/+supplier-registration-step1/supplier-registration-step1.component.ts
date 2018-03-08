import {Component, EventEmitter, Input, Output, ViewChild} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {Observable} from "rxjs/Rx";
import {TranslateService} from "ng2-translate/ng2-translate";
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
    private websitePattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\\/\\/([wW][wW][wW]\\.)?))?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,3}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";


    constructor(private sharedService: SharedService, private uxService: UxService) {
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
}

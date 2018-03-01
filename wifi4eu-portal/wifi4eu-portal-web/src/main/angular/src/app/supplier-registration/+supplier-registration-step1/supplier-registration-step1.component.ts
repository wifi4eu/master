import {Component, EventEmitter, Input, Output, ViewChild} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {Observable} from "rxjs/Rx";
import { TranslateService } from "ng2-translate/ng2-translate";

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


    constructor(private translate: TranslateService, private uxService: UxService) {
        this.supplierChange = new EventEmitter<SupplierDTOBase>();
        this.logoUrlChange = new EventEmitter<FileReader>();
        this.onNext = new EventEmitter<any>();
    }

    submit() {
        this.supplierChange.emit(this.supplier);
        this.logoUrlChange.emit(this.logoUrl);
        this.onNext.emit();
    }

    changeLogo(event) {
        if (event.target.files.length > 0) {
            this.logoFile = event.target.files[0];
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
                    switch(imageStatus) {
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

    uploadCorrect() : any {
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

    uploadWrong() : any {
        let detailTranslation = 'The file you uploaded is not a valid image file.';
        this.translate.get('shared.growl.fileNotValid').subscribe(
            (res: string) => {
                detailTranslation = res;
            }
        );
        this.clearLogoFile();
        this.uxService.growl({
            severity: 'error',
            summary: 'ERROR',
            detail: detailTranslation
        });
    }

    clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.logoFile = null;
        this.supplier.logo = null;
    }
}

import {Component, Input, Output, EventEmitter, ViewChild, OnInit} from "@angular/core";
import { SupplierDTOBase } from "../../shared/swagger/model/SupplierDTO";
import { Observable } from 'rxjs/Rx';
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Component({
    selector: 'supplier-registration-step1-component',
    templateUrl: 'supplier-registration-step1.component.html'
})
export class SupplierRegistrationComponentStep1 implements OnInit {
    private webPattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\/\/([wW][wW][wW]\\.)?))[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+";
    private isLogoUploaded: boolean = false;
    private logoUrl: FileReader = new FileReader();
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;
    @Input('logoFile') logoFile: File;
    @Output() onNext = new EventEmitter<number>();
    @Output() onLogoSubmit = new EventEmitter<any>();
    @ViewChild('logoInput') logoInput: any;

    constructor(private uxService: UxService) {
    }

    ngOnInit() {
        if (this.logoFile) {
            this.isLogoUploaded = true;
            this.logoUrl.readAsDataURL(this.logoFile);
        }
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    onSelect(event) {
        this.isLogoUploaded = false;
        if (event.target && event.target.files && event.target.files.length > 0) {
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
        } else {
            this.clearLogoFile();
        }
	}

	uploadCorrect() : any {
        this.logoUrl.readAsDataURL(this.logoFile);
        let subscription = Observable.interval(200).subscribe(
            x => {
                if (this.logoUrl.result != "") {
                    this.isLogoUploaded = true;
                    this.onLogoSubmit.emit(this.logoFile);
                    subscription.unsubscribe();
                }
            }
        );
    }

    uploadWrong() : any {
        this.clearLogoFile();
        this.uxService.growl({
            severity: 'error',
            summary: 'ERROR',
            detail: 'The file you uploaded is not a valid image file.'
        });
    }

    clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.onLogoSubmit.emit(null);
        this.logoFile = null;
    }
}

import {Component, Input, Output, EventEmitter, ViewChild} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {FileUploadModule} from 'primeng/primeng';
import {Observable} from 'rxjs/Rx';

@Component({
    selector: 'supplier-registration-step1-component',
    templateUrl: 'supplier-registration-step1.component.html'
})
export class SupplierRegistrationComponentStep1 {
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;
    @Output() onNext = new EventEmitter<number>();
    @Output() onLogoSubmit = new EventEmitter<any>();
    private webPattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\/\/([wW][wW][wW]\\.)?))[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)+";
    private isLogoUploaded: boolean = false;
    private logoUrl: FileReader = new FileReader();
    @Input('logoFile') logoFile: File;
    @ViewChild('logoInput') logoInput: any;

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
            this.onLogoSubmit.emit(event.target.files["0"]);
            this.logoUrl.readAsDataURL(event.target.files["0"]);
            this.logoFile = event.target.files["0"];
            let subscription = Observable.interval(500).map((x) => {
            }).subscribe((x) => {
                if (this.logoUrl.result != "") {
                    this.isLogoUploaded = true;
                    subscription.unsubscribe();
                }
            });
        } else {
            this.clearLogoFile();
        }
	}

    clearLogoFile() {
        this.logoInput.nativeElement.value = "";
        this.isLogoUploaded = false;
        this.logoUrl = new FileReader();
        this.onLogoSubmit.emit(null);
        this.logoFile = null;
    }
}

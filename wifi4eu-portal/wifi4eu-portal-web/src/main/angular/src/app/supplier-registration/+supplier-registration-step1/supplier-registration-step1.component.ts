import {Component, EventEmitter, Input, Output, ViewChild} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {Observable} from "rxjs/Rx";
import {SharedService} from "../../shared/shared.service";
import { NgForm } from "@angular/forms";

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
    @ViewChild('supplierForm') private supplierForm: NgForm;
    private logoFile: File;
    private websitePattern: string = "(([wW][wW][wW]\\.)|([hH][tT][tT][pP][sS]?:\\/\\/([wW][wW][wW]\\.)?))?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,256}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";
    private buttonEnabled: boolean = false;

    private countrySelected: boolean = false;
    private officialAddress: any = {};

    @Input('countries') private countries: NutsDTOBase[];
    @Input('country') private country: NutsDTOBase;
    @Output() private countryChange: EventEmitter<NutsDTOBase>;

    constructor(private sharedService: SharedService) {
        this.supplierChange = new EventEmitter<SupplierDTOBase>();
        this.logoUrlChange = new EventEmitter<FileReader>();
        this.onNext = new EventEmitter<any>();
        this.countryChange = new EventEmitter<NutsDTOBase>();
    }

    private submit() {
        // Wrap address first
        this.supplier.address = this.officialAddress.streetName.trim() + " " + this.officialAddress.streetNumber.trim() + " " + this.officialAddress.postalCode.trim() + " " +  this.officialAddress.city.trim() + " " + this.country.label;
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

    private selectCountry(event: any) {
        if (this.country != null) {
            this.countrySelected = true;
            this.countryChange.emit(this.country);
            this.sharedService.clean();
        }
    }

    private checkButtonEnabled(event){
      /*  && this.supplier.accountNumber != null && this.supplier.bic != null &&
      this.supplier.accountNumber.trim() != "" && this.supplier.bic.trim() != "" 
      && this.supplier.address != null && this.supplier.address.trim() != ""
      */
        if(this.supplier.name != null && this.supplier.name.trim() != "" 
        && this.supplier.vat != null  &&  this.supplier.vat.trim() != ""
        && this.officialAddress.streetName != null && this.officialAddress.streetName.trim() != ""
        && this.officialAddress.streetNumber != null && this.officialAddress.streetNumber.trim() != ""
        && this.officialAddress.postalCode != null && this.officialAddress.postalCode.trim() != ""
        && this.officialAddress.city != null && this.officialAddress.city.trim() != ""
        ){
            this.buttonEnabled = true;
        }
        //custom name validator
        if(this.supplier.name != null && this.supplier.name.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['name'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['name'].setErrors({'invalid': true});} ,5);
        }
        //custom accountNumber validator
        /* if(this.supplier.accountNumber != null && this.supplier.accountNumber.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['accountNumber'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['accountNumber'].setErrors({'invalid': true});} ,5);
        }
        //custom bic validator
        if(this.supplier.bic != null && this.supplier.bic.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['bic'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['bic'].setErrors({'invalid': true});} ,5);
        } */
        //custom vat validator
        if(this.supplier.vat != null && this.supplier.vat.trim() != "" && this.supplier.vat.trim().slice(0, 2).match(/[A-z][A-z]/) && this.supplier.vat.trim().length > 3 && this.supplier.vat.trim().match(/[1-9][1-9][1-9]/)){
            setTimeout(()=>{this.supplierForm.controls['vat'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['vat'].setErrors({'invalid': true});} ,5);
        }
        //custom address validator
        /* if(this.supplier.address != null && this.supplier.address.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['address'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['address'].setErrors({'invalid': true});} ,5);
        } */
        // custom street name validator
        if(this.officialAddress.streetName != null && this.officialAddress.streetName.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['streetName'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['streetName'].setErrors({'invalid': true});} ,5);
        }
        // custom streetNumber validator
        if(this.officialAddress.streetNumber != null && this.officialAddress.streetNumber.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['streetNumber'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['streetNumber'].setErrors({'invalid': true});} ,5);
        }
        // custom postal code validator
        if(this.officialAddress.postalCode != null && this.officialAddress.postalCode.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['postalCode'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['postalCode'].setErrors({'invalid': true});} ,5);
        }
        // custom city validator
        if(this.officialAddress.city != null && this.officialAddress.city.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['city'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['city'].setErrors({'invalid': true});} ,5);
        }
    }
}

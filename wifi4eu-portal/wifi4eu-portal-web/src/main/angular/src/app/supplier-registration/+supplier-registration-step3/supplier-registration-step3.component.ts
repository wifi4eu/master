import {Component, Input, Output, EventEmitter, ViewChild} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import { NgForm } from "@angular/forms";

@Component({
    selector: 'supplier-registration-step3', templateUrl: 'supplier-registration-step3.component.html'
})

export class SupplierRegistrationStep3Component {
    @Input('supplier') private supplier: SupplierDTOBase;
    @Output() private supplierChange: EventEmitter<SupplierDTOBase>;
    @Output() private onNext: EventEmitter<number>;
    @Output() private onBack: EventEmitter<number>;
    @ViewChild('supplierForm') private supplierForm: NgForm;
    private confirmEmailField: string = '';
    private emailMatches: boolean = false;
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    private css_class_email: string = 'notValid';
    private buttonEnabled: boolean = false;

    constructor() {
        this.supplierChange = new EventEmitter<SupplierDTOBase>();
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    private submit() {
        this.supplierChange.emit(this.supplier);
        this.onNext.emit();
        this.confirmEmailField = '';
    }

    private back() {
        this.onBack.emit();
        this.confirmEmailField = '';
    }

    private checkIfEmailMatches() {
        this.emailMatches = false;
        this.css_class_email = 'notValid';
        if (this.supplier.contactEmail === this.confirmEmailField && this.confirmEmailField.length > 0) {
            this.emailMatches = true;
            this.css_class_email = 'isValid';
        }
    }

    private preventPaste(event: any) {
        return false;
    }
    private checkButtonEnabled(event){
        if(this.supplier.contactSurname != null && this.supplier.contactName != null 
        && this.supplier.contactPhoneNumber != null && this.supplier.contactPhonePrefix != null
             && this.supplier.contactSurname.trim() != "" && this.supplier.contactName.trim() != "" && this.supplier.contactPhoneNumber.trim() != "" && this.supplier.contactPhonePrefix.trim() != ""){
                this.buttonEnabled = true;
        }

         //custom name validator
        if(this.supplier.contactName != null && this.supplier.contactName.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['contactName'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['contactName'].setErrors({'invalid': true});} ,5);
        }
         //custom surname validator
        if(this.supplier.contactSurname != null && this.supplier.contactSurname.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['contactSurname'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['contactSurname'].setErrors({'invalid': true});} ,5);
        }
         //custom surname validator
        if(this.supplier.contactPhoneNumber != null && this.supplier.contactPhoneNumber.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['contactPhoneNumber'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['contactPhoneNumber'].setErrors({'invalid': true});} ,5);
        }
         //custom surname validator
         if(this.supplier.contactPhonePrefix != null && this.supplier.contactPhonePrefix.trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['contactPhonePrefix'].setErrors(null);} ,5);
        }else {
            setTimeout(()=>{this.supplierForm.controls['contactPhonePrefix'].setErrors({'invalid': true});} ,5);
        }
    }
}

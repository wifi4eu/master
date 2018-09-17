import {Component, Input, Output, EventEmitter, ViewChild} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import { NgForm } from "@angular/forms";
import { UserDTO } from "../../shared/swagger";
import { LocalStorageService } from "angular-2-local-storage";

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
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    private css_class_email: string = 'notValid';
    private buttonEnabled: boolean = false;
    private userForSUpplier: UserDTO;
    private user: UserDTO;
    private hasEcasEmail: boolean = false;
    private prefixRegex = new RegExp('^[+]?[1-9]{1}[0-9]{1,2}$');
    private phoneNumberRegex = new RegExp('^[0-9]{1,}$');

    constructor(private localStorageService: LocalStorageService) {
        this.supplierChange = new EventEmitter<SupplierDTOBase>();
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        
        if (this.user.ecasEmail && this.user.ecasEmail.trim() != ""){
            this.hasEcasEmail = true;
        }
    }

    private submit() {
        if (!this.hasEcasEmail){
            this.user.email = this.supplier.contactEmail;
            this.user.ecasEmail = this.supplier.contactEmail;
        } else {
            this.supplier.contactEmail = this.user.ecasEmail;
        }
        this.user.name = this.supplier['contactName'];
        this.user.surname = this.supplier['contactSurname'];
        this.supplier.contactPrefix = this.supplier['contactPhonePrefix'];
        this.supplier.contactNumber = this.supplier['contactPhoneNumber'];
        this.supplier['users'] = []
        this.supplier.users.push(this.user);
        this.supplierChange.emit(this.supplier);
        this.onNext.emit();
    }

    private back() {
        this.onBack.emit();  
    }

    private checkIfEmailMatches() {
        this.css_class_email = 'notValid';
        if (this.supplier.contactEmail === this.confirmEmailField && this.confirmEmailField.length > 0) {
            this.css_class_email = 'isValid';
            return true;
        }
        return false;
    }

    private preventPaste(event: any) {
        return false;
    }

    private checkButtonEnabled(event){
        this.buttonEnabled = false;
        if(this.supplier['contactSurname'] != null && this.supplier['contactName'] != null 
          && this.supplier['contactPhoneNumber'] != null && this.supplier['contactPhonePrefix'] != null
              && this.supplier['contactSurname'].trim() != "" && this.supplier['contactName'].trim() != "" && this.supplier['contactPhoneNumber'].trim() != "" && this.supplier['contactPhonePrefix'].trim() != ""){
                 this.buttonEnabled = true;
        }
        // custom name validator
       if(this.supplier['contactName'] != null && this.supplier['contactName'].trim() != ""){
        setTimeout(()=>{this.supplierForm.controls['contactName'].setErrors(null);} ,5);
        } else {
            setTimeout(()=>{this.supplierForm.controls['contactName'].setErrors({'invalid': true});} ,5);
        }
        // custom surname validator
        if(this.supplier['contactSurname'] != null && this.supplier['contactSurname'].trim() != ""){
            setTimeout(()=>{this.supplierForm.controls['contactSurname'].setErrors(null);} ,5);
        } else {
            setTimeout(()=>{this.supplierForm.controls['contactSurname'].setErrors({'invalid': true});} ,5);
        }
    }
    

    private isButtonEnabled() {
        return this.checkFieldAreFilled() && this.checkPrefixAndNumberRegex();
    }

    private checkFieldAreFilled() : boolean {
        if (this.hasEcasEmail) {
            if(this.supplier['contactSurname'] != null && this.supplier['contactName'] != null 
            && this.supplier['contactPhoneNumber'] != null && this.supplier['contactPhonePrefix'] != null
                && this.supplier['contactSurname'].trim() != "" && this.supplier['contactName'].trim() != "" && this.supplier['contactPhoneNumber'].trim() != "" && this.supplier['contactPhonePrefix'].trim() != "") {
                    return true;
            }
        } else {
            if(this.supplier['contactSurname'] != null && this.supplier['contactName'] != null 
            && this.supplier['contactPhoneNumber'] != null && this.supplier['contactPhonePrefix'] != null
            && this.supplier['contactSurname'].trim() != "" && this.supplier['contactName'].trim() != "" && this.supplier['contactPhoneNumber'].trim() != "" 
            && this.supplier['contactPhonePrefix'].trim() != "" && this.supplier.contactEmail === this.confirmEmailField && this.confirmEmailField.length > 0) {
                    this.css_class_email = 'isValid';
                    return true;
            }
        }
    }
        
    private checkPrefixAndNumberRegex() : boolean{
        return this.supplier['contactPhonePrefix'].trim().match(this.prefixRegex) && this.supplier['contactPhoneNumber'].trim().match(this.phoneNumberRegex);
    }

    private rulesPrefix(event) {
        let inputValue = event.target.value;
        let result = inputValue.match(this.prefixRegex);
    }
    //      //¡custom name validator
    //     if(this.supplier.contactName != null && this.supplier.contactName.trim() != ""){
    //         setTimeout(()=>{this.supplierForm.controls['contactName'].setErrors(null);} ,5);
    //     }else {
    //         setTimeout(()=>{this.supplierForm.controls['contactName'].setErrors({'invalid': true});} ,5);
    //     }
    //      //custom surname validator
    //     if(this.supplier.contactSurname != null && this.supplier.contactSurname.trim() != ""){
    //         setTimeout(()=>{this.supplierForm.controls['contactSurname'].setErrors(null);} ,5);
    //     }else {
    //         setTimeout(()=>{this.supplierForm.controls['contactSurname'].setErrors({'invalid': true});} ,5);
    //     }
    //      //custom surname validator
    //     if(this.supplier.contactPhoneNumber != null && this.supplier.contactPhoneNumber.trim() != ""){
    //         setTimeout(()=>{this.supplierForm.controls['contactPhoneNumber'].setErrors(null);} ,5);
    //     }else {
    //         setTimeout(()=>{this.supplierForm.controls['contactPhoneNumber'].setErrors({'invalid': true});} ,5);
    //     }
    //      //custom surname validator
    //      if(this.supplier.contactPhonePrefix != null && this.supplier.contactPhonePrefix.trim() != ""){
    //         setTimeout(()=>{this.supplierForm.controls['contactPhonePrefix'].setErrors(null);} ,5);
    //     }else {
    //         setTimeout(()=>{this.supplierForm.controls['contactPhonePrefix'].setErrors({'invalid': true});} ,5);
    //     }
    // }
}

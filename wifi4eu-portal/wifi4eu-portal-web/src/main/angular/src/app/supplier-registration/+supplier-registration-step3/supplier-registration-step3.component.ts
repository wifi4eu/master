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
    private emailMatches: boolean = false;
    private emailPattern = new RegExp("(?:[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-zA-Z0-9-]*[a-zA-Z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])");
    private css_class_email: string = 'notValid';
    private buttonEnabled: boolean = false;
    private  userForSUpplier: UserDTO;
    private user: UserDTO;

    constructor(private localStorageService: LocalStorageService) {
        this.supplierChange = new EventEmitter<SupplierDTOBase>();
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
    }

    private submit() {

        let storedUser = this.localStorageService.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;
        this.user.email = this.supplier.contactEmail;
        this.user.name = this.supplier['contactName'];
        this.user.surname = this.supplier['contactSurname'];
        this.user.phonePrefix = this.supplier['contactPhonePrefix'];
        this.user.phoneNumber = this.supplier['contactPhoneNumber'];
        this.supplier['users'] = []
        this.supplier.users.push(this.user);
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
}

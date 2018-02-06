import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";

@Component({
    selector: 'supplier-registration-step3', templateUrl: 'supplier-registration-step3.component.html'
})

export class SupplierRegistrationStep3Component {
    @Input('supplier') private supplier: SupplierDTOBase;
    @Output() private supplierChange: EventEmitter<SupplierDTOBase>;
    @Output() private onNext: EventEmitter<number>;
    @Output() private onBack: EventEmitter<number>;
    private confirmEmailField: string = '';
    private emailMatches: boolean = false;
    private emailPattern = '^[a-zA-Z0-9](\\.?[a-zA-Z0-9_-]){0,}@[a-zA-Z0-9-]+\\.([a-zA-Z]{1,6}\\.)?[a-zA-Z]{2,6}$';

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
        if (this.supplier.contactEmail === this.confirmEmailField) {
            this.emailMatches = true;
        }
    }

    private preventPaste(event: any) {
        return false;
    }
}

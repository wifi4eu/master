import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";


@Component({
    selector: 'supplier-registration-step1-component',
    templateUrl: 'supplier-registration-step1.component.html'
})
export class SupplierRegistrationComponentStep1 {
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;

    @Output() onNext = new EventEmitter<number>();

    onSubmit(step: number) {
        this.onNext.emit(step);
    }
}

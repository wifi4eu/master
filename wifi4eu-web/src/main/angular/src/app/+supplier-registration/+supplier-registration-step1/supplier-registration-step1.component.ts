import {Component, Input, Output, EventEmitter} from "@angular/core";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";


@Component({
    selector: 'supplier-registration-step1-component',
    templateUrl: 'supplier-registration-step1.component.html'
})
export class SupplierRegistrationComponentStep1 {
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;

    @Output() onNext = new EventEmitter<number>();

    //private webPattern: string = "@^(http\:\/\/|https\:\/\/)?([a-z0-9][a-z0-9\-]*\.)+[a-z0-9][a-z0-9\-]*$@i";
    private webPattern: string = "(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9]\.[^\s]{2,})";
    
    onSubmit(step: number) {
        this.onNext.emit(step);
    }
}

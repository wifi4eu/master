import { Directive, forwardRef, Attribute } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
    selector: '[noEmptyStrings][formControlName],[noEmptyStrings][formControl],[noEmptyStrings][ngModel]',
    providers: [
        { provide: NG_VALIDATORS, useExisting: forwardRef(() => EmptyStringsValidator), multi: true }
    ]
})
export class EmptyStringsValidator implements Validator {
    constructor() { }


    validate(control: AbstractControl): { [key: string]: any } {

        let selfValue = control.value;
        if (selfValue && !selfValue.trim()) return {
            noEmptyStrings: false
        }

        return null;
    }
}
import { Directive, forwardRef, Attribute } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
    selector: '[validateEquals][formControlName],[validateEquals][formControl],[validateEquals][ngModel]',
    providers: [
        { provide: NG_VALIDATORS, useExisting: forwardRef(() => EqualValidator), multi: true }
    ]
})
export class EqualValidator implements Validator {
    constructor(@Attribute('validateEquals') public validateEquals: string) { }

    validate(control: AbstractControl): { [key: string]: any } {
        
        let selfValue = control.value;
        let confirmValue = control.root.get(this.validateEquals);
        if (confirmValue && !confirmValue.pristine && selfValue !== confirmValue.value) return {
            validateEquals: false
        }
        return null;
    }
}
import { Directive, forwardRef, Attribute } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
    selector: '[validateEquals][formControlName],[validateEquals][formControl],[validateEquals][ngModel]',
    providers: [
        { provide: NG_VALIDATORS, useExisting: forwardRef(() => EqualValidator), multi: true }
    ]
})
export class EqualValidator implements Validator {
    constructor(@Attribute('validateEquals') public validateEquals: string,
        @Attribute('reverse') public reverse: string) { }

    private get isReverse() {
        if (!this.reverse) return false;
        return this.reverse === 'true' ? true : false;
    }

    validate(control: AbstractControl): { [key: string]: any } {

        let selfValue = control.value;
        let confirmValue = control.root.get(this.validateEquals);
        if (confirmValue && selfValue !== confirmValue.value && !this.isReverse) return {
            validateEquals: false
        }
        
        if (confirmValue && selfValue === confirmValue.value && this.isReverse) {
            if (Object.keys(confirmValue.errors).length) confirmValue.setErrors(null);
        }

        if (confirmValue && selfValue !== confirmValue.value && this.isReverse) {
            confirmValue.setErrors({ validateEqual: false });
        }

        return null;
    }
}
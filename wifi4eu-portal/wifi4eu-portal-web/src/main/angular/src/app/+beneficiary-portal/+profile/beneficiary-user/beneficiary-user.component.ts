import { Component, Input, OnChanges, EventEmitter, Output, SimpleChange } from '@angular/core';
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import { TranslateService } from "ng2-translate";
import { UserDTOBase, NutsDTOBase } from '../../../shared/swagger';

@Component({ selector: 'beneficiary-user', templateUrl: 'beneficiary-user.component.html' })
export class BeneficiaryUserComponent {
    @Input() user: UserDTOBase;
    @Input() countries: NutsDTOBase[] = [];
    @Input() isEdit: boolean = false;
    @Output() onUserChange = new EventEmitter();


    constructor(private uxService: UxService, private translateService: TranslateService) {
    }

    onChangesUser() {
      this.onUserChange.emit(this.user);
    }
}
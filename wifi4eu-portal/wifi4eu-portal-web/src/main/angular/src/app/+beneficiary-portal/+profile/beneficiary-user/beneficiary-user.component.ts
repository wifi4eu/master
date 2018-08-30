import {Component, Input, OnChanges} from '@angular/core';
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {TranslateService} from "ng2-translate";
import { UserDTOBase } from '../../../shared/swagger';

@Component({selector: 'beneficiary-user', templateUrl: 'beneficiary-user.component.html'})
export class BeneficiaryUserComponent implements OnChanges {
    @Input() user: UserDTOBase;

    constructor(private uxService: UxService, private translateService: TranslateService) {
    }

    ngOnChanges() {
    }
}
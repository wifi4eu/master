import { Component, Input, OnChanges, EventEmitter, Output, SimpleChange, OnInit } from '@angular/core';
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import { TranslateService } from "ng2-translate";
import { UserDTOBase, NutsDTOBase } from '../../../shared/swagger';

@Component({ selector: 'beneficiary-user', templateUrl: 'beneficiary-user.component.html' })
export class BeneficiaryUserComponent implements OnInit {
    @Input() user: UserDTOBase;
    @Input() countries: NutsDTOBase[] = [];
    @Input() isEdit: boolean = false;
    @Input() organizationName: string;
    @Output() onUserChange = new EventEmitter();
    @Output() onOrganizationChange = new EventEmitter();

    private isOrganization: boolean = false;

    constructor(private uxService: UxService, private translateService: TranslateService) {

    }

    ngOnInit() {
        if (this.organizationName != undefined)
            this.isOrganization = true;
    }

    onChangesUser() {
        this.onUserChange.emit(this.user);
    }

    onChangesOrganization() {
        this.onOrganizationChange.emit(this.organizationName);
    }
}
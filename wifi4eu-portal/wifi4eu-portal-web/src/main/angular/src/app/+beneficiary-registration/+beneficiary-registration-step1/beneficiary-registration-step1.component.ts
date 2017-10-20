import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Component({
    selector: 'beneficiary-registration-step1', templateUrl: 'beneficiary-registration-step1.component.html'
})

export class BeneficiaryRegistrationStep1Component implements OnInit {
    @Input('initialUser') initialUser: UserDTOBase;
    @Output() initialUserChange: EventEmitter<UserDTOBase>;
    @Input('representing') representing: boolean;
    @Output() representingChange: EventEmitter<boolean>;
    @Output() onNext: EventEmitter<any>;
    private mayorUser: UserDTOBase;
    private representativeUser: UserDTOBase;
    private mayorEmails: string[] = ['', ''];
    private representativeEmails: string[] = ['', ''];

    constructor(private uxService: UxService) {
        this.initialUserChange = new EventEmitter<UserDTOBase>();
        this.representingChange = new EventEmitter<boolean>();
        this.onNext = new EventEmitter<any>();
    }

    ngOnInit() {
        this.mayorUser = new UserDTOBase();
        this.mayorUser.type = 2;
        this.representativeUser = new UserDTOBase();
        this.representativeUser.type = 3;
    }

    checkRepresentative(option: boolean) {
        this.representing = option;
    }

    submit() {
        let emailsUnmatch = false;
        if (this.representing) {
            if (this.representativeEmails[0].length > 0 && this.representativeEmails[0] == this.representativeEmails[1]) {
                this.representativeUser.email = this.representativeEmails[0];
            } else {
                emailsUnmatch = true;
            }
            this.initialUser = this.representativeUser;
        } else {
            if (this.mayorEmails[0].length > 0 && this.mayorEmails[0] == this.mayorEmails[1]) {
                this.mayorUser.email = this.mayorEmails[0];
            } else {
                emailsUnmatch = true;
            }
            this.initialUser = this.mayorUser;
        }
        if (emailsUnmatch) {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'The email inputs must match.'
            });
        } else {
            this.initialUserChange.emit(this.initialUser);
            this.representingChange.emit(this.representing);
            this.onNext.emit();
        }
    }
}
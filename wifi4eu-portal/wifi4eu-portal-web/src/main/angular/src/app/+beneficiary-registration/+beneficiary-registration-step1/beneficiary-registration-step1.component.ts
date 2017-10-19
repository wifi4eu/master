import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Component({
    selector: 'beneficiary-registration-step1', templateUrl: 'beneficiary-registration-step1.component.html'
})

export class BeneficiaryRegistrationStep1Component implements OnInit {
    @Input('users') users: UserDTOBase[];
    @Input('mayors') mayors: MayorDTOBase[];
    @Input('representing') representing: boolean;
    private mayorUser: UserDTOBase;
    private representativeUser: UserDTOBase;
    private mayorEmails: string[] = ['', ''];
    private representativeEmails: string[] = ['', ''];
    @Output() onNext: EventEmitter<any>;

    constructor(private uxService: UxService) {
        this.onNext = new EventEmitter<any>();
    }

    ngOnInit() {
        this.mayorUser = new UserDTOBase();
        this.representativeUser = new UserDTOBase();
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
            this.users[0] = this.representativeUser;
        } else {
            if (this.mayorEmails[0].length > 0 && this.mayorEmails[0] == this.mayorEmails[1]) {
                this.mayorUser.email = this.mayorEmails[0];
            } else {
                emailsUnmatch = true;
            }
            let mayor = new MayorDTOBase();
            mayor.name = this.mayorUser.name;
            mayor.surname = this.mayorUser.surname;
            mayor.email = this.mayorUser.email;
            this.users[0] = this.mayorUser;
            this.mayors[0] = mayor;
        }
        if (emailsUnmatch) {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'The email inputs must match.'
            });
        } else {
            this.onNext.emit(this.representing);
        }
    }
}
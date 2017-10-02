import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UserDetails} from "../../shared/models/user-details.model";
import {UserService} from "../../shared/services/user.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";


@Component({
    selector: 'review-component',
    templateUrl: 'review.component.html',
    providers: [UserService, BeneficiaryApi]
})

export class ReviewComponent {

    @Input('beneficiaryDTO') beneficiaryDTO: BeneficiaryDTOBase;
    @Input('nutsDTO') nutsDTO: NutsDTOBase;
    @Input('lausDTO') lausDTO: LauDTOBase;
    @Input('selection') selection: boolean[];

    @Output() gotoStep: EventEmitter<number>;
    @Output() onSuccess: EventEmitter<boolean>;
    @Output() onFailure: EventEmitter<boolean>;

    private userDetails: UserDetails;
    private displayConfirmingData: boolean;
    private confirmingData: boolean;
    private successCaptcha: boolean;
    private checkboxes: boolean[];

    constructor(private userService: UserService, private uxService: UxService, private beneficiaryApi: BeneficiaryApi) {
        this.gotoStep = new EventEmitter<number>();
        this.onSuccess = new EventEmitter<boolean>();
        this.onFailure = new EventEmitter<boolean>();
        this.userDetails = new UserDetails();

        this.displayConfirmingData = false;
        this.successCaptcha = false;
        this.checkboxes = [false, false, false];
    }

    onSubmit() {
        this.displayConfirmingData = true;
        this.beneficiaryDTO.legalEntityDTO.legalCheckbox1 = this.checkboxes[0];
        this.beneficiaryDTO.legalEntityDTO.legalCheckbox2 = this.checkboxes[1];
        this.beneficiaryDTO.legalEntityDTO.legalCheckbox3 = this.checkboxes[2];
        this.beneficiaryApi.create(this.beneficiaryDTO).subscribe(
            data => {
                this.displayConfirmingData = false;
                if (data['success'] && data['data'] != null) {
                    this.onSuccess.emit(true);
                } else {
                    this.onFailure.emit(true);
                }
            },
            error => {
                this.displayConfirmingData = false;
                this.onFailure.emit(true);
            }
        );
    }

    editStep(step: number) {
        this.gotoStep.emit(step);
    }

    private onCaptchaComplete(response: any) {
        this.successCaptcha = response.success;
    }

    duplicatedLau() {
        this.uxService.growl({
            severity: 'warn',
            summary: 'WARNING',
            detail: 'I`m a testing growl, I`m doing nothing'
        });


    }
}

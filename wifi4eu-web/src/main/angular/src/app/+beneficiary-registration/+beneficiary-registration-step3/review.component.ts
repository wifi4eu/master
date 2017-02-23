import {Component, Input, Output, EventEmitter} from "@angular/core";
import {EntityDetails} from "../../shared/models/legal-entity-details.model";
import {BeneficiaryDetails} from "../../shared/models/beneficiary-details.model";
import {UserDetails} from "../../shared/models/user-details.model";
import {UserService} from "../../shared/services/user.service";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {BeneficiaryDTO} from "./beneficiaryDTO.model";

@Component({
    selector: 'review-component',
    templateUrl: 'review.component.html',
    providers: [UserService]
})
export class ReviewComponent {
    @Input('entityDetails') entityDetails: EntityDetails;
    @Input('beneficiaryDetails') beneficiaryDetails: BeneficiaryDetails;
    @Output() gotoStep: EventEmitter<number>;
    @Output() onSuccess: EventEmitter<boolean>;
    @Output() onFailure: EventEmitter<boolean>;

    displayConfirmingData: boolean;
    confirmingData: boolean;

    private countryField;
    private municipalityField;
    private checkboxes: boolean[];
    private userDetails: UserDetails;
    private successCaptcha: boolean;

    private beneficiaryDTO: BeneficiaryDTO;

    constructor(private userService: UserService, private uxService: UxService) {
        this.gotoStep = new EventEmitter<number>();
        this.onSuccess = new EventEmitter<boolean>();
        this.onFailure = new EventEmitter<boolean>();
        this.userDetails = new UserDetails();
        this.displayConfirmingData = false;
        this.confirmingData = true;
        this.checkboxes = [false, false, false];
        this.successCaptcha = false;
    }

    submitRegistration() {
        if (!this.entityDetails || !this.beneficiaryDetails) {
            this.onFailure.emit(true);
            return;
        }

        this.userDetails.entity = this.entityDetails;
        this.userDetails.beneficiary = this.beneficiaryDetails;

        this.displayConfirmingData = true;

        this.beneficiaryDTO = this.mapperBeneficiaryDTO(this.userDetails);

        this.userService.addBeneficiary(this.beneficiaryDTO).subscribe(
            user => console.log(user),
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get user, ignore this when NG is' + ' working in offline mode'
                });
                console.log('WARNING: Could not get user: ', error);
            }
        );

        setTimeout(() => {
            this.displayConfirmingData = false;
            this.onSuccess.emit(true);
        }, 2000);
    }

    editStep(step: number) {
        this.gotoStep.emit(step);
    }

    checkObjects() {
        this.countryField = this.entityDetails.country;
        this.municipalityField = this.entityDetails.municipality;
        if (typeof this.entityDetails.country != "string") {
            this.countryField = this.entityDetails.country.name;
            this.municipalityField = this.entityDetails.municipality.NAME_1;
        }
    }

    mapperBeneficiaryDTO(userDetails: UserDetails): BeneficiaryDTO {

        console.log("Mapping beneficiaryDetails to benenficiaryDTO...");

        let beneficiaryDTO: BeneficiaryDTO = new BeneficiaryDTO();

        beneficiaryDTO.mayorDTO.email = userDetails.beneficiary.email;
        beneficiaryDTO.mayorDTO.name = userDetails.beneficiary.name;
        beneficiaryDTO.mayorDTO.surname = userDetails.beneficiary.surname;
        beneficiaryDTO.mayorDTO.treatment = userDetails.beneficiary.treatment;
        beneficiaryDTO.mayorDTO.repeatEmail = userDetails.beneficiary.email;

        beneficiaryDTO.legalEntityDTO.address = userDetails.entity.address;
        beneficiaryDTO.legalEntityDTO.addressNum = userDetails.entity.number;
        beneficiaryDTO.legalEntityDTO.postalCode = userDetails.entity.postalCode;
        beneficiaryDTO.legalEntityDTO.countryCode = userDetails.entity.country.code;
        beneficiaryDTO.legalEntityDTO.legalCheckbox1 = true;
        beneficiaryDTO.legalEntityDTO.legalCheckbox2 = true;
        beneficiaryDTO.legalEntityDTO.legalCheckbox3 = true;
        beneficiaryDTO.legalEntityDTO.municipalityCode = userDetails.entity.municipality.LAU1_NAT_CODE;

        console.log("Mapping result:", beneficiaryDTO);

        return beneficiaryDTO;
    }

    private onCaptchaComplete(response: any) {
        this.successCaptcha = response.success;
    }

}

import {Component, Output, ViewChild} from '@angular/core';
import {CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {LegalEntityDTO, LegalEntityDTOBase} from "../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {BenPubSupDTOBase} from "../../shared/swagger/model/BenPubSupDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {UserDTO} from "../../shared/swagger/model/UserDTO";
import {RepresentativeDTOBase} from "../../shared/swagger/model/RepresentativeDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {CallApi} from "../../shared/swagger/api/CallApi";

@Component({
    templateUrl: 'voucher.component.html',
    providers: [BeneficiaryApi, CallApi]
})
export class VoucherComponent {
    private voucherCompetitionState: number;
    private user: UserDTO;
    private currentCall: CallDTOBase;
    private myMunicipality: LegalEntityDTO;
    private errorCause: string;

    constructor(private localStorage: LocalStorageService, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new CallDTOBase();
        this.myMunicipality = new LegalEntityDTOBase();
    }

    ngOnInit() {
        if (this.user != null) {
            if (this.user.userType == 3) {
                this.beneficiaryApi.getRepresentativeById(this.user.userTypeId).subscribe(
                    (representative: RepresentativeDTOBase) => {
                        this.beneficiaryApi.getMayorById(representative.mayorId).subscribe(
                            (mayor: MayorDTOBase) => {
                                this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(
                                    entity => {
                                        this.myMunicipality = entity;
                                        this.checkForCalls();
                                    },
                                    error => {
                                        console.log(error);
                                        this.myMunicipality = null;
                                        this.voucherCompetitionState = -1;
                                        this.errorCause = "beneficiaryportal.municipalitynotfound";
                                    }
                                );
                            }, error => {
                                console.log(error);
                                this.myMunicipality = null;
                                this.voucherCompetitionState = -1;
                                this.errorCause = "beneficiaryportal.municipalitynotfound";
                            }
                        );
                    }, error => {
                        console.log(error);
                        this.myMunicipality = null;
                        this.voucherCompetitionState = -1;
                        this.errorCause = "beneficiaryportal.municipalitynotfound";
                    }
                );
            } else if (this.user.userType == 2) {
                this.beneficiaryApi.getMayorById(this.user.userTypeId).subscribe(
                    (mayor: MayorDTOBase) => {
                        this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(
                            entity => {
                                this.myMunicipality = entity;
                                this.checkForCalls();
                            },
                            error => {
                                console.log(error);
                                this.myMunicipality = null;
                                this.voucherCompetitionState = -1;
                                this.errorCause = "beneficiaryportal.municipalitynotfound";
                            }
                        );
                    }, error => {
                        console.log(error);
                        this.myMunicipality = null;
                        this.voucherCompetitionState = -1;
                        this.errorCause = "beneficiaryportal.municipalitynotfound";
                    }
                );
            }
        }
    }

    checkForCalls() {
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.currentCall != null) {
                    // First, check if the call has already began
                    if ((this.currentCall.startDate - new Date().getTime()) <= 0) {
                        this.checkIfAlreadyApplied();
                    } else {
                        // The competition hasn't started, display the timer
                        this.voucherCompetitionState = 1;
                    }
                } else {
                    // Display "no competition active" message
                    this.voucherCompetitionState = 0;
                }
            },
            error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 0;
            }
        );
    }

    checkIfAlreadyApplied() {
        this.beneficiaryApi.findByBeneficiaryIdAndPublicationId(this.myMunicipality.legalEntityId, this.currentCall.callId).subscribe(
            (request: BenPubSupDTOBase) => {
                if (request != null) {
                    if (request.awarded) {
                        // Display 'Select supplier' screen.
                        this.voucherCompetitionState = 4;
                    } else {
                        this.voucherCompetitionState = 3;
                    }
                } else {
                    // The user hasn't applied yet, display the "Apply for Voucher" button.
                    this.voucherCompetitionState = 2;
                }
            },
            error => {
                console.log(error);
                this.voucherCompetitionState = -1;
                this.errorCause = "beneficiaryportal.couldntcheckifapplied";
            }
        );
    }

    applyForVoucher() {
        this.beneficiaryApi.apply(this.myMunicipality.legalEntityId, this.currentCall.callId).subscribe(
            data => {
                this.voucherCompetitionState = 3;
            },
            error => {
                console.log(error);
                this.voucherCompetitionState = -1;
                this.errorCause = "beneficiaryportal.errorapplying";
            }
        );
    }
    
}
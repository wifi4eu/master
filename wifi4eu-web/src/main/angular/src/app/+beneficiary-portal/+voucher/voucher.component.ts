import {Component, Output, ViewChild} from '@angular/core';
import {CallDTOBase} from "../../shared/swagger/model/CallDTO";
import {LegalEntityDTO, LegalEntityDTOBase} from "../../shared/swagger/model/LegalEntityDTO";
import {BeneficiaryApi} from "../../shared/swagger/api/BeneficiaryApi";
import {UserDTO} from "../../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
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

    constructor(private localStorage: LocalStorageService, private beneficiaryApi: BeneficiaryApi, private callApi: CallApi) {
        this.voucherCompetitionState = -1;
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new CallDTOBase();
        this.myMunicipality = new LegalEntityDTOBase();
        
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.currentCall != null) {
                    this.voucherCompetitionState = 0;
                }
            },
            error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 3;
            }
        );
    }

    ngOnInit() {
        if (this.user != null) {
            if (this.user.userType == 3) {
                this.beneficiaryApi.getRepresentativeById(this.user.userTypeId).subscribe(
                    (representative: RepresentativeDTOBase) => {
                        this.beneficiaryApi.getMayorById(representative.mayorId).subscribe(
                            (mayor: MayorDTOBase) => {
                                this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(
                                    entity => this.myMunicipality = entity,
                                    error => {
                                        console.log(error);
                                        this.myMunicipality = null;
                                        this.voucherCompetitionState = 3;
                                    }
                                );
                            }, error => {
                                console.log(error);
                                this.myMunicipality = null;
                                this.voucherCompetitionState = 3;
                            }
                        );
                    }, error => {
                        console.log(error);
                        this.myMunicipality = null;
                        this.voucherCompetitionState = 3;
                    }
                );
            } else if (this.user.userType == 2) {
                this.beneficiaryApi.getMayorById(this.user.userTypeId).subscribe(
                    (mayor: MayorDTOBase) => {
                        this.beneficiaryApi.getLegalEntity(mayor.legalEntityId).subscribe(
                            entity => this.myMunicipality = entity,
                            error => {
                                console.log(error);
                                this.myMunicipality = null;
                                this.voucherCompetitionState = 3;
                            }
                        );
                    }, error => {
                        console.log(error);
                        this.myMunicipality = null;
                        this.voucherCompetitionState = 3;
                    }
                );
            }
        }
    }

    beginCompetition() {
        this.voucherCompetitionState = 1;
        this.checkIfAlreadyApplied();
    }

    applyForVoucher() {
        this.beneficiaryApi.apply(this.myMunicipality.legalEntityId, this.currentCall.callId).subscribe(
            data => {
                this.voucherCompetitionState = 2;
            },
            error => {
                console.log(error);
                this.voucherCompetitionState = 3;
            }
        );
    }

    checkIfAlreadyApplied() {
        this.beneficiaryApi.findByBeneficiaryIdAndPublicationId(this.myMunicipality.legalEntityId, this.currentCall.callId).subscribe(
            call => {
                if (call != null) {
                    this.voucherCompetitionState = 4;
                }
            },
            error => {
                console.log(error);
                this.voucherCompetitionState = 3;
            }
        );
    }
}
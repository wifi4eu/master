import {Component} from "@angular/core";
import {CallDTOBase} from "../shared/swagger/model/CallDTO";
import {SupplierDTO, SupplierDTOBase} from "../shared/swagger/model/SupplierDTO";
import {MunicipalityDTO, MunicipalityDTOBase} from "../shared/swagger/model/MunicipalityDTO";
import {SupplierApi} from "../shared/swagger/api/SupplierApi";
import {UserDTO} from "../shared/swagger/model/UserDTO";
import {LocalStorageService} from "angular-2-local-storage";
import {CallApi} from "../shared/swagger/api/CallApi";

@Component({templateUrl: 'supplier-portal.component.html', providers: [SupplierApi, CallApi]})
export class SupplierPortalComponent {
    private voucherCompetitionState: number;
    private user: UserDTO;
    private currentCall: CallDTOBase;
    private supplierInfo: SupplierDTO;
    private municipalitiesThatSelectedMe: MunicipalityDTO[];
    private errorCause: string;

    constructor(private localStorage: LocalStorageService, private supplierApi: SupplierApi, private callApi: CallApi) {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
        this.currentCall = new CallDTOBase();
        this.supplierInfo = new SupplierDTOBase();
        this.municipalitiesThatSelectedMe = [];
    }

    ngOnInit() {
        if (this.user != null) {
            this.supplierApi.getSupplierById(this.user.id).subscribe(
                (supplier: SupplierDTOBase) => {
                    this.supplierInfo = supplier;
                    this.checkForCalls();
                }, error => {
                    console.log(error);
                    this.supplierInfo = null;
                    this.voucherCompetitionState = -1;
                    this.errorCause = "supplierportal.suppliernotfound";
                }
            );
        }
    }

    checkForCalls() {
        this.callApi.allCalls().subscribe(
            calls => {
                this.currentCall = calls[0];
                if (this.currentCall != null) {
                    // First, check if the call has already began
                    if ((this.currentCall.startDate - new Date().getTime()) <= 0) {
                        this.checkIfSelected();
                    } else {
                        // The competition hasn't started, display the timer
                        this.voucherCompetitionState = 1;
                    }
                } else {
                    // Display "no competition active" message
                    this.voucherCompetitionState = 0;
                }
            }, error => {
                console.log(error);
                this.currentCall = null;
                this.voucherCompetitionState = 0;
            }
        );
    }

    checkIfSelected() {
        this.supplierApi.getSupplierByUserId(this.user.id).subscribe(
            (entities: MunicipalityDTO[]) => {
                if (entities.length > 0) {
                    this.municipalitiesThatSelectedMe = entities;
                    // Display the 'municipalities' screen
                    this.voucherCompetitionState = 3;
                } else {
                    this.voucherCompetitionState = 2;
                }
            }, error => {
                console.log(error);
                this.supplierInfo = null;
                this.voucherCompetitionState = -1;
                this.errorCause = "supplierportal.couldntgetselectedmunicipalities";
            }
        );
    }
}
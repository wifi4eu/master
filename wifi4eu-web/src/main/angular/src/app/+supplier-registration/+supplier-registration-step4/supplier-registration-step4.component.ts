import {Component, Input, EventEmitter, Output} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {NutsDTO} from "../../shared/swagger/model/NutsDTO";

@Component({
    selector: 'supplier-registration-step4-component',
    templateUrl: 'supplier-registration-step4.component.html',
    providers: [SupplierApi]
})

export class SupplierRegistrationComponentStep4 {
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;

    @Input('selection') selection: boolean[];

    private legalChecks: boolean[];
    private successCaptcha: boolean;
    private display: boolean;

    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;
    @Output() gotoStep: EventEmitter<number>;
    @Output() onSuccess: EventEmitter<boolean>;
    @Output() onFailure: EventEmitter<boolean>;

    @Input('nuts0') nuts0: NutsDTO[];
    @Input('nuts3') nuts3: NutsDTO[];

    constructor(private supplierApi: SupplierApi, private uxService: UxService) {
        this.legalChecks = [false, false];
        this.successCaptcha = false;
        this.display = false;

        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
        this.gotoStep = new EventEmitter<number>();
        this.onSuccess = new EventEmitter<boolean>();
        this.onFailure = new EventEmitter<boolean>();
    }

    openModal() {
        this.display = true;
    }

    private onCaptchaComplete(response: any) {
        this.successCaptcha = response.success;
    }

    onSubmit() {
        this.supplierDTO.legalCheck1 = this.legalChecks[0];
        this.supplierDTO.legalCheck2 = this.legalChecks[1];
        for (let country of this.nuts0) {
            this.supplierDTO.nutsIds += '' + country.code.toString() + ',';
        }
        for (let regions of this.nuts3) {
            this.supplierDTO.nutsIds += '' + regions.code.toString() + ',';
        }
        this.supplierDTO.nutsIds = this.supplierDTO.nutsIds.slice(0, -1);
        this.supplierApi.createSupplier(this.supplierDTO).subscribe(
            data => {
                if (data['success'] != true) {
                    this.onFailure.emit(true);
                    return;
                }
                this.onSuccess.emit(true)

            },
            error => {
                this.onFailure.emit(true);
            }
        );
    }

    editStep(step: number) {
        this.gotoStep.emit(step);
    }
}

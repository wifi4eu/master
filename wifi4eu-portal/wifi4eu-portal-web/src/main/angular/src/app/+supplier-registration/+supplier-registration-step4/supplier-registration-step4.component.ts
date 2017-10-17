import {Component, Input, EventEmitter, Output, OnInit} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {SupplierApi} from "../../shared/swagger/api/SupplierApi";
import {SupplierDTOBase} from "../../shared/swagger/model/SupplierDTO";
import {NutsDTO} from "../../shared/swagger/model/NutsDTO";
import {SuppliedRegionDTOBase} from "../../shared/swagger/model/SuppliedRegionDTO";
import {UserDTO, UserDTOBase} from "../../shared/swagger/model/UserDTO"
import {UserApi} from "../../shared/swagger/api/UserApi";

@Component({
    selector: 'supplier-registration-step4-component',
    templateUrl: 'supplier-registration-step4.component.html',
    providers: [SupplierApi, UserApi]
})

export class SupplierRegistrationComponentStep4 implements OnInit {
    private legalChecks: boolean[];
    private successCaptcha: boolean;
    private display: boolean;
    private isLogoUploaded: boolean = false;
    private logoUrl: FileReader = new FileReader();
    private userDTO: UserDTO[];
    private userDTOBase: UserDTOBase;
    @Input('supplierDTO') supplierDTO: SupplierDTOBase;
    @Input('selection') selection: boolean[];
    @Input('nuts0') nuts0: NutsDTO[];
    @Input('nuts3') nuts3: NutsDTO[][];
    @Input('logoFile') logoFile: File;
    @Output() onNext: EventEmitter<number>;
    @Output() onBack: EventEmitter<number>;
    @Output() gotoStep: EventEmitter<number>;
    @Output() onSuccess: EventEmitter<boolean>;
    @Output() onFailure: EventEmitter<boolean>;

    constructor(private supplierApi: SupplierApi, private uxService: UxService, private userApi: UserApi) {
        this.legalChecks = [false, false];
        this.successCaptcha = false;
        this.display = false;

        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
        this.gotoStep = new EventEmitter<number>();
        this.onSuccess = new EventEmitter<boolean>();
        this.onFailure = new EventEmitter<boolean>();
    }

    ngOnInit() {
        if (this.logoFile) {
            this.isLogoUploaded = true;
            this.logoUrl.readAsDataURL(this.logoFile);
        }
    }

    openModal() {
        this.display = true;
    }


    private onCaptchaComplete(response: any) {
        // this.successCaptcha = response.success;
    }

    onSubmit() {
        // this.supplierDTO.legalCheck1 = this.legalChecks[0];
        // this.supplierDTO.legalCheck2 = this.legalChecks[1];

        for (let country of this.nuts0) {
            for (let i = 0; i < this.nuts3[country.label].length; i++) {
                let suppliedRegion = new SuppliedRegionDTOBase();
                suppliedRegion.regionId = this.nuts3[country.label][i].id;
                this.supplierDTO.suppliedRegions.push(suppliedRegion);
            }
        }

        let user = new UserDTOBase();
        user.name = this.supplierDTO.contactName;
        user.email = this.supplierDTO.contactEmail;
        user.surname = this.supplierDTO.contactSurname;

        this.userApi.createUser(user).subscribe(
            data => {
                this.supplierApi.createSupplier(this.supplierDTO).subscribe(
                    data => {
                        if (data['success'] != true) {
                            this.onFailure.emit(true);
                            return;
                        }
                        this.onSuccess.emit(true);
                    },
                    error => {
                        this.onFailure.emit(true);
                    }
                );

            }, error => {
                this.onFailure.emit(true);
            }
        );


    }

    editStep(step: number) {
        this.gotoStep.emit(step);
    }
}

import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {SharedService} from "../../shared/shared.service";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {LocalStorageService} from "angular-2-local-storage";

@Component({
    selector: 'beneficiary-registration-step4', templateUrl: 'beneficiary-registration-step4.component.html',
    styles: [`
      .publish-button {
        width: auto;
        min-width: 10em;
      }
    `]
})

export class BeneficiaryRegistrationStep4Component {
    @Input('initialUser') private initialUser: UserDTOBase;
    @Input('country') private country: NutsDTOBase;
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Input('mayors') private mayors: UserDTOBase[];
    @Input('multipleMunicipalities') private multipleMunicipalities: boolean;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    @Output() private onEdit: EventEmitter<number>;
    private displayConfirmingData: boolean = false;
    private legalChecks: boolean[] = [true, false, false, false, false, false, false, false, false, false];
    private allChecked: boolean = false;

    constructor(private sharedService: SharedService, private localStorage: LocalStorageService, private userApi: UserApi) {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();
    }

    submit() {
        this.check(this.legalChecks);
        if (this.allChecked) {
            this.displayConfirmingData = true;
            this.onNext.emit();
        }else{
            alert("You must check all the conditions")
        }
    }

    private back() {
        this.onBack.emit();
        this.legalChecks = [true, false, false, false, false, false, false, false, false];
    }

    private edit(step: number) {
        this.onEdit.emit(step);
        this.legalChecks = [true, false, false, false, false, false, false, false, false];
        this.sharedService.clean();
    }

    check(legalChecks: boolean[]){
        if(!legalChecks[1] || !legalChecks[2] || !legalChecks[3]
            || !legalChecks[4] || !legalChecks[5] || !legalChecks[6] || !legalChecks[7]
            || !legalChecks[8]){
            this.allChecked = false;
        }else{
            this.allChecked = true;
        }
    }
}
import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {SharedService} from "../../shared/shared.service";
import {UserApi} from "../../shared/swagger/api/UserApi";
import {LocalStorageService} from "angular-2-local-storage";


@Component({
    selector: 'beneficiary-registration-step4', templateUrl: 'beneficiary-registration-step4.component.html'
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
    private legalChecks: boolean[] = [true, false, false, false, false, false, false, false, false];

    constructor(private sharedService: SharedService, private localStorage: LocalStorageService, private userApi: UserApi) {
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
        this.onEdit = new EventEmitter<any>();
    }

    private submit() {
        if (this.legalChecks) {
            this.setLanguage();
            this.displayConfirmingData = true;
            this.onNext.emit();
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

    private setLanguage() {
        let language = this.localStorage.get('lang');
        if (!language) {
            language = 'en';
        }

        this.userApi.setUserLang(language.toString()).subscribe(
            (language: string) => {
                console.log("The mail will send in " + language);
            }, error => {
                console.log(error);
            }
        );
    }
}
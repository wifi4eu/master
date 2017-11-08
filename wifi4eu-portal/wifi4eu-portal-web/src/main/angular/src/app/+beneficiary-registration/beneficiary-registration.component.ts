import {Component} from "@angular/core";
import {UserDTOBase} from "../shared/swagger/model/UserDTO";
import {MunicipalityDTOBase} from "../shared/swagger/model/MunicipalityDTO";
import {BeneficiaryDTOBase} from "../shared/swagger/model/BeneficiaryDTO";
import {BeneficiaryApi} from "../shared/swagger/api/BeneficiaryApi";
import {ResponseDTOBase} from "../shared/swagger/model/ResponseDTO";
import {NutsDTOBase} from "../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../shared/swagger/model/LauDTO";
import {NutsApi} from "../shared/swagger/api/NutsApi";
import {LauApi} from "../shared/swagger/api/LauApi";
import {Subscription} from "rxjs/Subscription";

@Component({
    selector: 'beneficiary-registration', templateUrl: 'beneficiary-registration.component.html', providers: [BeneficiaryApi, NutsApi, LauApi]
})

export class BeneficiaryRegistrationComponent {
    private successRegistration: boolean = false;
    private failureRegistration: boolean = false;
    private completed: boolean[] = [false, false, false, false];
    private active: boolean[] = [true, false, false, false];
    private representing: boolean = false;
    private initialUser: UserDTOBase = new UserDTOBase();
    private users: UserDTOBase[] = [new UserDTOBase()];
    private municipalities: MunicipalityDTOBase[] = [new MunicipalityDTOBase()];
    private userAddress: string = "";
    //private registrations: RegistrationDTOBase[] = [];
    private finalBeneficiary: BeneficiaryDTOBase = new BeneficiaryDTOBase();
    private country: NutsDTOBase = null;
    private multipleMunicipalities: boolean = false;
    private countries: NutsDTOBase[] = [];
    private laus: LauDTOBase[][] = [];
    private countrySubscription: Subscription = new Subscription();

    constructor(private beneficiaryApi: BeneficiaryApi, private nutsApi: NutsApi, private lauApi: LauApi) {
        this.nutsApi.getNutsByLevel(0).subscribe(
            (nuts: NutsDTOBase[]) => {
                this.countries = nuts;
            }, error => {
                console.log(error);
            }
        );
    }

    selectCountry(country: NutsDTOBase) {
        if (this.country != country) {
            this.country = country;
            if (!this.laus[country.countryCode]) {
                this.laus[country.countryCode] = [];
            }
            this.countrySubscription.unsubscribe();
            this.countrySubscription = this.lauApi.getLausByCountryCode(country.countryCode).subscribe(
                (laus: LauDTOBase[]) => {
                    this.laus[country.countryCode] = laus;
                }
            );
        }
    }

    navigate(step: number) {
        switch (step) {
            case 1:
                this.completed = [false, false, false, false];
                this.active = [true, false, false, false];
                break;
            case 2:
                this.completed = [true, false, false, false];
                this.active = [false, true, false, false];
                break;
            case 3:
                this.completed = [true, true, false, false];
                this.active = [false, false, true, false];
                break;
            case 4:
                this.completed = [true, true, true, false];
                this.active = [false, false, false, true];
                break;
        }
    }

    submitRegistration() {
        this.finalBeneficiary.representing = this.representing;
        this.finalBeneficiary.users = [];
        this.finalBeneficiary.municipalities = [];
        this.finalBeneficiary.users.push(this.initialUser);
        for (let user of this.users) {
            this.finalBeneficiary.users.push(user);
        }
        for (let municipality of this.municipalities) {
            this.finalBeneficiary.municipalities.push(municipality);
        }
        this.beneficiaryApi.submitBeneficiaryRegistration(this.finalBeneficiary).subscribe(
            (data: ResponseDTOBase) => {
                if (data.success) {
                    this.successRegistration = true;
                } else {
                    this.failureRegistration = true;
                }
                console.log(data);
            }, error => {
                this.failureRegistration = true;
                console.log(error);
            }
        );
    }
}
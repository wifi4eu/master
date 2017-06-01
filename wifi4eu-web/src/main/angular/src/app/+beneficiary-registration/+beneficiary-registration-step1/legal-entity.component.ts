import {Component, Input, Output, EventEmitter} from "@angular/core";
import {Http} from "@angular/http";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";

@Component({
    selector: 'legal-entity-component',
    templateUrl: 'legal-entity.component.html',
    providers: [LauApi, NutsApi]
})
export class EntityComponent {
    @Input('beneficiaryDTO') beneficiaryDTO: BeneficiaryDTOBase;
    @Input('nutsDTO') nutsDTO: NutsDTOBase;
    @Input('lausDTO') lausDTO: NutsDTOBase;

    @Output() onNext = new EventEmitter<number>();

    private nutsSuggestions: NutsDTOBase[];
    private lausSuggestions: LauDTOBase[];

    constructor(private http: Http, private lauApi: LauApi, private nutsApi: NutsApi, private uxService: UxService) {
    }

    onSubmit(step: number) {
        this.onNext.emit(step);
    }

    onKeyUp(event) {
        // Check if key pressed is a ascii printable letter
        if (event.keyCode > 64 && event.keyCode < 91) {
            if (typeof this.nutsDTO === "string") {
                let name: string = this.nutsDTO;
                let nuts = this.nutsSuggestions;
                for (let i = 0; i < nuts.length; i++) {
                    let nut = nuts[i];
                    if (nut.name.toLowerCase().indexOf(name.toLowerCase()) == 0) {
                        this.nutsDTO = nut;
                    }
                }
            }
        }
    }

    filterNuts(event) {
        this.nutsApi.findNutsByLevel(0).subscribe(
            nuts => {
                this.nutsSuggestions = this.filterCountries(event.query, nuts)
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get nuts, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get nuts', error);
            }
        );
    }

    filterCountries(query, nuts: NutsDTOBase[]) {
        let filteredNuts: NutsDTOBase[] = [];
        for (let i = 0; i < nuts.length; i++) {
            let nut = nuts[i];
            nut.name = nut.name.toLowerCase();
            if (nut.name.indexOf(query.toLowerCase()) == 0) {
                nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1);
                filteredNuts.push(nut);
            }
        }
        return filteredNuts;
    }

    filterLaus(event) {
        this.lauApi.findLauByCountryCode(this.nutsDTO.countryCode).subscribe(
            laus => {
                this.lausSuggestions = this.filterMunicipalities(event.query, laus)
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get LAU, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get nuts', error);
            }
        );
    }

    filterMunicipalities(query, laus: LauDTOBase[]) {
        let filteredLaus: LauDTOBase[] = [];

        for (let i = 0; i < laus.length; i++) {
            let lau = laus[i];
            if (lau.name1 != null) {
                if (lau.name1.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                    filteredLaus.push(lau);
                }
            }
        }
        return filteredLaus;
    }

    isValidNutsLausSelection() {
        let isValid = true;
        if (!(typeof this.nutsDTO === 'object') || !(typeof this.lausDTO === 'object')) {
            isValid = false;
        }
        return isValid; 
    }

    isValidNutsSeleted() {
        return typeof this.nutsDTO === 'object';
    }
}
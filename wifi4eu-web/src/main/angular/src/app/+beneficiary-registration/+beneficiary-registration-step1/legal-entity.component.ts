import {Component, Input, Output, EventEmitter} from "@angular/core";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";
import {NutsDTO, NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTO, LauDTOBase} from "../../shared/swagger/model/LauDTO";

@Component({
    selector: 'legal-entity-component',
    templateUrl: 'legal-entity.component.html',
    providers: [LauApi, NutsApi]
})
export class EntityComponent {
    @Input('beneficiaryDTO') beneficiaryDTO: BeneficiaryDTOBase;
    @Input('nutsDTO') nutsDTO: NutsDTOBase;
    @Input('lausDTO') lausDTO: NutsDTOBase;
    @Input('allCountries') allCountries: NutsDTO[];
    @Input('allMunicipalities') allMunicipalities: NutsDTO[][];

    @Output() onNext = new EventEmitter<number>();

    private nutsSuggestions: NutsDTOBase[];
    private lausSuggestions: LauDTOBase[];

    private readyMunicipalities: boolean = false;
    private placeholderMunicipality: string = 'Barcelona';

    constructor(private lauApi: LauApi, private nutsApi: NutsApi, private uxService: UxService) {
    }

    ngOnInit() {
        if (this.allCountries == null || this.allCountries.length <= 0) {
            this.nutsApi.findNutsByLevel(0).subscribe(
                (countries: NutsDTO[]) => {
                    this.allCountries = [];
                    this.allMunicipalities = [];
                    for (let country of countries) {
                        this.allCountries.push(country);
                    }
                }
            );
        }
        if (this.nutsDTO != null && this.lausDTO != null) {
            this.readyMunicipalities = true;
            this.placeholderMunicipality = '';
        }
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
        this.nutsSuggestions = this.filterCountries(event.query, this.allCountries);
        this.checkIfCountryIsWritten();
    }

    filterCountries(query, nuts: NutsDTOBase[]) {
        let filteredNuts: NutsDTOBase[] = [];
        for (let i = 0; i < nuts.length; i++) {
            let nut = nuts[i];
            nut.name = nut.name.toLowerCase();
            if (nut.name.indexOf(query.toLowerCase()) == 0) {
                nut.name = this.formatCountryName(nut.name);
                filteredNuts.push(nut);
            }
        }
        return filteredNuts;
    }

    checkIfCountryIsWritten() {
        this.lausDTO = null;
        if (typeof this.nutsDTO === "string") {
            let name: string = this.nutsDTO;
            for (let country of this.allCountries) {
                if (this.formatCountryName(name) == this.formatCountryName(country.name)) {
                    this.nutsDTO = country;
                    this.selectCountry();
                }
            }
        }
    }

    formatCountryName(name) {
        return name.charAt(0).toUpperCase() + name.slice(1).toLowerCase()
    }

    selectCountry() {
        this.lausDTO = null;
        if (this.allMunicipalities[this.formatCountryName(this.nutsDTO.name)]) {
            if (this.allMunicipalities[this.formatCountryName(this.nutsDTO.name)].length > 0) {
                this.readyMunicipalities = true;
                this.placeholderMunicipality = '';
            } else {
                this.readyMunicipalities = false;
                this.placeholderMunicipality = 'Loading municipalities...';
            }
        } else {
            this.allMunicipalities[this.formatCountryName(this.nutsDTO.name)] = [];
            this.readyMunicipalities = false;
            this.placeholderMunicipality = 'Loading municipalities...';
            this.lauApi.findLauByCountryCode(this.nutsDTO.countryCode).subscribe(
                (laus: LauDTO[]) => {
                    if (laus.length > 0) {
                        if (laus[0].countryCode == this.nutsDTO.countryCode) {
                            this.allMunicipalities[this.formatCountryName(this.nutsDTO.name)] = laus;
                            this.readyMunicipalities = true;
                            this.placeholderMunicipality = '';
                        } else {
                            for (let country of this.allCountries) {
                                if (laus[0].countryCode == country.countryCode) {
                                    this.allMunicipalities[this.formatCountryName(country.name)] = laus;
                                    break;
                                }
                            }
                        }
                    } else {
                        this.uxService.growl({
                            severity: 'warn',
                            summary: 'WARNING',
                            detail: 'Could not find any LAU for this country'
                        });
                    }
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
    }

    filterLaus(event) {
        this.lausSuggestions = this.filterMunicipalities(event.query, this.allMunicipalities[this.nutsDTO.name]);
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
        return ((typeof this.nutsDTO === 'object') && (typeof this.lausDTO === 'object' && this.lausDTO != null));
    }

    isValidNutsSeleted() {
        return (typeof this.nutsDTO === 'object') && this.readyMunicipalities;
    }
}
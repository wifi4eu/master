import {Component, Input, Output, EventEmitter, ViewChild} from "@angular/core";
import {MultiSelect, SelectItem} from "primeng/primeng";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LangChangeEvent, TranslateService} from "ng2-translate";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";
import {UxLanguage} from "@ec-digit-uxatec/eui-angular2-ux-language-selector/dist/ux-language";
import {SharedService} from "../../shared/shared.service";
import {LocalStorageService} from "angular-2-local-storage";

@Component({
    selector: 'supplier-registration-step2', templateUrl: 'supplier-registration-step2.component.html'
})

export class SupplierRegistrationStep2Component {
    @Input('selectedCountriesNames') private selectedCountriesNames: string[];
    @Output() private selectedCountriesNamesChange: EventEmitter<string[]>;
    @Input('selectedRegions') private selectedRegions: NutsDTOBase[][];
    @Output() private selectedRegionsChange: EventEmitter<NutsDTOBase[][]>;
    @Input('allCountriesSelect') private allCountriesSelect: SelectItem[];
    @Input('allRegionsSelect') private allRegionsSelect: SelectItem[][];
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    private selectedCountries: NutsDTOBase[] = [];
    private areRegionsSelected: boolean = false;
    private chooseTranslation: Map<String, String>;
    @ViewChild("selectRegions") selectRegions: MultiSelect;
    @ViewChild("selectCountry") selectCountry: MultiSelect;

    constructor(private translateService: TranslateService, private uxService: UxService, private localStorage: LocalStorageService, private sharedService: SharedService) {
        this.selectedRegionsChange = new EventEmitter<NutsDTOBase[][]>();
        this.selectedCountriesNamesChange = new EventEmitter<string[]>();
        this.onNext = new EventEmitter<number>();
        this.onBack = new EventEmitter<number>();
        translateService.setDefaultLang('en');
        this.translateService.onLangChange.subscribe(
            (event: LangChangeEvent) => {
                this.updateChooseTranslation();
            }
        );
    }

    checkIfRegionsSelected() {
        this.areRegionsSelected = true;
        for (let country of this.allCountriesSelect) {
            let countryFound = false;
            if (this.selectedCountries.length > 0) {
                for (let selectedCountry of this.selectedCountries) {
                    if (this.selectedRegions[selectedCountry.label] != null) {
                        if (this.selectedRegions[selectedCountry.label].length == 0) {
                            this.areRegionsSelected = false;
                        }
                    } else {
                        this.areRegionsSelected = false;
                    }
                    if (selectedCountry.countryCode == country.value.countryCode) {
                        if (this.selectedRegions[selectedCountry.label].length > 0) {
                            countryFound = true;
                        }
                    }
                }
            } else {
                this.areRegionsSelected = false;
            }
            if (!countryFound) {
                this.selectedRegions[country.value.label] = [];
            }
        }
    }

    cleanEmptyRegions() {
        this.selectedCountriesNames = [];
        let countriesToRemove: number[] = [];
        let removedCount = 0;
        for (let selectedCountry of this.selectedCountries) {
            if (this.selectedRegions[selectedCountry.label].length == 0) {
                countriesToRemove.push(this.selectedCountries.indexOf(selectedCountry));
            } else {
                this.selectedCountriesNames.push(selectedCountry.label);
            }
        }
        for (let index of countriesToRemove) {
            this.selectedCountries.splice(index - removedCount, 1);
            removedCount++;
        }
    }

    submit() {
        this.cleanEmptyRegions();
        this.selectedCountriesNamesChange.emit(this.selectedCountriesNames);
        this.selectedRegionsChange.emit(this.selectedRegions);
        this.onNext.emit();
    }

    back() {
        this.cleanEmptyRegions();
        this.selectedCountriesNamesChange.emit(this.selectedCountriesNames);
        this.selectedRegionsChange.emit(this.selectedRegions);
        this.onBack.emit();
    }

    changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
        this.updateChooseTranslation();
    }

    private updateChooseTranslation() {
        this.translateService.get('shared.choose.label').subscribe(
            (translatedString: string) => {
                this.selectCountry.defaultLabel = translatedString;
                this.selectCountry.updateLabel();
                if (this.selectRegions !== undefined) {
                    this.selectRegions.defaultLabel = translatedString;
                    this.selectRegions.updateLabel();
                }
            }
        );
    }
}
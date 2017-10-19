import {Component, EventEmitter, Input, OnInit, Output} from "@angular/core";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {MayorDTOBase} from "../../shared/swagger/model/MayorDTO";
import {CustomAccordionBoxComponent} from "../../shared/components/custom-accordion-box/custom-accordion-box.component";
import {UxAccordionBoxesComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-ui-elements/ux-accordion-box/ux-accordion-boxes.component";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Component({
    selector: 'beneficiary-registration-step2', templateUrl: 'beneficiary-registration-step2.component.html', providers: [NutsApi, LauApi]
})

export class BeneficiaryRegistrationStep2Component implements OnInit {
    @Input('municipalities') municipalities: MunicipalityDTOBase[];
    @Input('users') users: UserDTOBase[];
    @Input('mayors') mayors: MayorDTOBase[];
    @Input('representing') representing: boolean;
    private allNuts: NutsDTOBase[] = [];
    private allLaus: LauDTOBase[][] = [];
    private accordionBoxItems: CustomAccordionBoxComponent[] = [];
    private newMunicipalities: MunicipalityDTOBase[] = [];
    private newUsers: UserDTOBase[] = [];
    private newMayors: MayorDTOBase[] = [];
    private newNuts: NutsDTOBase[] = [];
    private newLaus: LauDTOBase[] = [];
    private nutsSuggestions: NutsDTOBase[] = [];
    private lausSuggestions: LauDTOBase[] = [];
    @Output() onNext: EventEmitter<any>;

    constructor(private nutsApi: NutsApi, private lauApi: LauApi, private uxService: UxService) {
        this.onNext = new EventEmitter<any>();
    }

    ngOnInit() {
        if (this.allNuts.length == 0) {
            this.nutsApi.getNutsByLevel(0).subscribe(
                (nuts : NutsDTOBase[]) => {
                    this.allNuts = nuts;
                    this.municipalities = [];
                    for (let country of this.allNuts) {
                        this.allLaus[country.label] = [];
                    }
                    console.log(this.allNuts);
                }, error => {
                    console.log(error);
                    this.uxService.growl({
                        severity: 'warn',
                        summary: 'WARNING',
                        detail: 'Couldn\'t get the list of countries. Please, try again later.'
                    });
                }
            );
        }
        this.accordionBoxItems.push(new CustomAccordionBoxComponent(new UxAccordionBoxesComponent()));
        this.newMunicipalities.push(new MunicipalityDTOBase());
        if (this.representing) {
            this.newUsers.push(new UserDTOBase());
            this.newMayors.push(new MayorDTOBase());
        }
    }

    addMunicipality() {
        this.accordionBoxItems.push(new CustomAccordionBoxComponent(new UxAccordionBoxesComponent()));
        this.newMunicipalities.push(new MunicipalityDTOBase());
    }

    removeMunicipality(index: number) {
        this.accordionBoxItems.splice(index, 1);
        this.newMunicipalities.splice(index, 1);
        this.newNuts.splice(index, 1);
    }

    filterNuts(event) {
        this.nutsSuggestions = [];
        for (let i = 0; i < this.allNuts.length; i++) {
            let nut = this.allNuts[i];
            nut.label = nut.label.toLowerCase();
            if (nut.label.indexOf(event.query.toUpperCase()) == 0) {
                nut.label = nut.label.charAt(0).toUpperCase() + nut.label.slice(1).toLowerCase();
                this.nutsSuggestions.push(nut);
            }
        }
    }

    submit() {
    }

    back() {
    }
}
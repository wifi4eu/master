import {Component, EventEmitter, Input, Output, OnInit} from "@angular/core";
import {MunicipalityDTOBase} from "../../shared/swagger/model/MunicipalityDTO";
import {UserDTOBase} from "../../shared/swagger/model/UserDTO";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {CustomAccordionBoxComponent} from "../../shared/components/custom-accordion-box/custom-accordion-box.component";
import {UxAccordionBoxesComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-ui-elements/ux-accordion-box/ux-accordion-boxes.component";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/shared/ux.service";

@Component({
    selector: 'beneficiary-registration-step3',
    templateUrl: 'beneficiary-registration-step3.component.html',
    providers: [NutsApi, LauApi]
})

export class BeneficiaryRegistrationStep3Component implements OnInit {
    @Input('municipalities') private municipalities: MunicipalityDTOBase[];
    @Output() private municipalitiesChange: EventEmitter<MunicipalityDTOBase[]>;
    @Input('users') private users: UserDTOBase[];
    @Output() private usersChange: EventEmitter<UserDTOBase[]>;
    @Input('representing') private representing: boolean;
    @Output() private onNext: EventEmitter<any>;
    @Output() private onBack: EventEmitter<any>;
    private allNuts: NutsDTOBase[] = [];
    private allLaus: LauDTOBase[][] = [];
    private nutsSuggestions: NutsDTOBase[] = [];
    private lausSuggestions: LauDTOBase[] = [];
    private accordionBoxItems: CustomAccordionBoxComponent[] = [];
    private newUsers: UserDTOBase[] = [];
    private newNuts: NutsDTOBase[] = [];
    private newLaus: LauDTOBase[] = [];
    private newMunicipalities: MunicipalityDTOBase[] = [];
    private newEmailConfirmations: string[] = [];
    private spain: NutsDTOBase;
    private barcelona: LauDTOBase;

    constructor(private nutsApi: NutsApi, private lauApi: LauApi, private uxService: UxService) {
        this.municipalitiesChange = new EventEmitter<MunicipalityDTOBase[]>();
        this.usersChange = new EventEmitter<UserDTOBase[]>();
        this.onNext = new EventEmitter<any>();
        this.onBack = new EventEmitter<any>();
    }

    ngOnInit() {
        if (this.allNuts.length == 0) {
            this.nutsApi.getNutsByLevel(0).subscribe(
                (nuts: NutsDTOBase[]) => {
                    this.allNuts = nuts;
                    this.municipalities = [];
                    for (let country of this.allNuts) {
                        this.allLaus[country.label] = [];
                        if (country.label.toUpperCase() == "ESPAÑA") {
                            this.spain = country;
                            console.log(this.spain);
                            this.lauApi.getLausByCountryCode(this.spain.countryCode).subscribe(
                                (laus: LauDTOBase[]) => {
                                    this.allLaus[country.label] = laus;
                                    for (let municipality of this.allLaus[country.label]) {
                                        if (municipality.name1 == "Barcelona") {
                                            this.barcelona = municipality;
                                            console.log(this.barcelona);
                                        }
                                    }
                                }
                            );
                        }
                    }
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
        this.newUsers.push(new UserDTOBase());
        this.newNuts.push(new NutsDTOBase());
        this.newLaus.push(new LauDTOBase());
        this.newMunicipalities.push(new MunicipalityDTOBase());
        this.newEmailConfirmations.push();
    }

    addMunicipality() {
        this.accordionBoxItems.push(new CustomAccordionBoxComponent(new UxAccordionBoxesComponent()));
        this.newUsers.push(new UserDTOBase());
        this.newNuts.push(new NutsDTOBase());
        this.newLaus.push(new LauDTOBase());
        this.newMunicipalities.push(new MunicipalityDTOBase());
        this.newEmailConfirmations.push();
        this.uxService.growl({
            severity: 'success',
            summary: 'SUCCESS',
            detail: 'Municipality #' + (this.accordionBoxItems.length) + ' added.'
        });
    }

    removeMunicipality(index: number) {
        if (this.accordionBoxItems.length > 1) {
            this.uxService.growl({
                severity: 'success',
                summary: 'SUCCESS',
                detail: 'Municipality #' + (index + 1) + ' removed.'
            });
            this.accordionBoxItems.splice(index, 1);
            this.newUsers.splice(index, 1);
            this.newNuts.splice(index, 1);
            this.newLaus.splice(index, 1);
            this.newMunicipalities.splice(index, 1);
            this.newEmailConfirmations.splice(index, 1);
        }
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
        let emailsUnmatch = false;
        this.users = [];
        if (this.representing) {
            for (let i = 0; i < this.newUsers.length; i++) {
                let user = this.newUsers[i];
                if (user.email.length <= 0 || user.email != this.newEmailConfirmations[i]) {
                    emailsUnmatch = true;
                }
                user.type = 2;
                this.users.push(user);
            }
        }
        this.municipalities = [];
        for (let i = 0; i < this.newMunicipalities.length; i++) {
            let municipality = new MunicipalityDTOBase();
            municipality.country = this.spain.label;
            municipality.lauId = this.barcelona.id;
            municipality.name = this.barcelona.name1;
            municipality.address = this.newMunicipalities[i].address;
            municipality.addressNum = this.newMunicipalities[i].addressNum;
            municipality.postalCode = this.newMunicipalities[i].postalCode;
            this.municipalities.push(municipality);
        }
        if (emailsUnmatch) {
            this.uxService.growl({
                severity: 'warn',
                summary: 'WARNING',
                detail: 'All the email inputs must match.'
            });
        } else {
            this.municipalitiesChange.emit(this.municipalities);
            this.usersChange.emit(this.users);
            this.onNext.emit();
        }
    }

    back() {
        this.onBack.emit();
    }
}
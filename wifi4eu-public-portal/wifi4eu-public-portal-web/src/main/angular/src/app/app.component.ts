import { Component, enableProdMode, Output } from "@angular/core";
import { Router } from "@angular/router";
import { TranslateService } from "ng2-translate/ng2-translate";
import { UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons";
import { UxLanguage, UxEuLanguages } from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import { SharedService } from "./shared/shared.service";
import { LocalStorageService } from "angular-2-local-storage";
import { UserApi } from "./shared/swagger/api/UserApi";
import { RegistrationApi } from "./shared/swagger/api/RegistrationApi";
import { CustomLayoutLink } from "./shared/components/custom-layout-nav-bar-top-menu/custom-layout-link";

enableProdMode();

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    providers: [UserApi, RegistrationApi]
})
export class AppComponent {
    private menuLinks: Array<CustomLayoutLink>;
    private visibility: boolean[];

    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode ['en'];

    constructor(private router: Router, private translateService: TranslateService, private uxService: UxService, private localStorage: LocalStorageService, private sharedService: SharedService) {
        translateService.setDefaultLang('en');
        let language = this.localStorage.get('lang');
        if (language) {
            this.translateService.use(language.toString());
            this.uxService.activeLanguage = UxEuLanguages.languagesByCode [language.toString()];
            this.selectedLanguage = UxEuLanguages.languagesByCode [language.toString()];
        } else {
            translateService.use('en');
            this.uxService.activeLanguage = UxEuLanguages.languagesByCode ['en'];
            this.selectedLanguage = UxEuLanguages.languagesByCode ['en'];
        }

        this.menuLinks = [new CustomLayoutLink({
            label: 'Wifi4EU',
            children: [
                new CustomLayoutLink({label: 'Beneficiary Registration', url: '/#/beneficiary-landing', externalUrl: true}),
                new CustomLayoutLink({label: 'Supplier Registration', url: '../../../wifi4eu/#/supplier-registration', externalUrl: true})
            ]
        })];

        this.visibility = [false, false, false, false, false];
        this.updateHeader();

        this.sharedService.updateEmitter.subscribe(() => this.updateHeader());
    }

    updateHeader() {
        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;
    }

    changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }
}
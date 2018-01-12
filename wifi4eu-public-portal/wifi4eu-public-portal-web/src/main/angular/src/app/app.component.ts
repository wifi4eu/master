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
import { UxLayoutLink } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-layout/models/ux-layout-link";
import { BehaviorSubject } from "rxjs/BehaviorSubject";

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
    private actualDate: string;
    private menuTranslations: Map<String, String>;
    private stringsTranslated = new BehaviorSubject<number>(null);

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

        this.menuLinks = [
          new CustomLayoutLink({label: 'Beneficiary Registration', url: '/beneficiary-landing'}),
          new CustomLayoutLink({label: 'Supplier Registration', url: '/supplier-landing'})
        ];
        this.menuTranslations = new Map();
        this.stringsTranslated.subscribe(
          (stringsTranslated: number) => {
            if(stringsTranslated == 2){
              this.updateMenuLink();
              this.updateHeader();
            }
          }
        );

        this.visibility = [false, false, false, false, false];
        this.updateHeader();

        this.sharedService.updateEmitter.subscribe(() => this.updateHeader());

        this.updateFooterDate();
        this.updateMenuTranslations();
    }

    updateHeader() {
        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;
    }

    changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
        this.updateMenuTranslations();
        this.updateFooterDate();
    }

    updateMenuLink() {
      this.menuLinks = [
        new CustomLayoutLink({label: this.menuTranslations.get('itemMenu.appReg'), url: '/beneficiary-landing'}),
        new CustomLayoutLink({label: this.menuTranslations.get('itemMenu.suppReg'), url: '/supplier-landing'})
      ]
    }

    private updateMenuTranslations(){
      var num = 0;
      this.translateService.get('itemMenu.appReg').subscribe(
        (translatedString: string) => {
          console.log(translatedString);
          this.menuTranslations.set('itemMenu.appReg', translatedString);
          num++;
          this.stringsTranslated.next(num)
        }
      );
      this.translateService.get('itemMenu.suppReg').subscribe(
        (translatedString: string) => {
          this.menuTranslations.set('itemMenu.suppReg', translatedString);
          num++;
          this.stringsTranslated.next(num)
        }
      );
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }

    private updateFooterDate() {
        let lang = this.localStorage.get('lang');
        if (!lang) lang = 'en';
        this.actualDate = new Date( Date.now() ).toLocaleDateString(lang.toString());
    }
}
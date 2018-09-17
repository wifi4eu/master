import {Component, enableProdMode, Output} from "@angular/core";
import {TranslateService} from "ng2-translate/ng2-translate";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UxLanguage, UxEuLanguages} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import {SharedService} from "./shared/shared.service";
import {LocalStorageService} from "angular-2-local-storage";
import {CustomLayoutLink} from "./shared/components/custom-layout-nav-bar-top-menu/custom-layout-link";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {UserApi} from "./shared/swagger/api/UserApi";
import {UserDTOBase} from "./shared/swagger/model/UserDTO";
import {environment} from '../environments/environment';

enableProdMode();

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    providers: [UserApi]
})

export class AppComponent {
    private menuLinks: Array<CustomLayoutLink>;
    private user: UserDTOBase;
    private visibility: boolean[];
    private actualDate: string;
    private menuTranslations: Map<String, String>;
    private stringsTranslated = new BehaviorSubject<number>(null);
    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode ['en'];
    private newLanguageArray: string = "bg,cs,da,de,et,el,en,es,fr,it,lv,lt,hu,mt,nl,pl,pt,ro,sk,sl,fi,sv,hr,ga";

    constructor(private translateService: TranslateService, private uxService: UxService, private localStorage: LocalStorageService, private sharedService: SharedService, private userApi: UserApi) {
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
                if (stringsTranslated == 5) {
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
        let storedUser = this.localStorage.get('user');
        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;

        if (this.user != null) {
            switch (this.user.type) {
                case 1:
                    this.menuLinks = [
                        new CustomLayoutLink({
                            label: this.menuTranslations.get('itemMenu.myAccount'),
                            url: '/wifi4eu/#/supplier-portal/profile',
                            externalUrl: true
                        })
                    ];
                    break;
                case 3:
                    this.menuLinks = [
                        new CustomLayoutLink({
                            label: this.menuTranslations.get('itemMenu.myAccount'),
                            url: '/wifi4eu/#/beneficiary-portal/profile',
                            externalUrl: true
                        }),
                        new CustomLayoutLink({
                            label: this.menuTranslations.get('itemMenu.appPortal'),
                            url: '/wifi4eu/#/beneficiary-portal/voucher',
                            externalUrl: true
                        })
                    ];
                    break;
            }
        }


        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;
    }

    changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
        this.updateMenuTranslations();
        this.updateFooterDate();
        this.sharedService.changeLanguage();
    }

    updateMenuLink() {
        this.menuLinks = [
            new CustomLayoutLink({label: this.menuTranslations.get('itemMenu.appReg'), url: '/beneficiary-landing'}),
            new CustomLayoutLink({label: this.menuTranslations.get('itemMenu.suppReg'), url: '/supplier-landing'})
        ]
    }

    private updateMenuTranslations() {
        var num = 0;
        this.translateService.get('itemMenu.appReg').subscribe(
            (translatedString: string) => {
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
        this.translateService.get('itemMenu.myAccount').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.myAccount', translatedString);
                num++;
                this.stringsTranslated.next(num)
            }
        );
        this.translateService.get('itemMenu.suppPortal').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.suppPortal', translatedString);
                num++;
                this.stringsTranslated.next(num)
            }
        );
        this.translateService.get('itemMenu.appPortal').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.appPortal', translatedString);
                num++;
                this.stringsTranslated.next(num)
            }
        );
    }

    logout() {
        this.user = null;
        this.localStorage.remove('user');

        this.menuLinks = [
            new CustomLayoutLink({label: 'Beneficiary Registration', url: '/beneficiary-landing'}),
            new CustomLayoutLink({label: 'Supplier Registration', url: '/supplier-landing'})
        ];

        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;

        this.userApi.doCompleteSignOut().subscribe(
            (response: string) => {
                window.location.href = environment['logoutUrl'];
            }, error => {
                console.log(error);
            }
        );
    }

    myAccount() {
        window.location.href = environment['myAccountUrl'];
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }

    private updateFooterDate() {
        let lang = this.localStorage.get('lang');
        if (!lang) lang = 'en';
        this.actualDate = new Date(Date.now()).toLocaleDateString(lang.toString());
    }
}
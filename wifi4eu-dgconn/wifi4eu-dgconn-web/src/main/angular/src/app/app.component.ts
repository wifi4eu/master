import {Component, enableProdMode, OnInit, Output} from "@angular/core";
import {Router} from "@angular/router";
import {TranslateService} from "ng2-translate/ng2-translate";
import {UxLayoutLink, UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UxEuLanguages, UxLanguage} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import {SharedService} from "./shared/shared.service";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTOBase} from "./shared/swagger/model/UserDTO";
import {UserApi} from "./shared/swagger/api/UserApi";
import {RegistrationApi} from "./shared/swagger/api/RegistrationApi";
import {ResponseDTOBase} from "./shared/swagger/model/ResponseDTO";
import {environment} from '../environments/environment';

enableProdMode();

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    providers: [UserApi, RegistrationApi]
})
export class AppComponent implements OnInit {
    private menuLinks: Array<UxLayoutLink>;
    private user: UserDTOBase;
    private profileUrl: string;
    private actualDate: string;

    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode ['en'];
    private newLanguageArray: string = "bg,cs,da,de,et,el,en,es,fr,it,lv,lt,hu,mt,nl,pl,pt,ro,sk,sl,fi,sv,hr";

    constructor(private router: Router, private translateService: TranslateService, private localStorageService: LocalStorageService, private uxService: UxService, private sharedService: SharedService, private userApi: UserApi, private registrationApi: RegistrationApi) {
        translateService.setDefaultLang('en');
        let language = this.localStorageService.get('lang');
        if (language) {
            this.translateService.use(language.toString());
            this.uxService.activeLanguage = UxEuLanguages.languagesByCode [language.toString()];
            this.selectedLanguage = UxEuLanguages.languagesByCode [language.toString()];
        } else {
            translateService.use('en');
            this.uxService.activeLanguage = UxEuLanguages.languagesByCode ['en'];
            this.selectedLanguage = UxEuLanguages.languagesByCode ['en'];
        }

        this.profileUrl = '/portal';

        this.menuLinks = [
            new UxLayoutLink({
                label: 'Comission Portal', url: 'portal'
            })
        ];
        this.updateMenuTranslations();

        // this.sharedService.updateEmitter.subscribe(() => this.updateHeader());
        this.sharedService.logoutEmitter.subscribe(() => this.logout());

        this.updateFooterDate();
    }

    ngOnInit() {
        this.localStorageService.remove('user');
        this.userApi.ecasLogin().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.user = response.data;
                    this.localStorageService.set('user', JSON.stringify(response.data));
                    this.sharedService.update();
                } else {
                    this.uxService.growl({
                        severity: 'warn',
                        summary: 'WARNING',
                        detail: 'Could not get ECAS User, ignore this when NG is working in offline mode'
                    });
                }

            }, error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get ECAS User, ignore this when NG is working in offline mode'
                });
                console.log('WARNING : Could not get ECAS User, ignore this when NG is working in offline mode');
            });
    }

    private updateMenuTranslations() {
        this.translateService.get('itemMenu.dgPortal').subscribe(
            (translatedString: string) => {
                this.menuLinks = [
                    new UxLayoutLink({
                        label: translatedString,
                        url: 'portal'
                    })
                ];
            }
        );
    }

    private changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorageService.set('lang', language.code);
        this.updateMenuTranslations();
        this.updateFooterDate();
    }

    private logout() {
        this.user = null;
        this.localStorageService.remove('user');
        this.profileUrl = null;

        this.userApi.doCompleteSignOut().subscribe(
            (response: string) => {
                console.log(response);
            }, error => {
                console.log(error);
            }
        );
        this.userApi.ecasLogout().subscribe(
            (response: ResponseDTOBase) => {
                window.location.href = environment['logoutUrl'];
            }, error => {
                console.log(error);
                window.location.href = environment['logoutUrl'];
            }
        );
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }

    private updateFooterDate() {
        let lang = this.localStorageService.get('lang');
        if (!lang) lang = 'en';
        this.actualDate = new Date(Date.now()).toLocaleDateString(lang.toString());
    }
}
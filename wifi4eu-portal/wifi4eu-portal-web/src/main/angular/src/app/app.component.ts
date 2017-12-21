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
    private visibility: boolean[];
    private profileUrl: string;
    private actualDate: string;

    private children: UxLayoutLink[][];

    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode ['en'];

    constructor(private router: Router, private translateService: TranslateService, private localStorageService: LocalStorageService, private uxService: UxService, private localStorage: LocalStorageService, private sharedService: SharedService, private userApi: UserApi, private registrationApi: RegistrationApi) {
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

        this.profileUrl = '';

        this.menuLinks = [new UxLayoutLink({
            label: 'Wifi4EU',
            children: [
                new UxLayoutLink({label: 'Beneficiary Registration', url: '/beneficiary-landing'}),
                new UxLayoutLink({label: 'Supplier Registration', url: '/supplier-registration'})
            ]
        })];

        this.visibility = [false, false, false, false, false];
        this.children = [];
        this.initChildren();
        this.updateHeader();

        this.sharedService.updateEmitter.subscribe(() => this.updateHeader());
        this.sharedService.logoutEmitter.subscribe(() => this.logout());

        this.updateFooterDate();
    }

    ngOnInit() {
        this.userApi.ecasLogin().subscribe(
            (response: ResponseDTOBase) => {
                this.localStorageService.set('user', JSON.stringify(response.data));
                this.sharedService.update();
                /*
                switch (this.user.type) {
                    case 1:
                        this.router.navigateByUrl('/supplier-portal/profile');
                        break;
                    case 2:
                    case 3:
                        this.router.navigateByUrl('/beneficiary-portal/profile');
                        break;
                    case 5:
                        this.router.navigateByUrl('/dgconn-portal');
                        break;
                    default:
                        this.router.navigateByUrl('/home');
                        break;
                }
                */

            },
            error => {
                this.uxService.growl({
                    severity: 'warning',
                    summary: 'WARNING',
                    detail: 'Could not get ECAS User, ignore this when NG is working in offline mode'
                });
                console.log('WARNING : Could not get ECAS User, ignore this when NG is working in offline mode');
            });
    }

    initChildren() {
        this.children[0] = [
            new UxLayoutLink({
                label: 'Beneficiary Registration',
                url: '/beneficiary-landing'
            }),
            new UxLayoutLink({
                label: 'Supplier Registration',
                url: '/supplier-registration'
            })
        ];
        this.children[1] = [
            new UxLayoutLink({
                label: 'Supplier Portal',
                url: '/supplier-portal'
            }),
            new UxLayoutLink({
                label: 'Supplier Profile',
                url: '/supplier-portal/profile'
            })
        ];
        this.children[2] = [
            new UxLayoutLink({
                label: 'Beneficiary Portal',
                url: '/beneficiary-portal'
            }),
            new UxLayoutLink({
                label: 'Beneficiary Profile',
                url: '/beneficiary-portal/profile'
            })
        ];
        this.children[3] = [
            new UxLayoutLink({
                label: 'Beneficiary Portal',
                url: '/beneficiary-portal'
            }),
            new UxLayoutLink({
                label: 'Beneficiary Profile',
                url: '/beneficiary-portal/profile'
            })
        ];
        this.children[4] = [
            new UxLayoutLink({
                label: 'Member State Portal',
                url: '#'
            })
        ];
        this.children[5] = [
            new UxLayoutLink({
                label: 'DGConnect Portal',
                url: 'dgconn-portal'
            })
        ];
    }

    updateHeader() {
        let storedUser = this.localStorage.get('user');

        this.user = storedUser ? JSON.parse(storedUser.toString()) : null;

        if (this.user != null) {

            this.userApi.getUserById(this.user.id).subscribe(
                (user: UserDTOBase) => {
                    this.user = user;
                    this.localStorage.set('user', JSON.stringify(user));
                    switch (this.user.type) {
                        case 1:
                            this.profileUrl = '/supplier-portal/profile';
                            this.menuLinks = this.children[1];
                            break;
                        case 2:
                        case 3:
                            this.registrationApi.checkIfRegistrationIsKO(this.user.id).subscribe(
                                (response: ResponseDTOBase) => {
                                    if (response.data) {
                                        this.logout();
                                    }
                                }
                            );
                            this.profileUrl = '/beneficiary-portal/profile';
                            this.menuLinks = this.children[2];
                            break;
                        case 5:
                            this.profileUrl = '/dgconn-portal';
                            this.menuLinks = this.children[5];
                            break;
                        default:
                            this.profileUrl = '/home';
                            this.menuLinks = this.children[0];
                            break;
                    }
                }, error => {
                    this.logout();
                }
            );
        } else {
            //this.logout();
        }
        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;
    }

    changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
        this.updateFooterDate();
    }

    logout() {
        this.user = null;
        this.localStorage.remove('user');
        this.menuLinks = [new UxLayoutLink({
            label: 'Wifi4EU',
            children: this.children[0]
        })];
        this.profileUrl = null;
        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;
        this.userApi.ecasLogout();
        window.location.href = 'https://ecas.acceptance.ec.europa.eu/cas/logout';
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
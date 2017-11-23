import {Component, enableProdMode, Output} from "@angular/core";
import {Router} from "@angular/router";
import {LocalStorageService} from "angular-2-local-storage";
import {TranslateService} from "ng2-translate/ng2-translate";
import {UxService, UxLayoutLink} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UxLanguage, UxEuLanguages} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import {SharedService} from "./shared/shared.service";
import {UserDTOBase} from "./shared/swagger/model/UserDTO";
import {UserApi} from "./shared/swagger/api/UserApi";
import {RegistrationApi} from "./shared/swagger/api/RegistrationApi";
import {ResponseDTOBase} from "./shared/swagger/model/ResponseDTO";


enableProdMode()

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    providers: [UserApi, RegistrationApi]
})
export class AppComponent {
    private menuLinks: Array<UxLayoutLink>;
    private user: UserDTOBase;
    private visibility: boolean[];
    private profileUrl: string;

    private children: UxLayoutLink[][];

    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode ['en'];

    constructor(private router: Router, private translateService: TranslateService, private uxService: UxService, private localStorage: LocalStorageService, private sharedService: SharedService, private userApi: UserApi, private registrationApi: RegistrationApi) {
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
                new UxLayoutLink({label: 'Beneficiary Registration', url: '/beneficiary-registration'}),
                new UxLayoutLink({label: 'Supplier Registration', url: '/supplier-registration'})
            ]
        })];

        this.visibility = [false, false, false, false, false];
        this.children = [];
        this.initChildren();
        this.updateHeader();
        this.sharedService.changeEmitted.subscribe(() => this.updateHeader());
    }

    initChildren() {
        this.children[0] = [
            new UxLayoutLink({
                label: 'Beneficiary Registration',
                url: '/beneficiary-registration'
            }),
            new UxLayoutLink({
                label: 'Supplier Registration',
                url: '/supplier-registration'
            })
        ];
        this.children[1] = [
            new UxLayoutLink({
                label: 'Supplier Registration',
                url: '/supplier-registration'
            }),
            new UxLayoutLink({
                label: 'Supplier Portal',
                url: '/supplier-portal'
            })
        ];
        this.children[2] = [
            new UxLayoutLink({
                label: 'Beneficiary Registration',
                url: '/beneficiary-registration'
            }),
            new UxLayoutLink({
                label: 'Beneficiary Portal',
                url: '/beneficiary-portal'
            })
        ];
        this.children[3] = [
            new UxLayoutLink({
                label: 'Beneficiary Registration',
                url: '/beneficiary-registration'
            }),
            new UxLayoutLink({
                label: 'Beneficiary Portal',
                url: '/beneficiary-portal'
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
                            break;
                        case 2:
                        case 3:
                            this.profileUrl = '/beneficiary-portal/profile';
                            break;
                        case 5:
                            this.profileUrl = '/dgconn-portal';
                            break;
                        default:
                            this.profileUrl = '/home';
                            break;
                    }
                }, error => {
                    this.logout();
                }
            );
        } else {
            this.logout();
        }
    }

    changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
    }

    logout() {
        this.user = null;
        this.localStorage.remove('user');
        this.router.navigateByUrl('/home');
        this.menuLinks = [new UxLayoutLink({
            label: 'Wifi4EU',
            children: this.children[0]
        })];
        this.profileUrl = null;
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }
}
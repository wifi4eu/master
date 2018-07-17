import {Component, enableProdMode, Output, EventEmitter} from "@angular/core";
import {TranslateService} from "ng2-translate/ng2-translate";
import {UxService, UxLayoutLink} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {CoreService} from "./core/core.service";
import {UxLanguage, UxEuLanguages} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTO} from "./shared/swagger/model/UserDTO";
import {SharedService} from "./shared/shared.service";
import {Router} from "@angular/router";


enableProdMode()

@Component({selector: 'app-root', templateUrl: './app.component.html', styleUrls: ['./app.component.scss']})
export class AppComponent {
    private menuLinks: Array<UxLayoutLink>;
    private user: UserDTO;
    private visibility: boolean[];
    private profileUrl: string;

    private children: UxLayoutLink[][];

    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode ['en'];

    constructor(private router: Router, private translateService: TranslateService, private coreService: CoreService, private uxService: UxService, private localStorage: LocalStorageService, private sharedService: SharedService) {
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

        this.profileUrl = "";

        this.menuLinks = [new UxLayoutLink({
            label: 'Wifi4EU-Financial',
            children: [
                //new UxLayoutLink({label: 'Free Wi-Fi for Europeans', url: 'home'}),
                //new UxLayoutLink({label: 'Registration', url: 'registration'}),
                //new UxLayoutLink({label: 'Beneficiary Portal', url: 'beneficiary-portal'}),
                new UxLayoutLink({label: 'Abac Portal', url: 'abac'}),
                new UxLayoutLink({label: 'DGConnect Portal', url: 'dgconn-portal'})
            ]
        })];

        this.visibility = [false, false, false, false, false];
        this.children = [];
        this.initChildren();
        this.updateHeader();
        this.sharedService.changeEmitted.subscribe(() => this.updateHeader());
    }

    updateHeader() {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;

        if (this.user != null) {
            switch (this.user.type) {
                case 1:
                    this.profileUrl = "/supplier-portal/profile";
                    break;
                case 2:
                    this.profileUrl = "/beneficiary-portal/profile";
                    break;
                case 5:
                    this.profileUrl = "/dgconn-portal";
                    break;
                default:
                    break;
            }
        }

        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;

        let i = (this.user) ? this.user.type : 0;

        //this.menuLinks = [new UxLayoutLink({
            //label: 'Wifi4EU',
            //children: this.children[i]
        //})];
    }

    onLanguageChanged(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorage.set('lang', language.code);
    }

    onLogout() {
        this.localStorage.remove('user');
        this.updateHeader();
        this.router.navigateByUrl("login");
    }

    initChildren() {
        this.children[0] = [
            new UxLayoutLink({
                label: 'Beneficiary Registration',
                url: 'registration'
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
                url: '/registration'
            }),
            new UxLayoutLink({
                label: 'Beneficiary Portal',
                url: '/beneficiary-portal'
            })
        ];
        this.children[3] = [
            new UxLayoutLink({
                label: 'Beneficiary Registration',
                url: '/registration'
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

}
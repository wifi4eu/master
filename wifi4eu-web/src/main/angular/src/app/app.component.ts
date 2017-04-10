import {Component, enableProdMode, Output, EventEmitter} from "@angular/core";
import {TranslateService} from "ng2-translate/ng2-translate";
import {UxService, UxLayoutLink, UxLayoutNotificationItem} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {CoreService} from "./core/core.service";
import {UxLanguage} from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import {LocalStorageService} from "angular-2-local-storage";
import {UserDTO} from "./shared/swagger/model/UserDTO";
import {SharedService} from "./shared/shared.service";
import {Router} from "@angular/router";


enableProdMode()

@Component({selector: 'app-root', templateUrl: './app.component.html', styleUrls: ['./app.component.scss']})
export class AppComponent {
    private menuLinks: Array<UxLayoutLink>;
    private user: UserDTO;
    private profileUrl;

    @Output() private languageChanged: EventEmitter<UxLanguage> = new EventEmitter<UxLanguage>();

    constructor(private router: Router, private translate: TranslateService, translateService: TranslateService, private coreService: CoreService, private uxService: UxService, private localStorage: LocalStorageService, private sharedService: SharedService) {
        translateService.setDefaultLang('en');
        translateService.use('en');

        this.menuLinks = [new UxLayoutLink({
            label: 'Wifi4EU',
            children: [
                new UxLayoutLink({label: 'Free Wi-Fi for Europeans', url: 'home'}),
                new UxLayoutLink({label: 'Registration', url: 'registration'}),
                new UxLayoutLink({label: 'Beneficiary Portal', url: 'beneficiary-portal'}),
                new UxLayoutLink({label: 'DGConnect Portal', url: 'dgconn-portal'})
            ]
        })];

        this.updateHeader();
        this.sharedService.changeEmitted.subscribe(() => this.updateHeader());
    }

    updateHeader() {
        let u = this.localStorage.get('user');
        this.user = u ? JSON.parse(u.toString()) : null;
    }

    onLanguageChanged(language: UxLanguage) {
        this.translate.use(language.code);
        this.uxService.activeLanguage = language;
        this.languageChanged.emit(language);
    }

    onLogout() {
        this.localStorage.remove('user');
        this.updateHeader();
        this.router.navigateByUrl("home");
    }

}
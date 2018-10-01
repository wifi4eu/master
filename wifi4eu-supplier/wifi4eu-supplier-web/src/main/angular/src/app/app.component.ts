import { Component, Inject, OnInit, HostListener } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';
import { UxService, UxLink, UxLanguage } from '@eui/ux-commons';
import { LocalStorageService } from 'angular-2-local-storage'
import { CONFIG_TOKEN, AppState, UserState, RouteUpdateAction, getAppState, getUserState, StoreService } from '@eui/ux-core';
import { UserDetailsService } from './core/services/user-details.service';
import { UserDTOBase, UserApi, ResponseDTOBase } from './shared/swagger';
import { environment } from '../environments/environment';
import {WebsockApi} from "./shared/swagger";
import {CookieService} from 'ngx-cookie-service';
import { Subject } from '../../node_modules/rxjs';
import { IntervalObservable } from '../../node_modules/rxjs/observable/IntervalObservable';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    providers: [UserApi, WebsockApi]
})

export class AppComponent implements OnInit {
    appState: Observable<AppState>;
    userState: Observable<UserState>;
    menuLinks: UxLink[] = [];
    menuTranslations: Map<String, String>;
    notificationLinks: UxLink[] = [];
    userInfos: string = 'NAME Firstname';
    user: UserDTOBase;

    private ngUnSubscribe: Subject<void> = new Subject<void>();
    private sessionInterval: any;
    sessionExpired: Boolean = false;

    constructor(@Inject(CONFIG_TOKEN) private config: any, private translateService: TranslateService, private uxService: UxService, private store: Store<any>, private userDetailsService: UserDetailsService, private localStorageService: LocalStorageService, private userApi: UserApi, private websockApi: WebsockApi, private cookieService: CookieService) {
        translateService.setDefaultLang('en');
        translateService.use('en');

        this.menuTranslations = new Map();
        this.updateMenuTranslations();
    }

    ngOnInit() {
        this.appState = this.store.select(getAppState);
        this.userState = this.store.select(getUserState);

        this._createMenuLinks();
        this._createNotifications();

        this.getUserData();

        this.sessionInterval = IntervalObservable.create(61500);
        this.startInterval();
    }

    startInterval() {
        this.sessionInterval
            .takeUntil(this.ngUnSubscribe)
            .subscribe(execution => {
                // This will be called every 10 seconds until `stopCondition` flag is set to true
                //this.isSessionExpired();
            });
    }

    @HostListener('document:keyup', ['$event'])
    @HostListener('document:click', ['$event'])
    @HostListener('document:wheel', ['$event'])
    private resetInterval(newEndTime) {
        this.ngUnSubscribe.next();
        this.startInterval();
    }

    updateMenuTranslations() {
        this.translateService.get('menu.about').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('menu.about', translatedString);
            }
        );

        this.translateService.get('menu.submenu').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('menu.submenu', translatedString);
            }
        );
    }

    onLanguageChanged(language: UxLanguage) {
        this.translateService.use(language.code);
    }

    private _createMenuLinks() {
        this.menuLinks = [
            new UxLink(
                {
                    label: 'HOME', url: '/screen/home', isHome: true
                }
            ),
            new UxLink(
                {
                    label: this.menuTranslations.get('menu.about'), children: [
                        new UxLink({ label: this.menuTranslations.get('menu.submenu'), urlExternal: 'https://ec.europa.eu/digital-single-market/en/policies/wifi4eu-free-wi-fi-europeans' }),
                    ]
                }
            ),

        ];
    }

    private _createNotifications() {
        this.notificationLinks = [
            new UxLink(
                { label: 'Notification title', subLabel: 'This is the description of the noficiation' }
            ),
            new UxLink(
                { label: 'Notification title', subLabel: 'This is the description of the noficiation' }
            ),
            new UxLink(
                { label: 'Notification title', subLabel: 'This is the description of the noficiation' }
            ),
            new UxLink(
                { label: 'Notification title', subLabel: 'This is the description of the noficiation' }
            ),
            new UxLink(
                { label: 'Notification title', subLabel: 'This is the description of the noficiation' }
            )
        ];
    }

    private getUserData() {
        this.userApi.ecasLogin().subscribe((response: ResponseDTOBase) => {
            if (response.success) {
                this.user = response.data;
                this.userInfos = this.user.ecasUsername;
            }
        }, error => {
            this.uxService.growl({
                severity: 'warning',
                summary: 'WARNING',
                detail: 'Could not get user details, ignore this when NG is working in offline mode'
            });
            console.log('WARNING : Could not get user details, ignore this when NG is working in offline mode');
            this.userInfos = 'Name Firstname';
        });
    }

    private logout() {
        this.user = null;

        this.userApi.doCompleteSignOut().subscribe((response: string) => {
            window.location.href = environment['logoutUrl'];
        }, (error) => {
            window.location.href = environment['logoutUrl'];
            console.log(error)
        }
        );
    }

    private reload() {
        this.removeDataSession()
        window.location.reload();
    }

    private removeDataSession() {
        this.user = null;
        this.localStorageService.remove('user');
        this.localStorageService.remove('public-redirection');
        this.cookieService.deleteAll();
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }



    isSessionExpired() {
        this.websockApi.isInvalidatedSession().subscribe(
            (sessionStatus: Boolean) => {
                this.sessionExpired = (sessionStatus == null) || sessionStatus;
            }
        );
    }

}

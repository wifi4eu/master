import { Component, enableProdMode, Output, HostListener } from "@angular/core";
import { Router } from "@angular/router";
import { TranslateService } from "ng2-translate/ng2-translate";
import { UxLayoutLink, UxService } from "@ec-digit-uxatec/eui-angular2-ux-commons";
import { UxEuLanguages, UxLanguage } from "@ec-digit-uxatec/eui-angular2-ux-language-selector";
import { SharedService } from "./shared/shared.service";
import { LocalStorageService } from "angular-2-local-storage";
import { UserDTOBase } from "./shared/swagger/model/UserDTO";
import { UserApi } from "./shared/swagger/api/UserApi";
import { RegistrationApi } from "./shared/swagger/api/RegistrationApi";
import { ResponseDTOBase } from "./shared/swagger/model/ResponseDTO";
import { environment } from '../environments/environment';
import { Subject } from "rxjs/Subject";
import { WebsockApi } from "./shared/swagger";
import { Observable } from "rxjs/Observable";
import { CookieService } from 'ngx-cookie-service';
import { IntervalObservable } from "../../node_modules/rxjs/observable/IntervalObservable";


enableProdMode();

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    providers: [UserApi, RegistrationApi, WebsockApi]
})

export class AppComponent {
    private actualDate: string;
    private newLanguageArray: string = "bg,cs,da,de,et,el,en,es,fr,it,lv,lt,hu,mt,nl,pl,pt,ro,sk,sl,fi,sv,hr,ga";
    private user: UserDTOBase;
    private voucherAwarded: Boolean = false;
    private profileUrl: string;
    private menuLinks: Array<UxLayoutLink>;
    private children: UxLayoutLink[][];
    private menuTranslations: Map<String, String>;
    private stringsTranslated = new Subject<any>();
    private childrenInitialized = new Subject<any>();

    private ngUnSubscribe: Subject<void> = new Subject<void>();
    private sessionInterval: any;
    sessionExpired: Boolean = false;

    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode['en'];

    constructor(private translate: TranslateService,
                private router: Router,
                private translateService: TranslateService,
                private localStorageService: LocalStorageService,
                private uxService: UxService,
                private sharedService: SharedService,
                private userApi: UserApi,
                private registrationApi: RegistrationApi,
                private websockApi: WebsockApi,
                private cookieService: CookieService) {
        translateService.setDefaultLang('en');
        let language = this.localStorageService.get('lang');
        if (language) {
            this.translateService.use(language.toString());
            this.uxService.activeLanguage = UxEuLanguages.languagesByCode[language.toString()];
            this.selectedLanguage = UxEuLanguages.languagesByCode[language.toString()];
        } else {
            translateService.use('en');
            this.uxService.activeLanguage = UxEuLanguages.languagesByCode['en'];
            this.selectedLanguage = UxEuLanguages.languagesByCode['en'];
        }

        // Initialize menu links and translations
        this.profileUrl = '';
        this.menuLinks = [];
        this.children = [];
        this.menuTranslations = new Map();
        this.updateMenuTranslations();
        this.initChildren();

        // Get the ECAS user information
        this.getUserData();

        // Set the subscriptions methods/functions
        this.sharedService.updateEmitter.subscribe(() => this.getUserData());
        this.sharedService.logoutEmitter.subscribe(() => this.logout());

        this.updateFooterDate();

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

    private updateMenuTranslations() {
        let translatedItems = 0;
        this.translateService.get('itemMenu.appReg').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.appReg', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('itemMenu.suppReg').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.suppReg', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('itemMenu.myAccount').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.myAccount', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('itemMenu.suppPortal').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.suppPortal', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('itemMenu.dissForum').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.dissForum', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('itemMenu.appPortal').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.appPortal', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('itemMenu.dgPortal').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.dgPortal', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('itemMenu.listSuppliers').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.listSuppliers', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('benefPortal.myVoucher.title.text').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('benefPortal.myVoucher.title.text', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
        this.translateService.get('benefPortal.myHistory.title').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('benefPortal.myHistory.title', translatedString);
                translatedItems++;
                if (translatedItems == 10) {
                    this.stringsTranslated.next();
                }
            }
        );
    }

    private initChildren() {
        this.stringsTranslated.subscribe(() => {
            this.children[0] = [
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.appReg'),
                    url: '/beneficiary-registration'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.suppReg'),
                    url: '/supplier-registration'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.listSuppliers'),
                    url: 'list-suppliers'
                })
            ];
            this.children[1] = [
                /* new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.suppPortal'),
                    url: '/supplier-portal/voucher'
                }), */
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.myAccount'),
                    url: '/supplier-portal/profile'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.listSuppliers'),
                    url: 'list-suppliers'
                })
            ];
            this.children[2] = [
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.myAccount'),
                    url: '/beneficiary-portal/profile'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.appPortal'),
                    url: '/beneficiary-portal/voucher'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('benefPortal.myVoucher.title.text'),
                    url: '/beneficiary-portal/my-voucher/grant-agreement'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.listSuppliers'),
                    url: 'list-suppliers'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('benefPortal.myHistory.title'),
                    url: '/beneficiary-portal/my-history'
                })
            ];
            this.children[3] = [
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.myAccount'),
                    url: '/beneficiary-portal/profile'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.appPortal'),
                    url: '/beneficiary-portal/voucher'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('benefPortal.myVoucher.title.text'),
                    url: '/beneficiary-portal/my-voucher/grant-agreement'
                }),
                new UxLayoutLink({
                    label: 'Registered suppliers',
                    url: 'list-suppliers'
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
                    label: 'Complete invitate contact details',
                    url: '/invited-contact-details'
                })
            ];
            this.children[6] = [
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.myAccount'),
                    url: '/beneficiary-portal/profile'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.appPortal'),
                    url: '/beneficiary-portal/voucher'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('itemMenu.listSuppliers'),
                    url: 'list-suppliers'
                }),
                new UxLayoutLink({
                    label: this.menuTranslations.get('benefPortal.myHistory.title'),
                    url: '/beneficiary-portal/my-history'
                })
            ];

            this.children[7] = [
            ];
            this.childrenInitialized.next();
        });
    }

    private getUserData() {
        let publicRedirection = this.localStorageService.get('public-redirection');
        this.userApi.ecasLogin().subscribe(
            (response: ResponseDTOBase) => {
                if (response.success) {
                    this.user = response.data;
                    // NEED WORK
                    if (this.user.type == -1){
                        //deactivated user
                        this.router.navigateByUrl('/deactivated-user');
                    } else if (this.user.userInvited){
                        this.router.navigateByUrl('/invited-contact-details');
                    }
                    this.localStorageService.set('user', JSON.stringify(response.data));
                    if (this.user.type == 3){
                        // check menu
                        this.checkIfVoucher();
                    }
                    if (this.user.type == 0 && publicRedirection) {
                        this.router.navigateByUrl(String(publicRedirection));
                    }
                    this.sharedService.login(this.user);
                    if (this.children.length > 0) {
                        this.updateHeader();
                    } else {
                        this.childrenInitialized.subscribe(() => this.updateHeader());
                    }
                    
                }
            }
        );
    }

    private checkIfVoucher(){
        this.userApi.checkIfVoucherAwarded().subscribe(
            (response: ResponseDTOBase) => {
                if(response.success){
                    this.voucherAwarded = response.data;
                    /* console.log(response.data); */
                    this.updateHeader();
                }
            }
        );
    }

    private updateHeader() {
        if (this.user) {
            switch (this.user.type) {
                case -1:
                    this.profileUrl = '/deactivated-user';
                    this.menuLinks = this.children[7];
                break;
                case 1:
                    this.profileUrl = '/supplier-portal/profile';
                    this.menuLinks = this.children[1];
                    break;
                case 2:
                case 3:
                    this.profileUrl = '/beneficiary-portal/profile';
                    if(this.voucherAwarded){
                    this.menuLinks = this.children[2];
                    } else {
                        this.menuLinks = this.children[6];
                    }
                    break;
                default:
                    if (this.user.userInvited){
                        this.profileUrl = '/invite-contact-details';
                        this.menuLinks = this.children[5];
                    } else {
                        this.profileUrl = '/home';
                        this.menuLinks = this.children[0];
                    }
                    break;
            }
        } else {
            this.menuLinks = this.children[0];
        }
    }

    private changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorageService.set('lang', language.code);
        this.updateMenuTranslations();
        this.initChildren();
        this.childrenInitialized.subscribe(() => this.updateHeader());
        this.updateFooterDate();
        this.sharedService.emitLanguage.next();
    }

    private logout() {
        this.user = null;
        this.localStorageService.remove('user');
        this.localStorageService.remove('public-redirection');
        this.menuLinks = this.children[0];
        this.profileUrl = null;

        window.location.href = environment['logoutUrl'];

        this.userApi.doCompleteSignOut().subscribe(
            (response: string) => {
                window.location.href = environment['logoutUrl'];
            }, (error) => {
                window.location.href = environment['logoutUrl'];
                console.log(error);
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

        this.menuLinks = this.children[0];
        this.profileUrl = null;
    }

    private goToTop() {
        window.scrollTo(0, 0);
    }

    private updateFooterDate() {
        let lang = this.localStorageService.get('lang');
        if (!lang) lang = 'en';
        this.actualDate = new Date(Date.now()).toLocaleDateString(lang.toString());
    }


    isSessionExpired() {
        this.websockApi.isInvalidatedSession().subscribe(
            (sessionStatus: Boolean) => {
                this.sessionExpired = (sessionStatus == null) || sessionStatus;
            }
        );
    }

}
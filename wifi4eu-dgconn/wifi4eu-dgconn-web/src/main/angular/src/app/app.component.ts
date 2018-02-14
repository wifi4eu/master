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
import {Http} from "@angular/http";
import {Observable} from "rxjs/Observable";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
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
    private visibility: boolean[];
    private profileUrl: string;
    private actualDate: string;

    private children: UxLayoutLink[][];
    private menuTranslations: Map<String, String>;
    private stringsTranslated = new BehaviorSubject<number>(null);


    @Output() private selectedLanguage: UxLanguage = UxEuLanguages.languagesByCode ['en'];
    private newLanguageArray: string = "bg,cs,da,de,et,el,en,es,fr,it,lv,lt,hu,mt,nl,pl,pt,ro,sk,sl,fi,sv,hr,is"

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

        this.profileUrl = '';

        this.menuLinks = [
          new UxLayoutLink({label: 'Beneficiary Registration', url: '/beneficiary-registration'}),
          new UxLayoutLink({label: 'Supplier Registration', url: '/supplier-registration'})
        ];

        this.visibility = [false, false, false, false, false];
        this.children = [];
        this.menuTranslations = new Map();
        this.stringsTranslated.subscribe(
            (stringsTranslated: number) => {
                if (stringsTranslated == 7) {
                    this.initChildren();
                    this.updateHeader();
                }
            }
        );

        this.initChildren();

        this.sharedService.updateEmitter.subscribe(() => this.updateHeader());
        this.sharedService.logoutEmitter.subscribe(() => this.logout());

        this.updateFooterDate();
        this.updateMenuTranslations();
    }

    ngOnInit() {
        let publicRedirection = this.localStorageService.get("public-redirection");
        this.localStorageService.remove('user');
        this.userApi.ecasLogin().subscribe(
            (response: ResponseDTOBase) => {
              if(response.success){
                this.user = response.data;
                this.localStorageService.set('user', JSON.stringify(response.data));

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
                        if (publicRedirection) {
                            this.router.navigateByUrl(String(publicRedirection));
                            this.localStorageService.remove("public-redirection");
                        }
                        //this.router.navigateByUrl('/home');
                        break;
                }
                this.sharedService.update();
              }
              else{
                this.menuLinks = this.children[0];
                this.uxService.growl({
                  severity: 'warn',
                  summary: 'WARNING',
                  detail: 'Could not get ECAS User, ignore this when NG is working in offline mode'
                });
              }

            }, error => {
                this.menuLinks = this.children[0];
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get ECAS User, ignore this when NG is working in offline mode'
                });
                console.log('WARNING : Could not get ECAS User, ignore this when NG is working in offline mode');
            });
    }

    initChildren() {
        this.children[0] = [
            new UxLayoutLink({
                label: this.menuTranslations.get('itemMenu.appReg'),
                url: '/beneficiary-registration'
            }),
            new UxLayoutLink({
                label: this.menuTranslations.get('itemMenu.suppReg'),
                url: '/supplier-registration'
            })
        ];
        this.children[1] = [
            new UxLayoutLink({
                label: this.menuTranslations.get('itemMenu.suppPortal'),
                url: '/supplier-portal/voucher'
            }),
            new UxLayoutLink({
                label: this.menuTranslations.get('itemMenu.myAccount'),
                url: '/supplier-portal/profile'
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
                label: this.menuTranslations.get('itemMenu.dgPortal'),
                url: 'dgconn-portal'
            })
        ];
    }

    updateHeader() {
        /* let storedUser = this.localStorageService.get('user');

        this.user = storedUser ? JSON.parse(storedUser.toString()) : null; */

        if (this.user != null) {
          switch (this.user.type) {
            case 1:
                this.profileUrl = '/supplier-portal/profile';
                this.menuLinks = this.children[1];
                break;
            case 2:
            case 3:
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

            /* this.userApi.getUserById(this.user.id).subscribe(
                (user: UserDTOBase) => {
                    this.user = user;
                    this.localStorageService.set('user', JSON.stringify(user));
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
                }, 
                error => {
                  
                } 
            );*/
        } else {
            //this.logout();
            this.menuLinks = this.children[0];
        }
        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;
    }

    changeLanguage(language: UxLanguage) {
        this.translateService.use(language.code);
        this.uxService.activeLanguage = language;
        this.localStorageService.set('lang', language.code);
        this.updateMenuTranslations();
        this.updateFooterDate();
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
        this.translateService.get('itemMenu.dissForum').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.dissForum', translatedString);
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
        this.translateService.get('itemMenu.dgPortal').subscribe(
            (translatedString: string) => {
                this.menuTranslations.set('itemMenu.dgPortal', translatedString);
                num++;
                this.stringsTranslated.next(num)
            }
        );
    }

    logout() {
        this.user = null;
        this.localStorageService.remove('user');
        this.menuLinks = this.children[0];
        this.profileUrl = null;
        for (let i = 0; i < this.visibility.length; i++) this.visibility[i] = false;

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
import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Observable } from 'rxjs/Observable';
import { ApiModule } from './shared/api.module';

import { UxLanguage } from '@eui/ux-commons';
import { UserState, UxLink } from '@eui/ux-core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  
    userState: UserState;
    menuLinks: UxLink[] = [];

    constructor(private translateService: TranslateService, protected api: ApiModule) {
    }

    ngOnInit() {
        this._createMenuLinks();
        this.api.getUserDetails().subscribe(userState => {
            this.userState = userState;
        });
    }

    onLanguageChanged(language: UxLanguage) {
        this.translateService.use(language.code);
    }
  
    renderLoginInfo(){
        if (this.userState !== undefined && this.userState !== null){
            return 'Loged in as: ' + this.userState.fullName + ' (' + this.userState.userId + ')';
        }else{
            return 'Login unknown';
        }
    }

    private _createMenuLinks() {
        this.menuLinks = [
            new UxLink({ label: 'HOME', url: '/screen/home', isHome: true }),
            new UxLink({ label: 'Monitoring', url: '/screen/monitoring' }), 
        ];
    }
}

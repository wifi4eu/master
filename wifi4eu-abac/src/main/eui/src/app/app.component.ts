import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { UxLanguage } from '@eui/ux-commons';
import { UxLink } from '@eui/ux-core';
import { ApiModule } from './shared/api.module';
import { UserDetailsDTO } from './shared/model/DTOs';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
  
    userDetails: UserDetailsDTO;
    menuLinks: UxLink[] = [];

    constructor(private translateService: TranslateService, protected api: ApiModule) {
    }

    ngOnInit() {
        this.api.getUserDetails().subscribe(userDetails => {
            this.userDetails = userDetails;
            this._createMenuLinks();
        });
    }

    onLanguageChanged(language: UxLanguage) {
        this.translateService.use(language.code);
    }
  
    renderLoginInfo(){
        if (this.userDetails !== undefined && this.userDetails !== null){
            return this.userDetails.fullName + ' (' + this.userDetails.userId + ')';
        }else{
            return 'Login unknown';
        }
    }

    private _createMenuLinks() {
        this.menuLinks = [
            new UxLink({ label: 'HOME', url: '/screen/home', isHome: true }),
            new UxLink({ label: 'Monitoring', url: '/screen/monitoring' }), 
        ];
        if (this.userDetails && this.userDetails.roles.length > 0 && this.userDetails.roles.includes('ROLE_DEVELOPER')) {
            this.menuLinks.push( new UxLink({ label: 'Bank Accounts', url: '/screen/bafMonitoring' }) );
        }
    }
}

import {Component, OnInit} from '@angular/core';
import {TranslateService} from 'ng2-translate/ng2-translate';
import {UxService, UxLayoutLink, UxLayoutNotificationItem} from '@ec-digit-uxatec/eui-angular2-ux-commons';
import {CoreService} from './core/core.service';

@Component({selector: 'app-root', templateUrl: './app.component.html', styleUrls: ['./app.component.scss']})
export class AppComponent implements OnInit {
  menuLinks : Array < UxLayoutLink > = [];
  notifications : Array < UxLayoutNotificationItem > = [];
  userInfos : string = '';

  constructor(translateService : TranslateService, private coreService : CoreService, private uxService : UxService) {
    translateService.setDefaultLang('en');
    translateService.use('en');

    this.menuLinks = [new UxLayoutLink({
        label: 'Wifi4EU',
        children: [
          new UxLayoutLink({label: 'Free Wi-Fi for Europeans', url: 'home'}),
          new UxLayoutLink({label: 'Who will benefit', url: 'home'}),
          new UxLayoutLink({label: 'How to apply', url: 'home'}),
          new UxLayoutLink({label: 'More information', url: 'home'})
        ]
      })];

  }

  ngOnInit() {
    this
      .coreService
      .getUserDetails()
      .subscribe((userDetails : any) => {
        let userName = userDetails.domainUsername;
        let department = userDetails.departmentNumber;
        let buffer : string[] = [userDetails.firstName, userDetails.lastName];
        if (userName != null) {
          buffer.push('(' + userName + ')');
        }
        if (department != null) {
          buffer.push(department);
        }
        this.userInfos = buffer.join(' ');

      }, error => {
        this
          .uxService
          .growl({severity: 'warn', summary: 'WARNING', detail: 'Could not get user details, ignore this when NG is working in offline mode'});
        console.log('WARNING : Could not get user details, ignore this when NG is working in offline ' +
            'mode');
        this.userInfos = 'Name Firstname';
      });
  }

}
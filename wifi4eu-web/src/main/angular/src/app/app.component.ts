import { Component, OnInit } from '@angular/core';
import { TranslateService } from 'ng2-translate/ng2-translate';
import { UxService, UxLayoutLink, UxLayoutNotificationItem } from '@ec-digit-uxatec/eui-angular2-ux-commons';
import { CoreService } from './core/core.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
    menuLinks: Array<UxLayoutLink> = [];
    notifications: Array<UxLayoutNotificationItem> = [];
    userInfos: string = '';

    constructor(translateService: TranslateService, private coreService: CoreService, private uxService:UxService) {
        translateService.setDefaultLang('en');
        translateService.use('en');

        this.menuLinks = [
            new UxLayoutLink(
                {
                    label: 'Menu item samples', children: [
                        new UxLayoutLink({label: 'disabled item', disabled: true, url:'/screen/home'}),
                        new UxLayoutLink({label: 'sub item', url:'/screen/home'}),
                        new UxLayoutLink({label: 'sub item parent', children: [
                               new UxLayoutLink({label: 'sub item 1', url:'/screen/home'}),
                               new UxLayoutLink({label: 'sub item 2', url:'/screen/home'}),
                               new UxLayoutLink({label: 'sub item 3', url:'/screen/home'})
                        ]})
                    ]
                }
            ),
            new UxLayoutLink(
                {
                    label: 'Module1', url: '/screen/module1', children: [
                        new UxLayoutLink({label: 'Page 1', url:'/screen/module1/page1'}),
                        new UxLayoutLink({label: 'Page 2', url:'/screen/module1/page2'})
                    ]
                }
            ),
            new UxLayoutLink(
                {
                    label: 'Module2', url: '/screen/module2'
                }
            )            
        ];

        this.notifications = [
            new UxLayoutNotificationItem(
                { title: 'Notification title', description: 'This is the description of the notification'}
            ),
            new UxLayoutNotificationItem(
                { title: 'Notification title', description: 'This is the description of the notification'}
            ),
            new UxLayoutNotificationItem(
                { title: 'Notification title', description: 'This is the description of the notification'}
            ),
            new UxLayoutNotificationItem(
                { title: 'Notification title', description: 'This is the description of the notification'}
            ),
            new UxLayoutNotificationItem(
                { title: 'Notification title', description: 'This is the description of the notification'}
            ),
            new UxLayoutNotificationItem(
                { title: 'Notification title', description: 'This is the description of the notification'}
            ),
            new UxLayoutNotificationItem(
                { title: 'Notification title', description: 'This is the description of the notification'}
            )                                                              
        ];

    }

    ngOnInit() {
        this.coreService.getUserDetails().subscribe(
            (userDetails: any) => {
                let userName = userDetails.domainUsername;
                let department = userDetails.departmentNumber;
                let buffer: string [] = [userDetails.firstName, userDetails.lastName];
                if (userName != null) {
                    buffer.push('(' + userName + ')');
                }
                if (department != null) {
                    buffer.push(department);
                }
                this.userInfos =  buffer.join(' ');

            },
            error => {
                this.uxService.growl({severity: 'warn', summary: 'WARNING', detail: 'Could not get user details, ignore this when NG is working in offline mode'});
                console.log('WARNING : Could not get user details, ignore this when NG is working in offline mode');
                this.userInfos = 'Name Firstname';
            });        
    }

}
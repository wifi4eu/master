import { Component, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { Observable } from 'rxjs/Observable';
import { Store } from '@ngrx/store';

import { UxLanguage } from '@eui/ux-commons';
import { UserState, getUserState, UxLink } from '@eui/ux-core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {
    userState: Observable<UserState>;

    menuLinks: UxLink[] = [];

    constructor(private translateService: TranslateService, private store: Store<any>, ) {
    }

    ngOnInit() {
        this.userState = <any>this.store.select(getUserState);
        this._createMenuLinks();
    }

    onLanguageChanged(language: UxLanguage) {
        this.translateService.use(language.code);
    }

    private _createMenuLinks() {
        this.menuLinks = [
            new UxLink({ label: 'HOME', url: '/screen/home', isHome: true })
        ];
    }
}

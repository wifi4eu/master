import { Component, Input } from '@angular/core';
import { UxLayoutHeaderComponent } from '@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-layout/ux-layout-header.component';

@Component({
    selector: "custom-layout-header",
    template: `
        <div id="app-header" [class.compact]="isCompact" [class.big]="isBig">
            <a [href]="logoUrl" *ngIf="!isHideLogo">
                <div class="logo">
                    <div *ngIf="envLabel" class="env">{{envLabel}}</div>
                </div>
            </a>    


            <div *ngIf="isCustomTitleContent" class="title">
                <ng-content select="uxLayoutHeaderTitleContent"></ng-content>
            </div>

            <div *ngIf="!isCustomTitleContent" class="title">
                <h1 [class.with-subtitle]="hasSubtitle" [class.no-margin-left]="isHideLogo" class="full" [ngClass]="appFullNameStyleClass">{{appFullName}}</h1>
                <h1 class="short">{{appShortNameGen}}</h1>
                <h2 *ngIf="appSubtitle">
                    {{appSubtitle}}
                </h2>
            </div>

            <div *ngIf="!isCustomRightContent" class="right-links">
                <div *ngIf="isShowLanguageSelector" class="links">
                    <ul>
                        <li>
                            <ux-language-selector *ngIf="languageCodes" (languageChanged)="onLanguageChanged($event)" languageCodes="{{languageCodes}}" [selectedLanguage]="uxService.activeLanguage"></ux-language-selector>
                            <ux-language-selector *ngIf="!languageCodes" (languageChanged)="onLanguageChanged($event)" [selectedLanguage]="uxService.activeLanguage"></ux-language-selector>
                        </li>
                    </ul>
                </div>
                <div class="user-infos" *ngIf="userInfos">
                    <span class="fa fa-user"></span>
                    
                    {{userInfos}}
                    
                    <button *ngIf="!isLogoutHidden" type="button" class="btn btn-sm btn-secondary" title="LOGOUT" (click)="onLogout($event)">
                        <span class="fa fa-sign-out"></span>
                    </button>

                    <button *ngIf="isShowExtraButtonAction" type="button" class="btn btn-sm btn-secondary" title="{{extraButtonActionTitle}}" (click)="onExtraButtonAction($event)">
                        <span class="fa {{extraButtonActionIconClass}}"></span>
                    </button>
                </div>
            </div>

            <div *ngIf="isCustomRightContent" class="right-content">
                <ng-content select="uxLayoutHeaderRightContent"></ng-content>
            </div>
        </div>
    `
})

export class CustomLayoutHeaderComponent extends UxLayoutHeaderComponent {
    @Input() appShortName: string = '';
    @Input() appFullName: string = '';
    @Input() appFullNameStyleClass: string;
    @Input() appSubtitle: string = '';

    @Input() envLabel: string = '';
    @Input() languageCodes: string = '';

    @Input() userInfos: string;
    @Input() isHideLogo: boolean;

    @Input() isCompact: boolean;
    @Input() isBig: boolean;
    @Input() isLogoutHidden: boolean;

    @Input() isCustomRightContent: boolean = false;
    @Input() isCustomTitleContent: boolean = false;

    @Input() isShowExtraButtonAction: boolean = false;
    @Input() extraButtonActionTitle: string;
    @Input() extraButtonActionIconClass: string;

    @Input() isShowLanguageSelector: boolean = true;

    @Input() logoUrl: string = '';
}
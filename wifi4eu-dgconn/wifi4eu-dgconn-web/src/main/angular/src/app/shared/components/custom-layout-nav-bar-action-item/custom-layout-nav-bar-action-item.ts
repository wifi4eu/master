import {Component, Directive, EventEmitter, Input, Output} from "@angular/core";
import {UxLayoutNavBarActionItemComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-layout/ux-layout-nav-bar-action-item.component";
import {UxLayoutLink} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-layout/models/ux-layout-link";
import {UxLayoutNavBarActionsComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-layout/ux-layout-nav-bar-actions.component";

@Component({
    selector: "custom-layout-nav-bar-action-item",
    template: `
        <li class="action-item {{itemClass}}" (click)="toggle($event)" [class.selected]="isActive" [class.hidden-sm-down]="isHiddenMobile">
        <span class="fa {{iconClass}}">
            <span *ngIf="tagCount" class="tag">{{tagCount}}</span>
        </span>
        </li>  

        <template [ngIf]="isOverlayPanel">
        <div class="overlay-panel right-position white state-open hidden-lg-up" [class.hidden]="!isActive" (click)="onClick($event)">
            <div class="overlay-panel-toggle">
                <a (click)="toggle($event)">
                    <span class="label-open">
                    <span class="fa fa-chevron-right"></span>
                    </span>
                    <span class="label-close">
                    <span class="fa fa-times"></span>
                    </span>
                </a>
            </div>      
            
            <template [ngIf]="isOverlayPanelCustomContent">
                <div class="header">
                <ng-content select="uxLayoutNavBarOverlayPanelHeader"></ng-content>
                </div>         
                <div class="overlay-inner">
                <ng-content select="uxLayoutNavBarOverlayPanelInner"></ng-content>
                </div>
            </template>

            <template [ngIf]="!isOverlayPanelCustomContent">
                <div class="header">
                    <div class="profile">
                        <span><ux-language-selector (languageChanged)="onLanguageChanged($event)" languageCodes="en,fr" [selectedLanguage]="uxService.activeLanguage"></ux-language-selector></span>
                        
                        <div *ngIf="isShowProfilePicture" class="picture fa {{profilePictureIconClass}}"></div>

                        <div class="infos">
                            {{userInfos}} 
                        </div>
                    </div>
                </div>

                <div class="overlay-inner">
                    <h5 class="center">Menu</h5>
                    
                    <ul *ngIf="isShowHome">
                        <li routerLinkActive="active" [routerLinkActiveOptions]="{exact:true}">
                            <a [routerLink]="homeUrl">
                                {{ 'shared.home.label' | translate }}
                            </a>
                        </li>
                    </ul>

                    <div *ngFor="let link of links">
                        <template [ngIf]="link.hasChildren">
                            <h5>{{link.label}}</h5>
                            <ul>
                                <li *ngFor="let childLink of link.children" routerLinkActive="active" [routerLinkActiveOptions]="{exact:true}"> 
                                    <template [ngIf]="childLink.disabled">
                                        <a class="disabled">{{childLink.label}}</a>
                                    </template>
                                    <template [ngIf]="!childLink.disabled">
                                        <a [routerLink]="childLink.url">{{childLink.label}}</a>
                                    </template>   
                                </li>
                            </ul>                    
                        </template>
                        <template [ngIf]="!link.hasChildren">
                            <ul>
                                <li routerLinkActive="active">
                                    <a [routerLink]="link.url">{{link.label}}</a>
                                </li>
                            </ul>
                        </template>

                    </div>	
                </div>

            </template>  
        </div>
        </template>

        <template [ngIf]="!isOverlayPanel">
        <aside class="inner-content {{contentClass}}" [class.hidden]="!isActive" (click)="onClick($event)">
            <ng-content></ng-content>       
        </aside>
        </template>
    `
})

export class CustomLayoutNavBarActionItemComponent extends UxLayoutNavBarActionItemComponent {
    @Input() id: string;
    @Input() isToggleContent: boolean = true;
    @Input() isOverlayPanel: boolean = false;
    @Input() isOverlayPanelCustomContent: boolean = false;
    @Input() links: Array<UxLayoutLink> = [];
    @Input() isShowHome: boolean = true;
    @Input() homeUrl: string = '/screen/home';
    @Input() iconClass: string;
    @Input() itemClass: string = '';
    @Input() contentClass: string = '';
    @Input() isActive = false;
    @Input() tagCount: number = 0;
    @Input() userInfos: string;
    @Input() isHiddenMobile: boolean;
    @Input() isShowProfilePicture: boolean = true;
    @Input() profilePictureIconClass: string = 'fa-user';

    uxLayoutNavBarActionsComponent: UxLayoutNavBarActionsComponent;

    toggle(event: Event) {
        super.toggle(event);
    }
}
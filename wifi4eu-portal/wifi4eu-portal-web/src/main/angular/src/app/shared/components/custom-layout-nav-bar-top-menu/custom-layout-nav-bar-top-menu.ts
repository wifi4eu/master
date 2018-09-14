import { Component, Input } from "@angular/core";
import { UxLayoutNavBarTopMenuComponent } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-layout/ux-layout-nav-bar-top-menu.component";
import { UxLayoutLink } from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-layout/models/ux-layout-link";

@Component({
    selector: "custom-layout-nav-bar-top-menu",
    template: `
        <nav id="top-menu">
            <ul>
                <li class="icon-menu-item" routerLinkActive="selected" [routerLinkActiveOptions]="{exact:true}">
                    <a *ngIf="!goToHomeButton" [routerLink]="homeUrl" (click)="onLinkClick({id:'home',url:homeUrl})">
                        <span class="fa fa-home" style="line-height: 27px; vertical-align: bottom;"></span>
                    </a>
                    <a *ngIf="goToHomeButton" (click)="goToHome()">
                        <span class="fa fa-home" style="line-height: 27px; vertical-align: bottom;"></span>
                    </a>
                </li>

                <template [ngIf]="hasLinks">
                    <li [class.has-sub]="link.hasChildren" *ngFor="let link of links" routerLinkActive="selected">
                        <template [ngIf]="link.visible">
                            <a *ngIf="!link.url" (click)="onLinkClick(link)">{{link.label}}</a>
                            <a *ngIf="link.url" [routerLink]="link.url" (click)="onLinkClick(link)">{{link.label}}</a>
                            <ul *ngIf="link.hasChildren">
                                <li class="child" *ngFor="let childLink of link.children" [class.has-sub]="childLink.hasChildren">
                                    <template [ngIf]="childLink.visible">
                                        <a *ngIf="!childLink.url" [class.disabled]="childLink.disabled" (click)="onLinkClick(childLink)">{{childLink.label}}</a>
                                        <a *ngIf="childLink.url" [class.disabled]="childLink.disabled" [routerLink]="childLink.url" (click)="onLinkClick(childLink)">{{childLink.label}}</a>
                                        <ul *ngIf="childLink.hasChildren">
                                            <li class="child" *ngFor="let childSubLink of childLink.children">
                                                <template [ngIf]="childSubLink.visible">
                                                    <a *ngIf="childSubLink.url" [class.disabled]="childSubLink.disabled" [routerLink]="childSubLink.url" (click)="onLinkClick(childSubLink)">{{childSubLink.label}}</a>
                                                    <a *ngIf="!childSubLink.url" [class.disabled]="childSubLink.disabled" (click)="onLinkClick(childSubLink)">{{childSubLink.label}}</a>
                                                </template>    
                                            </li>
                                        </ul>
                                    </template> 
                                </li>
                            </ul>
                        </template>
                    </li>
                </template>
            </ul>
        </nav>
    `
})

export class CustomLayoutNavBarTopMenuComponent extends UxLayoutNavBarTopMenuComponent {
    @Input() links: Array<UxLayoutLink> = [];
    @Input() homeUrl: string = '/screen/home';
    @Input() goToHomeButton: boolean = false;

    get hasLinks(): boolean {
        return this.links != null && this.links.length != 0;
    }

    goToHome() {
        window.location.href = "/#/home";
    }
}
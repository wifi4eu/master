import {Component, EventEmitter, Input, Output} from "@angular/core";
import { CustomLayoutLink } from "./custom-layout-link";

@Component({
    selector: "custom-layout-nav-bar-top-menu",
    template: `
        <nav id="top-menu">
            <ul>
                <li class="icon-menu-item" style="max-height:50px" routerLinkActive="selected" [routerLinkActiveOptions]="{exact:true}">
                    <a style="line-height:19px" [routerLink]="homeUrl" (click)="onLinkClick({id:'home',url:homeUrl})">
                        <span class="fa fa-home" ></span>
                    </a>
                </li>

                <template [ngIf]="hasLinks">
                    <li [class.has-sub]="link.hasChildren" *ngFor="let link of links" routerLinkActive="selected">
                        <template [ngIf]="link.visible">
                            <a *ngIf="!link.url" (click)="onLinkClick(link)">{{link.label}}</a>
                            <a *ngIf="link.url && link.externalUrl" [href]="link.url" (click)="onLinkClick(link)">{{link.label}}</a>
                            <a *ngIf="link.url && !link.externalUrl" [routerLink]="link.url" (click)="onLinkClick(link)">{{link.label}}</a>
                            <ul *ngIf="link.hasChildren">
                                <li class="child" *ngFor="let childLink of link.children" [class.has-sub]="childLink.hasChildren">
                                    <template [ngIf]="childLink.visible">
                                        <a *ngIf="!childLink.url" [class.disabled]="childLink.disabled" (click)="onLinkClick(childLink)">{{childLink.label}}</a>
                                        <a *ngIf="childLink.url && childLink.externalUrl" [class.disabled]="childLink.disabled" [href]="childLink.url" (click)="onLinkClick(childLink)">{{childLink.label}}</a>
                                        <a *ngIf="childLink.url && !childLink.externalUrl" [class.disabled]="childLink.disabled" [routerLink]="childLink.url" (click)="onLinkClick(childLink)">{{childLink.label}}</a>
                                        <ul *ngIf="childLink.hasChildren">
                                            <li class="child" *ngFor="let childSubLink of childLink.children">
                                                <template [ngIf]="childSubLink.visible">
                                                    <a *ngIf="childSubLink.url && childSubLink.externalUrl" [class.disabled]="childSubLink.disabled" [href]="childSubLink.url" (click)="onLinkClick(childSubLink)">{{childSubLink.label}}</a>
                                                    <a *ngIf="childSubLink.url && !childSubLink.externalUrl" [class.disabled]="childSubLink.disabled" [routerLink]="childSubLink.url" (click)="onLinkClick(childSubLink)">{{childSubLink.label}}</a>
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

export class CustomLayoutNavBarTopMenuComponent {
    @Input() links: Array<CustomLayoutLink> = [];
    @Input() homeUrl: string = '/screen/home';
    @Output() private menuItemClicked:EventEmitter<CustomLayoutLink> = new EventEmitter<CustomLayoutLink>();

    get hasLinks(): boolean {
        return this.links.length != 0;
    }

    onLinkClick(uxLayoutLink: CustomLayoutLink) {
        if (uxLayoutLink.url) {
            window.scrollTo(0,0);
        }
        if (!uxLayoutLink.disabled) {
            this.menuItemClicked.emit(uxLayoutLink);
        }
    }
}
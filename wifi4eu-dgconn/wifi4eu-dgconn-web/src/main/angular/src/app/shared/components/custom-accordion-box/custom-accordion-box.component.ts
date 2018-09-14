import {Component, EventEmitter, forwardRef, Host, Inject, Input, Output} from "@angular/core";
import {UxAccordionBoxComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {UxAccordionBoxesComponent} from "@ec-digit-uxatec/eui-angular2-ux-commons/dist/ux-ui-elements/ux-accordion-box/ux-accordion-boxes.component";

@Component({
    selector: 'custom-accordion-box',
    template: `
        <div class="box accordion-box" [class.expanded]="isExpanded">
            <div class="header" style="cursor: default;">
                <span *ngIf="closable" class="closable" [style.padding]="rightSide ? '0.65rem 0 0 1rem' : '0.65rem 1rem 0 0'"
                      style="cursor: pointer;" [style.float]="rightSide ? 'left' : 'right'"(click)="close()"><i class="fa fa-times"></i></span>
                <span class="title" [style.padding]="rightSide ? '0.65rem 1rem 0 0' : '0.65rem 0 0 1rem'"
                      style="cursor: pointer;" [style.float]="rightSide ? 'right' : 'left'" (click)="toggle()">
                    <span *ngIf="isExpanded">{{ 'shared.hide.label' | translate}}</span>
                    <span *ngIf="!isExpanded">{{ 'shared.expand.label' | translate}}</span>
                    <i [class]="isExpanded ? 'fa fa-2x fa-chevron-up' : 'fa fa-2x fa-chevron-down'" style="font-size: 15px; margin-left: 3px;"></i></span>
            </div>
            <div class="content" (click)="clickInside($event)">
                <ng-content></ng-content>
            </div>
        </div>
    `
})

export class CustomAccordionBoxComponent extends UxAccordionBoxComponent {
    @Input() rightSide: boolean = false;
    @Input() isExpanded: boolean = false;
    @Input() closable: boolean = false;
    @Output('onClose') onClose: EventEmitter<any> = new EventEmitter();

    clickInside(event: any) {
        // return event.preventDefault();
    }

    close() {
        this.onClose.emit();
    }
}
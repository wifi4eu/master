import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
    selector: 'panelButton',
    templateUrl: 'panelButton.component.html',
    styleUrls: [ 'panelButton.component.scss' ],
    changeDetection: ChangeDetectionStrategy.OnPush,
    preserveWhitespaces: false
})
export class PanelButtonComponent {

    @Input() title: string;

    @Input() description: string;

    @Input() panelDisabled = false;

    @Output() onClick: EventEmitter<any> = new EventEmitter();

    constructor() {
    }

    panelClicked() {
        this.onClick.emit();
    }

}
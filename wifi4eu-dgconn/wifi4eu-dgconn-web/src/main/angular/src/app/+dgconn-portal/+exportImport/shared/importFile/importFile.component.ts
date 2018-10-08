import { ChangeDetectionStrategy, Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
    selector: 'importFile',
    templateUrl: 'importFile.component.html',
    changeDetection: ChangeDetectionStrategy.OnPush,
    preserveWhitespaces: false
})
export class ImportFileComponent {

    @Input() title: string;

    @Output() selectedFile: EventEmitter<FormData> = new EventEmitter();

    constructor() {
    }

    sendFormData(importFile) {
        this.selectedFile.emit(importFile);
    }

}
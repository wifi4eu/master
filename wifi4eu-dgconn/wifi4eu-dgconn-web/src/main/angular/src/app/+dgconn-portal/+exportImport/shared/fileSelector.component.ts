import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { SharedService } from '../../../shared/shared.service';

@Component({
    selector: 'fileSelector',
    templateUrl: 'fileSelector.component.html'
})
export class FileSelectorComponent {

    @Output() selectedFile: EventEmitter<FormData> = new EventEmitter();

    form: FormGroup;

    constructor(private formBuilder: FormBuilder, private sharedService: SharedService) {
        this.form = this.formBuilder.group({
            importFile: [null, Validators.required]
        });
    }

    onFileChange(event) {
        if (event.target.files.length > 0) {
            let file = event.target.files[0];
            this.form.get('importFile').setValue(file);
        }
    }

    importLegalEntityFile() {
        if (this.form.valid) {
            this.selectedFile.emit(this.prepareSave());
        } else {
            this.sharedService.growlTranslation(
                'An error occurred while trying to retrieve the data from the server. Please, try again later.',
                'shared.error.api.generic',
                'error'
            );
        }
    }

    private clearFileInput() {
        this.form.get('importFile').setValue(null);
    }

    private prepareSave(): any {
        const input = new FormData();
        input.append('importFile', this.form.get('importFile').value);
        return input;
    }
}
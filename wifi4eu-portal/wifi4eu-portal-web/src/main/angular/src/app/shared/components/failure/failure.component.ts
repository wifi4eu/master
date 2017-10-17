import {Component, Input} from '@angular/core';

@Component({selector: 'failure-component', templateUrl: 'failure.component.html'})

export class FailureComponent {
    @Input() titleKey: string = 'submitregistration.failure.title';
    @Input() textKeys: string[] = ['submitregistration.failure.text.part1'];
}
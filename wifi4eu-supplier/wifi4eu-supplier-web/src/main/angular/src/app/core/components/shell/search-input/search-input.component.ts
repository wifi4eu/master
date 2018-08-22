import { Component, NgModule, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UxSearchInputComponent, UxSearchInputSuggestionsService, UxSearchInputComponentModule } from '@eui/ux-commons';
import { Observable } from 'rxjs/Observable';
import { Observer } from 'rxjs/Observer';

@Component({
    selector: 'app-search-input',
    templateUrl: './search-input.component.html'
})
export class SearchInputComponent {
    @ViewChild(UxSearchInputComponent) searchInput: UxSearchInputComponent;

    suggestionsService: UxSearchInputSuggestionsService = {
        getSuggestions(query: string): Observable<string []> {
            return new Observable<string []>((observer: Observer<string []>) => {
                observer.next(['suggestion 1', 'suggestion 2', 'suggestion 3']);
                observer.complete();
            });
        }
    };

    onSearch(query: string) {
        alert('Now searching for: ' + query);
    }

    onSearchButtonClick() {
        this.searchInput.startSearch();
    }
}

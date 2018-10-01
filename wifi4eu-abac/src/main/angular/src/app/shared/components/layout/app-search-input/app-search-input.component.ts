import { Component, ViewChild } from '@angular/core';
import { UxSearchInputComponent, UxSearchInputSuggestionsService } from '@ec-digit-uxatec/eui-angular2-ux-search-input';
import { Observable, Observer } from 'rxjs/Rx';

@Component({
    selector: 'app-search-input',
    templateUrl: './app-search-input.component.html'
})
export class AppSearchInputComponent {
    @ViewChild(UxSearchInputComponent) private searchInput: UxSearchInputComponent;
    private suggestionsService: UxSearchInputSuggestionsService = {
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
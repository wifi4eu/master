import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Subject } from 'rxjs/Subject';
import { SearchParameters } from '../models/search-parameters.model';

@Injectable()
export class SearchParametersService {

    parameters: SearchParameters;

    constructor() { 
        this.parameters = new SearchParameters();
    }

    get() : SearchParameters{
        return this.parameters;
    }
}
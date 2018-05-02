import { Injectable } from '@angular/core';
import { Resolve } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { BeneficiaryDisplayedListDTOBase } from '../../shared/swagger';

@Injectable()
export class BeneficiaryService {

    beneficiarySelected : BeneficiaryDisplayedListDTOBase;
    
    constructor() { }

    
}
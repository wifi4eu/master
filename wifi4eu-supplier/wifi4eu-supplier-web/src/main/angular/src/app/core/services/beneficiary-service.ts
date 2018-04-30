import { Injectable } from '@angular/core';
import { Resolve, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { BeneficiaryDisplayedListDTOBase } from '../../shared/swagger';
import { UxService } from '@eui/ux-commons';
import { TranslateService } from '@ngx-translate/core';

@Injectable()
export class BeneficiaryService {

    beneficiarySelected: BeneficiaryDisplayedListDTOBase;

    constructor(private uxService: UxService, private router: Router, private translateService: TranslateService) { }


    growlNotSelected() {
        this.router.navigate(['screen/installation-report']);
        let translatedString = "No beneficiary selected.";
        this.translateService.get('shared.error.beneficiaryNotSelected').subscribe(
            (translation: string) => {
                if (translation) {
                    translatedString = translation;
                }
                this.uxService.growl({
                    severity: 'danger',
                    summary: 'DANGER',
                    detail: translatedString
                });
            }, error => {
                this.uxService.growl({
                    severity: 'danger',
                    summary: 'DANGER',
                    detail: translatedString
                });
            });
    }

}
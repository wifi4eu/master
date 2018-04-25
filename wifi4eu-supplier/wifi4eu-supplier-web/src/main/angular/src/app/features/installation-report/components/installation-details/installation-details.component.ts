import { Component, Input } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { Router, ActivatedRoute } from "@angular/router";
import { BeneficiaryDisplayedListDTOBase, BeneficiaryDisplayedListDTO } from '../../../../shared/swagger';
import { BeneficiaryService } from '../../../../core/services/beneficiary-service';

@Component({
    templateUrl: './installation-details.component.html'
})
export class InstallationDetailsComponent {
    // @Input('beneficiary') beneficiary : BeneficiaryDisplayedListDTOBase;
    beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;

    installationSite: string = 'installationSite';

    constructor(private uxService: UxService, private router: Router, private route: ActivatedRoute, private beneficiaryService: BeneficiaryService) {
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiary = this.beneficiaryService.beneficiarySelected;
        } else {
            router.navigate(['screen/installation-report']);
        }
    }

    ngOnInit() {

    }

    openUpdateInstallationSite() {
        this.uxService.openModal('updateInstallationSite');
    }

    openRemoveInstallationSite() {
        this.uxService.openModal('removeInstallationSite');
    }

    submitRemoveInstallationSite() {
        this.closeRemoveInstallationSite();
        this.router.navigate(['screen/installation-report']);
    }

    closeRemoveInstallationSite() {
        this.uxService.closeModal('removeInstallationSite');

    }
}

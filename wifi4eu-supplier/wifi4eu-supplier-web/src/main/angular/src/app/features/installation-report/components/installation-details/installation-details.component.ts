import { Component } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { Router } from "@angular/router";

@Component({
    templateUrl: './installation-details.component.html'
})
export class InstallationDetailsComponent{
    beneficiary : string = 'beneficiario';

    installationSite: string = 'installationSite';

    constructor(private uxService: UxService, private router: Router){

    }

    openUpdateInstallationSite(){
        this.uxService.openModal('updateInstallationSite');
    }

    openRemoveInstallationSite(){
        this.uxService.openModal('removeInstallationSite');
    }

    submitRemoveInstallationSite(){
        console.log('submit removeInstallationSite');
        this.closeRemoveInstallationSite();
        this.router.navigate(['screen/installation-report']);
    }

    closeRemoveInstallationSite(){
        this.uxService.closeModal('removeInstallationSite');

    }
}

import { Component, Input } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { Router, ActivatedRoute } from "@angular/router";
import { BeneficiaryDisplayedListDTOBase, BeneficiaryDisplayedListDTO } from '../../../../shared/swagger';
import { BeneficiaryService } from '../../../../core/services/beneficiary-service';
import { Location } from '@angular/common';
import { AccessPointBase } from '../../../../shared/swagger/model/AccessPoint';

@Component({
    templateUrl: './access-point-details.component.html'
})
export class AccessPointDetailsComponent {
    // @Input('beneficiary') beneficiary : BeneficiaryDisplayedListDTOBase;
    private beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private installationSiteName: string;

    private accessPoint : AccessPointBase;

    //observable that gets the id from route params
    private idSub: any;

    constructor(private uxService: UxService, private router: Router,private location: Location, private route: ActivatedRoute, private beneficiaryService: BeneficiaryService) {
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiary = this.beneficiaryService.beneficiarySelected;
        } else {
            router.navigate(['screen/installation-report']);
        }

        this.idSub = this.route.params.subscribe(params => {
            this.installationSiteName = params['name'];
            let apId= params['ap'];
            //get access point by id
        });
    }

    openUpdateAccessPoint() {
        this.uxService.openModal('updateAccessPoint');
    }

    openRemoveAccessPoint() {
        this.uxService.openModal('removeAccessPoint');
    }

    submitRemoveAccessPoint() {
        this.closeRemoveAccessPoint();
        this.location.back();
    }

    closeRemoveAccessPoint() {
        this.uxService.closeModal('removeAccessPoint');

    }
}

import { Component, Input, OnInit } from '@angular/core';
import { UxService } from '@eui/ux-commons';
import { Router, ActivatedRoute } from "@angular/router";
import { BeneficiaryDisplayedListDTOBase, BeneficiaryDisplayedListDTO, ResponseDTOBase } from '../../../../shared/swagger';
import { BeneficiaryService } from '../../../../core/services/beneficiary-service';
import { Location } from '@angular/common';
import { AccessPointBase } from '../../../../shared/swagger/model/AccessPoint';
import { AccesspointsApi } from '../../../../shared/swagger/api/AccesspointsApi';

@Component({
    templateUrl: './access-point-details.component.html'
})
export class AccessPointDetailsComponent implements OnInit {
    // @Input('beneficiary') beneficiary : BeneficiaryDisplayedListDTOBase;
    private beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private installationSiteName: string;

    private accessPoint: AccessPointBase;

    //observable that gets the id from route params
    private idSub: any;

    constructor(private uxService: UxService, private router: Router, private location: Location, private route: ActivatedRoute,
        private beneficiaryService: BeneficiaryService, private accessPointService: AccesspointsApi) {
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiary = this.beneficiaryService.beneficiarySelected;
        } else {
            router.navigate(['screen/installation-report']);
        }

        this.idSub = this.route.params.subscribe(params => {
            this.installationSiteName = params['name'];
            let apId = params['ap'];

        });

    }

    ngOnInit() {
        this.route.data.subscribe((data: { accessPoint: AccessPointBase }) => {
             this.accessPoint = data.accessPoint;
        });
    }

    openUpdateAccessPoint() {
        this.uxService.openModal('updateAccessPoint');
    }

    openRemoveAccessPoint() {
        this.uxService.openModal('removeAccessPoint');
    }

    submitRemoveAccessPoint() {
        this.accessPointService.deleteAccessPointById(this.accessPoint.id).subscribe((response : ResponseDTOBase)=> {
            if(response.success){
                this.location.back();
            }
        });
        this.closeRemoveAccessPoint();
    }

    closeRemoveAccessPoint() {
        this.uxService.closeModal('removeAccessPoint');

    }
}

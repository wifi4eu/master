import 'rxjs/add/operator/switchMap';
import { Component, OnInit } from '@angular/core';
import { BeneficiaryDisplayedListDTOBase } from '../../../../shared/swagger';
import { UxService } from '@eui/ux-commons';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { BeneficiaryService } from '../../../../core/services/beneficiary-service';
import { SearchParametersService } from '../../../../core/services/search-parameters.service';
import { Observable } from 'rxjs/Observable';
import { AccessPoint } from '../../../../core/models/access-point.model';


@Component({
    templateUrl: './access-point-list.component.html'
})
export class AccessPointListComponent {

    private beneficiary: BeneficiaryDisplayedListDTOBase = new BeneficiaryDisplayedListDTOBase;
    private totalResults: number = 0;
    private accessPoints: AccessPoint[];
    private installationSiteId: number = 0;
    private installationSiteName: string = '';

    //observable that gets the id from route params
    private idSub: any;

    constructor(private uxService: UxService, private router: Router, private route: ActivatedRoute,
        private beneficiaryService: BeneficiaryService, public searchParametersService: SearchParametersService) {
        if (this.beneficiaryService.beneficiarySelected != undefined) {
            this.beneficiary = this.beneficiaryService.beneficiarySelected;
        } else {
            router.navigate(['screen/installation-report']);
        }

        this.idSub = this.route.params.subscribe(params => {
            this.installationSiteId = params['id'];
            this.installationSiteName = params['name'];
        });

        this.onSearch();
    }

    onPage(event: any) {
        this.searchParametersService.parameters.delta = event.rows;
        this.searchParametersService.parameters.page = event.first;
        this.searchParametersService.parameters.fieldOrder = event.sortField ? event.sortField : "number";
        this.searchParametersService.parameters.order = event.sortOrder > 0 ? "asc" : "desc";
        this.onSearch();
    }

    onSearch() {
        this.totalResults = 0;
        this.accessPoints = [];
        this.accessPoints.push(new AccessPoint(1, 'City Hall', 'Corridor', '50.84148', '4.368323',
            'Indoor', 'Cysco', 'Mx-123', '1234567', '00:0C:6E:D2:11:E6'));
        this.accessPoints.push(new AccessPoint(2, 'Library', 'Corridor', '50.84148', '4.368323',
            'Indoor', 'Cysco', 'Mx-123', '1234567', '00:0C:6E:D2:11:E6'));
        this.accessPoints.push(new AccessPoint(2, 'Library', 'Corridor', '50.84148', '4.368323',
            'Indoor', 'Cysco', 'Mx-123', '1234567', '00:0C:6E: D2:11:E6'));
        this.totalResults = this.accessPoints.length;
    }

    openUpdateAccessPoint() {
        this.uxService.openModal('updateAccessPoint');
    }

}

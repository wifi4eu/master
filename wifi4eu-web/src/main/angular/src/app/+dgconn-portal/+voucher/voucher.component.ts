import {Component, Input, EventEmitter, OnInit, Output} from "@angular/core";
import {DgConnDetails} from "../dgconnportal-details.model";
import {Http} from "@angular/http";
import {BeneficiaryDTOBase} from "../../shared/swagger/model/BeneficiaryDTO";
import {UxService} from "@ec-digit-uxatec/eui-angular2-ux-commons";
import {LauApi} from "../../shared/swagger/api/LauApi";
import {NutsApi} from "../../shared/swagger/api/NutsApi";
import {NutsDTOBase} from "../../shared/swagger/model/NutsDTO";
import {LauDTOBase} from "../../shared/swagger/model/LauDTO";

@Component({
    templateUrl: 'voucher.component.html',
    providers: [LauApi, NutsApi]
})

export class DgConnVoucherComponent {

    @Input('beneficiaryDTO') beneficiaryDTO: BeneficiaryDTOBase;
    @Input('nutsDTO') nutsDTO: NutsDTOBase;
    @Input('lausDTO') lausDTO: NutsDTOBase;

    @Output() onNext = new EventEmitter<number>();

    private nutsSuggestions: NutsDTOBase[];
    private lausSuggestions: LauDTOBase[];

    constructor(private http: Http, private lauApi: LauApi, private nutsApi: NutsApi, private uxService: UxService) {
    }

    onKeyUp(event) {
        // Check if key pressed is a ascii printable letter
        if (event.keyCode > 64 && event.keyCode < 91) {
            if (typeof this.nutsDTO === "string") {
                let name: string = this.nutsDTO;
                let nuts = this.nutsSuggestions;
                for (let i = 0; i < nuts.length; i++) {
                    let nut = nuts[i];
                    if (nut.name.toLowerCase().indexOf(name.toLowerCase()) == 0) {
                        this.nutsDTO = nut;
                    }
                }
            }
        }
    }

    filterNuts(event) {
        this.nutsApi.findNutsByLevel(0).subscribe(
            nuts => {
                this.nutsSuggestions = this.filterCountries(event.query, nuts)
            },
            error => {
                this.uxService.growl({
                    severity: 'warn',
                    summary: 'WARNING',
                    detail: 'Could not get nuts, ignore this when NG is working in offline mode'
                });
                console.log('WARNING: Could not get nuts', error);
            }
        );
    }

    filterCountries(query, nuts: NutsDTOBase[]) {
        let filteredNuts: NutsDTOBase[] = [];
        for (let i = 0; i < nuts.length; i++) {
            let nut = nuts[i];
            nut.name = nut.name.toLowerCase();
            if (nut.name.indexOf(query.toLowerCase()) == 0) {
                nut.name = nut.name.charAt(0).toUpperCase() + nut.name.slice(1);
                filteredNuts.push(nut);
            }
        }
        return filteredNuts;
    }
}
import { Component } from "@angular/core";
import { SharedService } from "../../shared/shared.service";
import { UserDTOBase, BeneficiaryApi, ResponseDTO} from "../../shared/swagger";
import { BeneficiaryMyInstallationDTOBase } from "../../shared/swagger/model/BeneficiaryMyInstallationDTO";



@Component({
    selector: 'supplier-my-installation',
    templateUrl: 'supplier-my-installation.component.html',
    providers: [BeneficiaryApi]
})

export class SupplierMyInstallationComponent {

    private firstDataDownload: boolean = false;
    private user: UserDTOBase = null;
    private beneficiaryList: BeneficiaryMyInstallationDTOBase[] = [];
    // private bankAccounts: BankAccountDTOBase[] = [];

    constructor(private sharedService: SharedService, private beneficiaryApi: BeneficiaryApi) {
        this.firstDataDownload = true;
        if (this.sharedService.user) {
            this.user = this.sharedService.user;
            this.getSupplierBeneficiaries();
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.user = this.sharedService.user;
                this.getSupplierBeneficiaries()
            });
        }
    }


    private getSupplierBeneficiaries() {
        this.beneficiaryApi.getBeneficiariesListMyInstallation().subscribe((response: ResponseDTO) => {
            if (response.success) {
                this.beneficiaryList = response.data;
            } else {
                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'summary.error');
            }
            this.firstDataDownload = false;
        }, error => {
            console.log(error);
            this.firstDataDownload = false;
            this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'summary.error');
        });
    }

}
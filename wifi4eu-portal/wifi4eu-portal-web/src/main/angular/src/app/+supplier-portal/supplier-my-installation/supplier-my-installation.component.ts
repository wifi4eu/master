import { Component } from "@angular/core";
import { SharedService } from "../../shared/shared.service";
import { UserDTOBase, BeneficiaryApi, ResponseDTO } from "../../shared/swagger";
import { BeneficiaryMyInstallationDTOBase } from "../../shared/swagger/model/BeneficiaryMyInstallationDTO";
import { animate, style, transition, trigger } from "@angular/animations";
import { BankAccountDTOBase } from "../../shared/swagger/model/BankAccountDTO";



@Component({
    selector: 'supplier-my-installation',
    templateUrl: 'supplier-my-installation.component.html',
    providers: [BeneficiaryApi],
    animations: [
        trigger(
            'enterSpinner', [
                transition(':enter', [
                    style({ opacity: 0 }),
                    animate('200ms', style({ opacity: 1 }))
                ]),
                transition(':leave', [
                    style({ opacity: 1 }),
                    animate('200ms', style({ opacity: 0 }))
                ])
            ]
        )
    ]
})
export class SupplierMyInstallationComponent {

    private firstDataDownload: boolean = false;
    private user: UserDTOBase = null;
    private beneficiaryList: BeneficiaryMyInstallationDTOBase[] = [];
    private bankAccounts: BankAccountDTOBase[] = [];

    //modal variables
    private displaySelectBankAccount: boolean = false;
    private confirmAttribute: boolean = false;

    //select bank account
    private beneficiaryToModify: BeneficiaryMyInstallationDTOBase = null;
    private selectedBankAccount: number = null;

    constructor(private sharedService: SharedService, private beneficiaryApi: BeneficiaryApi) {
        this.firstDataDownload = true;
        if (this.sharedService.user) {
            this.user = this.sharedService.user;
            this.loadData();
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.user = this.sharedService.user;
                this.loadData()
            });
        }
    }

    private loadData() {
        this.beneficiaryApi.getMyInstallationData().subscribe((response: ResponseDTO) => {
            if (response.success) {
                this.beneficiaryList = response.data.beneficiaryMyInstallationDTOList;
                this.bankAccounts = response.data.bankAccountDTOList;
            } else {
                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
            }
            this.firstDataDownload = false;
        }, error => {
            console.log(error);
            this.firstDataDownload = false;
            this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
        });
    }

    private selectBankAccount(beneficiary: BeneficiaryMyInstallationDTOBase, bankAccountId: number) {
        this.beneficiaryToModify = beneficiary;
        if (bankAccountId) {
            this.selectedBankAccount = bankAccountId;
        }
        this.displaySelectBankAccount = true;
    }

    private closeModal() {
        this.displaySelectBankAccount = false;
        this.confirmAttribute = false;
        this.beneficiaryToModify = null;
        this.selectedBankAccount = null;
    }
    private selectBankAccountSubmit() {
        if (this.beneficiaryToModify && this.selectedBankAccount) {
            this.beneficiaryApi.attributeBankAccountToBeneficiary(this.beneficiaryToModify.id, this.selectedBankAccount).subscribe((response: ResponseDTO) => {
                if (response.success) {
                    let index = this.beneficiaryList.findIndex(benef => benef.id == this.beneficiaryToModify.id);
                    this.beneficiaryList[index].bankAccountId = this.selectedBankAccount;
                    this.closeModal();
                    this.sharedService.growlTranslation('Bank account successfuly attributed for the selected munipality.', 'supplier.myInstallation.selectBankSuccess', 'success');
                } else {
                    this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
                }
            }, error => {
                console.log(error);
                this.sharedService.growlTranslation('An error occurred while trying to retrieve the data from the server. Please, try again later.', 'shared.error.api.generic', 'error');
            });
        }
    }

}
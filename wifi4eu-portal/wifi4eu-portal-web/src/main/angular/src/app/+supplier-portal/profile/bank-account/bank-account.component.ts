import { Component, ViewChild } from "@angular/core";
import { BankAccountApi } from "../../../shared/swagger/api/BankAccountApi";
import { SupplierApi } from "../../../shared/swagger/api/SupplierApi";
import { SharedService } from "../../../shared/shared.service";
import { BankAccountDTOBase } from "../../../shared/swagger/model/BankAccountDTO";
import { SupplierDTOBase, SupplierDTO } from "../../../shared/swagger/model/SupplierDTO";
import { UserDTOBase } from "../../../shared/swagger/model/UserDTO";
import { ResponseDTOBase } from "../../../shared/swagger/model/ResponseDTO";

@Component({
    templateUrl: 'bank-account.component.html',
    providers: [BankAccountApi, SupplierApi]
})

export class BankAccountComponent {

    private currentBankAccountDTO : BankAccountDTOBase = new BankAccountDTOBase();
    private bankAccountDTOList : BankAccountDTOBase[] = [];
    private supplier : SupplierDTOBase;
    private user : UserDTOBase;

    private addOrEditBankAccount: boolean = false;
    private confirmEnabled: boolean = false;

    constructor(private bankAccountApi: BankAccountApi, private supplierApi: SupplierApi, private sharedService: SharedService) {
        if (this.sharedService.user) {
            this.user = this.sharedService.user;
            this.fillSuplierAndBankAccounts(); 
        } else {
            this.sharedService.loginEmitter.map(() => {
                this.user = this.sharedService.user;
                this.fillSuplierAndBankAccounts(); 
            });
        }
    }

    private fillSuplierAndBankAccounts() {
        this.supplierApi.getSupplierByUserId(this.user.id, new Date().getTime()).subscribe(
            (supplier: SupplierDTOBase) => {
                if (supplier != null) {
                    this.supplier = supplier;

                    this.bankAccountApi.getBankAccountsBySupplierId(this.supplier.id).subscribe(
                        (responseDTO: ResponseDTOBase) => {
                            if (responseDTO.success){
                                this.bankAccountDTOList = responseDTO.data;    
                            }

                        }
                    );
                }                    
            }
        );
    }

    private enableButtonConfirm() {
        this.confirmEnabled = !(this.isEmpty(this.currentBankAccountDTO.accountName) || this.isEmpty(this.currentBankAccountDTO.iban) 
            || this.isEmpty(this.currentBankAccountDTO.accountHolderStreet) || this.isEmpty(this.currentBankAccountDTO.accountHolderNumber) 
            || this.isEmpty(this.currentBankAccountDTO.accountHolderCity) || this.isEmpty(this.currentBankAccountDTO.accountHolderCountry)  
            || this.isEmpty(this.currentBankAccountDTO.bankName) 
            || this.isEmpty(this.currentBankAccountDTO.bankStreet) || this.isEmpty(this.currentBankAccountDTO.bankNumber) 
            || this.isEmpty(this.currentBankAccountDTO.bankCity) || this.isEmpty(this.currentBankAccountDTO.bankCountry)); 
    }

    private addBankAccount(){
        this.currentBankAccountDTO = new BankAccountDTOBase();
        this.currentBankAccountDTO.supplierId = this.supplier.id;
        this.currentBankAccountDTO.status = 2;
        this.activateAddOrEditBankAccountModal();
    }
    
    private editBankAccount(index: number){
        this.currentBankAccountDTO =this.bankAccountDTOList[index]; ;
        this.activateAddOrEditBankAccountModal();
    }

    private deleteBankAccount(index: number){
        this.currentBankAccountDTO =this.bankAccountDTOList[index]; ;
    }
    
    private activateAddOrEditBankAccountModal(){
        this.addOrEditBankAccount = true;
        this.enableButtonConfirm();
    }

    private closeModalCancel(){
        this.addOrEditBankAccount = false;
    }

    private closeModalOK(){
        this.addOrEditBankAccount = false;
        this.bankAccountApi.createBankAccount(this.currentBankAccountDTO).subscribe(
            (responseDTO: ResponseDTOBase) => {
                if (responseDTO.success){
                    this.bankAccountDTOList.push(responseDTO.data);    
                }

            }
        );;
    }

    private isEmpty(string: String) : boolean{
        return string == null || string.trim() == "";
    }

}
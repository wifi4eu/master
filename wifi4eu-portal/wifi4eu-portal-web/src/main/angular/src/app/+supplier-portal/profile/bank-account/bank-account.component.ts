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

    private bankAccountDTOList : BankAccountDTOBase[] = [];
    private supplier : SupplierDTOBase;
    private user : UserDTOBase;

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

}
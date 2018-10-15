import { Component, ViewChild } from "@angular/core";
import { BankAccountsApi } from "../../../shared/swagger/api/BankAccountsApi";
import { SupplierApi } from "../../../shared/swagger/api/SupplierApi";
import { NutsApi } from "../../../shared/swagger/api/NutsApi";
import { SharedService } from "../../../shared/shared.service";
import { BankAccountDTOBase } from "../../../shared/swagger/model/BankAccountDTO";
import { BankAccountDocumentDTOBase } from "../../../shared/swagger/model/BankAccountDocumentDTO";
import { SupplierDTOBase, SupplierDTO } from "../../../shared/swagger/model/SupplierDTO";
import { UserDTOBase } from "../../../shared/swagger/model/UserDTO";
import { ResponseDTOBase } from "../../../shared/swagger/model/ResponseDTO";
import { Observable } from "rxjs/Observable";
import { NutsDTOBase } from "../../../shared/swagger/model/NutsDTO";

@Component({
    templateUrl: 'bank-account.component.html',
    styleUrls: ['bank-account.component.scss'],
    providers: [BankAccountsApi, SupplierApi, NutsApi]
})

export class BankAccountComponent {

    private countries: NutsDTOBase[] = [];

    private currentBankAccountDTO : BankAccountDTOBase = new BankAccountDTOBase();
    private bankAccountDTOList : BankAccountDTOBase[] = [];
    private supplier : SupplierDTOBase;
    private user : UserDTOBase;

    private addOrEditBankAccount: boolean = false;
    private confirmEnabled: boolean = false;
    private index: number;

    private bankAccountDocumentDTOToUpdate :BankAccountDocumentDTOBase = null;

    private reader: FileReader = new FileReader();

    private show : boolean[] = [];

    private fileURL: String = '/wifi4eu/api/bankAccounts/';
    private emptySpaces : String = ' ';

    constructor(private bankAccountsApi: BankAccountsApi, private supplierApi: SupplierApi, private nutsApi: NutsApi,private sharedService: SharedService) {
        this.findCountries();
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

                    this.bankAccountsApi.getBankAccountsBySupplierId(this.supplier.id).subscribe(
                        (responseDTO: ResponseDTOBase) => {
                            if (responseDTO.success){
                                this.bankAccountDTOList = responseDTO.data;   

                                for(let i = 0;i< this.bankAccountDTOList.length; i++){
                                    this.show.push(true);
                                }
                                
                                this.bankAccountsApi.getBankAccountDocsBySupplierId(this.supplier.id).subscribe(
                                    (responseDTO: ResponseDTOBase) => {
                                        if (responseDTO.success){
                                            let bankAccountDocumentDTOList : BankAccountDocumentDTOBase[] = responseDTO.data;

                                             let bankAccountIndex : number = 0;
                                             
                                             for (let i = 0; i < bankAccountDocumentDTOList.length; i++) {
                                                let bankAccountDocumentDTO : BankAccountDocumentDTOBase = bankAccountDocumentDTOList[i];

                                                while (bankAccountDocumentDTO.bankAccountId != this.bankAccountDTOList[bankAccountIndex].id) {
                                                    bankAccountIndex++;
                                                }

                                                this.bankAccountDTOList[bankAccountIndex].bankAccountDocumentDTOList.push(bankAccountDocumentDTO);
                                             }
                                        }
                                    }
                                );
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
        this.index = index;
        this.currentBankAccountDTO = this.cloneBankAccount(this.bankAccountDTOList[index]); ;
        this.activateAddOrEditBankAccountModal();
    }

    private deleteBankAccount(index: number){
        this.currentBankAccountDTO =this.bankAccountDTOList[index]; ;
    }
    
    private activateAddOrEditBankAccountModal(){
        this.addOrEditBankAccount = true;
        this.bankAccountDocumentDTOToUpdate = null;
        //this.enableButtonConfirm();
    }

    private closeModalCancel(){
        this.addOrEditBankAccount = false;
    }

    private closeModalOK(){
        this.addOrEditBankAccount = false;
        this.confirmEnabled = false;

        this.bankAccountsApi.saveBankAccount(this.currentBankAccountDTO).subscribe(
            (responseDTO: ResponseDTOBase) => {
                if (responseDTO.success){
                    if (this.currentBankAccountDTO.id){ //EDIT
                        responseDTO.data.bankAccountDocumentDTOList = this.bankAccountDTOList[this.index].bankAccountDocumentDTOList;
                        this.bankAccountDTOList[this.index] = responseDTO.data;

                    }else{ //CREATE
                        this.bankAccountDTOList.push(responseDTO.data); 
                        this.show.push(true);
                    }
                    
                    if (this.bankAccountDocumentDTOToUpdate){

                        let bankAccountDTO : BankAccountDTOBase = responseDTO.data;
                        this.bankAccountDocumentDTOToUpdate.bankAccountId = bankAccountDTO.id; 

                        this.bankAccountsApi.saveBankAccountDocument(this.bankAccountDocumentDTOToUpdate).subscribe(
                            (responseDTO: ResponseDTOBase) => {
                                if (responseDTO.success){
                                    bankAccountDTO.bankAccountDocumentDTOList.push(responseDTO.data);
                                }
                            }
                        );
                    }

                }else{
                    this.sharedService.growlTranslation('An error occurred and your Bank Account could not be saved.', 'shared.suppRegistration.bankAccount.save.error', 'error');
                }
            }, error => {
                this.sharedService.growlTranslation('An error occurred and your Bank Account could not be saved.', 'shared.suppRegistration.bankAccount.save.error', 'error');
            }
        );;
    }

    private isEmpty(string: String) : boolean{
        return string == null || string.trim() == "";
    }

    private cloneBankAccount(bankAccountDTO: BankAccountDTOBase): BankAccountDTOBase{
        return JSON.parse(JSON.stringify(bankAccountDTO));
    }

    private uploadFile(event: any) {
        if (event.target.files[0]) {
            this.reader = new FileReader();
            if (event.target.files[0].size > 1024000) {
                this.sharedService.growlTranslation('The file you uploaded is too big. Max file size allowed is 1 MB.', 'benefPortal.file.toobig.maxsize', 'warn', { size: '1 MB' });
                return;
            }
            if (event.target.files[0].type == "application/pdf" || event.target.files[0].type == "image/png" || event.target.files[0].type == "image/jpg" || event.target.files[0].type == "image/jpeg") {
                this.checkFileMimeType(event.target.files[0]).then(() => {
                    let subscription;
                    this.reader.readAsDataURL(event.target.files[0]);
                    subscription = Observable.interval(200).subscribe(
                        x => {
                            if (this.reader.result != "") {
                                let file = new BankAccountDocumentDTOBase();
                                file.fileData = this.reader.result;

                                let nameWithExtension : String = event.target.files[0].name;

                                file.fileName = nameWithExtension.substring(0,nameWithExtension.lastIndexOf('.'));
                                file.fileSize = event.target.files[0].size;
                                file.supplierId = this.supplier.id;
                                this.bankAccountDocumentDTOToUpdate = file;
                                this.enableButtonConfirm();

                                subscription.unsubscribe();
                            }
                        }
                    );
                }).catch(() => {
                    this.sharedService.growlTranslation('Please, select a valid file.', 'shared.incorrectFormat', 'warn');
                });
            } else {
                this.sharedService.growlTranslation('Please, select a valid file.', 'shared.incorrectFormat', 'warn');
            }
        }
    }

    private checkFileMimeType(file: File): Promise<any> {
        return new Promise((resolve, reject) => {
            var blob = file;
            var fileReader = new FileReader();
            fileReader.onloadend = function (e: any) {
                var arr = (new Uint8Array(e.target.result)).subarray(0, 4);
                var header = "";
                for (var i = 0; i < arr.length; i++) {
                    header += arr[i].toString(16);
                }
                var type = "";
                // Check the file signature against known types
                switch (header) {
                    case "89504e47":
                        type = "image/png";
                        resolve();
                        break;
                    case "ffd8ffe0":
                    case "ffd8ffe1":
                    case "ffd8ffe2":
                    case "ffd8ffe3":
                    case "ffd8ffe8":
                        type = "image/jpeg";
                        resolve();
                        break;
                    case "25504446":
                        type = "application/pdf";
                        resolve();
                        break;
                    default:
                        // extension not 
                        reject();
                        break;
                }
            };
            fileReader.readAsArrayBuffer(blob);
        });
    }

    private changeShow(index: number){
        this.show[index]  = !this.show[index];
    }


    private checkShow(index: number) : boolean{
        return this.show[index];
    }

    private findCountries() : void{
        this.nutsApi.getNutsByLevel(0).subscribe(
            (nuts: NutsDTOBase[]) => {
                this.countries = nuts;
            }, error => {
                console.log(error);
            }
        );
    }

    private fillAccountHolderDetails() : void{
        if (this.currentBankAccountDTO.sameAddressAsSupplier){

                let userOfSupplierrDTO : UserDTOBase = this.getUserMainOfSUpplier();

                this.currentBankAccountDTO.accountHolderNumber = userOfSupplierrDTO.addressNum;
                this.currentBankAccountDTO.accountHolderStreet = userOfSupplierrDTO.address;
                this.currentBankAccountDTO.accountHolderCity = userOfSupplierrDTO.city;
                this.currentBankAccountDTO.accountHolderCountry = userOfSupplierrDTO.country;
        }
    }

    /*
        Now we don't have contacts, but when we have, we will have to search the main user od the supplier, so this method will change
    */

    private getUserMainOfSUpplier() : UserDTOBase {
        return this.user;
    }

    private afterChange(){
        this.formatFields();
        this.enableButtonConfirm();
    }

    private formatFields() : void{
        this.currentBankAccountDTO.accountName =  this.replaceNonAsciiCharacters(this.currentBankAccountDTO.accountName);

        this.currentBankAccountDTO.bankName = this.replaceNonAsciiCharacters(this.currentBankAccountDTO.bankName);
        this.currentBankAccountDTO.bankCity = this.replaceNonAsciiCharacters(this.currentBankAccountDTO.bankCity);
        this.currentBankAccountDTO.bankStreet = this.replaceNonAsciiCharacters(this.currentBankAccountDTO.bankStreet);
        this.currentBankAccountDTO.bankNumber = this.replaceNonAsciiCharacters(this.currentBankAccountDTO.bankNumber);

        this.currentBankAccountDTO.accountHolderCity = this.replaceNonAsciiCharacters(this.currentBankAccountDTO.accountHolderCity);
        this.currentBankAccountDTO.accountHolderStreet = this.replaceNonAsciiCharacters(this.currentBankAccountDTO.accountHolderStreet);
        this.currentBankAccountDTO.accountHolderNumber = this.replaceNonAsciiCharacters(this.currentBankAccountDTO.accountHolderNumber);
    }

    private replaceNonAsciiCharacters(s : string) :string{
        if (s == null) return null;
        
        s = s.replace(new RegExp("[óòöðôõøő]"),"o")
            .replace(new RegExp("[ÒÓÖÔÕØŐ]"),"O")
            .replace(new RegExp("[ñńňņ]"),"n")
            .replace(new RegExp("[ÑŃŇŅ]"),"N")
            .replace(new RegExp("[èéêëęėěē]"),"e")
            .replace(new RegExp("[ÈÉÊËĘĖĚĒ]"),"E")
            .replace(new RegExp("[áãâàäåæąăā]"),"a")
            .replace(new RegExp("[Æ]"),"AE")
            .replace(new RegExp("[ÀÁÂÃÅÄĄĂĀ]"),"A")
            .replace(new RegExp("[ùúûüµųūůű]"),"u")
            .replace(new RegExp("[ÙÚÛÜŲŪŮŰ]"),"U")
            .replace(new RegExp("[ÝŸ]"),"Y")
            .replace(new RegExp("[ÿý]"),"y")
            .replace(new RegExp("[œ]"),"oe")
            .replace(new RegExp("[çčćċ]"),"c")
            .replace(new RegExp("[Œ]"),"OE")
            .replace(new RegExp("[ÇČĆĊ]"),"C")
            .replace(new RegExp("[ìíîïįī]"),"i")
            .replace(new RegExp("[ÌÍÎÏĮĪ]"),"I")
            .replace(new RegExp("[Þ]"),"Th")
            .replace(new RegExp("[ĐĎ]"),"D")
            .replace(new RegExp("[ďđ]"),"d")
            .replace(new RegExp("[ß]"),"ss")
            .replace(new RegExp("[ŠŚŞ]"),"S")
            .replace(new RegExp("[šśş]"),"s")
            .replace(new RegExp("[β]"),"b")
            .replace(new RegExp("[łļľ]"),"l")
            .replace(new RegExp("[ŁĽ]"),"D")
            .replace(new RegExp("[ŁĽ]"),"D")
            .replace(new RegExp("[ŽŻŹ]"),"Z")
            .replace(new RegExp("[žżź]"),"z")
            .replace(new RegExp("[ŢŤ]"),"T")
            .replace(new RegExp("[ţť]"),"t")
            .replace(new RegExp("[Ý]"),"Y")
            .replace(new RegExp("[ý]"),"y")
            .replace(new RegExp("[Ř]"),"R")
            .replace(new RegExp("[řŕ]"),"r")
            .replace(new RegExp("[Ħ]"),"H")
            .replace(new RegExp("[ħ]"),"h")
            .replace(new RegExp("[Ġ]"),"G")
            .replace(new RegExp("[ġ]"),"g")
            .replace(new RegExp("[þ]"),"th")
            .replace(new RegExp("[ķ]"),"k")
            .replace(new RegExp("[Ķ]"),"K")
            .replace(new RegExp("[_]"),"-");

        return s;
    }

}
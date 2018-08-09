import { OnInit, Component, ViewEncapsulation, ViewChild, ElementRef } from "@angular/core";
import { trigger, transition, style, animate, query, stagger, group, state } from '@angular/animations';
import { CallDTOBase, CallApi, NutsApi, NutsDTOBase, BeneficiaryApi, ResponseDTO } from '../../shared/swagger';
import { Subscription } from 'rxjs';
import {ActivatedRoute, Router} from "@angular/router";
import {SharedService} from "../../shared/shared.service";
import * as FileSaver from 'file-saver';

@Component({
  selector: 'app-beneficiary-list',
  templateUrl: './beneficiary-list.component.html',
  styleUrls: ['./beneficiary-list.component.scss'],
  providers: [CallApi, NutsApi, BeneficiaryApi],
  encapsulation: ViewEncapsulation.None,
  animations: [
    trigger('opacityTransition', [
      state('*', style({ opacity: 1 })),
      state('void', style({ opacity: 0 })),
      transition('* => void', [
        style({ opacity: 1 }),
        animate('0.2s linear', style({ opacity: 0 }))
      ]),
      transition('void => *', [
        style({ opacity: 0 }),
        animate('0.2s linear', style({ opacity: 1 }))
      ])
    ])
  ]
})
export class BeneficiaryListComponent implements OnInit {

  private calls: CallDTOBase[] = [];
  private currentCall : CallDTOBase = null;
  private currentIndex : number = 0;
  private countries: NutsDTOBase[] = [];
  private country: NutsDTOBase = null;
  private finalBeneficiaries = [];
  private beneficiaryRequest: Subscription = new Subscription();
  private cancelBeneficiaryId: number = 0;
  private cancelReason: string = '';
  private currentPage: number = 0;
  private sizePage: number = 5;
  private sizePageOptions: number[] = [5,20,50];
  private sortField: string = '';
  private sortDirection: string = 'ASC';
  private totalItems:number = 0;

  private firstDataDownload: boolean = true;

  private inputSearch: string = '';
  private loading = false;
  private nameSearched = '';

  constructor(private router: Router, private sharedService: SharedService, private callApi: CallApi, private nutsApi: NutsApi, private beneficiaryApi: BeneficiaryApi) { }

  ngOnInit() {
    this.nutsApi.getNutsByLevel(0).subscribe(
      (nuts: NutsDTOBase[]) => {
        this.countries = nuts;
      }
    );
    this.callApi.allCalls().subscribe((calls: CallDTOBase[]) => {
      if (calls.length > 0) {
        this.currentCall = calls[0];
        this.calls = calls;
        this.searchBeneficiaries(); 
      }
    });
  }

  private searchBeneficiaries(){
    this.finalBeneficiaries = [];
    if(typeof this.beneficiaryRequest !== "undefined"){
      this.beneficiaryRequest.unsubscribe();
    }
    this.firstDataDownload = false;
    this.loading = true;
    this.beneficiaryRequest = this.beneficiaryApi.getBeneficiariesFromFinalList(this.currentCall.id, 
                                                                                this.country != null ? this.country.countryCode : '%', 
                                                                                this.nameSearched == '' ? '%' : this.nameSearched, 
                                                                                this.currentPage, this.sizePage, 
                                                                                this.sortField == '' ? 'name' : this.sortField, 
                                                                                this.sortDirection).subscribe(
      (response: ResponseDTO) => {
        this.finalBeneficiaries = response.data;
        this.totalItems = response.xtotalCount == null ? 0 : response.xtotalCount;
        this.loading = false;
        for(let i = 0; this.finalBeneficiaries.length > i ; i++){
          if(this.finalBeneficiaries[i].dateSignature != null){
            let dateFront;
            let date = new Date(this.finalBeneficiaries[i].dateSignature);
            dateFront = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
            this.finalBeneficiaries[i].dateSignature = dateFront;
          }
        }
      }
    )
  }

  private cancelBeneficiary(){
    if (this.cancelBeneficiaryId != 0 && this.cancelReason.trim().length > 0){
      this.beneficiaryApi.cancelBeneficiaryFromRegistrationId(this.cancelBeneficiaryId, this.cancelReason, this.currentCall.id).subscribe(
        (response: ResponseDTO) => {
          if (response.success){
            this.sharedService.growlTranslation("Beneficiary cancelled correctly", "dgConn.beneficiariesList.cancel.confirm", "success");
            this.searchBeneficiaries();    
          } else {
            this.sharedService.growlTranslation("An error has ocurred during canceling the beneficiary. Please, try again later", "dgConn.beneficiariesList.cancel.failure", "error");
          }
          this.cancelReason = '';
          this.cancelBeneficiaryId = 0;
        }, 
        error => {
          this.sharedService.growlTranslation("An error has ocurred during canceling the beneficiary. Please, try again later", "dgConn.beneficiariesList.cancel.failure", "error");
          this.cancelBeneficiaryId = 0;
          this.cancelReason = '';
        }
      )
    } else {
      this.sharedService.growlTranslation("Please, complete the reason field to cancel the beneficiary", "dgConn.beneficiariesList.cancel.empty", "error");
    }
  }

  private downloadPdfGrantAgreement(registrationId: number){
    this.beneficiaryApi.exportBeneficiaryPdfGrantAgreement(registrationId).subscribe(          
      (response) => {
          let blob = new Blob([response], {type: 'application/pdf'});
          FileSaver.saveAs(blob, 'grantAgreementPdf.pdf');
          this.sharedService.growlTranslation("Your file have been exported correctly!", "dgconn.dashboard.card.messageExport", "success");              
      }, error => {
          this.sharedService.growlTranslation("An error occurred while trying to retrieve the data from the server. Please, try again later.", "shared.error.api.generic", "error");
      }
  );
  }



  private searchByName() {
    if (this.inputSearch.trim().length > 0) {
        this.nameSearched = this.inputSearch.trim();
    } else {
        this.nameSearched = '';
    }
    this.searchBeneficiaries();
}

private changeCall(event){
  if (event['index']!= null){
    this.currentCall = this.calls[event['index']];
    this.searchBeneficiaries();
  }
}

  private paginateData(event) {
    if (event['rows'] != null) {
        if (this.sizePage != event['rows']) {
            this.sizePage = event['rows'];
        }
    }
    if (event['first'] != null) {
        if (this.currentPage != event['first'] / this.sizePage) {
            this.currentPage = event['first'] / this.sizePage;
        }
    }

    this.searchBeneficiaries();
}

  private sortData(event) {
      if (event['field'] != null) {
          this.sortField = event['field'];
      }
      if (event['order'] != null) {
          this.sortDirection = event['order'] === -1 ? 'DESC' : 'ASC';
      }
      this.searchBeneficiaries(); 
  }

  private goToMunicipalityDetails(lauId: number) {
    this.router.navigate(['../applicant-registrations', lauId, 'call' ,this.currentCall.id]);
  }

}

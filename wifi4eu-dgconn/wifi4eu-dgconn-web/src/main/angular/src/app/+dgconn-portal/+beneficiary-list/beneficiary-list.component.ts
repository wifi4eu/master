import { Component, OnInit } from '@angular/core';
import { CallDTOBase, CallApi, NutsApi, NutsDTOBase, BeneficiaryApi, ResponseDTO } from '../../shared/swagger';

@Component({
  selector: 'app-beneficiary-list',
  templateUrl: './beneficiary-list.component.html',
  styleUrls: ['./beneficiary-list.component.scss'],
  providers: [CallApi, NutsApi, BeneficiaryApi]
})
export class BeneficiaryListComponent implements OnInit {

  private calls: CallDTOBase[] = [];
  private currentCall : CallDTOBase = null;
  private currentIndex : number = 0;
  private countries: NutsDTOBase[] = [];
  private country: NutsDTOBase = null;
  private finalBeneficiaries = [];
  private beneficiaryRequest;

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

  constructor(private callApi: CallApi, private nutsApi: NutsApi, private beneficiaryApi: BeneficiaryApi) { }

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
    if(typeof this.beneficiaryRequest !== "undefined"){
      this.beneficiaryRequest.unsubscribe();
    }
    this.beneficiaryRequest = this.beneficiaryApi.getBeneficiariesFromFinalList(this.currentCall.id, 
                                                                                this.country != null ? this.country.countryCode : '%', 
                                                                                this.nameSearched == '' ? '%' : this.nameSearched, 
                                                                                this.currentPage, this.sizePage, 
                                                                                this.sortField == '' ? 'name' : this.sortField, 
                                                                                this.sortDirection);
    this.firstDataDownload = false;
    this.loading = true;
    this.beneficiaryRequest.subscribe(
      (response: ResponseDTO) => {
        this.finalBeneficiaries = response.data;
        this.totalItems = response.xtotalCount == null ? 0 : response.xtotalCount;
        this.loading = false;
      }
    )
  }

  private searchByName() {
    if (this.inputSearch.trim().length > 0) {
        this.nameSearched = this.inputSearch.trim();
    } else {
        this.nameSearched = '';
    }
    this.searchBeneficiaries();
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

}

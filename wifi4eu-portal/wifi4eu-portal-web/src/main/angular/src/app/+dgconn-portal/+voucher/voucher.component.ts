import { Component, ViewEncapsulation, ViewChild } from "@angular/core";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { VoucherApi } from "../../shared/swagger/api/VoucherApi";
import { ApplicationVoucherInfoDTOBase } from "../../shared/swagger/model/ApplicationVoucherInfoDTO";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { Observable } from 'rxJs/Observable';
import { SharedService } from "../../shared/shared.service";
import { VoucherAssignmentDTO, VoucherSimulationDTO, ResponseDTO, VoucherAssignmentAuxiliarDTO } from "../../shared/swagger";
import { trigger, transition, style, animate, query, stagger, group, state } from '@angular/animations';
import { count } from "rxjs/operator/count";
import { Paginator, MenuItem } from "primeng/primeng";
import {ActivatedRoute, Router} from "@angular/router";
import * as FileSaver from "file-saver";

@Component({
  templateUrl: 'voucher.component.html', providers: [CallApi, ApplicationApi, NutsApi, VoucherApi],
  styleUrls: ['./voucher.component.scss'],
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

export class DgConnVoucherComponent {
  private calls: CallDTOBase[] = [];
  private applicationsInfo: ApplicationVoucherInfoDTOBase[][] = [];
  private shownApplicationsInfo: ApplicationVoucherInfoDTOBase[] = [];
  private countries: NutsDTOBase[] = [];
  private chosenCountry: string = null;
  private totalRequests: number = 0;
  private displayMessage: boolean = false;
  displayConfirmingData: boolean = false;

  private countrySelected: NutsDTOBase = {id: 0, code: '0', label: 'All', level: 0, countryCode: "ALL", order: 1, sorting: 1};
  private simulationAssignment = null;

  private validApplications: number = 0;
  private getApplicationsCall = null;
  private numVoucher = [];
  private percentageBudgetCall = [];
  private callVoucherAssignment: VoucherAssignmentDTO = null;
  private callsLoaded = false;
  private callSelected: CallDTOBase = null;
  private listAssignment: VoucherSimulationDTO[] = [];
  private municipalityMunicipality = null;
  private simulationRequest = null;
  
  private totalRecords: number = null;
  private page = 0;
  private sizePage = 20;
  private sortDirection = 'ASC';
  private sortField = 'euRank';
  private pageLinks: number = null;
  private loadingSimulation = false;

  private searchedMunicipality = null;

  private rowDisplayOptions = [20, 50, 100]

  private selectedCountry = 'All';

  private msgs = [];

  private items: MenuItem[] = [
    {
        label: 'Next',
        icon: 'fa-chevron-right'
    },
    {
        label: 'Prev',
        icon: 'fa-chevron-left'
    }
  ];

  @ViewChild("paginator") paginator: Paginator;
  private downloadingExcel: boolean = false;

  constructor(private sharedService: SharedService, private callApi: CallApi, private applicationApi: ApplicationApi, private nutsApi: NutsApi,
    private voucherApi: VoucherApi, private router: Router, private route: ActivatedRoute, ) {
    this.callApi.allCalls().subscribe(
      (calls: CallDTOBase[]) => {
        this.callsLoaded = true;
        this.calls = calls;
        if (this.calls.length > 0) {
          this.callSelected = this.calls[0];
          this.loadingSimulation = true;

          this.voucherApi.getVoucherAssignmentAuxiliarByCall(this.calls[0].id).subscribe((data: VoucherAssignmentAuxiliarDTO) => {
            this.callVoucherAssignment = data;
            this.loadPage();
          })

          this.applicationApi.getApplicationsNotInvalidated(this.calls[0].id).subscribe((data) => {
            this.validApplications = data;
          })
         
        }
        let i = 0;
        for (let call of this.calls) {
          this.applicationsInfo[call.id] = [];
          //this.numVoucher[i] = call.budget / call.budgetVoucher;
          this.percentageBudgetCall[i] = 0;
          /* this.applicationApi.getApplicationsVoucherInfoByCall(call.id).subscribe(
            (info: ApplicationVoucherInfoDTOBase[]) => {
              if (info != null) {
                this.applicationsInfo[call.id] = info;
                this.totalRequests += info.length;
                for (let item of info) {
                  this.shownApplicationsInfo.push(item);
                }
              }
            }
          ); */
          i++;
        }
      }
    );
    this.nutsApi.getNutsByLevel(0).subscribe((countries) => {
      this.countries = <NutsDTOBase[]>countries;
      this.countries.splice(0, 0, {id: 0, code: '0', label: 'All', level: 0, countryCode: "ALL", order: 1, sorting: 1});
    });
  }

  selectCountry(country: NutsDTOBase) {
    this.selectedCountry = country.label;
    this.loadPage();
  }

  fillPaginator(response) {
    this.totalRecords = response.xtotalCount;
    this.pageLinks = Math.ceil(this.totalRecords / this.sizePage);
  }

  searchByMunicipality(event) {
    if(event.keyCode == 13) {
      this.loadPage();
    }
  }

  exportListExcel(){
    this.loadingSimulation = true;
    this.downloadingExcel = false;
    this.voucherApi.exportExcelVoucherSimulation(this.callVoucherAssignment.id, this.selectedCountry, this.searchedMunicipality === null || this.searchedMunicipality === "" ? 'All' : this.searchedMunicipality, this.page, this.sizePage, this.sortField, this.sortDirection).subscribe((response) => {
      let blob = new Blob([response], {type: "application/vnd.ms-excel"});
      FileSaver.saveAs(blob, `voucher-simulation-${this.callSelected.event}`);
      this.loadingSimulation = false;
      this.downloadingExcel = false;
    }, (error) => {
      this.downloadingExcel = false;
    });
  }

  compareFn(n1: NutsDTOBase, n2: NutsDTOBase): boolean {
    return n1 && n2 ? n1.id === n2.id : n1 === n2;
  }

  paginate(event){
    this.simulationAssignment.unsubscribe();
    this.page = event.page;
    this.loadPage();
  }

  changeRowSelection(pageSize: number){
    this.sizePage = pageSize;
    this.loadPage();
  }

  loadPage(){
    this.loadingSimulation = true;
    if (this.getApplicationsCall != null) {
      this.getApplicationsCall.unsubscribe();
    }
    if(this.simulationAssignment != null)  {
      this.simulationAssignment.unsubscribe();
    }
    this.simulationAssignment = this.voucherApi.getVoucherSimulationByVoucherAssignment(this.callVoucherAssignment.id, this.selectedCountry, this.searchedMunicipality === null || this.searchedMunicipality === "" ? 'All' : this.searchedMunicipality, this.page, this.sizePage, this.sortField, this.sortDirection).subscribe((response: ResponseDTO) => {
      this.listAssignment = response.data;
      this.loadingSimulation = false;
      this.fillPaginator(response);
    })
  }

  sortTable(event){
    this.sortField = event.field;
    this.sortDirection = event.order === 1 ? 'ASC' : 'DESC';
    this.loadPage();
  }

  handleChange(event) {
    this.loadingSimulation = true;
    this.sortField = 'euRank';
    this.sortDirection = 'ASC';
    this.listAssignment = [];
    if (this.getApplicationsCall != null) {
      this.getApplicationsCall.unsubscribe();
    }
    if(this.simulationAssignment != null)  {
      this.simulationAssignment.unsubscribe();
    }
    this.callSelected = this.calls[event.index];
    this.getApplicationsCall = this.applicationApi.getApplicationsNotInvalidated(this.calls[event.index].id).subscribe((data) => {
      this.validApplications = data;
    });

    this.voucherApi.getVoucherAssignmentByCall(this.callSelected.id).subscribe((data: VoucherAssignmentDTO) => {  
      this.callVoucherAssignment = data;
      if(data == null){
        this.simulateVoucherAssignment();
      }
      else{
        this.loadPage();
      }
    })

    
  }

  show() {
    if(this.msgs.length > 0){
      this.msgs = [];
    }
    this.msgs.push({severity:'info', detail:'Simulation complete'});
    setTimeout(() => this.msgs = [], 6000);
  }

  private displayInfo() {
    this.displayMessage = true;
  }

  private simulateVoucherAssignment(){
    this.displayConfirmingData = true;
    this.loadingSimulation = true;
    if(this.callVoucherAssignment == null || this.callVoucherAssignment.status == 1){
      this.simulationRequest = this.voucherApi.simulateVoucherAssignment(this.callSelected.id).subscribe((data: VoucherAssignmentDTO) => {
        this.displayConfirmingData = false;
        this.callVoucherAssignment = data;
        //this.show();
        this.loadPage();
        this.loadingSimulation = false;
      }, (error) => {
        this.loadingSimulation = false;
      })
    }
  }

  private chooseCountryApplicationsInfo() {
    this.shownApplicationsInfo = [];
    for (let call of this.applicationsInfo) {
      if (call != null) {
        for (let application of call) {
          if (this.chosenCountry != null && this.chosenCountry != "-") {
            if (application.countryName.toLowerCase() == this.chosenCountry.toLowerCase()) {
              this.shownApplicationsInfo.push(application);
            }
          } else {
            this.shownApplicationsInfo.push(application);
          }
        }
      }
    }
  }

  cancelSimulation() {
    this.displayMessage = false;
    this.simulationRequest.unsubscribe();
  }

  private goToMunicipality(lauId: number) {
    this.router.navigate(['../applicant-registrations/', lauId, 'call' ,this.callSelected.id], {relativeTo: this.route});
  }

}

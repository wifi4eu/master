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
import { VoucherAssignmentDTO, VoucherSimulationDTO, ResponseDTO, VoucherAssignmentAuxiliarDTO, ResponseDTOBase, ApplicationDTO, VoucherAssignmentAuxiliarDTOBase } from "../../shared/swagger";
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
  private callVoucherAssignment: VoucherAssignmentAuxiliarDTO = null;
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
  private preSelectedEnabled = null;
  private confirmationModal = false;
  private displayFreezeConfirmation = false;

  private dateNumberPreList: string;
  private hourNumberPreList: string; 

  private dateNumberFreeze: string;
  private hourNumberFreeze: string; 

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
            if(data != null){
              this.callVoucherAssignment = data;
              let date = new Date(this.callVoucherAssignment.preListExecutionDate);
              this.dateNumberPreList = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
              this.hourNumberPreList = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2); 
              if(data.hasFreezeListSaved){
                this.voucherApi.getVoucherAssignmentByCallAndStatus(this.calls[0].id, 3).subscribe(
                 (response: VoucherAssignmentAuxiliarDTO) => {
                    if(response != null){
                      this.callVoucherAssignment.id = response.id;
                      let date = new Date(this.callVoucherAssignment.freezeLisExecutionDate);
                      this.dateNumberFreeze = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
                      this.hourNumberFreeze = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2); 
                      this.loadPage();
                    }                    
                }, error => {
                  console.log(error);
                });
              }
              else{
                this.loadPage();
              }
            }       
            else{
              this.loadingSimulation = false;
            }     
          })

          this.applicationApi.getApplicationsNotInvalidated(this.calls[0].id).subscribe((data) => {
            this.validApplications = data;
          })
         
        }
        let i = 0;
        for (let call of this.calls) {
          this.applicationsInfo[call.id] = [];
          this.percentageBudgetCall[i] = 0;
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
    this.downloadingExcel = true;
    this.voucherApi.exportExcelVoucherSimulation(this.callVoucherAssignment.id, this.selectedCountry, this.searchedMunicipality === null || this.searchedMunicipality === "" ? 'All' : this.searchedMunicipality, this.sortField, this.sortDirection).subscribe((response) => {
      let blob = new Blob([response], {type: "application/vnd.ms-excel"});
      FileSaver.saveAs(blob, `voucher-simulation-${this.callSelected.event}.xls`);
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
    if (this.getApplicationsCall != null && !this.getApplicationsCall['closed']) {
      this.getApplicationsCall.unsubscribe();
    }
    if(this.simulationAssignment != null && !this.simulationAssignment['closed'])  {
      this.simulationAssignment.unsubscribe();
    }
    this.simulationAssignment = this.voucherApi.getVoucherSimulationByVoucherAssignment(this.callVoucherAssignment.id, this.selectedCountry, this.searchedMunicipality === null || this.searchedMunicipality === "" ? 'All' : this.searchedMunicipality, this.page, this.sizePage, this.sortField, this.sortDirection).subscribe((response: ResponseDTO) => {
      this.listAssignment = response.data;
      this.loadingSimulation = false;
      this.fillPaginator(response);
    })
  }

  checkPreListEnabled(){
    if(this.callVoucherAssignment.hasPreListSaved){
      return;
    }
    this.voucherApi.checkSavePreSelectionEnabled(this.callVoucherAssignment.id).subscribe((response: boolean) => {
      this.preSelectedEnabled = response;
    },(error) => {
      console.log(error);      
    })
  }

  savePreList(savePreListBtn){
    savePreListBtn.disabled = true;
    if(this.callVoucherAssignment.hasPreListSaved){
      return;
    }
    this.voucherApi.savePreListSimulation(this.callVoucherAssignment.id, this.callSelected.id).subscribe((response: ResponseDTO) => {
      this.preSelectedEnabled = null;
      this.callVoucherAssignment.hasPreListSaved = true;
      this.callVoucherAssignment.preListExecutionDate = response.data.executionDate;
      let date = new Date(this.callVoucherAssignment.preListExecutionDate);
      this.dateNumberPreList = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
      this.hourNumberPreList = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2); 
      savePreListBtn.disabled = false;
    }, error => {
      console.log("error => ", error);
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

    this.voucherApi.getVoucherAssignmentAuxiliarByCall(this.callSelected.id).subscribe((data: VoucherAssignmentDTO) => {  
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
    if(this.callVoucherAssignment.hasFreezeListSaved){
      return;
    }
    this.displayConfirmingData = true;
    this.loadingSimulation = true;
    if(this.callVoucherAssignment == null || this.callVoucherAssignment.status == 1){
      this.simulationRequest = this.voucherApi.simulateVoucherAssignment(this.callSelected.id).subscribe((resp: ResponseDTO) => {
        this.displayConfirmingData = false;
        this.callVoucherAssignment = resp.data;
        //this.show();
        this.loadPage();
        this.loadingSimulation = false;
      }, (error) => {
        this.loadingSimulation = false;
        this.displayConfirmingData = false;
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

  lookupRowStyleClass(rowData: VoucherSimulationDTO) {
    return rowData.selectionStatus === 2 ? 'rejected-row' : '';
}

  cancelSimulation() {
    this.displayMessage = false;
    this.simulationRequest.unsubscribe();
  }

  private goToMunicipality(lauId: number) {
    this.router.navigate(['../applicant-registrations/', lauId, 'call' ,this.callSelected.id], {relativeTo: this.route});
  }

  rejectApplication(applicationId: number){
    if((!this.callVoucherAssignment.hasPreListSaved && this.callVoucherAssignment == null) || (this.callVoucherAssignment.hasFreezeListSaved && this.callVoucherAssignment != null)){
      return;
    }
    this.applicationApi.rejectApplicationVoucherAssigment(applicationId).subscribe((response: ResponseDTO) => {
      var index = this.listAssignment.findIndex((x) => x.application.id == response.data.id)
      this.listAssignment[index].application = <ApplicationDTO>response.data;
    }, error => {
      console.log("error => ", error);
    })
  }

  selectApplication(applicationId: number){
    if((!this.callVoucherAssignment.hasPreListSaved && this.callVoucherAssignment == null) || (this.callVoucherAssignment.hasFreezeListSaved && this.callVoucherAssignment != null)){
      return;
    }
    this.applicationApi.selectApplicationVoucherAssigment(applicationId).subscribe((response: ResponseDTO) => {
      var index = this.listAssignment.findIndex((x) => x.application.id == response.data.id)
      this.listAssignment[index].application = <ApplicationDTO>response.data;
    }, error => {
      console.log("error => ", error);
    }) 
  }

  private freezeList(){
    if((!this.callVoucherAssignment.hasPreListSaved && this.callVoucherAssignment != null) || (this.callVoucherAssignment.hasFreezeListSaved && this.callVoucherAssignment != null)){
      return;
    }
    this.displayFreezeConfirmation = true;
  }

  private saveFreezeList(saveFreezeBtn){
    saveFreezeBtn.disabled = true;
    this.voucherApi.saveFreezeListSimulation(this.callVoucherAssignment.id, this.callSelected.id).subscribe((response: ResponseDTO) => {
      this.displayFreezeConfirmation = false;
      this.callVoucherAssignment.id = response.data.id;
      this.callVoucherAssignment.hasFreezeListSaved = true;
      this.callVoucherAssignment.executionDate = response.data.executionDate;  
      this.callVoucherAssignment.freezeLisExecutionDate = response.data.executionDate;      
      let date = new Date(this.callVoucherAssignment.freezeLisExecutionDate);
      this.dateNumberFreeze = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
      this.hourNumberFreeze = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2); 
      this.loadPage();
      saveFreezeBtn.disabled = false;
    }, error => {
      console.log(error);
    });    
  }

  sendNotificationToApplicants(){
    if(!this.callVoucherAssignment.hasFreezeListSaved){
      return;
    }
    this.voucherApi.sendNotificationForApplicants(this.callSelected.id).subscribe((response: ResponseDTO) => {
      console.log(response);
    })
  }

}

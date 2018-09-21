import { Component, ViewEncapsulation, ViewChild, ElementRef } from "@angular/core";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { VoucherApi } from "../../shared/swagger/api/VoucherApi";
import { ApplicationVoucherInfoDTOBase } from "../../shared/swagger/model/ApplicationVoucherInfoDTO";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { Observable } from 'rxjs/Observable';
import { SharedService } from "../../shared/shared.service";
import { VoucherAssignmentDTO, VoucherSimulationDTO, ResponseDTO, VoucherAssignmentAuxiliarDTO, ResponseDTOBase, ApplicationDTO, VoucherAssignmentAuxiliarDTOBase, RegistrationWarningApi, VoucherAssignmentDTOBase, AdminactionsApi } from "../../shared/swagger";
import { trigger, transition, style, animate, query, stagger, group, state } from '@angular/animations';
import { count } from "rxjs/operator/count";
import { Paginator, MenuItem, DataTable, TabView } from "primeng/primeng";
import { ActivatedRoute, Router } from "@angular/router";
import * as FileSaver from "file-saver";
import { Subscription } from "rxjs";
import { AdminActionsDTO, AdminActionsDTOBase } from "../../shared/swagger/model/AdminActionsDTO";

@Component({
  templateUrl: 'voucher.component.html',
  providers: [ApplicationApi, NutsApi, VoucherApi, RegistrationWarningApi, CallApi, AdminactionsApi],
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
  private preSelectedEnabledButton: Boolean = false;
  private freezeButtonEnabled: Boolean = false;

  private countrySelected: NutsDTOBase = { id: 0, code: '0', label: 'All', level: 0, countryCode: "ALL", order: 1, sorting: 1 };
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
  private preListLoaded = false;

  private indexTab = 0;
  private totalRecords: number = null;
  private page = 0;
  private sizePage = 100;
  private sortDirection = 'ASC';
  private sortField = 'euRank';
  private pageLinks: number = null;
  private rowDisplayOptions = [20, 50, 100]
  private columns = ['euRank', 'countryRank', 'selectionStatus', 'application.preSelectedFlag', 'country', 'municipalityName', 'issues', 'numApplications', 'application.status'];

  private loadingSimulation = false;
  private preSelectedEnabled = null;
  private confirmationModal = false;
  private displayFreezeConfirmation = false;
  private pressedNotificationButton = false;

  private dateNumberPreList: string;
  private hourNumberPreList: string;
  private dateNumberFreeze: string;
  private hourNumberFreeze: string;
  private dateNumberNotified: string;
  private hourNumberNotified: string;
  private startSendingNotifications = {};

  private loadingFreezeList = false;
  private loadingPreList = false;

  private hasCallEnded: boolean = false;

  private searchedMunicipality = null;
  private selectedCountry = 'All';

  private showFreezeModal:boolean = false;
  private psswdFreeze: string = '';
  private psswdNotification: string ='';
  private confirmFreezeBtn : boolean = true;
  private confirmNotificationsBtn: boolean = true;
  private showNotificationModal : boolean = false;

  @ViewChild("paginator") paginator: Paginator;
  @ViewChild("tableVoucher") tableVoucher: DataTable;
  @ViewChild("tabCalls") tabCalls: TabView;
  private downloadingExcel: boolean = false;
  @ViewChild("municipalitySearch") municipalitySearch: ElementRef;

  private displayAlreadyLaunched: boolean = false;

  constructor(private adminActionsApi: AdminactionsApi, private sharedService: SharedService, private callApi: CallApi, private applicationApi: ApplicationApi, private nutsApi: NutsApi,
    private voucherApi: VoucherApi, private router: Router, private route: ActivatedRoute, private registrationWarningApi: RegistrationWarningApi) {
    this.callApi.allCalls().subscribe(
      (calls: CallDTOBase[]) => {
        this.callsLoaded = true;
        this.calls = calls;
        if (calls.length > 0) {
          this.route.queryParams.subscribe((queryParams) => {
            var callId = typeof queryParams['call'] === 'undefined' ? this.calls[0].id : parseInt(queryParams['call']);
            var country = typeof queryParams['country'] === 'undefined' ? 'All' : queryParams['country'];
            var page = typeof queryParams['page'] === 'undefined' ? this.page : parseInt(queryParams['page']);

            var size = typeof queryParams['size'] === 'undefined' ? this.sizePage : parseInt(queryParams['size']);
            var sortField = typeof queryParams['sortField'] === 'undefined' ? 'euRank' : queryParams['sortField'];
            var sortDirection = typeof queryParams['sortDirection'] === 'undefined' ? this.sortDirection : queryParams['sortDirection'];
            var municipality = typeof queryParams['municipality'] === 'undefined' ? 'All' : queryParams['municipality'];
            if (municipality === "") {
              municipality == 'All';
            }

            if (page < 0) {
              this.page = 0;
            }

            if (size > 100) {
              this.sizePage = 100;
            }
            else if (size < 20) {
              this.sizePage = 20;
            }

            if (!this.columns.some(x => x === sortField)) {
              sortField = this.columns[0];
            }

            if (!this.calls.some(call => call.id === callId)) {
              this.callSelected = calls[0];
            } else {
              var index = this.calls.findIndex(call => call.id === callId);
              this.callSelected = calls[index];
            }
            callApi.isCallClosed(this.callSelected.id).subscribe((enabled: boolean) => {
              this.hasCallEnded = enabled;
            });
            this.page = page;
            this.sizePage = size;
            this.selectedCountry = country;
            this.searchedMunicipality = municipality;
            this.sortField = sortField;
            this.sortDirection = sortDirection.toUpperCase();


            setTimeout(() => {
              if (this.searchedMunicipality.toUpperCase() !== 'ALL') {
                this.municipalitySearch.nativeElement.value = this.searchedMunicipality;
              }
              this.tableVoucher.sortColumn = this.tableVoucher.columns.find(col => col.field === this.sortField);
              this.tableVoucher.sortField = this.sortField;
              this.tableVoucher.sortOrder = this.sortDirection === 'ASC' ? 1 : -1;
              calls.forEach((element, _index) => {
                if (element.id === this.callSelected.id) {
                  var selectedTab = this.tabCalls.findSelectedTab();
                  selectedTab.selected = false;
                  this.tabCalls.tabs[_index].selected = true;
                  return;
                }
              });
              this.tableVoucher.sortSingle();
            }, 200);

            this.nutsApi.getNutsByLevel(0).subscribe((countries) => {
              this.countries = <NutsDTOBase[]>countries;
              this.countries.splice(0, 0, { id: 0, code: '0', label: 'All', level: 0, countryCode: "ALL", order: 1, sorting: 1 });
              countries.forEach((_country: NutsDTOBase, _index) => {
                if (_country.label == country) {
                  this.countrySelected = this.countries[_index];
                  return;
                }
              });
            });
            this.pressedNotificationButton = true;
            this.voucherApi.getVoucherAssignmentAuxiliarByCall(this.callSelected.id).subscribe((data: VoucherAssignmentAuxiliarDTO) => {
              if (data != null) {
                this.loadingPreList = true;
                this.loadingFreezeList = true;
                this.callVoucherAssignment = data;
                this.preListLoaded = data.hasPreListSaved;
                let date = new Date(this.callVoucherAssignment.preListExecutionDate);
                this.dateNumberPreList = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
                this.hourNumberPreList = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2);
                this.voucherApi.checkSavePreSelectionEnabled(this.callVoucherAssignment.id)
                  .finally(() => {
                    this.loadingPreList = false;
                  })
                  .subscribe((response: boolean) => {
                    this.preSelectedEnabledButton = response;
                  }, (error) => {
                    this.sharedService.growlTranslation('An error occured while checking if pre-list is enabled', 'dgConn.voucherAssignment.error.checkPreList', 'error');
                  })
                this.voucherApi.checkApplicationAreValidForFreezeList(this.callSelected.id, new Date().getTime())
                  .finally(() => {
                    this.loadingFreezeList = false;
                  })
                  .subscribe((enabled) => {
                    this.freezeButtonEnabled = enabled;
                  }, (error) => {
                    this.sharedService.growlTranslation('An error occured while checking if freeze list is enabled', 'dgConn.voucherAssignment.error.checkFreezeList', 'error');
                  });
                if (data.hasFreezeListSaved) {
                  this.voucherApi.getVoucherAssignmentByCallAndStatus(this.callSelected.id, 3).subscribe(
                    (response: VoucherAssignmentAuxiliarDTO) => {
                      if (response != null) {
                        this.callVoucherAssignment.id = response.id;
                        let date = new Date(this.callVoucherAssignment.freezeLisExecutionDate);
                        this.dateNumberFreeze = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
                        this.hourNumberFreeze = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2);

                        if (response.notifiedDate != null) {
                          let dateNotified = new Date(response.notifiedDate);
                          this.dateNumberNotified = ('0' + dateNotified.getUTCDate()).slice(-2) + "/" + ('0' + (dateNotified.getUTCMonth() + 1)).slice(-2) + "/" + dateNotified.getUTCFullYear();
                          this.hourNumberNotified = ('0' + (dateNotified.getUTCHours() + 2)).slice(-2) + ":" + ('0' + dateNotified.getUTCMinutes()).slice(-2);
                        }
                        this.adminActionsApi.getByActionName("voucher_send_notifications").subscribe((response: ResponseDTO) => {
                          if (response.success) {
                            let adminAction = <AdminActionsDTO>response.data;
                            if (adminAction != null) {
                              if (adminAction.running) {
                                let dateStartSending = new Date(adminAction['startDate']);
                                this.startSendingNotifications['startSendingDate'] = ('0' + dateStartSending.getUTCDate()).slice(-2) + "/" + ('0' + (dateStartSending.getUTCMonth() + 1)).slice(-2) + "/" + dateStartSending.getUTCFullYear();
                                this.startSendingNotifications['startSendingHour'] = ('0' + (dateStartSending.getUTCHours() + 2)).slice(-2) + ":" + ('0' + dateStartSending.getUTCMinutes()).slice(-2);
                              }
                              this.pressedNotificationButton = adminAction.running;
                            } else {
                              this.pressedNotificationButton = false;
                            }
                          }
                        })
                        this.loadPage();
                      }
                    }, error => {
                      this.sharedService.growlTranslation('Error retrieving list.', 'dgConn.voucherAssignment.error.retrievingList', 'error');
                    });
                }
                else {
                  this.loadPage();
                }
              }
              else {
                this.loadingSimulation = false;
                this.listAssignment = [];
                this.sharedService.growlTranslation('Voucher assignment list not found for this call', 'dgConn.voucherAssignment.warning.noVoucherForCall', 'warn');
              }
            })
            this.applicationApi.countValidatedApplications(this.callSelected.id).subscribe((ResponseDTO: ResponseDTOBase) => {
              this.validApplications = ResponseDTO.data;
            })
          })
        }
        let i = 0;
        for (let call of this.calls) {
          this.applicationsInfo[call.id] = [];
          this.percentageBudgetCall[i] = 0;
          i++;
        }
      }
    )
  }

  filterTable() {
    this.router.navigate(['./dgconn-portal/voucher'], { queryParams: { call: this.callSelected.id, page: this.page, size: this.sizePage, municipality: this.searchedMunicipality, country: this.selectedCountry, sortField: this.sortField, sortDirection: this.sortDirection } });
  }

  selectCountry(country: NutsDTOBase) {
    this.selectedCountry = country.label;
    this.page = 0;
    this.searchedMunicipality = 'All';
    this.municipalitySearch.nativeElement.value = '';
    this.filterTable();
  }

  fillPaginator(response) {
    this.totalRecords = response.xtotalCount;
    this.pageLinks = Math.ceil(this.totalRecords / this.sizePage);
  }

  searchByMunicipality(event) {
    if (event.keyCode == 13) {
      this.page = 0;
      this.searchedMunicipality = this.municipalitySearch.nativeElement.value;
      this.filterTable();
    }
  }

  exportListExcel() {
    this.loadingSimulation = true;
    this.downloadingExcel = true;
    this.voucherApi.exportExcelVoucherSimulation(this.callVoucherAssignment.id, this.selectedCountry, this.searchedMunicipality === null || this.searchedMunicipality === "" ? 'All' : this.searchedMunicipality, this.sortField, this.sortDirection).subscribe((response) => {
      let blob = new Blob([response], { type: "application/vnd.ms-excel" });
      FileSaver.saveAs(blob, `voucher-simulation-${this.callSelected.event}.xls`);
      this.loadingSimulation = false;
      this.downloadingExcel = false;
    }, (error) => {
      this.sharedService.growlTranslation('An error ocurred while downloading the list', 'dgConn.voucherAssignment.error.exportExcel', 'error');
      this.downloadingExcel = false;
    });
  }

  compareFn(n1: NutsDTOBase, n2: NutsDTOBase): boolean {
    return n1 && n2 ? n1.id === n2.id : n1 === n2;
  }

  paginate(event) {
    this.simulationAssignment.unsubscribe();
    this.page = event.page;
    this.filterTable();
  }

  changeRowSelection(pageSize: number) {
    this.sizePage = pageSize;
    this.page = 0;
    this.filterTable();
  }

  loadPage() {
    this.loadingSimulation = true;
    if (this.getApplicationsCall != null && !this.getApplicationsCall['closed']) {
      this.getApplicationsCall.unsubscribe();
    }
    if (this.simulationAssignment != null && !this.simulationAssignment['closed']) {
      this.simulationAssignment.unsubscribe();
    }
    this.simulationAssignment = this.voucherApi.getVoucherSimulationByVoucherAssignment(this.callVoucherAssignment.id, this.selectedCountry, this.searchedMunicipality === null || this.searchedMunicipality === "" ? 'All' : this.searchedMunicipality, this.page, this.sizePage, this.sortField, this.sortDirection).subscribe((response: ResponseDTO) => {
      this.listAssignment = response.data;
      this.loadingSimulation = false;
      this.fillPaginator(response);
    })
  }

  checkPreListEnabled() {
    if (this.callVoucherAssignment.hasPreListSaved) {
      return;
    }
    this.voucherApi.checkSavePreSelectionEnabled(this.callVoucherAssignment.id).subscribe((response: boolean) => {
      this.preSelectedEnabled = response;
      if (!response) {
        this.sharedService.growlTranslation('It\'s not possible to pre-save the list with applications left to be validated.', 'dgConn.voucherAssignment.warning.savingPreList', 'warn');
      }
    });
  }

  savePreList(savePreListBtn) {
    savePreListBtn.disabled = true;
    if (this.callVoucherAssignment.hasPreListSaved) {
      return;
    }
    this.voucherApi.savePreListSimulation(this.callVoucherAssignment.id, this.callSelected.id).subscribe((response: ResponseDTO) => {
      this.preSelectedEnabled = null;
      this.callVoucherAssignment.hasPreListSaved = true;
      this.callVoucherAssignment.preListExecutionDate = response.data.executionDate;
      let date = new Date(this.callVoucherAssignment.preListExecutionDate);
      this.freezeButtonEnabled = true;
      this.filterTable();
      this.dateNumberPreList = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
      this.hourNumberPreList = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2);
      savePreListBtn.disabled = false;
    }, error => {
      this.sharedService.growlTranslation('An error ocurred while saving pre-list', 'dgConn.voucherAssignment.error.savingPreList', 'error');
    })
  }

  sortTable(event) {
    this.sortField = event.field;
    this.sortDirection = event.order === 1 ? 'ASC' : 'DESC';
    this.filterTable();
  }

  handleChange(event) {
    this.callSelected = this.calls[event.index];
    this.callApi.isCallClosed(this.callSelected.id).subscribe((enabled: boolean) => {
      this.hasCallEnded = enabled;
    });
    this.sortField = 'euRank';
    this.sortDirection = 'ASC';
    this.filterTable();
  }

  private displayInfo() {
    this.displayMessage = true;
  }

  private simulateVoucherAssignment() {
    if (this.callVoucherAssignment != null && this.callVoucherAssignment.hasFreezeListSaved) {
      return;
    }
    this.displayConfirmingData = true;
    this.loadingSimulation = true;
    this.loadingFreezeList = true;
    this.loadingPreList = true;
    if (this.callVoucherAssignment == null || this.callVoucherAssignment.status == 1) {
      this.simulationRequest = this.voucherApi.simulateVoucherAssignment(this.callSelected.id).subscribe((resp: ResponseDTO) => {
        this.displayConfirmingData = false;
        if (this.callVoucherAssignment == null) {
          this.callVoucherAssignment = resp.data;
        } else {
          this.callVoucherAssignment.id = resp.data.id;
        }
        if (!this.callVoucherAssignment.hasPreListSaved) {
          this.voucherApi.checkSavePreSelectionEnabled(this.callVoucherAssignment.id)
            .finally(() => {
              this.loadingPreList = false;
            })
            .subscribe((response: boolean) => {
              this.preSelectedEnabledButton = response;
            }, (error) => {
              this.sharedService.growlTranslation('An error occured while checking if pre-list is enabled', 'dgConn.voucherAssignment.error.checkPreList', 'error');
            })
        }
        this.loadPage();
        this.voucherApi.checkApplicationAreValidForFreezeList(this.callSelected.id, new Date().getTime())
          .finally(() => {
            this.loadingFreezeList = false;
          })
          .subscribe((enabled) => {
            this.freezeButtonEnabled = enabled;
          }, (error) => {
            this.sharedService.growlTranslation('An error occured while checking if freeze list is enabled', 'dgConn.voucherAssignment.error.checkFreezeList', 'error');
          });
        this.loadingSimulation = false;
      }, (error) => {
        this.sharedService.growlTranslation('An error occurred while simulating.', 'dgConn.voucherAssignment.error.runningSimulation', 'error');
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
    this.router.navigate(['../applicant-registrations/', lauId, 'call', this.callSelected.id], { relativeTo: this.route });
  }

  rejectApplication(applicationId: number) {
    if (this.callVoucherAssignment == null || !this.callVoucherAssignment.hasPreListSaved) {
      return;
    }
    this.applicationApi.rejectApplicationVoucherAssigment(applicationId).subscribe((response: ResponseDTO) => {
      var index = this.listAssignment.findIndex((x) => x.application.id == response.data.id)
      this.listAssignment[index].application = <ApplicationDTO>response.data;
    }, error => {
      this.sharedService.growlTranslation('An error occurred while rejecting an application.', 'dgConn.voucherAssignment.error.rejectingApplication', 'error');
    })
  }

  selectApplication(applicationId: number) {
    if (this.callVoucherAssignment == null || !this.callVoucherAssignment.hasPreListSaved) {
      return;
    }
    this.applicationApi.selectApplicationVoucherAssigment(applicationId).subscribe((response: ResponseDTO) => {
      var index = this.listAssignment.findIndex((x) => x.application.id == response.data.id)
      this.listAssignment[index].application = <ApplicationDTO>response.data;
    }, error => {
      this.sharedService.growlTranslation('An error occurred while selecting an application.', 'dgConn.voucherAssignment.error.selectingApplication', 'error');
    })
  }

  private freezeList() {
    this.voucherApi.checkApplicationAreValidForFreezeList(this.callSelected.id, new Date().getTime()).subscribe((enabled) => {
      this.showFreezeModal = enabled;
      this.pressedNotificationButton = !enabled;
      if (!enabled) {
        this.sharedService.growlTranslation('It\'s not possible to freeze the list with applications left to be validated', 'dgConn.voucherAssignment.warning.savingFreezeList', 'warn');
      }
    }, (error) => {
      this.sharedService.growlTranslation('An error occured while checking if freeze list is enabled', 'dgConn.voucherAssignment.error.checkFreezeList', 'error');
    });
  }

  private saveFreezeList(saveFreezeBtn) {
    this.loadingFreezeList = true;
    this.confirmFreezeBtn = false;
    
    this.voucherApi.saveFreezeListSimulation(this.psswdFreeze, this.callVoucherAssignment.id, this.callSelected.id).finally(() => {
      this.loadingFreezeList = false;
      this.confirmFreezeBtn = true;
      
    }).subscribe((response: ResponseDTO) => {
      this.displayFreezeConfirmation = false;
      this.callVoucherAssignment.id = response.data.id;
      this.callVoucherAssignment.hasFreezeListSaved = true;
      this.callVoucherAssignment.executionDate = response.data.executionDate;
      this.callVoucherAssignment.freezeLisExecutionDate = response.data.executionDate;
      let date = new Date(this.callVoucherAssignment.freezeLisExecutionDate);
      this.dateNumberFreeze = ('0' + date.getUTCDate()).slice(-2) + "/" + ('0' + (date.getUTCMonth() + 1)).slice(-2) + "/" + date.getUTCFullYear();
      this.hourNumberFreeze = ('0' + (date.getUTCHours() + 2)).slice(-2) + ":" + ('0' + date.getUTCMinutes()).slice(-2);
      this.loadPage();
      this.showFreezeModal = false;
      this.displayConfirmingData = false;
    }, error => {
      this.sharedService.growlTranslation('An error occurred while freezing the list.', 'dgConn.voucherAssignment.error.savingFreezeList', 'error');
      this.showFreezeModal = false;
      this.displayConfirmingData = false;
    });
  }

  private sendNotificationToApplicants() {
    this.showNotificationModal = true;
    this.confirmNotificationsBtn = false;
    if (this.callVoucherAssignment.notifiedDate != null) {
      return;
    }
    if (!this.callVoucherAssignment.hasFreezeListSaved || !this.hasCallEnded) {
      return;
    }
    this.pressedNotificationButton = true;
    this.voucherApi.sendNotificationForApplicants(this.psswdNotification, this.callSelected.id).subscribe((response: ResponseDTO) => {
      if (response.success) {
        this.pressedNotificationButton = true;
        this.showNotificationModal = false;
        this.sharedService.growlTranslation('The process of sending notifications has started.', 'dgConn.voucherAssignment.success.sendingNotifications', 'success');
        this.router.navigate(['../voucher'], { relativeTo: this.route });
      } else {
        if (response.data != null && (response.data["running"] || response.data["notifiedDate"])) {
          if (response.data["running"]) {
            let dateStartSending = new Date(response.data["startDate"]);
            this.startSendingNotifications['startSendingDate'] = ('0' + dateStartSending.getUTCDate()).slice(-2) + "/" + ('0' + (dateStartSending.getUTCMonth() + 1)).slice(-2) + "/" + dateStartSending.getUTCFullYear();
            this.startSendingNotifications['startSendingHour'] = ('0' + (dateStartSending.getUTCHours() + 2)).slice(-2) + ":" + ('0' + dateStartSending.getUTCMinutes()).slice(-2);
          } else {
            let dateNotified = new Date(response.data["notifiedDate"]);
            this.callVoucherAssignment.notifiedDate = response.data["notifiedDate"];
            this.dateNumberNotified = ('0' + dateNotified.getUTCDate()).slice(-2) + "/" + ('0' + (dateNotified.getUTCMonth() + 1)).slice(-2) + "/" + dateNotified.getUTCFullYear();
            this.hourNumberNotified = ('0' + (dateNotified.getUTCHours() + 2)).slice(-2) + ":" + ('0' + dateNotified.getUTCMinutes()).slice(-2);
          }
          this.pressedNotificationButton = true;
          this.displayAlreadyLaunched = true;;
        } else {
          this.pressedNotificationButton = false;
        }
      }
      this.showNotificationModal = false;
    }, (error) => {
      this.showNotificationModal = false;
      this.pressedNotificationButton = false;
      this.sharedService.growlTranslation('An error occurred while sending notifications.', 'dgConn.voucherAssignment.error.sendingNotifications', 'error');
    })
   
  }

  private showFreezePopUp(){
    this.psswdFreeze = '';
    this.showFreezeModal = true;
    this.loadingFreezeList = false;
  }

  private showNotificationPopUp(){
    this.psswdNotification = '';
    this.showNotificationModal = true;
    this.loadingFreezeList = false;
  }

}

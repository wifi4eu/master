import { Component, ViewEncapsulation } from "@angular/core";
import { CallApi } from "../../shared/swagger/api/CallApi";
import { CallDTOBase } from "../../shared/swagger/model/CallDTO";
import { ApplicationApi } from "../../shared/swagger/api/ApplicationApi";
import { VoucherApi } from "../../shared/swagger/api/VoucherApi";
import { ApplicationVoucherInfoDTOBase } from "../../shared/swagger/model/ApplicationVoucherInfoDTO";
import { NutsApi } from "../../shared/swagger/api/NutsApi";
import { NutsDTOBase } from "../../shared/swagger/model/NutsDTO";
import { Observable } from 'rxJs/Observable';
import { SharedService } from "../../shared/shared.service";
import { VoucherAssignmentDTO } from "../../shared/swagger";
import { trigger, transition, style, animate, query, stagger, group, state } from '@angular/animations';

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

  private validApplications = [];
  private getApplicationsCall = null;
  private numVoucher = [];
  private percentageBudgetCall = [];
  private callVoucherAssignment: VoucherAssignmentDTO = null;
  private callsLoaded = false;
  private callSelected: CallDTOBase = null;

  constructor(private sharedService: SharedService, private callApi: CallApi, private applicationApi: ApplicationApi, private nutsApi: NutsApi,
    private voucherApi: VoucherApi) {
    this.callApi.allCalls().subscribe(
      (calls: CallDTOBase[]) => {
        this.callsLoaded = true;
        this.calls = calls;
        if (this.calls.length > 0) {
          this.callSelected = this.calls[0];
          this.applicationApi.getApplicationsByRegistrationNotInvalidated(this.calls[0].id).subscribe((data) => {
            this.validApplications = data;
          })
          this.voucherApi.getVoucherAssignmentByCall(this.calls[0].id).subscribe((data: VoucherAssignmentDTO) => {
            console.log(data);
            this.callVoucherAssignment = data;
          })
        }
        let i = 0;
        for (let call of this.calls) {
          this.applicationsInfo[call.id] = [];
          this.numVoucher[i] = call.budget / call.budgetVoucher;
          this.percentageBudgetCall[i] = 0;
          this.applicationApi.getApplicationsVoucherInfoByCall(call.id).subscribe(
            (info: ApplicationVoucherInfoDTOBase[]) => {
              if (info != null) {
                this.applicationsInfo[call.id] = info;
                this.totalRequests += info.length;
                for (let item of info) {
                  this.shownApplicationsInfo.push(item);
                }
              }
            }
          );
          i++;
        }
      }
    );
    this.nutsApi.getNutsByLevel(0).subscribe(
      (countries: NutsDTOBase[]) => {
        this.countries = countries;
      }
    );
  }

  handleChange(event) {
    if (this.getApplicationsCall != null) {
      this.getApplicationsCall.unsubscribe();
    }
    
    this.getApplicationsCall = this.applicationApi.getApplicationsByRegistrationNotInvalidated(this.calls[event.index].id).subscribe((data) => {
      this.validApplications = data;
      this.callSelected = this.calls[event.index];
    })

    this.voucherApi.getVoucherAssignmentByCall(this.calls[event.index].id).subscribe((data: VoucherAssignmentDTO) => {
      console.log(data);
      this.callVoucherAssignment = data;
    })
  }

  private displayInfo() {
    this.displayMessage = true;
  }

  private simulateVoucherAssignment(){
    if(this.callVoucherAssignment == null || this.callVoucherAssignment.status == 1){
      this.voucherApi.simulateVoucherAssignment(this.callSelected).subscribe(() => {
        console.log("SIMULATE");
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
}
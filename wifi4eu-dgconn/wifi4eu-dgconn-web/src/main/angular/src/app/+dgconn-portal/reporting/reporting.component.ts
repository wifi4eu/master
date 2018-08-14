import { Component, OnInit } from '@angular/core';

// import {ReportingApi} from '../../../shared/swagger/api/ReportingApi';
// import { MessageService } from '../../../core/services/message.service';
// import { ErrorHandlingService } from '../../../core/services/error.service';
import { ReportingApi } from "../../shared/swagger/api/ReportingApi";
import { SharedService } from "../../shared/shared.service";

@Component({
  selector: 'app-reporting',
  templateUrl: './reporting.component.html',
  styleUrls: ['./reporting.component.scss'],
  providers: [
    ReportingApi
    // ErrorHandlingService,
    // MessageService
  ]
})
export class ReportingComponent implements OnInit {

  private reports: string[] = ['first', 'second', 'third', 'fourth', 'fifth', 'sixth', 'seventh', 'eight', 'ninth', 'tenth', 'eleventh'];

  constructor(
    private reportingApi: ReportingApi,
    private sharedService: SharedService
    // private errorHandlingService: ErrorHandlingService,
    // private messageService: MessageService
  ) { }

  ngOnInit() {
    window.scrollTo(0,0);
  
  }

  private onReport(report: string) {
    switch (report) {
        case "first":
          this.firstReport();
        break;

        case "eight":
          this.eightReport();
        break; 
    }
  }
  
  private firstReport(){
    this.reportingApi.generateCallOpenReport().subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
      // this.sharedService.growlTranslation('An error ocurred while downloading the list', 'dgConn.voucherAssignment.error.exportExcel', 'error');
    });
  }

  private eightReport(){
    this.reportingApi.generateTypesInstallationReport().subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
      // return this.errorHandlingService.handleError(error);
    });
  }


  private isCallSelector(report: string) {
    let result: boolean;
    switch (report) {
      case "second":
      case "third":
      case "fifth":
      case "seventh":
      case "tenth":
        result = true
        break;
      default:
        result = false;
        break;
    }
    return result;
  }

}

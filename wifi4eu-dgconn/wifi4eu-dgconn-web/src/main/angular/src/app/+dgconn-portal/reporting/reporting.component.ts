import { Component, OnInit } from '@angular/core';
import { ReportingApi } from "../../shared/swagger/api/ReportingApi";
import { SharedService } from "../../shared/shared.service";
import { CallApi, CallDTOBase } from '../../shared/swagger';

@Component({
  selector: 'app-reporting',
  templateUrl: './reporting.component.html',
  styleUrls: ['./reporting.component.scss'],
  providers: [ReportingApi, CallApi]
})
export class ReportingComponent implements OnInit {

  private reports: string[] = ['first', 'second', 'third', 'fourth', 'fifth', 'sixth', 'seventh', 'eight', 'ninth', 'tenth', 'eleventh'];
  private calls: CallDTOBase[] = [];
  private call: CallDTOBase;

  constructor(
    private reportingApi: ReportingApi,
    private sharedService: SharedService,
    private callApi: CallApi
  ) {
    this.callApi.allCallsClosed().subscribe(callList => {
      this.calls = callList;
    }, (error: Error) => {

    });
  }

  ngOnInit() {
    window.scrollTo(0, 0);
  }

  private onReport(report: string) {
    switch (report) {
      case "first":
        this.firstReport();
        break;

      case "second":
        this.secondReport(this.call.id);
        break;

      case "third":
        this.thirdReport(this.call.id);
        break;

      case "fourth":
        this.fourthReport();
        break;

      /*
      case "eight":
        this.eightReport();
      break;
      */
    }
  }

  private firstReport() {
    this.reportingApi.generateCallOpenReport().subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
    });
  }

  private secondReport(callId) {
    this.reportingApi.generatePreSelectionReport(callId).subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
    });
  }

  private thirdReport(callId) {
    this.reportingApi.generateNotificationsSentOutReport(callId).subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
    });
  }

  private fourthReport() {
    this.reportingApi.generateTimeToInformReport().subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
    });
  }

  private eightReport() {
    this.reportingApi.generateTypesInstallationReport().subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
    });
  }


  private selectCallClosed(event: any){
    console.log(event);
  }


  private isCallSelector(report: string) {
    let result: boolean;
    switch (report) {
      case "second":
      case "third":
      case "fourth":
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

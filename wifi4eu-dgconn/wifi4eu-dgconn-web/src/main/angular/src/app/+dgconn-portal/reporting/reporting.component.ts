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
  private callsNotified: CallDTOBase[] = [];
  private callsPreSelected: CallDTOBase[] = [];
  private call: CallDTOBase;
  private callNotified: CallDTOBase;
  private callPreSelected: CallDTOBase;

  constructor(
    private reportingApi: ReportingApi,
    private sharedService: SharedService,
    private callApi: CallApi
  ) {
    this.callApi.allCallsClosed().subscribe(callList => {
      this.calls = callList;
      
      
    }, (error: Error) => {
      
    });
    this.callApi.allCallsClosedNotified().subscribe(callList => {
      this.callsNotified = callList;
    }, (error: Error) => {
      
    });
    this.callApi.allCallsClosedPreSelected().subscribe(callList => {
      this.callsPreSelected = callList;
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
        this.secondReport(this.callPreSelected.id);
        break;

      case "third":
        this.thirdReport(this.callNotified.id);
        break;

      case "fourth":
        this.fourthReport();
        break;

      case "fifth":
        this.fifthReport(this.callNotified.id);
        break;

      case "sixth":
        this.sixthReport();
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

  private fifthReport(callId) {
    this.reportingApi.generateAgreementPreparationReport(callId).subscribe(data => {
      if (data['success'] && data['data']) {
        this.sharedService.growlTranslation('Request sent successfully', data['data'], 'success');
      } else {
        this.sharedService.growlTranslation('An error ocurred while generating the report', data['data'], 'error');
      }
    }, (error: Error) => {
      this.sharedService.growlTranslation('An error occurred while generating the report', 'reports.generate.error', 'error');
    });
  }

  private sixthReport() {
    this.reportingApi.generateTimeToGrantReport().subscribe(data => {
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


  private selectCallClosed(event: any) {
    console.log(event);
  }

  private isCallSelector(report: string) {
    let result: boolean;
    switch (report) {
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

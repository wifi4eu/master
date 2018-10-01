import { Component, OnInit } from '@angular/core';
import { ReportingApi } from "../../shared/swagger/api/ReportingApi";
import { SharedService } from "../../shared/shared.service";

@Component({
  selector: 'app-reporting',
  templateUrl: './reporting.component.html',
  styleUrls: ['./reporting.component.scss'],
  providers: [
    ReportingApi
  ]
})
export class ReportingComponent implements OnInit {

  private reports: string[] = ['first', 'second', 'third', 'fourth', 'fifth', 'sixth', 'seventh', 'eight', 'ninth', 'tenth', 'eleventh'];

  constructor(
    private reportingApi: ReportingApi,
    private sharedService: SharedService
  ) { }

  ngOnInit() {
    window.scrollTo(0,0);
  }

  private onReport(report: string) {
    switch (report) {
        case "first":
          this.firstReport();
        break;

        /*
        case "eight":
          this.eightReport();
        break;
        */
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

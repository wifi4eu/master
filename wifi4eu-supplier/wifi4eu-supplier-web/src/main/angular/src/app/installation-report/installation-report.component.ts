import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-installation-report',
  templateUrl: './installation-report.component.html',
  styleUrls: ['./installation-report.component.scss']
})
export class InstallationReportComponent implements OnInit {

  constructor(private router: Router) {
    
   }

  ngOnInit() {
  }

}

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstallationReportComponent } from './installation-report.component';

describe('InstallationReportComponent', () => {
  let component: InstallationReportComponent;
  let fixture: ComponentFixture<InstallationReportComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstallationReportComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstallationReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

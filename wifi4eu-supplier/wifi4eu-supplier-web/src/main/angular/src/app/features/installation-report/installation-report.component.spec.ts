/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { CoreModule } from '../../core/core.module';
import { InstallationReportComponent } from './installation-report.component';

describe('InstallationReportComponent', () => {
    let component: InstallationReportComponent;
    let fixture: ComponentFixture<InstallationReportComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                InstallationReportComponent
            ],
            imports: [
                CoreModule,
            ],
        }).compileComponents();
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

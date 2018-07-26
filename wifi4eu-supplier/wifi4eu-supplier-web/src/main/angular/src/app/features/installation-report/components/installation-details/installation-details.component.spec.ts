/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { CoreModule } from '../../../../core/core.module';
import { InstallationDetailsComponent } from './installation-details.component';

describe('InstallationDetailsComponent', () => {
    let component: InstallationDetailsComponent
;
    let fixture: ComponentFixture<InstallationDetailsComponent
>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                InstallationDetailsComponent
            
            ],
            imports: [
                CoreModule,
            ],
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(InstallationDetailsComponent
    );
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

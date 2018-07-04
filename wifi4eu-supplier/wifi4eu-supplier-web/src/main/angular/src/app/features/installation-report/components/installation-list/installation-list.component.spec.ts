/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { CoreModule } from '../../../../core/core.module';
import { InstallationListComponent } from './installation-list.component';

describe('InstallationListComponent', () => {
    let component: InstallationListComponent
;
    let fixture: ComponentFixture<InstallationListComponent
>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                InstallationListComponent
            
            ],
            imports: [
                CoreModule,
            ],
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(InstallationListComponent
    );
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { CoreModule } from '../../../../core/core.module';
import { AccessPointDetailsComponent } from './access-point-details.component';


describe('AccessPointDetailsComponent', () => {
    let component: AccessPointDetailsComponent
;
    let fixture: ComponentFixture<AccessPointDetailsComponent
>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                AccessPointDetailsComponent
            
            ],
            imports: [
                CoreModule,
            ],
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(AccessPointDetailsComponent
    );
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

/* tslint:disable:no-unused-variable */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Router } from '@angular/router';
import { CoreModule } from '../../core/core.module';
import { RouterMock } from '../../shared/testing/router.mock';
import { BAFMonitoringTableComponent } from './bafMonitoringTable.component';

describe('BAFMonitoringTableComponent', () => {
    let component: BAFMonitoringTableComponent;
    let fixture: ComponentFixture<BAFMonitoringTableComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                BAFMonitoringTableComponent
            ],
            imports: [
                CoreModule,
            ],
            providers: [
                { provide: Router, useClass: RouterMock },
            ]
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(BAFMonitoringTableComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

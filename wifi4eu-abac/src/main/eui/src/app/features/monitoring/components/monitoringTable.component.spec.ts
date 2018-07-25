/* tslint:disable:no-unused-variable */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Router } from '@angular/router';
import { CoreModule } from '../../core/core.module';
import { RouterMock } from '../../shared/testing/router.mock';
import { MonitoringTableComponent } from './monitoringTable.component';

describe('MonitoringTableComponent', () => {
    let component: MonitoringTableComponent;
    let fixture: ComponentFixture<MonitoringTableComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                MonitoringTableComponent
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
        fixture = TestBed.createComponent(MonitoringTableComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

/* tslint:disable:no-unused-variable */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { Router } from '@angular/router';
import { CoreModule } from '../../core/core.module';
import { RouterMock } from '../../shared/testing/router.mock';
import { LefStatusComponent } from './lefStatus.component';

describe('LefStatusComponent', () => {
    let component: LefStatusComponent;
    let fixture: ComponentFixture<LefStatusComponent>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                LefStatusComponent
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
        fixture = TestBed.createComponent(LefStatusComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

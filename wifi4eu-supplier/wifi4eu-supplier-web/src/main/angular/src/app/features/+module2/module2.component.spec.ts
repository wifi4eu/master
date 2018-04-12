/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { CoreModule } from '../../core/core.module';
import { Module2Component } from './module2.component';

describe('Module2Component', () => {
    let component: Module2Component;
    let fixture: ComponentFixture<Module2Component>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                Module2Component
            ],
            imports: [
                CoreModule,
            ],
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(Module2Component);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

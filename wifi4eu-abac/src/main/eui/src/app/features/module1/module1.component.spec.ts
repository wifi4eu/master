/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';
import { CoreModule } from '../../core/core.module';
import { Module1Component } from './module1.component';

describe('Module1Component', () => {
    let component: Module1Component;
    let fixture: ComponentFixture<Module1Component>;

    beforeEach(async(() => {
        TestBed.configureTestingModule({
            declarations: [
                Module1Component
            ],
            imports: [
                CoreModule,
            ],
        }).compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(Module1Component);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});

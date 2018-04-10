import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccessPointComponent } from './access-point.component';

describe('AccessPointComponent', () => {
  let component: AccessPointComponent;
  let fixture: ComponentFixture<AccessPointComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccessPointComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccessPointComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

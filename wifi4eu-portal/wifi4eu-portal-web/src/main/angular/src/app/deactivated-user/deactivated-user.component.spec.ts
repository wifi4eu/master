import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeactivatedUserComponent } from './deactivated-user.component';

describe('DeactivatedUserComponent', () => {
  let component: DeactivatedUserComponent;
  let fixture: ComponentFixture<DeactivatedUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeactivatedUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeactivatedUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

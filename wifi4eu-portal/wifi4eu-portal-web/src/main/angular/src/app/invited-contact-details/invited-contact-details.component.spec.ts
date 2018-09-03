import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InvitedContactDetailsComponent } from './invited-contact-details.component';

describe('InvitedContactDetailsComponent', () => {
  let component: InvitedContactDetailsComponent;
  let fixture: ComponentFixture<InvitedContactDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InvitedContactDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InvitedContactDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

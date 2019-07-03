import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmEqualPasswordComponent } from './confirm-equal-password.component';

describe('ConfirmEqualPasswordComponent', () => {
  let component: ConfirmEqualPasswordComponent;
  let fixture: ComponentFixture<ConfirmEqualPasswordComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfirmEqualPasswordComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfirmEqualPasswordComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

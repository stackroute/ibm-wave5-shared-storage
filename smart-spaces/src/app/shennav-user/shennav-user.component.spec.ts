import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShennavUserComponent } from './shennav-user.component';

describe('ShennavUserComponent', () => {
  let component: ShennavUserComponent;
  let fixture: ComponentFixture<ShennavUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShennavUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShennavUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

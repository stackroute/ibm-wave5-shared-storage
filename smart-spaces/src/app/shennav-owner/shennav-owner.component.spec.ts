import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShennavOwnerComponent } from './shennav-owner.component';

describe('ShennavOwnerComponent', () => {
  let component: ShennavOwnerComponent;
  let fixture: ComponentFixture<ShennavOwnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShennavOwnerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShennavOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

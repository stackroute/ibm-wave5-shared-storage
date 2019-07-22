import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShennavComponent } from './shennav.component';

describe('ShennavComponent', () => {
  let component: ShennavComponent;
  let fixture: ComponentFixture<ShennavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShennavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShennavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

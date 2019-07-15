import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OnlyCardComponent } from './only-card.component';

describe('OnlyCardComponent', () => {
  let component: OnlyCardComponent;
  let fixture: ComponentFixture<OnlyCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OnlyCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OnlyCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

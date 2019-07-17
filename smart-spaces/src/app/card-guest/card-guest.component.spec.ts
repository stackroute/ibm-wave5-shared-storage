import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardGuestComponent } from './card-guest.component';

describe('CardGuestComponent', () => {
  let component: CardGuestComponent;
  let fixture: ComponentFixture<CardGuestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardGuestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardGuestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarOwnerComponent } from './navbar-owner.component';

describe('NavbarOwnerComponent', () => {
  let component: NavbarOwnerComponent;
  let fixture: ComponentFixture<NavbarOwnerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarOwnerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarOwnerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

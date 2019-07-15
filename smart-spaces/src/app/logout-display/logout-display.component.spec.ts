import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoutDisplayComponent } from './logout-display.component';

describe('LogoutDisplayComponent', () => {
  let component: LogoutDisplayComponent;
  let fixture: ComponentFixture<LogoutDisplayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogoutDisplayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogoutDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

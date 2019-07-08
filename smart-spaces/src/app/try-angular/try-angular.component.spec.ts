import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TryAngularComponent } from './try-angular.component';

describe('TryAngularComponent', () => {
  let component: TryAngularComponent;
  let fixture: ComponentFixture<TryAngularComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TryAngularComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TryAngularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

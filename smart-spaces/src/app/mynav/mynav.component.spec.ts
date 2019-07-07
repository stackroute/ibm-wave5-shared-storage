import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MynavComponent } from './mynav.component';

describe('MynavComponent', () => {
  let component: MynavComponent;
  let fixture: ComponentFixture<MynavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MynavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MynavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

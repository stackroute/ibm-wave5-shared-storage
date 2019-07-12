import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JltComponent } from './jlt.component';

describe('JltComponent', () => {
  let component: JltComponent;
  let fixture: ComponentFixture<JltComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JltComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JltComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

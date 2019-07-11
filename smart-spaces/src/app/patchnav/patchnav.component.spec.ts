import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatchnavComponent } from './patchnav.component';

describe('PatchnavComponent', () => {
  let component: PatchnavComponent;
  let fixture: ComponentFixture<PatchnavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatchnavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatchnavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PatchpostComponent } from './patchpost.component';

describe('PatchpostComponent', () => {
  let component: PatchpostComponent;
  let fixture: ComponentFixture<PatchpostComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PatchpostComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PatchpostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

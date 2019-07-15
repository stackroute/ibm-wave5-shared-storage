import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommendationguestComponent } from './recommendationguest.component';

describe('RecommendationguestComponent', () => {
  let component: RecommendationguestComponent;
  let fixture: ComponentFixture<RecommendationguestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecommendationguestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommendationguestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

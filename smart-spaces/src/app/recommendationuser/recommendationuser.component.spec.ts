import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommendationuserComponent } from './recommendationuser.component';

describe('RecommendationuserComponent', () => {
  let component: RecommendationuserComponent;
  let fixture: ComponentFixture<RecommendationuserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecommendationuserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecommendationuserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

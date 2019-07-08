import { TestBed } from '@angular/core/testing';

import { RecommendServiceService } from './recommend-service.service';

describe('RecommendServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RecommendServiceService = TestBed.get(RecommendServiceService);
    expect(service).toBeTruthy();
  });
});

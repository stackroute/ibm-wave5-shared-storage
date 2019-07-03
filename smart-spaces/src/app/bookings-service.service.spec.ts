import { TestBed } from '@angular/core/testing';

import { BookingsServiceService } from './bookings-service.service';

describe('BookingsServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BookingsServiceService = TestBed.get(BookingsServiceService);
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { WarehouseServiceService } from './warehouse-service.service';

describe('WarehouseServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WarehouseServiceService = TestBed.get(WarehouseServiceService);
    expect(service).toBeTruthy();
  });
});

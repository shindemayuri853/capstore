import { TestBed } from '@angular/core/testing';

import { UpdateShippingService } from './update-shipping.service';

describe('UpdateShippingService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UpdateShippingService = TestBed.get(UpdateShippingService);
    expect(service).toBeTruthy();
  });
});

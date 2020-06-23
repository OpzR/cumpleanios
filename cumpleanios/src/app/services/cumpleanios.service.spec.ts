import { TestBed } from '@angular/core/testing';

import { CumpleaniosService } from './cumpleanios.service';

describe('CumpleaniosService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CumpleaniosService = TestBed.get(CumpleaniosService);
    expect(service).toBeTruthy();
  });
});

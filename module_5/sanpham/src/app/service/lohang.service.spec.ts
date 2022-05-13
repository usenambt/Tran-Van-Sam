import { TestBed } from '@angular/core/testing';

import { LohangService } from './lohang.service';

describe('LohangService', () => {
  let service: LohangService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LohangService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

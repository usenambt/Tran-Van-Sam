import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PetInforComponent } from './pet-infor.component';

describe('PetInforComponent', () => {
  let component: PetInforComponent;
  let fixture: ComponentFixture<PetInforComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PetInforComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PetInforComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

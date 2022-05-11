import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AloComponent } from './alo.component';

describe('AloComponent', () => {
  let component: AloComponent;
  let fixture: ComponentFixture<AloComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AloComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

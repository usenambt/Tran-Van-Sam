import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsHackernewsComponent } from './details-hackernews.component';

describe('DetailsHackernewsComponent', () => {
  let component: DetailsHackernewsComponent;
  let fixture: ComponentFixture<DetailsHackernewsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsHackernewsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsHackernewsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

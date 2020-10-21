import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StateCreditlineComponent } from './state-creditline.component';

describe('StateCreditlineComponent', () => {
  let component: StateCreditlineComponent;
  let fixture: ComponentFixture<StateCreditlineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StateCreditlineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StateCreditlineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

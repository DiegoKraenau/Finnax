import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterDeliveryComponent } from './register-delivery.component';

describe('RegisterDeliveryComponent', () => {
  let component: RegisterDeliveryComponent;
  let fixture: ComponentFixture<RegisterDeliveryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterDeliveryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterDeliveryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

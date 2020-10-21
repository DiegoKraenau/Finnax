import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPurchasesComponent } from './list-purchases.component';

describe('ListPurchasesComponent', () => {
  let component: ListPurchasesComponent;
  let fixture: ComponentFixture<ListPurchasesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListPurchasesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListPurchasesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

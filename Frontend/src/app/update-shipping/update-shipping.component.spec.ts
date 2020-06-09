import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateShippingComponent } from './update-shipping.component';

describe('UpdateShippingComponent', () => {
  let component: UpdateShippingComponent;
  let fixture: ComponentFixture<UpdateShippingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateShippingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateShippingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

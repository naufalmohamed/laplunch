import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SubscribedPlanComponent } from './subscribed-plan.component';

describe('SubscribedPlanComponent', () => {
  let component: SubscribedPlanComponent;
  let fixture: ComponentFixture<SubscribedPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SubscribedPlanComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SubscribedPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

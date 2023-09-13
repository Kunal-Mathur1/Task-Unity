import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LatestTaskComponent } from './latest-task.component';

describe('LatestTaskComponent', () => {
  let component: LatestTaskComponent;
  let fixture: ComponentFixture<LatestTaskComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LatestTaskComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LatestTaskComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

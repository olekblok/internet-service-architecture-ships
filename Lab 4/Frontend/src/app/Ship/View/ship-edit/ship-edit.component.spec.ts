import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipEditComponent } from './ship-edit.component';

describe('ShipEditComponent', () => {
  let component: ShipEditComponent;
  let fixture: ComponentFixture<ShipEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShipEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShipEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

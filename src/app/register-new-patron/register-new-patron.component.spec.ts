import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterNewPatronComponent } from './register-new-patron.component';

describe('RegisterNewPatronComponent', () => {
  let component: RegisterNewPatronComponent;
  let fixture: ComponentFixture<RegisterNewPatronComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterNewPatronComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterNewPatronComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

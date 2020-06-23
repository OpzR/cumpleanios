import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaludosCumpleaniosComponent } from './saludos-cumpleanios.component';

describe('SaludosCumpleaniosComponent', () => {
  let component: SaludosCumpleaniosComponent;
  let fixture: ComponentFixture<SaludosCumpleaniosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaludosCumpleaniosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaludosCumpleaniosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

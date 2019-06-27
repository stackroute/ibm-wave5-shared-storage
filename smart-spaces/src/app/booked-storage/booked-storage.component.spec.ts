import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookedStorageComponent } from './booked-storage.component';

describe('BookedStorageComponent', () => {
  let component: BookedStorageComponent;
  let fixture: ComponentFixture<BookedStorageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookedStorageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookedStorageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListedStorageComponent } from './listed-storage.component';

describe('ListedStorageComponent', () => {
  let component: ListedStorageComponent;
  let fixture: ComponentFixture<ListedStorageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListedStorageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListedStorageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

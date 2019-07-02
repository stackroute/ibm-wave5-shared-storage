import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PostStorageUnitComponent } from './post-storage-unit.component';

describe('PostStorageUnitComponent', () => {
  let component: PostStorageUnitComponent;
  let fixture: ComponentFixture<PostStorageUnitComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PostStorageUnitComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PostStorageUnitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

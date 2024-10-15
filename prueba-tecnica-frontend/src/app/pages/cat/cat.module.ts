import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CatComponent } from './cat.component';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { SharedModule } from 'src/app/shared/shared.module';
import { CatRoutingModule } from './cat-routing.module';



@NgModule({
  declarations: [CatComponent],
  imports: [
    CommonModule,
    SharedModule,
    CatRoutingModule,
    CarouselModule.forRoot()
  ]
})
export class CatModule { }

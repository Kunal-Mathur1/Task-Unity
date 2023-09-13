import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home/home.component';
import { ProjectsComponent } from './projects/projects.component';
import { LatestTaskComponent } from './latest-task/latest-task.component';


@NgModule({
  declarations: [
    HomeComponent,
    ProjectsComponent,
    LatestTaskComponent
  ],
  imports: [
    CommonModule,
    HomeRoutingModule
  ]
})
export class HomeModule { }

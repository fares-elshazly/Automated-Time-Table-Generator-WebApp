import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { RouterModule, Routes } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import * as $ from 'jquery';

import { AppComponent } from './app.component';
import { SideNavComponent } from './side-nav/side-nav.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
import { TableComponent } from './table/table.component';
import { AddCourseComponent } from './add-course/add-course.component';
import { AddSessionComponent } from './add-session/add-session.component';
import { AddRoomComponent } from './add-room/add-room.component';
import { AddTeacherComponent } from './add-teacher/add-teacher.component';

const appRoutes: Routes = [
  { path:'Home', component:HomeComponent},
  { path:'Table', component:TableComponent},
  { path:'Add-Course', component:AddCourseComponent},
  { path:'Add-Session', component:AddSessionComponent},
  { path:'Add-Room', component:AddRoomComponent},
  { path:'Add-Teacher', component:AddTeacherComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    SideNavComponent,
    NavbarComponent,
    HomeComponent,
    TableComponent,
    AddCourseComponent,
    AddSessionComponent,
    AddRoomComponent,
    AddTeacherComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(appRoutes),
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 2000,
      positionClass: 'toast-top-right',
      preventDuplicates: false
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

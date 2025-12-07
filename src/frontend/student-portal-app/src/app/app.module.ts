import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {en_US, provideNzI18n} from 'ng-zorro-antd/i18n';
import {registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {provideHttpClient} from '@angular/common/http';
import {DashboardModule} from './features/dashboard/dashboard.module';
import {SharedModule} from '../shared/shared.module';
import {LayoutModule} from './layout/layout.module';
import { GradeComponent } from './features/grade/grade.component';
import { ScheduleComponent } from './features/schedule/schedule.component';
import { AttendanceComponent } from './features/attendance/attendance.component';
import { EnrollmentComponent } from './features/enrollment/enrollment.component';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    GradeComponent,
    ScheduleComponent,
    AttendanceComponent,
    EnrollmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

    SharedModule,
    DashboardModule,
    LayoutModule
  ],
  providers: [
    provideNzI18n(en_US),
    provideAnimationsAsync(),
    provideHttpClient()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

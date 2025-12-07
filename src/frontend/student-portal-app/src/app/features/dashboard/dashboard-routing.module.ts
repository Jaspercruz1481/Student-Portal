// src/app/features/dashboard/dashboard-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DashboardMainComponent } from './dashboard-main/dashboard-main.component';

import {LayoutComponent} from '../../layout/layout.component';
import {GradeComponent} from '../grade/grade.component';
import {AttendanceComponent} from '../attendance/attendance.component';
import {ScheduleComponent} from '../schedule/schedule.component';
import {EnrollmentComponent} from '../enrollment/enrollment.component';

const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      { path: '', component: DashboardMainComponent },
      { path: 'grades', component: GradeComponent },
      { path: 'attendance', component: AttendanceComponent },
      { path: 'schedule', component: ScheduleComponent },
      { path: 'enrollment', component: EnrollmentComponent }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutingModule {}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {GradeComponent} from './features/grade/grade.component';

const routes: Routes = [
  { path: 'dashboard',
    loadChildren: () => import('./features/dashboard/dashboard.module')
      .then(m => m.DashboardModule) },
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

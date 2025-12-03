import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { DashboardHeaderComponent } from './dashboard-header/dashboard-header.component';
import { DashboardSidebarComponent } from './dashboard-sidebar/dashboard-sidebar.component';
import { DashboardMainComponent } from './dashboard-main/dashboard-main.component';
import { DashboardWidgetComponent } from './dashboard-widget/dashboard-widget.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';


@NgModule({
  declarations: [
    DashboardHeaderComponent,
    DashboardSidebarComponent,
    DashboardMainComponent,
    DashboardWidgetComponent,

  ],
  exports: [
    DashboardHeaderComponent,
    DashboardSidebarComponent,
    DashboardMainComponent,
    DashboardWidgetComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule,
  ]
})
export class DashboardModule { }

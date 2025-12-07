import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DashboardMainComponent} from './dashboard-main/dashboard-main.component';
import {DashboardWidgetComponent} from './dashboard-widget/dashboard-widget.component';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {NzLayoutModule} from 'ng-zorro-antd/layout';
import {NzMenuModule} from 'ng-zorro-antd/menu';
import {NzButtonModule} from 'ng-zorro-antd/button';
import {NzIconModule} from 'ng-zorro-antd/icon';
import {NzCardModule} from 'ng-zorro-antd/card';
import {NzListModule} from 'ng-zorro-antd/list';
import {NzGridModule} from 'ng-zorro-antd/grid';
import {NzTableModule} from 'ng-zorro-antd/table';
import {LayoutModule} from '../../layout/layout.module';
import {DashboardRoutingModule} from './dashboard-routing.module';

@NgModule({
  declarations: [
    DashboardMainComponent,
    DashboardWidgetComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    LayoutModule,
    DashboardRoutingModule,
    NzLayoutModule,
    NzMenuModule,
    NzButtonModule,
    NzIconModule,
    NzCardModule,
    NzListModule,
    NzGridModule,
    NzTableModule
  ],
  exports: [
    DashboardMainComponent,
    DashboardWidgetComponent,
  ]
})
export class DashboardModule { }

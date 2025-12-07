import { Component } from '@angular/core';
import {
  BarChartOutline,
  BellOutline,
  DashboardOutline,
  SettingOutline,
  UserOutline
} from '@ant-design/icons-angular/icons';
import {Router} from '@angular/router';

@Component({
  selector: 'app-sidebar',
  standalone: false,
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.scss'
})
export class SidebarComponent {
  icons = {
    dashboard: DashboardOutline,
    analytics: BarChartOutline,
    notifications: BellOutline,
    settings: SettingOutline,
    user: UserOutline
  };
  selected: string = 'dashboard';
  isCollapsed = false;

  constructor(private router: Router) {}

  navigateTo(path: string) {
    // this.router.navigate([path]);
    // this.selected = path.split('/')[1];

    this.router.navigate([path]);
    // Update the selected menu item
    if (path.includes('grades')) this.selected = 'grades';
    else if (path.includes('attendance')) this.selected = 'attendance';
    else if (path.includes('enrollment')) this.selected = 'enrollment';
    else if (path.includes('schedule')) this.selected = 'schedule';
    else this.selected = 'dashboard';
  }
}

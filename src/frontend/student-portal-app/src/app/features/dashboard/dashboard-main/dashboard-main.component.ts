import { Component } from '@angular/core';
import {DashboardService} from '../services/dashboard.service';
import {DashboardDto} from '../models/dashboard.model';

@Component({
  selector: 'app-dashboard-main',
  standalone: false,
  templateUrl: './dashboard-main.component.html',
  styleUrl: './dashboard-main.component.scss'
})
export class DashboardMainComponent {
  dashboardData?: DashboardDto;

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.dashboardService.getDashboard(1).subscribe(data => {
      this.dashboardData = data;
    });
  }
}

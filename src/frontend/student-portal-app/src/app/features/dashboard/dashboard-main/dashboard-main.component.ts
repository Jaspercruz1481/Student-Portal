import { Component } from '@angular/core';
import {DashboardDto} from "../../model/dashboard.model";
import {DashboardService} from "../../service/dashboard.service";

@Component({
  selector: 'app-dashboard-main',
  standalone: false,
  templateUrl: './dashboard-main.component.html',
  styleUrls: ['./dashboard-main.component.scss'],
})
export class DashboardMainComponent {
  dashboard?: DashboardDto;
  loading: boolean = false;

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.loadDashboard();
  }

  loadDashboard(): void {
    this.loading = true;
    // Replace 1 with actual studentId
    this.dashboardService.getDashboard(1).subscribe({
      next: (data) => {
        this.dashboard = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching dashboard', err);
        this.loading = false;
      }
    });
  }
}

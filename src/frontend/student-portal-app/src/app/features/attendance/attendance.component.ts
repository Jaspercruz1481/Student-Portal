import { Component } from '@angular/core';
import {Attendance} from '../model/attendance.model';
import {Schedule} from '../model/schedule.model';
import {ScheduleService} from '../service/schedule.service';
import {AttendanceService} from '../service/attendance.service';

@Component({
  selector: 'app-attendance',
  standalone: false,
  templateUrl: './attendance.component.html',
  styleUrl: './attendance.component.scss'
})
export class AttendanceComponent {
  attendance: Attendance[] = [];
  loading: boolean = false;

  constructor(private attendanceService: AttendanceService) {}

  ngOnInit(): void {
    this.loadAttendance();
  }

  loadAttendance(): void {
    const studentId = 1; // replace with actual student id
    this.loading = true;
    this.attendanceService.getAttendances(studentId).subscribe({
      next: (attendance) => {
        this.attendance = attendance;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching grades', err);
        this.loading = false;
      }
    });
  }
}

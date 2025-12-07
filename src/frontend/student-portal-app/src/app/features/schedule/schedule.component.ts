import { Component } from '@angular/core';
import {Schedule} from '../model/schedule.model';
import {GradeService} from '../service/grade.service';
import {ScheduleService} from '../service/schedule.service';

@Component({
  selector: 'app-schedule',
  standalone: false,
  templateUrl: './schedule.component.html',
  styleUrl: './schedule.component.scss'
})
export class ScheduleComponent {
  schedule: Schedule[] = [];
  loading: boolean = false;

  constructor(private scheduleService: ScheduleService) {}

  ngOnInit(): void {
    this.loadSchedule();
  }

  loadSchedule(): void {
    const studentId = 1; // replace with actual student id
    this.loading = true;
    this.scheduleService.getSchedules(studentId).subscribe({
      next: (schedule) => {
        this.schedule = schedule;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching grades', err);
        this.loading = false;
      }
    });
  }
}

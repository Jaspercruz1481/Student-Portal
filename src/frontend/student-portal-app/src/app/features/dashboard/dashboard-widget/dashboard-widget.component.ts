import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-dashboard-widget',
  standalone: false,
  templateUrl: './dashboard-widget.component.html',
  styleUrl: './dashboard-widget.component.scss'
})
export class DashboardWidgetComponent {
  @Input() title!: string;
  @Input() content: any;

  data: any;

  ngOnInit() {
    // Provide mock data based on title
    switch (this.title) {
      case 'Grades':
        this.data = [
          {subject: 'Math', grade: 'A'},
          {subject: 'Science', grade: 'B+'},
          {subject: 'History', grade: 'A-'}
        ];
        break;
      case 'Schedule':
        this.data = [
          {day: 'Monday', subject: 'Math'},
          {day: 'Tuesday', subject: 'Science'},
          {day: 'Wednesday', subject: 'History'}
        ];
        break;
      case 'Enrollment':
        this.data = {
          status: 'Enrolled',
          year: '2nd Year',
          program: 'BS Computer Science'
        };
        break;
      case 'Attendance':
        this.data = [
          {date: '2025-12-01', status: 'Present'},
          {date: '2025-12-02', status: 'Absent'},
          {date: '2025-12-03', status: 'Present'}
        ];
        break;
      default:
        this.data = 'No data available';
    }
  }
}

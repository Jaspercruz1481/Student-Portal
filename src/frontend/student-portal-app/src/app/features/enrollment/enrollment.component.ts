import {Component} from '@angular/core';
import {Enrollment} from '../model/enrollment.model';
import {EnrollmentService} from '../service/enrollment.service';

@Component({
  selector: 'app-enrollment',
  standalone: false,
  templateUrl: './enrollment.component.html',
  styleUrl: './enrollment.component.scss'
})
export class EnrollmentComponent {
  enrollment: Enrollment[] = [];
  loading: boolean = false;

  constructor(private enrollmentService: EnrollmentService) {
  }

  ngOnInit(): void {
    this.loadEnrollment();
  }

  loadEnrollment(): void {
    const studentId = 1; // replace with actual student id
    this.loading = true;
    this.enrollmentService.getEnrollment(studentId).subscribe({
      next: (enrollment) => {
        this.enrollment = enrollment;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching grades', err);
        this.loading = false;
      }
    });
  }
}

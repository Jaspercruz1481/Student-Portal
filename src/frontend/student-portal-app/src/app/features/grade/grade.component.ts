import { Component } from '@angular/core';
import {GradeDto} from '../model/grade.model';
import {GradeService} from '../service/grade.service';

@Component({
  selector: 'app-grade',
  standalone: false,
  templateUrl: './grade.component.html',
  styleUrl: './grade.component.scss'
})
export class GradeComponent {
  subjects: GradeDto[] = [];
  loading: boolean = false;

  constructor(private gradeService: GradeService) {}

  ngOnInit(): void {
    this.loadGrades();
  }

  loadGrades(): void {
    const studentId = 1; // replace with actual student id
    this.loading = true;
    this.gradeService.getGrades(studentId).subscribe({
      next: (grades) => {
        this.subjects = grades;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching grades', err);
        this.loading = false;
      }
    });
  }
}

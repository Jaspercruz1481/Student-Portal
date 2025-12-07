import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DashboardDto} from '../model/dashboard.model';
import {GradeDto} from '../model/grade.model';

@Injectable({
  providedIn: 'root'
})
export class GradeService {

  constructor(private http: HttpClient) {}

  getGrades(studentId: number): Observable<GradeDto[]> {
    return this.http.get<GradeDto[]>(`/api/grades/list/${studentId}`);
  }
}

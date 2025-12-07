import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {GradeDto} from '../model/grade.model';
import {Schedule} from '../model/schedule.model';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http: HttpClient) {}

  getSchedules(studentId: number): Observable<Schedule[]> {
    return this.http.get<Schedule[]>(`/api/schedule/list/${studentId}`);
  }
}

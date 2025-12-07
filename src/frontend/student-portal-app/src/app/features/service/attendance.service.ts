import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Attendance} from '../model/attendance.model';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {

  constructor(private http: HttpClient) {}

  getAttendances(studentId: number): Observable<Attendance[]> {
    return this.http.get<Attendance[]>(`/api/attendance/list/${studentId}`);
  }
}

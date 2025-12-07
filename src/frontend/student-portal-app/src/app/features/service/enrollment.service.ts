import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Schedule} from '../model/schedule.model';
import {Enrollment} from '../model/enrollment.model';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  constructor(private http: HttpClient) {}

  getEnrollment(studentId: number): Observable<Enrollment[]> {
    return this.http.get<Enrollment[]>(`/api/enrollment/list/${studentId}`);
  }
}

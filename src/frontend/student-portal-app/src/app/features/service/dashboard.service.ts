import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DashboardDto } from '../model/dashboard.model';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) {}

  getDashboard(studentId: number): Observable<DashboardDto> {
    return this.http.get<DashboardDto>(`/api/dashboard/${studentId}`);
  }
}

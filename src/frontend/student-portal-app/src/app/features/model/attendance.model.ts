export interface Attendance {
  studentId: number;
  date: string;
  status: string;
  timeIn?: string;
  timeOut?: string;
  remarks?: string;

}

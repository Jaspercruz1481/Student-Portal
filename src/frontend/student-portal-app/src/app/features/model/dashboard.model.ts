export interface DashboardDto {
  grades: GradesSummary;
  attendance: AttendanceSummary;
  todaySchedule: ScheduleSummary;
  enrollmentStatus: string;
}

export interface GradesSummary {
  gpa: number;
  latestSubjects: string[];
}

export interface AttendanceSummary {
  present: number;
  absent: number;
  late: number;
}

export interface ScheduleSummary {
  classesToday: string[];
}

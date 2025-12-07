import {Subject} from './subject.model';


export interface GradeDto {
  id?: number;
  studentId: number;
  midterms: number;
  finals: number;
  average: number;
  subjectId: number;
  subjectName?: Subject;
  studentName?: string;
}


import { Component } from '@angular/core';
import { CourseCard } from '../../components/course-card/course-card';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CourseCard],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList {
  courses = [
    { id: 1, name: 'Angular Fundamentals', code: 'ANG101', credits: 3 },
    { id: 2, name: 'TypeScript Essentials', code: 'TS201', credits: 2 },
    { id: 3, name: 'RxJS & Reactive Programming', code: 'RX301', credits: 4 },
    { id: 4, name: 'Angular Routing', code: 'ANG202', credits: 3 },
    { id: 5, name: 'NgRx State Management', code: 'NGR401', credits: 4 }
  ];

  selectedCourseId: number | null = null;

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}
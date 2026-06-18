import { Component, OnInit } from '@angular/core';
import { CourseCard } from '../../components/course-card/course-card';
import { HighlightDirective } from '../../directives/highlight';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CourseCard, HighlightDirective],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css',
})
export class CourseList implements OnInit {
  isLoading = true;

  courses = [
    { id: 1, name: 'Angular Fundamentals', code: 'ANG101', credits: 3, gradeStatus: 'passed' },
    { id: 2, name: 'TypeScript Essentials', code: 'TS201', credits: 2, gradeStatus: 'pending' },
    { id: 3, name: 'RxJS & Reactive Programming', code: 'RX301', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'Angular Routing', code: 'ANG202', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'NgRx State Management', code: 'NGR401', credits: 4, gradeStatus: 'pending' }
  ];

  selectedCourseId: number | null = null;

  ngOnInit() {
    setTimeout(() => this.isLoading = false, 1500);
  }

  trackByCourseId(index: number, course: any): number {
    return course.id;
  }

  onEnroll(courseId: number) {
    console.log('Enrolling in course: ' + courseId);
    this.selectedCourseId = courseId;
  }
}
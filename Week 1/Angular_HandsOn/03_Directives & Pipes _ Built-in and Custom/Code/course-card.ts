import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { NgClass, NgStyle, NgSwitch, NgSwitchCase } from '@angular/common';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [NgClass, NgStyle, NgSwitch, NgSwitchCase, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css',
})
export class CourseCard implements OnChanges {
  @Input() course!: { id: number; name: string; code: string; credits: number; gradeStatus: string };
  @Input() enrolled = false;
  @Output() enrollRequested = new EventEmitter<number>();
  isExpanded = false;

  ngOnChanges(changes: SimpleChanges) {
    if (changes['course']) {
      console.log('CourseCard changed:', changes['course'].currentValue);
    }
  }

  get cardClasses() {
    return {
      'card--enrolled': this.enrolled,
      'card--full': this.course?.credits >= 4,
      expanded: this.isExpanded
    };
  }

  get cardStyle() {
    let color = 'grey';
    if (this.course?.gradeStatus === 'passed') color = 'green';
    if (this.course?.gradeStatus === 'failed') color = 'red';
    return { 'border-left': '4px solid ' + color };
  }
}
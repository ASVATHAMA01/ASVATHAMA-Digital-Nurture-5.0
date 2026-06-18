import { Directive, Input, HostListener, HostBinding } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  @Input() appHighlight = 'yellow';

  @HostBinding('style.backgroundColor') bgColor = '';

  @HostListener('mouseenter') onEnter() {
    this.bgColor = this.appHighlight;
  }

  @HostListener('mouseleave') onLeave() {
    this.bgColor = '';
  }
}
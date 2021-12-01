import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'excitedPipe'
})
export class ExcitedPipePipe implements PipeTransform {

  transform(value: string): string {
    return value+'!!!';
  }

}

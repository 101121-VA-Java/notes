import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {

  constructor() { }

  private importantVar: string = 'Important';

  add(numOne: number, numTwo:number): number{
    return numOne + numTwo;
  }

  minus(numOne: number, numTwo:number): number{
    return numOne - numTwo;
  }

  getImportantVar(): string{
    return this.importantVar;
  }
}

import { Component, OnInit } from '@angular/core';
import { CalculatorService } from 'src/app/services/calculator.service';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  // template: '<h1>Hello from ts file!</h1>',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  constructor(private cal: CalculatorService) { }

  ngOnInit(): void {
  }

  employees: string[] = [
    'Kevin',
    'Brayden',
    'Patience'
  ];

  someBoolean: boolean = false;

  changeBoolean(){
    console.log(this.cal.getImportantVar());
    this.someBoolean = !this.someBoolean;

    this.cal.add(1,1);
  }

  styles = {
    backgroundColor: "orange",
    color:"blue"
  }
}

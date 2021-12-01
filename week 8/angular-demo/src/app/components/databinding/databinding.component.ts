import { Component, OnInit } from '@angular/core';
import { CalculatorService } from 'src/app/services/calculator.service';

@Component({
  selector: 'app-databinding',
  templateUrl: './databinding.component.html',
  styleUrls: ['./databinding.component.css']
})
export class DatabindingComponent implements OnInit {

  constructor(private calc: CalculatorService) { }

  ngOnInit(): void {
  }

  // Let's say some var was retrieve dynamically from an API
  someVar: string = 'Kevin';
  count: number = 0;
  countColor: string = 'red-text';
  i:string = this.calc.getImportantVar();
  increment(){
    this.count += 1;
    if(this.count%2 == 0){
      this.countColor = 'red-text';
    } else {
      this.countColor = 'green-text';
    }
    this.calc.add(2,2);
    
  }

}

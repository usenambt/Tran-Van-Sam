import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
  }


  total(value1: string, value2: string, value3: string) {
    console.log(value1);
    console.log(value2);
    console.log(value3);
  }
}

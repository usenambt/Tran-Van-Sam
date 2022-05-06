import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color-picker',
  templateUrl: './color-picker.component.html',
  styleUrls: ['./color-picker.component.css']
})
export class ColorPickerComponent implements OnInit {

  color: string | undefined;

  constructor() { }

  ngOnInit(): void {
  }


  setColor($event: Event) {
    // @ts-ignore
    this.color = event.target.value;

}}

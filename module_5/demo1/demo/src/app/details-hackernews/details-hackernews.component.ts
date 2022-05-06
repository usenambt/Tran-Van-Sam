import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-details-hackernews',
  templateUrl: './details-hackernews.component.html',
  styleUrls: ['./details-hackernews.component.css']
})
export class DetailsHackernewsComponent implements OnInit {

  constructor() {
  }

  @Input() detailHackernew: any;
  @Input() like: number | undefined;

  ngOnInit(): void {
  }

  setUrl() {
    // @ts-ignore
    console.log(document.getElementById("setUrl").value)
    // @ts-ignore
    this.detailHackernew.url = document.getElementById("setUrl").value
    console.log(this.detailHackernew.url)
    // @ts-ignore
    // console.log($event.target.value)

  }
}

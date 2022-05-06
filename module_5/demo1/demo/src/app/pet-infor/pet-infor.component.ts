import { Component, OnInit } from '@angular/core';
import {IPet} from "../models/IPet";

@Component({
  selector: 'app-pet-infor',
  templateUrl: './pet-infor.component.html',
  styleUrls: ['./pet-infor.component.css']
})
export class PetInforComponent implements OnInit {
  pet: IPet = {
    name: 'puppie',
    image: 'http://yourdost-blog-images.s3-ap-southeast-1.amazonaws.com/wp-content/uploads/2016/01/03165939/Dogs.jpg'
  };

  constructor() { }

  ngOnInit(): void {
  }

}

import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';
import {ILoHang} from '../model/ILoHang';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: ILoHang) { }

  ngOnInit(): void {
  }

}

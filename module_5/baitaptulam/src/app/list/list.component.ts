import {Component, OnInit} from '@angular/core';
import {StkService} from '../service/stk.service';
import {ISoTietKiem} from '../model/ISoTietKiem';
import {MatDialog} from '@angular/material/dialog';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  soTietKiemList: ISoTietKiem[];

  constructor(private service: StkService) {
  }

  ngOnInit(): void {
    this.service.getAll().subscribe(
      (duLieu) => {
        this.soTietKiemList = duLieu;
        console.log(this.soTietKiemList);
      },
      (error) => {
        console.log('lỗi đổ dữ liệu');
      }
    );
  }
  }

import {Component, OnInit} from '@angular/core';

import {MatDialog} from '@angular/material/dialog';

import {FormControl, FormGroup, Validators} from '@angular/forms';

import {MatSnackBar} from '@angular/material/snack-bar';
import {ILoHang} from '../model/ILoHang';
import {LohangService} from '../service/lohang.service';
import {CreateComponent} from '../create/create.component';
import {DeleteComponent} from '../delete/delete.component';
import {EditComponent} from '../edit/edit.component';
import {min} from 'rxjs/operators';


@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  loHangs: ILoHang[];
  p: string | number;
  dateHetHan: [] | any;

  formGroup = new FormGroup({
      id: new FormControl(),
      sanPham: new FormControl('', Validators.required),
      soLuong: new FormControl('', [Validators.required, Validators.min(0)]),
      ngayNhapHang: new FormControl('', Validators.required),
      ngaySanXuat: new FormControl('', Validators.required),
      ngayHetHan: new FormControl('', Validators.required),
      email : new FormControl('', [Validators.required, Validators.email])
    }
  );

  constructor(private service: LohangService,
              private dialog: MatDialog,
              private snackbar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.service.getAllLoHang().subscribe(
      (data) => {
        this.loHangs = data;
      }
    );
  }

  openDialogCreate() {
    const dialog = this.dialog.open(CreateComponent, {
      width: '800px',
      data: this.formGroup,
      disableClose: true
    });
    dialog.afterClosed().subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );
  }

  openDialogDelete(loHang: ILoHang) {
    const dialog = this.dialog.open(DeleteComponent, {
      data: loHang
    });
    dialog.afterClosed().subscribe(
      (check) => {
        if (check) {
          this.service.delete(loHang).subscribe(
            () => {
              this.snackbar.open('Đã xóa mã lô hàng: LH-' + loHang.id, 'Ok', {
                panelClass: ['mat-toolbar', 'mat-warn'],
                duration: 3000
              });
              this.p = 1;
              this.ngOnInit();
            }
          );
        }
      }
    );
  }

  openDialogEdit(loHang: ILoHang) {

    this.formGroup.setValue(loHang);
    const dialog = this.dialog.open(EditComponent, {
      width: '800px',
      data: this.formGroup,
      disableClose: true
    });
    dialog.afterClosed().subscribe(
      () => {
        this.formGroup.reset();
      },
      () => {
      },
      () => {
        this.ngOnInit();
      }
    );

  }

  searchNameSanPham(name: string) {
    this.service.searchNameSanPham(name).subscribe(
      (data) => {
        this.loHangs = data;
        this.p = 1;
      }
    );
  }

  searchHetHan(value: string) {
    // this.dateHetHan = value.charAt();

    console.log(value);
    this.service.searchHetHan(value).subscribe(
      (data) => {
        this.loHangs = data;
        console.log(data);
        this.p = 1;
      }
    );
  }
}

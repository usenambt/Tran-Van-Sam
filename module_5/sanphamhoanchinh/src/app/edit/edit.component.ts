import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {FormGroup} from '@angular/forms';
import {LohangService} from '../service/lohang.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ListComponent} from '../list/list.component';
import {ISanPham} from '../model/ISanPham';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  sanPhams: ISanPham[];

  compareWith(item1: any, item2: any) {
    return item1 && item2 && item1.id === item2.id;
  }

  constructor(@Inject(MAT_DIALOG_DATA) public formGroup: FormGroup,
              private service: LohangService,
              private snackbar: MatSnackBar,
              private dialog: MatDialogRef<ListComponent>) {
  }

  ngOnInit(): void {
    this.service.getAllSanPham().subscribe(
      (data) => this.sanPhams = data
    );
  }

  onSubmit() {

    if (this.formGroup.valid) {
      this.service.updateHang(this.formGroup.value).subscribe(
        () => {
        },
        () => {
        },
        () => {
          this.snackbar.open('Cập nhập mã lô hàng LH-' + this.formGroup.value.id + ' thành công', 'Ok', {
            duration: 3000
          });
          this.dialog.close();
        }
      );
    }
  }

}

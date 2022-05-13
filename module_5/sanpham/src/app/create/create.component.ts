import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {FormGroup} from '@angular/forms';
import {LohangService} from '../service/lohang.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {ISanPham} from '../model/ISanPham';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public formGroup: FormGroup,
              private service: LohangService,
              private dialog: MatDialogRef<CreateComponent>,
              private snackbar: MatSnackBar) {
  }

  sanPhams: ISanPham[];
  email: any;

  ngOnInit(): void {
    this.service.getAllSanPham().subscribe(
      (data) => this.sanPhams = data
    );
  }

  onSubmit() {

    if (this.formGroup.valid) {
      this.service.create(this.formGroup.value).subscribe(
        () => {
        },
        () => {
        },
        () => {
          this.snackbar.open('Nhập hàng thành công <3 ', 'Ok', {
            duration: 3000
          });
          this.formGroup.reset();
          this.dialog.close();
        }
      );
    }
  }


  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }

    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
}

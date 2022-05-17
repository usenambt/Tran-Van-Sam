import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import {DetailCustomerComponent} from '../detail-customer/detail-customer.component';
import {Customer} from '../../../model/customer/Customer';
import {DeleteCustomerComponent} from '../delete-customer/delete-customer.component';
import {ServiceCustomerService} from '../../../service/service-customer.service';
import {MatSnackBar} from '@angular/material/snack-bar';


@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {

  customers: Customer[];
  p: string | number;
  private msg: string;

  constructor(public dialog: MatDialog,
              private customerService: ServiceCustomerService,
              private snackbar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomer().subscribe(
      (data) => this.customers = data
    );
  }

  openDialogDetail(customer: Customer) {
    const dialogRef = this.dialog.open(DetailCustomerComponent, {
      width: '400px',
      // height: '700px',
      data: customer
    });
  }

  openDialogDelete(customer: Customer) {
    const dialogRef = this.dialog.open(DeleteCustomerComponent, {
      data: customer
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.customerService.deleteCustomer(customer).subscribe();
        this.snackbar.open('Đã xóa ' + customer.name, 'Ok', {
          panelClass: ['mat-toolbar', 'mat-warn']
        });
        this.ngOnInit();
      }
    });
  }

  searchName(element) {
    this.customerService.findByName(element).subscribe(data => {
      this.customers = data;
      this.p = 1;
    });
  }

  sortName() {
    this.customerService.sortByName().subscribe(data => {
        this.customers = data;
      }
    );
  }

}

import {Component, Input, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {ServiceCustomerService} from '../../../service/service-customer.service';
import {TypeCustomer} from '../../../model/customer/TypeCustomer';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  isSubmit = false;
  typeCustomers: TypeCustomer[];

  constructor(private httpClient: HttpClient,
              private serviceCustomer: ServiceCustomerService,
              private router: Router,
              private snackbar: MatSnackBar) {
  }


  customerForm = new FormGroup({
    id: new FormControl(),
    name: new FormControl('', [Validators.required]),
    typeCustomer: new FormControl('', [Validators.required]),
    dayOfBirthday: new FormControl('', [Validators.required]),
    cccd: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', [Validators.required])
  });

  ngOnInit(): void {
    this.serviceCustomer.getAllTypeCustomer().subscribe(
      (data) => this.typeCustomers = data
    );
  }

  onSubmit() {
    if (this.customerForm.valid) {
      this.serviceCustomer.addCustomer(this.customerForm.value).subscribe();
      this.isSubmit = false;
      this.snackbar.open('Đã thêm ' + this.customerForm.value.name + ' thành công !', 'OK');
      this.router.navigateByUrl('/');
    } else {
      this.isSubmit = true;
    }
  }
}

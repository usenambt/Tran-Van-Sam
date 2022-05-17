import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TypeCustomer} from '../../../model/customer/TypeCustomer';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {ServiceCustomerService} from '../../../service/service-customer.service';
import {Customer} from '../../../model/customer/Customer';
import {MatSnackBar} from '@angular/material/snack-bar';
import {colors} from '@angular/cli/utilities/color';
import {config} from 'rxjs';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  customer: Customer;
  typeCustomers: TypeCustomer[];
  isSubmit = false;

  constructor(private router: Router,
              private httpClient: HttpClient,
              private serviceCustomer: ServiceCustomerService,
              private activatedRoute: ActivatedRoute,
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

    // cach2
    // console.log(this.activatedRoute.snapshot.params['id']);
    // id = this.activatedRoute.snapshot.params['id'];

    // xử lý async nên lồng nhau
    this.serviceCustomer.getAllTypeCustomer().subscribe(
      (data) => this.typeCustomers = data,
      () => {
      },
      () => {
        let id;
        this.activatedRoute.paramMap.subscribe(
          (paramMap: ParamMap) => {
            id = paramMap.get('id');
          }
        );
        this.serviceCustomer.findById(id).subscribe(
          (data) => this.customer = data,
          () => {
          },
          () => {
            // setValue với giá trị this.customer cho form để update
            this.customerForm.setValue(this.customer);
          }
        );
      }
    );

  }

  onSubmit() {
    if (this.customerForm.valid) {
      this.serviceCustomer.updateCustomer(this.customerForm.value).subscribe();
      this.isSubmit = false;
      this.snackbar.open('Đã sửa ' + this.customerForm.value.name + ' thành công !', 'OK', {
        // panelClass: ['mat-toolbar', 'mat-primary']
      });


      this.router.navigateByUrl('/');
    } else {
      this.isSubmit = true;
    }
  }
}

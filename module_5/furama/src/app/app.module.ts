import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListCustomerComponent } from './content/customer/list-customer/list-customer.component';
import { EditCustomerComponent } from './content/customer/edit-customer/edit-customer.component';
import { DetailCustomerComponent } from './content/customer/detail-customer/detail-customer.component';
import { DeleteCustomerComponent } from './content/customer/delete-customer/delete-customer.component';
import { CreateCustomerComponent } from './content/customer/create-customer/create-customer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmployeeCreateComponent } from './content/employee/employee-create/employee-create.component';
import { EmployeeDeleteComponent } from './content/employee/employee-delete/employee-delete.component';
import { EmployeeDetailComponent } from './content/employee/employee-detail/employee-detail.component';
import { EmployeeEditComponent } from './content/employee/employee-edit/employee-edit.component';
import { EmployeeListComponent } from './content/employee/employee-list/employee-list.component';
import {MatDialogModule} from '@angular/material/dialog';
import {ReactiveFormsModule} from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ListCustomerComponent,
    EditCustomerComponent,
    DetailCustomerComponent,
    DeleteCustomerComponent,
    CreateCustomerComponent,
    EmployeeCreateComponent,
    EmployeeDeleteComponent,
    EmployeeDetailComponent,
    EmployeeEditComponent,
    EmployeeListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatDialogModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

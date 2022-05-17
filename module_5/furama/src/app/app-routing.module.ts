import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from './content/customer/list-customer/list-customer.component';
import {CreateCustomerComponent} from './content/customer/create-customer/create-customer.component';
import {EditCustomerComponent} from './content/customer/edit-customer/edit-customer.component';
import {EmployeeListComponent} from './content/employee/employee-list/employee-list.component';
import {EmployeeCreateComponent} from './content/employee/employee-create/employee-create.component';
import {EmployeeEditComponent} from './content/employee/employee-edit/employee-edit.component';


const routes: Routes = [
  {path: 'customer', component: ListCustomerComponent},
  {path: 'customer/create', component: CreateCustomerComponent},
  {path: 'customer/edit/:id', component: EditCustomerComponent},
  {path: 'employee', component: EmployeeListComponent},
  {path: 'employee/create', component: EmployeeCreateComponent},
  {path: 'employee/edit/:id', component: EmployeeEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

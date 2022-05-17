import {Injectable} from '@angular/core';
import {Customer} from '../model/customer/Customer';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {TypeCustomer} from '../model/customer/TypeCustomer';

@Injectable({
  providedIn: 'root'
})
export class ServiceCustomerService {

  readonly API_URL_CUSTOMER = 'http://localhost:3000/customer';
  readonly API_URL_TYPE = 'http://localhost:3000/typeCustomer';

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomer(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL_CUSTOMER);
  }

  getAllTypeCustomer(): Observable<TypeCustomer[]> {
    return this.httpClient.get<TypeCustomer[]>(this.API_URL_TYPE);
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL_CUSTOMER, customer);
  }

  deleteCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.API_URL_CUSTOMER + '/' + customer.id);
  }

  findById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API_URL_CUSTOMER + '/' + id);
  }

  updateCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(this.API_URL_CUSTOMER + '/' + customer.id, customer);
  }

  findByName(name): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL_CUSTOMER + '' +
      '' + name);
  }

  sortByName(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL_CUSTOMER + '?_sort=name');
  }
}

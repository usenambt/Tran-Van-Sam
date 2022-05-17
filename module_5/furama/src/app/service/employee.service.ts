import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ITrinhDo} from '../model/employee/ITrinhDo';
import {IBoPhan} from '../model/employee/IBoPhan';
import {IViTri} from '../model/employee/IViTri';
import {IEmploye} from '../model/employee/IEmployee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  readonly EMPLOYEE_API_URL = 'http://localhost:3000/employee';
  readonly TRINH_DO_EMPLOYEE_API_URL = 'http://localhost:3000/trinhDo';
  readonly BO_PHAN_API_URL = 'http://localhost:3000/boPhan';
  readonly VI_TRI_EMPLOYEE_API_URL = 'http://localhost:3000/viTri';

  constructor(private http: HttpClient) {
  }

  getAllEmployee(): Observable<IEmploye[]> {
    return this.http.get<IEmploye[]>(this.EMPLOYEE_API_URL);
  }

  getAllTrinhDo(): Observable<ITrinhDo[]> {
    return this.http.get<ITrinhDo[]>(this.TRINH_DO_EMPLOYEE_API_URL);
  }

  getAllBoPhan(): Observable<IBoPhan[]> {
    return this.http.get<IBoPhan[]>(this.BO_PHAN_API_URL);
  }

  getAllViTri(): Observable<IViTri[]> {
    return this.http.get<IViTri[]>(this.VI_TRI_EMPLOYEE_API_URL);
  }
}

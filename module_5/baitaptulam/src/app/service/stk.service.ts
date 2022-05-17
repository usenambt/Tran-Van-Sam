import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ISoTietKiem} from '../model/ISoTietKiem';

@Injectable({
  providedIn: 'root'
})
export class StkService {
  readonly SO_TIET_KIEM_API = 'http://localhost:3001/soTietKiem/';
  readonly KHACH_HANG_API = 'http://localhost:3001/khachHang/';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<ISoTietKiem[]> {
    return this.httpClient.get<ISoTietKiem[]>(this.SO_TIET_KIEM_API);
  }

  getById(id: number): Observable<ISoTietKiem> {
    return this.httpClient.get<ISoTietKiem>(this.SO_TIET_KIEM_API + id);
  }
}

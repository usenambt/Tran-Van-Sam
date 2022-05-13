  import { Injectable } from '@angular/core';
  import {HttpClient} from '@angular/common/http';
  import {Observable} from 'rxjs';
  import {ILoHang} from '../model/ILoHang';
  import {ISanPham} from '../model/ISanPham';

  @Injectable({
    providedIn: 'root'
  })
  export class LohangService {
    readonly LOHANG_API_URL = 'http://localhost:3000/loHang';
    readonly SANPHAM_API_URL = 'http://localhost:3000/sanPham';

    constructor(private http: HttpClient) {
    }

    getAllLoHang(): Observable<ILoHang[]> {
      return this.http.get<ILoHang[]>(this.LOHANG_API_URL);
    }

    getAllSanPham(): Observable<ISanPham[]> {
      return this.http.get<ISanPham[]>(this.SANPHAM_API_URL);
    }

    create(loHang: ILoHang): Observable<ILoHang> {
      return this.http.post<ILoHang>(this.LOHANG_API_URL, loHang);
    }

    delete(loHang: ILoHang): Observable<ILoHang> {
      return this.http.delete<ILoHang>(this.LOHANG_API_URL + '/' + loHang.id);
    }
    updateHang(loHang: ILoHang): Observable<ILoHang[]> {
      return this.http.put<ILoHang[]>(this.LOHANG_API_URL + '/' + loHang.id, loHang);
    }

    searchNameSanPham(name: any): Observable<ILoHang[]> {
      return this.http.get<ILoHang[]>(this.LOHANG_API_URL + '?sanPham.name_like=' + name);
    }

    searchHetHan(value: any): Observable<ILoHang[]> {
      return this.http.get<ILoHang[]>(this.LOHANG_API_URL + '?ngayHetHan_like=' + value);
    }

  }

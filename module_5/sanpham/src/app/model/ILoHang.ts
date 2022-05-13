import {ISanPham} from './ISanPham';

export interface ILoHang{
  id: number;
  sanPham: ISanPham;
  soLuong: number;
  ngayNhapHang: Date;
  ngaySanXuat: Date;
  ngayHetHan: Date;
}

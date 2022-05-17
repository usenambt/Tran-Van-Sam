import {IKhachHang} from './IKhachHang';

export interface ISoTietKiem {
  id: number;
  khachHang: IKhachHang;
  ngayMoSo: Date;
  thoigianBatdauGui: Date;
  kyHan: string;
  soTienGui: string;
  laiSuat: string;
  uuDai: string;
}

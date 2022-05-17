import {IViTri} from './IViTri';
import {IBoPhan} from './IBoPhan';
import {ITrinhDo} from './ITrinhDo';

export interface IEmploye {
  id: number;
  name: string;
  viTri: IViTri;
  boPhan: IBoPhan;
  trinhDo: ITrinhDo;
  dayOfBirthday: Date;
  cccd: string;
  salary: string;
  phone: string;
  email: string;
  address: string;
}

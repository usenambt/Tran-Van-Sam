import {TypeCustomer} from './TypeCustomer';

export interface Customer {
  id: number;
  typeCustomer: TypeCustomer;
  name: string;
  dayOfBirthday: Date;
  cccd: string;
  phone: string;
  email: string;
  address: string;
}

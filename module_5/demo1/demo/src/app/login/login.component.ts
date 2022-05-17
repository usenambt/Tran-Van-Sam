import {Component, Input, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AccountsDao} from '../dao/AccountsDao';
import {IAccount} from '../models/IAccount';
import {style} from '@angular/animations';
import {colors} from '@angular/cli/utilities/color';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input() accounts = AccountsDao;

  login = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email, this.checkUser]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
  }, this.checkPassword);


  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (!this.login.invalid) {
      alert('OKE LOG_IN');
    } else {
      alert('Failed log-in');
    }
  }

  checkUser(check: AbstractControl) {
    for (const account of AccountsDao) {
      if (account.email === check.value) {
        return null;
      }
    }
    return {invalidUser: true};
  }

  checkPassword(check: AbstractControl) {
    const userForm = check.value;
    let temp = '';
    for (const account of AccountsDao) {
      if (account.email === userForm.email) {
        temp = account.password;
        break;
      }
    }
    console.log('temp : ' + temp);
    console.log(userForm.password);
    if (userForm.password === temp) {
      return null;
    }
    return {invalidpassword: true};
  }

}

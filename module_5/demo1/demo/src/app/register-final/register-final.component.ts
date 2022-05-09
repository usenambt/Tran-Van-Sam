import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AccountsDao} from '../dao/AccountsDao';


@Component({
  selector: 'app-register-final',
  templateUrl: './register-final.component.html',
  styleUrls: ['./register-final.component.css']
})
export class RegisterFinalComponent implements OnInit {

  accountsDaos = AccountsDao;
  isSubmit = false;

  // phonePattern = '(090||+84)+[0-9]{7}+';

  constructor() {

  }

  account = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    checkPassword: new FormGroup({
      password: new FormControl('', [Validators.required, Validators.minLength(6)]),
      confirmPassword: new FormControl('')
    }, this.comparePassword),
    country: new FormControl('', Validators.required),
    age: new FormControl('', [Validators.required, Validators.min(18)]),
    gender: new FormControl('', Validators.required),
    phone: new FormControl('', [Validators.required, Validators.pattern(/^(\+84|\+94)\d{9,10}$/)])
  });

  ngOnInit(): void {

  }

  onSubmit() {
    if (!this.account.invalid) {
      this.accountsDaos.push(this.account.value);
      this.isSubmit = false;
    } else {
      this.isSubmit = true;
    }
    console.log(this.accountsDaos);
  }

  comparePassword(c: AbstractControl) {
    const v = c.value;
    return (v.password === v.confirmPassword) ?
      null : {
        passwordnotmatch: true
      };
  }
}

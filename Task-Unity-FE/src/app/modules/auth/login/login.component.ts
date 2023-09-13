import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    private _formBuilder: FormBuilder,
    private _authService: AuthService,
    private _router: Router
  ) {
  }

  LoginForm!: FormGroup;

  ngOnInit() {
    this.LoginForm = this._formBuilder.group({
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      // rememberMe: new FormControl(false, Validators.required)
    })
  }

  login() {
    if (this.LoginForm.valid) {
      this._authService.login(this.LoginForm.value).subscribe(() => {
        this._router.navigate(['home']);
      })
    }
  }

}

import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(
    private _formBuilder: FormBuilder,
    private _authService: AuthService
  ) {
  }

  signUpForm!: FormGroup;

  ngOnInit() {
    this.signUpForm = this._formBuilder.group({
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      dateOfBirth: new FormControl('2023/01/01', Validators.required)
    })
  }

  signIn(){
    if(this.signUpForm.valid){
      this._authService.register(this.signUpForm.value).subscribe((res) => {
        console.log(res);
      })
    }
  }
}

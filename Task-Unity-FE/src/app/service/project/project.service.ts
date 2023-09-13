import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserService } from 'src/app/auth/user.service';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private URL = 'http://localhost:8080/project'
  private user;

  constructor(private _http: HttpClient, private _userService: UserService) {
    this.user = this._userService?.user;
    console.log(this.user);
  }

  getProject(): Observable<any> {
    return this._http.get(`${this.URL}/${this.user?.userId}`)
  }
}

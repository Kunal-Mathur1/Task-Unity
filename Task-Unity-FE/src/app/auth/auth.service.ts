import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, tap, throwError } from 'rxjs';
import * as jwt from 'jsonwebtoken';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  readonly authUrl = "http://localhost:8080";
  user: any;

  constructor(private _http: HttpClient) { 
  }

  login(userDetails: { email: string, password: string }): Observable<any> {
    return this._http.post(`${this.authUrl}/login`, userDetails).pipe(
      tap((res) => {
        const user = res;
        console.log(user)
        debugger
        localStorage.setItem("user", generateJwtToken(user))
      }),
      catchError((err) => throwError(err))
    );
  }

  register(userDetails: any): Observable<any> {
    return this._http.post(`${this.authUrl}/register`, userDetails);
  }
}

function generateJwtToken(payload: any): string {
  debugger;

  const secretKey = 'H%:D^KFHW&S#@JKDS*D$'; // Replace with your actual secret key
  const algorithm = 'HS256';

  const header = {
    alg: algorithm,
    typ: 'JWT',
  };

  // Encode the header and payload as base64
  const encodedHeader = btoa(JSON.stringify(header));
  const encodedPayload = btoa(JSON.stringify(payload));

  // Create the signature by hashing the header and payload with the secret key
  const signature = btoa(encodedHeader + '.' + encodedPayload + secretKey);

  // Combine the encoded header, payload, and signature to create the JWT token
  const jwtToken = encodedHeader + '.' + encodedPayload + '.' + signature;

  return jwtToken;
}



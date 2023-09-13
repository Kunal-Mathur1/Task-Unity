import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  readonly user: any;
  static user: any;

  constructor() {
    this.user = this.decodeJwtToken();
  }

  decodeJwtToken(): any {
    const token = localStorage.getItem("user") ?? '';
    const parts = token.split('.');
    if (parts.length !== 3) {
      throw new Error('Invalid JWT token format');
    }

    const encodedPayload = parts[1];
    const decodedPayload = atob(encodedPayload);
    const decodedPayloadObject = JSON.parse(decodedPayload);

    return decodedPayloadObject;
  }
}

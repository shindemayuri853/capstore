import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UpdateShippingService {
  api = 'http://localhost:8080/';

  updateShippingDetails = {};
  router: any;
  constructor(public http: HttpClient) { }
  updateProfile(data) {
    console.log(data);
    this.updateShippingDetails = data;
    this.router.navigateByUrl('/updateShippingDetails');
  }
  updatedShippingDetails(data): Observable<any> {
    return this.http.post<any>(`${this.api}updateShippingDetails`, data);
  }
}

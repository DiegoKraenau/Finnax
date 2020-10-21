import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private baseURL:string='http://localhost:8080/api';
  private extendURL:string='/payments'
  private URL=this.baseURL+this.extendURL

  constructor(private http:HttpClient) { }

  registerPayment(payement:Object): Observable<any>{

    return this.http.post(`${this.URL}`, payement);
  }
}

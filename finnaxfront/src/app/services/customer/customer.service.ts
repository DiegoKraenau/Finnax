import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseURL:string='http://localhost:8080/api';
  private extendURL:string='/customers'
  private URL=this.baseURL+this.extendURL

  constructor(private http:HttpClient) { }

  registerCustomer(customer:Object): Observable<any>{

    return this.http.post(`${this.URL}`, customer);
  }

  purchasesByCustomerId(id:string): Observable<any>{

    return this.http.get(`${this.URL+'/'+id+'/purchases'}`);
  }

  findPaymentsByCustomerId(id:string): Observable<any>{

    return this.http.get(`${this.URL+'/'+id+'/payments'}`);
  }

  findCustomerById(id:string): Observable<any>{

    return this.http.get(`${this.URL+'/'+id}`);
  }

}

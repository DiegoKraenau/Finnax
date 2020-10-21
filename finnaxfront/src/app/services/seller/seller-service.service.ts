import { Injectable } from '@angular/core';
import { HttpRequest, HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SellerServiceService {

  private baseURL:string='http://localhost:8080/api';
  private extendURL:string='/sellers'
  private URL=this.baseURL+this.extendURL;

  constructor(private http:HttpClient) { }

  authLogin(user:Object): Observable<any>{

    return this.http.post(`${this.URL+'/login'}`, user);
  }

  getCustomersById(id:string): Observable<any>{

    return this.http.get(`${this.URL+'/'+id+'/customers'}`);
  }

  registerSeller(seller:Object): Observable<any>{
    return this.http.post(`${this.URL}`, seller);
  }
}

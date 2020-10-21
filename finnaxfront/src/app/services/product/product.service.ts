import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseURL:string='http://localhost:8080/api';
  private extendURL:string='/products'
  private URL=this.baseURL+this.extendURL

  constructor(private http:HttpClient) { }

  registerProduct(product:Object): Observable<any>{

    return this.http.post(`${this.URL}`, product);
  }
}

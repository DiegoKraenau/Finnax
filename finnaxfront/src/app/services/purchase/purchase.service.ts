import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {


  private baseURL:string='http://localhost:8080/api';
  private extendURL:string='/purchases'
  private URL=this.baseURL+this.extendURL

  constructor(private http:HttpClient) { }

  registerPurchase(purchase:Object): Observable<any>{
    //console.log("asdasfasf")
    return this.http.post(`${this.URL}`, purchase);
  }

  registerDelivery(purchase:Object): Observable<any>{
    //console.log("asdasfasf")
    return this.http.post(`${this.URL+'/delivery'}`, purchase);
  }

  findProductsByPurchaseId(purchaseId:string): Observable<any>{
    return this.http.get(`${this.URL+'/'+purchaseId+'/products'}`);
  }
}

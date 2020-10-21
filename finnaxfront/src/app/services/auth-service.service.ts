import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {

  constructor() { }
  
  readonly ISLOGGEDKEY='islogged';
  readonly sellerId='sellerId';

  login(id:string){
    localStorage.setItem(this.sellerId,id);
    localStorage.setItem(this.ISLOGGEDKEY,'true');

  }

  logout(){
    localStorage.removeItem(this.ISLOGGEDKEY);
    localStorage.removeItem(this.sellerId);

  }

}

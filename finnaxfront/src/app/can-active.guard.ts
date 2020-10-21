import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthServiceService } from './services/auth-service.service';

@Injectable({
  providedIn: 'root'
})
export class CanActiveGuard implements CanActivate {
  constructor(private router:Router,private authService:AuthServiceService){}


  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      
      const isLogged=localStorage.getItem('islogged');
      if( isLogged=='true'){
        return true;
      }else{
        this.router.navigate(['']);
    
        return false;
      }1
     
      
     
  }
  
}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {SellerServiceService} from '../../services/seller/seller-service.service';
import {User} from '../../entities/user';
import { Router } from '@angular/router';
import {AuthServiceService} from '../../services/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  

  constructor(private http:HttpClient,private sellerService:SellerServiceService,private router:Router,private authService:AuthServiceService) { }

  user=new User();
  email:string;
  password:string;
  //user:User;
  finded:Boolean;


  ngOnInit(): void {
  }

  login(){
    this.user.email=this.email;
    this.user.password=this.password;
    this.sellerService.authLogin(this.user).subscribe(
      response=>{
        this.user=response;
        this.authService.login(this.user.sellerId);
        this.finded=true;
        this.router.navigate(['/main']);
      },
      err=>{
        this.finded=false
      }
    )
  }

  PestañaRegistro(){
    this.router.navigate(['/create-seller'])
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router:Router,private authService:AuthServiceService) { }

  ngOnInit(): void {
  }

  salir(){
    this.authService.logout();
    this.router.navigate(['/']);
  }

}

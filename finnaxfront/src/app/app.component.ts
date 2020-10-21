import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  readonly ISLOGGEDKEY='islogged';
  title = 'finnaxfront';
  logueado:String='false'

  ngOnInit(){
    const isLogged=localStorage.getItem(this.ISLOGGEDKEY)
    this.logueado=isLogged;
    //console.log(this.logueado)
  }


 
}

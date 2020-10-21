import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer/customer.service';
import { Customer} from '../../entities/customer';
import { SellerServiceService } from 'src/app/services/seller/seller-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-customers',
  templateUrl: './list-customers.component.html',
  styleUrls: ['./list-customers.component.css']
})
export class ListCustomersComponent implements OnInit {

  nombres=['Diego','Guillermo','Karlos','Madafacon','Axel'];
  pageActual:number=1;
  customers=Array<Customer>();
  filterCustomers='';

  constructor(private sellerService:SellerServiceService,private router:Router) { }




  ngOnInit(): void {
    const sellerId=localStorage.getItem('sellerId');
    
    this.sellerService.getCustomersById(sellerId).subscribe(
      response=>{
        this.customers=response;
      }
    );
  }

  prueba(customer:Customer){
    console.log(customer)
    this.router.navigate[('/list-purchases')];
  }

}

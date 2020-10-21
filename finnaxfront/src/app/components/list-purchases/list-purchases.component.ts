import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/entities/customer';
import { CustomerService } from 'src/app/services/customer/customer.service';
import { Purchase }from '../../entities/purchase';

@Component({
  selector: 'app-list-purchases',
  templateUrl: './list-purchases.component.html',
  styleUrls: ['./list-purchases.component.css']
})
export class ListPurchasesComponent implements OnInit {

  purchases=Array<Purchase>();
  pageActual:number=1;
  customer=new Customer();

  constructor(private customerService:CustomerService,private rutaActiva: ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.customerService.purchasesByCustomerId(customerId).subscribe(
      response=>{
        this.purchases=response;
       // console.log(response)
      }
    );

    this.customerService.findCustomerById(customerId).subscribe(
      response=>{
        this.customer=response;
      }
    );

  }


  createPurchase(){
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.router.navigate(['/create-purchase/'+customerId]);
  }

  createProduct(purchaseId:string){
   
   this.router.navigate(['/create-product/'+purchaseId]);
  }

  registerDelivery(purchaseId:string){
    this.router.navigate(['/register-delivery/'+purchaseId]);
  }

  stateCreditLine(){
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.router.navigate(['/state-creditline/'+customerId]);
  }

}

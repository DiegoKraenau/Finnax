import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/entities/customer';
import { Payment } from 'src/app/entities/payment';
import { CustomerService } from 'src/app/services/customer/customer.service';

@Component({
  selector: 'app-state-creditline',
  templateUrl: './state-creditline.component.html',
  styleUrls: ['./state-creditline.component.css']
})
export class StateCreditlineComponent implements OnInit {

  payments=new Array<Payment>();
  pageActual=1;
  customer=new Customer();
  totalPayment:number=0;

  constructor(private customerService:CustomerService,private rutaActiva:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.customerService.findPaymentsByCustomerId(customerId).subscribe(
      response=>{
        this.payments=response;
        this.payments.forEach(element => {
          this.totalPayment=this.totalPayment+element.paymentAmount;
        });
      }
    );

    this.customerService.findCustomerById(customerId).subscribe(
      response=>{
        this.customer=response;
      }
    );

   
  }

  registerPayment(){
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.router.navigate(['/register-payment/'+customerId]);
  }

}

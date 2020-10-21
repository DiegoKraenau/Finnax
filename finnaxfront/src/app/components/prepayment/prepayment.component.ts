import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/entities/customer';
import { Payment } from 'src/app/entities/payment';
import { CustomerService } from 'src/app/services/customer/customer.service';
import { PaymentService } from 'src/app/services/payment/payment.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-prepayment',
  templateUrl: './prepayment.component.html',
  styleUrls: ['./prepayment.component.css']
})
export class PrepaymentComponent implements OnInit {

  payment=new Payment();
  customer=new Customer();


  constructor(private paymentService:PaymentService,private rutaActiva:ActivatedRoute,private customerService:CustomerService) { }

  ngOnInit(): void {
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.customerService.findCustomerById(customerId).subscribe(
      response=>{
        this.customer=response;
        console.log(this.customer.customerCreditUsed)
      }
    );
  }

  registerPayment(myForm:NgForm){
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.payment.customerId=customerId;

    if(this.payment.paymentAmount==null || this.payment.paymentName==null || this.payment.operationDate==null ){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Datos incorrectos o falta ingresar datos'
      })
    }
    else if(this.payment.paymentAmount>this.customer.customerCreditUsed){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Monto de pago mayor a lo que se debe.'
      })
    }
    else{
      this.paymentService.registerPayment(this.payment).subscribe(
        response=>{
          myForm.reset();
          if(response!=null){
            Swal.fire(
              'Buen trabajo!',
              'Se registro el pago adelantado de manera correcta.',
              'success'
            )
          }
        }
      );
    }

  }
}

import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/entities/customer';
import { CustomerService } from 'src/app/services/customer/customer.service';
import Swal from 'sweetalert2';
import { Payment} from '../../entities/payment';
import {PaymentService} from '../../services/payment/payment.service';

@Component({
  selector: 'app-register-payment',
  templateUrl: './register-payment.component.html',
  styleUrls: ['./register-payment.component.css']
})
export class RegisterPaymentComponent implements OnInit {

  payment=new Payment();
  customer=new Customer();


  constructor(private paymentService:PaymentService,private rutaActiva:ActivatedRoute,private customerService:CustomerService) { }

  ngOnInit(): void {
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.customerService.findCustomerById(customerId).subscribe(
      response=>{
        this.customer=response;
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
    else if(this.payment.paymentAmount>this.customer.customerTotalDebt){
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
              'Se registro el pago de manera correcta.',
              'success'
            )
          }
        }
      );
    }

  }
}

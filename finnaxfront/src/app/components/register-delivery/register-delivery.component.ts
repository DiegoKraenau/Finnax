import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Purchase } from 'src/app/entities/purchase';
import { PurchaseService } from 'src/app/services/purchase/purchase.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register-delivery',
  templateUrl: './register-delivery.component.html',
  styleUrls: ['./register-delivery.component.css']
})
export class RegisterDeliveryComponent implements OnInit {

  constructor(private purchaseService:PurchaseService,private rutaActiva:ActivatedRoute) { }

  purchase=new Purchase();
  purchaseTestName=new Purchase();

  ngOnInit(): void {
    const purchaseId=this.rutaActiva.snapshot.params.purchaseId;
    this.purchaseService.findProductsByPurchaseId(purchaseId).subscribe(
      response=>{
        this.purchaseTestName=response;
      }
    );
  }

  registerDelivery(myForm:NgForm){
    if(this.purchase.deliveryAmount==null ){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Datos incorrectos o falta ingresar datos'
      })
    }else{
      const purchaseId=this.rutaActiva.snapshot.params.purchaseId;
      this.purchase.purchaseId=purchaseId;

      this.purchaseService.registerDelivery(this.purchase).subscribe(
        response=>{
          myForm.reset();
          if(response!=null){
            Swal.fire(
              'Buen trabajo!',
              'Se registro el delivery de manera correcta.',
              'success'
            )
          }
        }
      );
    }
  }

}

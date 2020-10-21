import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { isEmpty } from 'rxjs/operators';
import { Purchase } from 'src/app/entities/purchase';
import Swal from 'sweetalert2';
import {PurchaseService} from '../../services/purchase/purchase.service';


@Component({
  selector: 'app-create-purchase',
  templateUrl: './create-purchase.component.html',
  styleUrls: ['./create-purchase.component.css']
})
export class CreatePurchaseComponent implements OnInit {

  purchase=new Purchase();
  prueba:String;

  constructor(private rutaActiva:ActivatedRoute,private purchaseService:PurchaseService) { }

  ngOnInit(): void {
    this.purchase.purchaseName=null

  }

  registerPurchase(myForm:NgForm){
    const customerId=this.rutaActiva.snapshot.params.customerId;
    this.purchase.customerId=customerId;
    if(this.purchase.purchaseName==null || this.purchase.purchaseProductsAmount==null || this.purchase.purchaseProductsName==null || this.purchase.operationDate==null){
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Datos incorrectos o falta ingresar datos'
        })
    }else{
      this.purchaseService.registerPurchase(this.purchase).subscribe(
        response=>{
          myForm.reset();
          if(response!=null){
            Swal.fire(
              'Buen trabajo!',
              'Se registro la compra de manera correcta.',
              'success'
            )
          }
        }
      );
    }

   
    
  }
}

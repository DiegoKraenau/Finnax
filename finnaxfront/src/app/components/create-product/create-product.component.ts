import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Purchase } from 'src/app/entities/purchase';
import { PurchaseService } from 'src/app/services/purchase/purchase.service';
import Swal from 'sweetalert2';
import { Product } from '../../entities/product';
import {ProductService} from'../../services/product/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  product=new Product();
  purchase=new Purchase();

  constructor(private productService:ProductService,private rutaActiva:ActivatedRoute,private purchaseService:PurchaseService) { }

  ngOnInit(): void {
    const purchaseId=this.rutaActiva.snapshot.params.purchaseId;
    this.purchaseService.findProductsByPurchaseId(purchaseId).subscribe(
      response=>{
        this.purchase=response;
      }
    );
  }

  registerProduct(myForm:NgForm){
    if(this.product.productAmount==null || this.product.productDescription==null){
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Datos incorrectos o falta ingresar datos'
      })
    }else{
      const purchaseId=this.rutaActiva.snapshot.params.purchaseId;
      this.product.purchaseId=purchaseId;
      this.productService.registerProduct(this.product).subscribe(
        response=>{
          myForm.reset();
          if(response!=null){
            Swal.fire(
              'Buen trabajo!',
              'Se registro el producto de manera correcta.',
              'success'
            )
          }
        }
      );
    }


  }

}

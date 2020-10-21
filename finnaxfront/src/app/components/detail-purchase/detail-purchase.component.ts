import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Purchase } from 'src/app/entities/purchase';
import { PurchaseService } from 'src/app/services/purchase/purchase.service';

@Component({
  selector: 'app-detail-purchase',
  templateUrl: './detail-purchase.component.html',
  styleUrls: ['./detail-purchase.component.css']
})
export class DetailPurchaseComponent implements OnInit {

  purchase=new Purchase();
  pageActual=1;

  constructor(private purchaseService:PurchaseService,private rutaActiva:ActivatedRoute) { }

  ngOnInit(): void {
    const purchaseId=this.rutaActiva.snapshot.params.purchaseId;
    this.purchaseService.findProductsByPurchaseId(purchaseId).subscribe(
      response=>{
        this.purchase=response;
        console.log(this.purchase.listaProducts)
      }
    );

  }

}

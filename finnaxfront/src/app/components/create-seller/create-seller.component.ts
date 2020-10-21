import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/entities/user';
import { SellerServiceService } from 'src/app/services/seller/seller-service.service';
import Swal from 'sweetalert2';
import { Seller } from '../../entities/seller';

@Component({
  selector: 'app-create-seller',
  templateUrl: './create-seller.component.html',
  styleUrls: ['./create-seller.component.css']
})
export class CreateSellerComponent implements OnInit {

  seller = new Seller();

  constructor(private sellerService: SellerServiceService) { }

  ngOnInit(): void {
  }

  RegisterSeller() {
    this.sellerService.registerSeller(this.seller).subscribe(
      response => {
        if (response != null) {
          Swal.fire(
            'Buen trabajo!',
            'Te registraste de  manera correcta!',
            'success'
          )
        }
      }
    );
  }

  refresh(myForm:NgForm){
    myForm.reset();
  }


}

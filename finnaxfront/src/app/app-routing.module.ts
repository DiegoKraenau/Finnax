import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateCustomerComponent } from './components/create-customer/create-customer.component';
import { LoginComponent } from './components/login/login.component';
import { MainComponent } from './components/main/main.component';
import {CanActiveGuard} from './can-active.guard';
import { CreateSellerComponent } from './components/create-seller/create-seller.component';
import { ListPurchasesComponent } from './components/list-purchases/list-purchases.component';
import { CreatePurchaseComponent } from './components/create-purchase/create-purchase.component';
import { CreateProductComponent } from './components/create-product/create-product.component';
import { RegisterDeliveryComponent } from './components/register-delivery/register-delivery.component';
import { DetailPurchaseComponent } from './components/detail-purchase/detail-purchase.component';
import { RegisterPaymentComponent } from './components/register-payment/register-payment.component';
import { StateCreditlineComponent } from './components/state-creditline/state-creditline.component';


const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'main',component:MainComponent,canActivate:[CanActiveGuard]},
  {path:'create-customer',component:CreateCustomerComponent,canActivate:[CanActiveGuard]},
  {path:'list-purchases/:customerId',component:ListPurchasesComponent,canActivate:[CanActiveGuard]},
  {path:'create-purchase/:customerId',component:CreatePurchaseComponent,canActivate:[CanActiveGuard]},
  {path:'create-product/:purchaseId',component:CreateProductComponent,canActivate:[CanActiveGuard]},
  {path:'register-delivery/:purchaseId',component:RegisterDeliveryComponent,canActivate:[CanActiveGuard]},
  {path:'detail-purchase/:purchaseId',component:DetailPurchaseComponent,canActivate:[CanActiveGuard]},
  {path:'register-payment/:customerId',component:RegisterPaymentComponent,canActivate:[CanActiveGuard]},
  {path:'state-creditline/:customerId',component:StateCreditlineComponent,canActivate:[CanActiveGuard]},
  {path:'create-seller',component:CreateSellerComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

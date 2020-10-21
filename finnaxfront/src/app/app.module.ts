import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { SpinnerComponent } from './components/spinner/spinner.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import {CustomHttpInterceptor} from '../app/custom-http-interceptor';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MainComponent } from './components/main/main.component';
import { CreateCustomerComponent } from './components/create-customer/create-customer.component';
import { ListCustomersComponent } from './components/list-customers/list-customers.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { CreateSellerComponent } from './components/create-seller/create-seller.component';
import { FilterPipe } from './pipes/filter.pipe';
import { ListPurchasesComponent } from './components/list-purchases/list-purchases.component';
import { CreatePurchaseComponent } from './components/create-purchase/create-purchase.component';
import { CreateProductComponent } from './components/create-product/create-product.component';
import { RegisterDeliveryComponent } from './components/register-delivery/register-delivery.component';
import { DetailPurchaseComponent } from './components/detail-purchase/detail-purchase.component';
import { RegisterPaymentComponent } from './components/register-payment/register-payment.component';
import { StateCreditlineComponent } from './components/state-creditline/state-creditline.component';
import { PrepaymentComponent } from './components/prepayment/prepayment.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SpinnerComponent,
    NavbarComponent,
    MainComponent,
    CreateCustomerComponent,
    ListCustomersComponent,
    CreateSellerComponent,
    FilterPipe,
    ListPurchasesComponent,
    CreatePurchaseComponent,
    CreateProductComponent,
    RegisterDeliveryComponent,
    DetailPurchaseComponent,
    RegisterPaymentComponent,
    StateCreditlineComponent,
    PrepaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [
    {
      provide:HTTP_INTERCEPTORS,
      useClass:CustomHttpInterceptor,
      multi:true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

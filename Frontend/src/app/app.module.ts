import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { CancelOrderComponent } from './cancel-order/cancel-order.component';
import { HeaderComponent } from './header/header.component';
import { ShippingDetailsComponent } from './shipping-details/shipping-details.component';
import { UpdateDetailsComponent } from './update-details/update-details.component';
import { UpdateShippingComponent } from './update-shipping/update-shipping.component';

@NgModule({
  declarations: [
    AppComponent,
    OrderHistoryComponent,
    OrderDetailsComponent,
    CancelOrderComponent,
    HeaderComponent,
    ShippingDetailsComponent,
    UpdateDetailsComponent,
    UpdateShippingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

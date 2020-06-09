import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CancelOrderComponent } from './cancel-order/cancel-order.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { OrderHistoryComponent } from './order-history/order-history.component';
import { ShippingDetailsComponent } from './shipping-details/shipping-details.component';
import { UpdateShippingComponent } from './update-shipping/update-shipping.component';


const routes: Routes = [
  { path: 'cancel-order', component: CancelOrderComponent },
  { path: 'order-details', component: OrderDetailsComponent},
  { path: 'order-history', component: OrderHistoryComponent},
  { path: 'shipping-details', component: ShippingDetailsComponent},
  {path: 'update-shipping', component: UpdateShippingComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

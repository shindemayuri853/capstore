import { Component, OnInit } from '@angular/core';
import { OrderserviceService } from '../orderservice.service';
import { OrderDetails } from '../orderDetails';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  OrderDetails = [];
  message: string = null;
  constructor(public orderService: OrderserviceService) {
    this.orderService.getOrderList();
   }
  //  cancelOrder(product) {
  //   this.orderService.cancelOrder(product).subscribe(response => {
  //     console.log(response);
  //     this.orderService.product();
  //   }, err => {
  //     console.log(err);
  //   });
  //  }
  cancelOrder(product) {
    this.orderService.cancelOrder(product).subscribe(response => {
      console.log(response);
      this.orderService.getOrderList();
      if (response.statusCode === 201) {
        this.message = 'Order Cancelled Successfully';
      } else {
        this.message = 'Unable to Cancel Order';
      }
    }, err => {
      console.log(err);
    });
  }
  ngOnInit() {
  }
}

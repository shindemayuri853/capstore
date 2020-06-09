import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderDetails } from './orderDetails';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderserviceService {

  api = 'http://localhost:8080/';
  constructor(private http: HttpClient) { }
  selectedQuantity;
  selectedProduct: OrderDetails[] = [];
  //   orderId: null,
  //   productId: null,
  //   productName: null,
  //   address: null,
  //   pinCode: null,
  //   phoneNumber: null,
  //   productQuantity: null,
  //   totalBill: null,
  //   email: null
  // };
  // http://localhost:8080/deleteOneCart?orderId=2
  cancelOrder(orderDetails): Observable<any> {
    return this.http.delete(`${this.api}cancelOrder?orderId=${orderDetails.orderId}`, orderDetails);
  }

  getOrderList() {
    this.http.get<any>(`${this.api}orderList`).subscribe(data => {
      console.log(data);
      this.selectedProduct = data.orderList;
      console.log(this.selectedProduct);
    });
  }
  // // http://localhost:8080/historyTable?userId=3
  // orderHistory() {
  //   const userId = JSON.parse(localStorage.getItem('user')).id;
  //   console.log(userId);
  //   this.http.get<any>(`${this.api}historyTable?userId=${userId}`).subscribe(data => {
  //     console.log(data);
  //     this.cart = data.historyList;
  //     console.log(this.cart);
  //   });
  // }
  }


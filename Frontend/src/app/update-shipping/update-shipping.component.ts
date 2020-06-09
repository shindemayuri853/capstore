import { Component, OnInit } from '@angular/core';
import { UpdateShipping } from '../updateshipping';
import { NgForm } from '@angular/forms';
import { UpdateShippingService } from '../update-shipping.service';

@Component({
  selector: 'app-update-shipping',
  templateUrl: './update-shipping.component.html',
  styleUrls: ['./update-shipping.component.css']
})
export class UpdateShippingComponent implements OnInit {
updateshipping: UpdateShipping = {
  orderId: null,
         productId: null,
         email: null,
         address: null,
         pincode: null,
         phoneNumber: null,
         productQuantity: null,
         totalBill: null,
         productName: null
                };
  router: any;
  constructor(public updateShippingService: UpdateShippingService ) { }
  UpdateShipping(UpdateShippingForm: NgForm) {
console.log(UpdateShippingForm.value);
this.updateshipping.productId = 1236;
this.updateshipping.email = UpdateShippingForm.value.email;
this.updateshipping.address = UpdateShippingForm.value.address;
this.updateshipping.pincode = UpdateShippingForm.value.pincode;
this.updateshipping.phoneNumber = UpdateShippingForm.value.phonenumber;
this.updateshipping.productQuantity = 2;
this.updateshipping.totalBill = 4500;
this.updateshipping.productName = 'Mens tshirt';
console.log(this.updateshipping);
this.updateShippingService.updatedShippingDetails(this.updateshipping).subscribe(response => {
  if (response.statusCode === 201) {
    console.log(response);
    alert(response.description);
   // this.router.navigateByUrl('shipping-details');
  } else {
    alert(response.description);
}
}, err => {
console.log(err);
});
  }
  ngOnInit() {
  }

}

export class OrderDetails {
    constructor(
        public orderId: number,
        public productId: number,
        public email: string,
        public address: string,
        public pincode: string,
        public phoneNumber: string,
        public productQuantity: number,
        public totalBill: number,
        public productName: string
    ) { }
}
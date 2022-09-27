import {
  Component,
  ComponentFactoryResolver,
  ElementRef,
  HostListener,
  OnInit,
  ViewChild,
} from '@angular/core';
import { OrderModel } from 'src/app/profilepage/orders/ordersmodel';
import { OrdersService } from 'src/app/profilepage/orders/ordersService';
import { ProfilepageService } from 'src/app/profilepage/profilepageService';
import { addressModel, userModel } from 'src/app/profilepage/usermodel';

import { Allitems } from '../Items/allitems';

import { Cart } from '../Items/cart.model';

import { ApiserviceService } from '../menuapiservice/apiservice.service';

import { CartService } from '../menuapiservice/cart.service';
import { Order, orderMenu } from './OrderModel';
import { paymentService } from '../../profilepage/payments/paymentApi';
import { paymentModel } from '../../profilepage/payments/paymentModel';
import { RecommendationService } from './../../recommendation.service';

declare var Razorpay: any;

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  menuproduct!: Cart;
  product!: Cart;
  public totalAmount!: number;
  Quantity: number = 1;
  menu: any;

  // address popup
  userEmailId: any = sessionStorage.getItem('emailId');
  userData: userModel = new userModel();
  addressList: addressModel[] = [];
  selectedindex: number = -1;
  newOrder: Order = new Order();
  itemsList: orderMenu[] = [];
  newItem: orderMenu = new orderMenu();

  //payment related
  newPayment: paymentModel = new paymentModel();
  checkoutPayment: paymentModel = new paymentModel();
  totPrice: number = 0;
  newOrderId: number = 0;

  // order related
  @ViewChild('myModal', { static: true }) myModal!: ElementRef;
  placedOrder: OrderModel = new OrderModel();

  constructor(
    private cartService: CartService,
    private api: ApiserviceService,
    private profileApi: ProfilepageService,
    private ordersApi: OrdersService,
    private paymentApi: paymentService,
    private recommendation: RecommendationService
  ) {}
  message: boolean = false;

  ngOnInit(): void {
    this.api.getallitems(this.userEmailId).subscribe((data) => {
      this.menuproduct = data;
      console.log(this.menuproduct.items);
    });
    this.getAllByUserEmailId(); //for displaying all addresses
  }

  removeItem(index: any) {
    this.menuproduct.items.splice(index, 1);
    this.api
      .updateItems(this.menuproduct, this.userEmailId)
      .subscribe((data) => (this.product = data));
    console.log(this.menuproduct);
  }

  emptycart() {
    this.menuproduct.items = [];
    this.api
      .updateItems(this.menuproduct, this.userEmailId)
      .subscribe((data) => (this.menuproduct = data));
    console.log(this.menuproduct);
  }
  getTotalAmount(): number {
    let total = 0;
    for (var i = 0; i < this.menuproduct.items.length; i++) {
      if (this.menuproduct.items[i].itemCost) {
        total +=
          this.menuproduct.items[i].itemCost *
          this.menuproduct.items[i].quantity;
        this.totalAmount = total;
      }
    }
    return total;
  }

  inc(index: number) {
    // if (this.menuproduct.items[index].quantity + 1 < 1) {
    //   this.menuproduct.items[index].quantity = 1;
    //   console.log('item_1-> ' + this.product.items[index].quantity);
    // } else {
    this.menuproduct.items[index].quantity += 1;
    // console.log(
    //   'item_2-> ' + index + '  ' + this.product.items[index].quantity
    // );
    this.api
      .updateItems(this.menuproduct, this.userEmailId)
      .subscribe((data) => (this.product = data));
    // }
  }

  desc(index: number) {
    /*. if item passed then item.qty. */
    if (this.menuproduct.items[index].quantity - 1 < 1) {
      this.menuproduct.items[index].quantity = 1;
      console.log('item_1-> ' + this.menuproduct.items[index].quantity);
    } else {
      this.menuproduct.items[index].quantity -= 1;
      console.log(
        'item_2-> ' + index + '  ' + this.menuproduct.items[index].quantity
      );
    }
    this.api
      .updateItems(this.menuproduct, this.userEmailId)
      .subscribe((data) => (this.product = data));
  }
  //   one(index:number){
  //     this.menuproduct.items[index].quantity =1;
  //     this.api
  //       .updateItems(this.menuproduct, this.userEmailId)
  //       .subscribe((data) => (this.product = data));
  //     console.log(this.menuproduct);
  //   }
  //   two(index:number){
  //     this.menuproduct.items[index].quantity =2;
  //     this.api
  //       .updateItems(this.menuproduct, this.userEmailId)
  //       .subscribe((data) => (this.product = data));
  //     console.log(this.menuproduct);
  //   }

  // three(index:number){
  //     this.menuproduct.items[index].quantity =3;
  //     this.api
  //       .updateItems(this.menuproduct, this.userEmailId)
  //       .subscribe((data) => (this.product = data));
  //     console.log(this.menuproduct);
  //   }
  //   four(index:number){
  //     this.menuproduct.items[index].quantity =4;
  //     this.api
  //       .updateItems(this.menuproduct, this.userEmailId)
  //       .subscribe((data) => (this.product = data));
  //     console.log(this.menuproduct);
  //   }
  //   five(index:number){
  //     this.menuproduct.items[index].quantity =5;
  //     this.api
  //       .updateItems(this.menuproduct, this.userEmailId)
  //       .subscribe((data) => (this.product = data));
  //     console.log(this.menuproduct);
  //   }

  // Address popup part-----

  getAllByUserEmailId() {
    this.profileApi.getAddressesById(this.userEmailId).subscribe((res) => {
      this.userData = res;
      this.addressList = this.userData.address;
      // console.log(this.addressList);
    });
  }

  addressclick(index: number) {
    this.selectedindex = index;
  }

  closeButtonAddressPopoup() {
    this.selectedindex = -1;
  }

  createNewPayment(): any {
    this.totPrice = this.getTotalAmount() + this.getTotalAmount() * 0.02 + 50;
    this.newPayment.userEmailId = this.userEmailId;
    this.newPayment.totalPrice = this.totPrice;
    this.newPayment.status = 'opened';
    this.paymentApi.createPayment(this.newPayment).subscribe((res) => {
      this.checkoutPayment = res;
      this.proceedToRazorpay();
      console.log(res);
    });
    console.log('inside new payment');
  }

  proceedToRazorpay(): any {
    console.log('inside proceed to razor pay');
    console.log(this.checkoutPayment.razorpayOrderId);
    var options = {
      key: 'rzp_test_NZF7xwvsZ1nV6d', // Enter the Key ID generated from the Dashboard
      amount: this.totPrice * 100, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
      currency: 'INR',
      name: 'Lap-Lunch',
      description: 'Test Transaction',
      image:
        'https://i.pinimg.com/originals/40/d4/b8/40d4b8c1ce2413ae119c9e873065fba7.png',
      order_id: this.checkoutPayment.razorpayOrderId, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1
      handler: function (response: {
        razorpay_payment_id: any;
        razorpay_order_id: any;
        razorpay_signature: any;
      }) {
        // alert(response.razorpay_payment_id);
        // alert(response.razorpay_order_id);
        // alert(response.razorpay_signature);
        // alert('Order Placed!');
        console.log('inside handler');
        var event: CustomEvent = new CustomEvent('payment.success', {
          detail: response,
          bubbles: true,
          cancelable: true,
        });
        window.dispatchEvent(event);
      },
      prefill: {
        name: this.userData.firstName + this.userData.lastName,
        email: this.userEmailId,
        contact: this.userData.mobileNum,
      },
      notes: {
        address: 'Lap-lunch Corporate Office',
      },
      theme: {
        color: '#3399cc',
      },
    };
    var rzp1 = new Razorpay(options);
    rzp1.on(
      'payment.failed',
      function (response: {
        error: {
          code: any;
          description: any;
          source: any;
          step: any;
          reason: any;
          metadata: { order_id: any; payment_id: any };
        };
      }) {
        // alert(response.error.code);
        // alert(response.error.description);
        // alert(response.error.source);
        // alert(response.error.step);
        // alert(response.error.reason);
        // alert(response.error.metadata.order_id);
        // alert(response.error.metadata.payment_id);
        var event: CustomEvent = new CustomEvent('payment.failure', {
          detail: response,
          bubbles: true,
          cancelable: true,
        });
        window.dispatchEvent(event);
      }
    );

    rzp1.open();

    // if (statusPay == 'success') {
    //   this.createNewOrder();
    //   this.checkoutPayment.orderId = this.newOrderId;
    //   console.log(this.checkoutPayment);
    // }
  }

  @HostListener('window:payment.success', ['$event'])
  onPaymentSuccess(event: any): void {
    console.log(event);
    this.createNewOrder();
  }

  @HostListener('window:payment.failure', ['$event'])
  onPaymentFailure(event: any): void {
    console.log(event);
    this.checkoutPayment.status = 'FAILED';
    this.paymentApi.updatePayment(this.checkoutPayment).subscribe((res) => {
      console.log(this.checkoutPayment);
    });
  }

  createNewOrder() {
    this.newOrder.userEmailId = this.userEmailId;
    this.menuproduct.items.forEach((item) => {
      this.newItem.itemId = item.itemId!;
      this.newItem.itemName = item.itemName!;
      this.newItem.itemDescription = item.itemDescription!;
      this.newItem.qty = item.quantity;
      this.newItem.itemCost = item.itemCost;
      this.newItem.image = item.itemImage!;
      this.itemsList.push(this.newItem);
      this.newItem = new orderMenu();
    });
    this.newOrder.itemsList = this.itemsList;
    this.newOrder.address = this.addressList[this.selectedindex];
    this.newOrder.totalPrice = this.totPrice;

    // console.log(this.newOrder);
    this.ordersApi.createOrderforUser(this.newOrder).subscribe((res) => {
      this.placedOrder = res;
      console.log(this.placedOrder);
      this.triggerOrderModal();
      this.emptycart();
      this.checkoutPayment.orderId = this.placedOrder.orderId;
      this.checkoutPayment.status = 'SUCCESS';
      this.paymentApi.updatePayment(this.checkoutPayment).subscribe(
        (res) => {},
        (err) => {
          console.log(this.checkoutPayment);
          this.recommendation.addOrder(this.placedOrder).subscribe();
          // email service to be added
          this.recommendation.sendEmail(this.placedOrder).subscribe();
        }
      );
    });
  }
  triggerOrderModal() {
    this.myModal.nativeElement.click();
  }

  // triggering modal

  // @ViewChild('orderButton')
  // orderButton!: ElementRef<HTMLElement>;
  // triggerFalseClick() {
  //   let el: HTMLElement = this.orderButton.nativeElement;
  //   el.click();
  // }

  // proceedButton() {
  //   setTimeout(this.createNewPayment(), 0);
  //   setTimeout(this.proceedToRazorpay(), 4000);

  //   // let a: String = this.proceedToRazorpay();
  //   // if (a == 'success') {
  //   //   this.createNewOrder();
  //   //   this.checkoutPayment.orderId = this.newOrderId;
  //   //   // console.log(this.checkoutPayment);
  //   // } else {
  //   //   console.log('order not generated');
  //   //   // console.log(a);
  //   // }
  // }
}

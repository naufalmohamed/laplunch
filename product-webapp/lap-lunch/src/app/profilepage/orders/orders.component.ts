import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { OrderModel } from './ordersmodel';
import { OrdersService } from './ordersService';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
})
export class OrdersComponent implements OnInit {
  userEmailId: any = sessionStorage.getItem('emailId');
  orderData!: OrderModel[];

  constructor(private api: OrdersService, private formbuilder: FormBuilder) {}

  ngOnInit(): void {
    this.getAllOrdersByEmailId();
  }

  getAllOrdersByEmailId() {
    this.api.getOrdersByemailId(this.userEmailId).subscribe((res) => {
      this.orderData = res;
      this.orderData.reverse();
      console.log(res);
    });
  }
}

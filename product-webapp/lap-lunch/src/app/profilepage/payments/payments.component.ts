import { Component, OnInit } from '@angular/core';
import { paymentService } from './paymentApi';
import { paymentModel } from './paymentModel';

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.css'],
})
export class PaymentsComponent implements OnInit {
  userEmailId: any = sessionStorage.getItem('emailId');
  userPayments: paymentModel[] = [];

  constructor(private paymentApi: paymentService) {}

  ngOnInit(): void {
    this.getAllPaymentsByUser();
  }

  getAllPaymentsByUser() {
    this.paymentApi.getPaymentsByemailId(this.userEmailId).subscribe((res) => {
      this.userPayments = res;
    });
  }
}

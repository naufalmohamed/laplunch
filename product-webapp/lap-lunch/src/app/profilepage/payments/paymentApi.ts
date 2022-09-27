import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { environment } from 'src/environments/environment';
import { paymentModel } from './paymentModel';

@Injectable({
  providedIn: 'root',
})
export class paymentService {
  constructor(private http: HttpClient) {}
  url = environment.url;
  createPayment(newPayment: any) {
    return this.http
      .post<any>(`${this.url}/paymentservice/api/v1/payNow`, newPayment)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
  updatePayment(newPayment: any) {
    return this.http
      .put<any>(`${this.url}/paymentservice/api/v1/updatePayment`, newPayment)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  getPaymentsByemailId(userEmailId: string) {
    return this.http
      .get<any>(`${this.url}/paymentservice/api/v1/getPayments/` + userEmailId)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
}

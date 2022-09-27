import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class OrdersService {
  constructor(private http: HttpClient) {}

  url=environment.url

  getOrdersByemailId(userEmailId: string) {
    return this.http
      .get<any>(`${this.url}/orderservice/api/v1/getOrders/` + userEmailId)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  createOrderforUser(orderData: any) {
    return this.http
      .post<any>(`${this.url}/orderservice/api/v1/addOrder`, orderData)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
}

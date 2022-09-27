import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { User } from './pages/registration/user.model';
import { Order, orderMenu } from './pages/cart/OrderModel';
import { OrderModel } from './profilepage/orders/ordersmodel';
@Injectable({
  providedIn: 'root',
})
export class RecommendationService {
  constructor(private http: HttpClient) {}

  url = environment.url;
  getData() {
    let url = `${this.url}/userrecommendation/api/v4/getdata`;
    return this.http.get(url);
  }

  getDataByCity(city: any) {
    let url = `${this.url}/userrecommendation/api/v4/city/` + city;
    return this.http.get(url);
  }

  addUser(user: any): Observable<User> {
    return this.http.post<User>(`${this.url}/userrecommendation/api/v1`, user);
  }

  addOrder(order: OrderModel): Observable<Order> {
    return this.http.post<OrderModel>(
      `${this.url}/userrecommendation/api/v3`,
      order
    );
  }

  sendEmail(order: OrderModel): Observable<OrderModel> {
    return this.http.post<OrderModel>(
      `${this.url}/usernotification/api/v1`,
      order
    );
  }
}

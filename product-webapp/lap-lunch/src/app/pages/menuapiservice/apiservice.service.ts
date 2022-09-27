import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Allitems } from '../Items/allitems';
import { Cart } from '../Items/cart.model';
import { Timetablemodel } from '../timetable/timetablemodel';
@Injectable({
  providedIn: 'root',
})
export class ApiserviceService {
  public search = new BehaviorSubject<string>('');

  constructor(private http: HttpClient) {}

  // getItem(){
  //   return this.http.get<Allitems[]>(" http://localhost:8081/api/v1/getall")
  //   .pipe(map((res:any)=>{
  //     return res;
  //   }));
  url = environment.url;
  getItem(): Observable<Allitems[]> {
    return this.http.get<Allitems[]>(`${this.url}/menuuser/api/v1/getall`);
  }

  //api for timetable post
  postItemsToTimetable(timetablelist:Timetablemodel): Observable<Timetablemodel>{
    return this.http.post<Timetablemodel>(`${this.url}/user/api/v2`,timetablelist);
  }
  //api for getting timetable 
  getTimeTable():Observable<any>{
    return this.http.get<any>(`${this.url}/user/api/v2`);
  }
// delete data from timetable
deleteTimeTableData(id:any,index :any):Observable<any>{
  return this.http.delete<any>(`${this.url}/user/api/v2/`+id+"/"+index)
}
//Update items in time table
// updateTimeTableData(id:any):Observable<Timetablemodel>{
//   return this.http.put<Timetablemodel>("http://localhost:8086/api/v2/")
// }


  // updateItems(cart:Cart): Observable<Cart>{
  //   return this.http.post<Cart>("http://localhost:8083/api/v1/cart/create",cart);


  updateItems(cart: Cart, userEmailId: string): Observable<Cart> {
    return this.http.put<Cart>(
      `${this.url}/orderservice/api/v1/cart/` + userEmailId,

      cart
    );
  }

  getallitems(userEmailId: string): Observable<Cart> {
    return this.http
      .get<Cart>(`${this.url}/orderservice/api/v1/cart/` + userEmailId)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
  emptyCart(userEmailId: string): Observable<Cart> {
    return this.http.delete<Cart>(`${this.url}/menuuser/api/v1/` + userEmailId);
  }
}

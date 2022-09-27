import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProfilepageService {
  constructor(private http: HttpClient) {}


  url=environment.url
  getAddressesById(id: string) {
    return this.http
      .get<any>(`${this.url}/user/api/v3/getUser/` + id)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }

  updateAddressById(id: string, userData: any) {
    return this.http
      .put<any>(`${this.url}/user/api/v3/updateUser/` + id, userData)
      .pipe(
        map((res: any) => {
          return res;
        })
      );
  }
}

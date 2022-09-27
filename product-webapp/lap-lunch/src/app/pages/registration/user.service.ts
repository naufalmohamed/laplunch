import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Allitems } from '../Items/allitems';
import { User } from './user.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  url=environment.url
  getUser(): Observable<User[]>{
    return this.http.get<User[]>(`${this.url}/user/api/v3/getusers`);
  }

  addUser(user : any): Observable<User> {
    return this.http.post<User>(`${this.url}/user/api/v3`, user);
  }
}

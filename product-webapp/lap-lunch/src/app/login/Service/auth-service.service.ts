import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Router } from '@angular/router';
import { Login } from '../login';
import { MatSnackBar } from '@angular/material/snack-bar';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  token:any;
  decodedToken:any;

  helper= new JwtHelperService();
  constructor(private http:HttpClient,private jwtHelper :JwtHelperService, private router:Router,private snackbar:MatSnackBar) { }
  
  url=environment.url
  login(email:string, password:string )  {
    return this.http.post<Login>(`${this.url}/userauth/api/v1/auth/login`, {email, password})
  }
  
  addUser(email:String, password:String){
    return this.http.post<Login>(`${this.url}/userauth/api/v1/post`,{email,password});
  }

logout(){
  sessionStorage.removeItem('emailId');
  sessionStorage.removeItem('token');
  this.router.navigateByUrl('/')
  // .then(()=>{
  //   this.snackbar.open("You have been logged out successfully!","Dismiss", {
  //   duration:2500,
  // });
  // });
}
isloggedIn() {
  return !!sessionStorage.getItem('token');;
}
}
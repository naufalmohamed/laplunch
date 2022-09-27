import { Token } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthServiceService } from 'src/app/login/Service/auth-service.service';
// import { JwtHelperService } from '@auth0/angular-jwt';
// import { AuthServiceService } from 'src/app/login/Service/auth-service.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  router: any;
  helper= new JwtHelperService();
  constructor(public authService:AuthServiceService, router:Router) { }

  ngOnInit(): void {
    
  }
}

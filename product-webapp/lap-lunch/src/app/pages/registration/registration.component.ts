import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import {MatSnackBar} from '@angular/material/snack-bar';
import { Address } from './address.model';
import { User } from './user.model';
import { UserService } from './user.service';
import { Router } from '@angular/router';
import { CustomvalidationService } from './customvalidation.service';
import { MatFormField } from '@angular/material/form-field';
import { AuthServiceService } from 'src/app/login/Service/auth-service.service';
import {MatDialog} from '@angular/material/dialog';
import { DialogBoxComponent } from './dialog-box/dialog-box.component';
// import * as $ from "jquery";

import { MatTooltipModule } from '@angular/material/tooltip';
import { RecommendationService } from './../../recommendation.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  alert:boolean = false;

  regForm! : FormGroup;

   user: User =  {
    userEmailId: '',
    mobileNum : '',
    firstName : '',
    lastName : '',
    password : '',
    address : []

  };


  constructor(private service : UserService, private router: Router,
    private authService:AuthServiceService, private builder: FormBuilder, 
    private customValidator : CustomvalidationService,
    private _snackBar : MatSnackBar,
    private dialogBox : MatDialog,
    private matTooltip:MatTooltipModule,
    private recommendation:RecommendationService) { }
  message:any;
  ngOnInit(): void {
    this.regForm = this.builder.group({
      userEmailId : ['', [Validators.required, Validators.email]],
      mobileNum : ['',[Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],
      firstName : ['', Validators.required],
      lastName : ['', Validators.required],
      password : ['', Validators.compose([Validators.required, this.customValidator.patternValidator()])],
      confirmPassword: ['', [Validators.required]],
      address : [[]]
    },

    {
      validator: this.customValidator.MatchPassword('password', 'confirmPassword'),
    }
    );
  }
  submitted:boolean = false;
  get f() { return this.regForm.controls; }
 
  
 
 
  onSubmit(){
    this.submitted = true;
    if (this.regForm.valid) {
      
      console.table(this.regForm.value);
      this.registerNow();
      
    } 
  }
  

  public registerNow(){
    this.user.userEmailId = this.regForm.value.userEmailId;
    this.user.mobileNum = this.regForm.value.mobileNum;
    this.user.firstName = this.regForm.value.firstName;
    this.user.lastName = this.regForm.value.lastName;
    this.user.password = this.regForm.value.password;
    this.user.address = this.regForm.value.address;
    this.service.addUser(this.user).subscribe((data) => {this.message=data,
      this.recommendation.addUser(this.user).subscribe();
    },
    )
    this.alert=true;
    console.log(this.message);
    this.regForm.reset({})
    // this.router.navigateByUrl('/login')
    
      
  }
  
  
  closeAlert(){
    this.alert=false;
  }
  
}

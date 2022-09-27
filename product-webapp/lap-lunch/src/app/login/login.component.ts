import { Component } from '@angular/core';
import { FormBuilder,FormsModule, FormControl, Validators} from '@angular/forms';
import { MatSnackBar} from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
//import { error } from 'console';
import { AuthServiceService } from './Service/auth-service.service';

declare var $:any;
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  alert:boolean=false;
  decodedToken:any;
  message:any;
  action:any;
  helper= new JwtHelperService();

  constructor( private fb:FormBuilder, private authService:AuthServiceService,
              private router: Router,
               public snackbar:MatSnackBar) {}

loginform =this.fb.group({
  email: [null,[Validators.email,Validators.required]],
  password:[null,[Validators.required,Validators.minLength(8)]],
})
ngonit(){
  $('[data-toggle="tooltip"]').tooltip();
}
  
login() {
    const val = this.loginform.value;
    
    if (val.email && val.password) {
        this.authService.login(val.email, val.password)
            .subscribe(
                (result) => {
                    console.log(result);
                    this.decodedToken= this.helper.decodeToken(result.token);
                    sessionStorage.setItem("emailId",this.decodedToken.sub);
                    sessionStorage.setItem('token',result.token);
                    this.loginform.reset();
                    this.router.navigateByUrl('/')
                    // .then(()=>{
                    //   this.snackbar.open("You are logged in!","OK",{
                    //     duration:2500,
                    //   });
                    // });
                },

                error=>{
                  console.log("Incorrect Details"); 
                  this.alert=true;
                  setTimeout(() => {
                    this.alert=false;
                  }, 3000);
                }
            )
      
            
                    
    }
    else{
      console.log("enter correct details")
      alert("enter correct details");
      this.loginform.reset();
    }
}
}
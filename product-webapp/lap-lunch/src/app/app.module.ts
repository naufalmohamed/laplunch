import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonComponentsModule } from './common-components/common-components.module';
import { PagesModule } from './pages/pages.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
//profile components
import { JwtHelperService, JWT_OPTIONS } from '@auth0/angular-jwt';
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';
import { SubscribedPlanComponent } from './subscribed-plan/subscribed-plan.component';
import { CommonModule } from '@angular/common';
import { ProfilepageModule } from './profilepage/profilepage.module';
//import { ProfilepageModule } from 'src/profilepage/profilepage.module';
import {MatDialog, MatDialogModule} from '@angular/material/dialog';
import {MatSnackBar} from '@angular/material/snack-bar';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCommonModule } from '@angular/material/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { MatTooltipModule } from '@angular/material/tooltip';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { AuthGuard } from './login/Service/auth.guard';
//import {ToastrModule} from 'ngx-toastr';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SubscriptionPlansComponent,
    SubscribedPlanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    ProfilepageModule,
    BrowserAnimationsModule,
    CommonComponentsModule,
    PagesModule,
    ReactiveFormsModule,
    FormsModule,
    MatToolbarModule,
    MatFormFieldModule,
    HttpClientModule,
    MatCommonModule,
    MatCardModule,
    MatInputModule,
    MatSnackBarModule,
    MatDialogModule,
    
  ],
  providers: [
    { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
    JwtHelperService,AuthGuard
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

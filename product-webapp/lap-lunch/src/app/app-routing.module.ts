import { RecommendationComponent } from './pages/recommendation/recommendation.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './common-components/header/header.component';
 import { LoginComponent } from './login/login.component';
import { CartComponent } from './pages/cart/cart.component';
import { ProductComponent } from './pages/product/product.component';
import { RegistrationComponent } from './pages/registration/registration.component';
import { SearchheaderComponent } from './pages/searchheader/searchheader.component';
import { TimetableComponent } from './pages/timetable/timetable.component';
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';
import { AuthGuard } from './login/Service/auth.guard';


const routes: Routes = [

  // { path: '', component: HeaderComponent },
  { path: 'cart', component: CartComponent,canActivate:[AuthGuard]},
  { path: '', component: SearchheaderComponent},
  { path: 'product', component: ProductComponent },
  { path: "search/:searchItem",component: SearchheaderComponent},
  { path: "timetable", component:TimetableComponent,canActivate:[AuthGuard]},
  { path: 'login', component: LoginComponent },
  { path: 'registration', component: RegistrationComponent },
  { path: 'subscriptionplan', component: SubscriptionPlansComponent,canActivate:[AuthGuard]}, // i have mentioned this lie
  { path: 'recommendation', component: RecommendationComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})],
  exports: [RouterModule],
  
})
export class AppRoutingModule {}

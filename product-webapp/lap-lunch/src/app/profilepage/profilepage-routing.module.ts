import { NgModule } from '@angular/core';

import { RouterModule, Routes, CanActivate } from '@angular/router';
import { ProfilepageComponent } from './profilepage.component';
import { OrdersComponent } from './orders/orders.component';
import { AddressesComponent } from './addresses/addresses.component';
import { SubscriptionComponent } from './subscription/subscription.component';
import { AuthGuard } from '../login/Service/auth.guard';
import { PaymentsComponent } from './payments/payments.component';

const routes: Routes = [
  {
    path: 'profilepage',
    component: ProfilepageComponent,
    children: [
      { path: 'orders', component: OrdersComponent, canActivate: [AuthGuard] },
      {
        path: 'addresses',
        component: AddressesComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'subscription',
        component: SubscriptionComponent,
        canActivate: [AuthGuard],
      },
      {
        path: 'payments',
        component: PaymentsComponent,
        canActivate: [AuthGuard],
      },
    ],
  },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfilepageRoutingModule {}

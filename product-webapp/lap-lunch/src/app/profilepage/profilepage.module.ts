import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfilepageComponent } from './profilepage.component';
import { ProfilepageRoutingModule } from './profilepage-routing.module';
import { OrdersComponent } from './orders/orders.component';
import { AddressesComponent } from './addresses/addresses.component';
import { SubscriptionComponent } from './subscription/subscription.component';
import { RouterModule } from '@angular/router';
import { CommonComponentsModule } from '../common-components/common-components.module';
import { ReactiveFormsModule } from '@angular/forms';
import { PaymentsComponent } from './payments/payments.component';

@NgModule({
  declarations: [
    ProfilepageComponent,
    OrdersComponent,
    AddressesComponent,
    SubscriptionComponent,
    PaymentsComponent,
  ],
  imports: [
    CommonModule,
    ProfilepageRoutingModule,
    RouterModule,
    CommonComponentsModule,
    ReactiveFormsModule,
  ],
  exports: [OrdersComponent, AddressesComponent, SubscriptionComponent],
})
export class ProfilepageModule {}

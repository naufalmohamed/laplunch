import { address } from 'src/app/pages/cart/OrderModel';

export class OrderModel {
  orderId!: number;
  userEmailId!: string;
  totalPrice!: number;
  time!: String;
  itemsList!: menuModel[];
  address!: address;
}

export class menuModel {
  itemId!: number;
  itemName!: string;
  itemDescription!: string;
  qty!: number;
  isVeg!: boolean;
  itemCost!: number;
  image!: string;
}

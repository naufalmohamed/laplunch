export class Order {
  userEmailId!: string;
  address!: address;
  itemsList!: orderMenu[];
  totalPrice!: number;
}

export class orderMenu {
  itemId!: number;
  itemName!: String;
  itemDescription!: String;
  qty!: number;
  isVeg!: boolean;
  itemCost!: number;
  image!: String;
}

export class address {
  addressType!: string;
  houseNum!: string;
  street!: string;
  city!: string;
  state!: string;
  pincode!: number;
}

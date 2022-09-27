export class userModel {
  userEmailId!: string;
  mobileNum!: string;
  firstName!: string;
  lastName!: string;
  password: string = '';
  address!: addressModel[];
}

export class addressModel {
  addressType!: string;
  houseNum!: string;
  street!: string;
  city!: string;
  state!: string;
  pincode!: number;
}

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

import { ProfilepageService } from '../profilepageService';
import { addressModel, userModel } from '../usermodel';

@Component({
  selector: 'app-addresses',
  templateUrl: './addresses.component.html',
  styleUrls: ['./addresses.component.css'],
})
export class AddressesComponent implements OnInit {
  addressformValue!: FormGroup;

  userEmailId: any = sessionStorage.getItem('emailId');
  userData!: userModel;
  addressList!: addressModel[];
  newAddress: addressModel = new addressModel();
  indexVal!: number;

  constructor(
    private formbuilder: FormBuilder,
    private profileApi: ProfilepageService
  ) {}

  ngOnInit(): void {
    this.addressformValue = this.formbuilder.group({
      addressType: [],
      houseNum: [],
      street: [],
      city: [],
      state: [],
      pincode: [],
    });

    this.getAllByUserEmailId();
  }

  getAllByUserEmailId() {
    this.profileApi.getAddressesById(this.userEmailId).subscribe((res) => {
      this.userData = res;
      this.addressList = this.userData.address;
    });
  }
  deleteOneAddressForUser(index: number) {
    this.addressList.splice(index, 1);
    this.userData.address = this.addressList;
    this.profileApi
      .updateAddressById(this.userEmailId, this.userData)
      .subscribe((res) => {
        console.log('updated');
        this.getAllByUserEmailId();
      });
  }

  editButtonClickEvent(index: number) {
    this.indexVal = index;
    this.addressformValue.controls['addressType'].setValue(
      this.addressList[index].addressType
    );
    this.addressformValue.controls['houseNum'].setValue(
      this.addressList[index].houseNum
    );
    this.addressformValue.controls['street'].setValue(
      this.addressList[index].street
    );
    this.addressformValue.controls['city'].setValue(
      this.addressList[index].city
    );
    this.addressformValue.controls['state'].setValue(
      this.addressList[index].state
    );
    this.addressformValue.controls['pincode'].setValue(
      this.addressList[index].pincode
    );
  }

  updateOneAddressForUser() {
    this.newAddress.addressType = this.addressformValue.value.addressType;
    this.newAddress.houseNum = this.addressformValue.value.houseNum;
    this.newAddress.street = this.addressformValue.value.street;
    this.newAddress.city = this.addressformValue.value.city;
    this.newAddress.state = this.addressformValue.value.state;
    this.newAddress.pincode = this.addressformValue.value.pincode;
    //console.log(this.newAddress);
    this.addressList.splice(this.indexVal, 1);
    this.addressList.splice(this.indexVal, 0, this.newAddress);
    //console.log(this.addressList);
    this.userData.address = this.addressList;
    this.profileApi
      .updateAddressById(this.userEmailId, this.userData)
      .subscribe((res) => {
        console.log('updated');
        this.getAllByUserEmailId();
      });
    this.addressformValue.reset();
    this.newAddress = new addressModel();
  }
  AddOneAddressForUser() {
    this.newAddress.addressType = this.addressformValue.value.addressType;
    this.newAddress.houseNum = this.addressformValue.value.houseNum;
    this.newAddress.street = this.addressformValue.value.street;
    this.newAddress.city = this.addressformValue.value.city;
    this.newAddress.state = this.addressformValue.value.state;
    this.newAddress.pincode = this.addressformValue.value.pincode;
    this.addressList.push(this.newAddress);
    this.userData.address = this.addressList;
    this.profileApi
      .updateAddressById(this.userEmailId, this.userData)
      .subscribe((res) => {
        console.log('updated');
        this.getAllByUserEmailId();
      });
    this.addressformValue.reset();
    this.newAddress = new addressModel();
  }

  // findAddressIndex(houseId: number): number {
  //   let i = 0;
  //   for (i = 0; i < this.addressList.length; i++) {
  //     if (this.addressList[i].houseId == houseId) {
  //       break;
  //     }
  //   }
  //   return i;
  // }
  closeButtonAddressPopup() {
    this.addressformValue.reset();
  }
}

import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

import { ProfilepageService } from './profilepageService';
import { userModel } from './usermodel';

@Component({
  selector: 'app-profilepage',
  templateUrl: './profilepage.component.html',
  styleUrls: ['./profilepage.component.css'],
})
export class ProfilepageComponent implements OnInit {
  userEmailId: any = sessionStorage.getItem('emailId');
  userData!: userModel;
  userformValue: any;

  constructor(
    private profileApi: ProfilepageService,
    private formbuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    this.userformValue = this.formbuilder.group({
      firstName: [],
      lastName: [],
      mobileNum: [],
    });

    this.getAllByUserEmailId();
  }

  editButtonProfile() {
    this.userformValue.controls['firstName'].setValue(this.userData.firstName);
    this.userformValue.controls['lastName'].setValue(this.userData.lastName);
    this.userformValue.controls['mobileNum'].setValue(this.userData.mobileNum);
  }
  updateUserDetails() {
    this.userData.mobileNum = this.userformValue.value.mobileNum;
    this.userData.firstName = this.userformValue.value.firstName;
    this.userData.lastName = this.userformValue.value.lastName;
    this.profileApi
      .updateAddressById(this.userEmailId, this.userData)
      .subscribe((res) => {
        console.log('updated');
        this.getAllByUserEmailId();
      });
    this.userformValue.reset();
  }
  getAllByUserEmailId() {
    this.profileApi.getAddressesById(this.userEmailId).subscribe((res) => {
      this.userData = res;
    });
  }
}

import { RecommendationService } from './../../recommendation.service';
import { Component, OnInit } from '@angular/core';
import { Cart } from '../Items/cart.model';
import { Menu } from '../Items/menu.model';
import { Allitems } from '../Items/allitems';
import { AuthServiceService } from 'src/app/login/Service/auth-service.service';
import { Router } from '@angular/router';
import { ApiserviceService } from '../menuapiservice/apiservice.service';



@Component({
  selector: 'app-recommendation',
  templateUrl: './recommendation.component.html',
  styleUrls: ['./recommendation.component.css']
})
export class RecommendationComponent implements OnInit {
  data: any = [];
  itemList: any[] = [];
  city: string = "Bangalore";
  isCity: boolean = false;
  isPopUp: boolean = false;
  tempdata!: Cart;
  userEmailId: any = sessionStorage.getItem('emailId');
  alert: boolean = false
  constructor(private recommendation:RecommendationService,
              private authService: AuthServiceService,
              private routes: Router,
              private api: ApiserviceService,
              ) {
    this.recommendation.getDataByCity(this.city).subscribe(data=>{
      // console.log(data);
    })
   }

  ngOnInit(): void {
    this.api.getItem().subscribe((res) => {
      this.itemList = res;
      // this.filterCategory = res;

      // console.log(this.searchKey);
      this.api.getallitems(this.userEmailId).subscribe((res) => {
        this.tempdata = res;
      });

      this.itemList.forEach((a: any) => {
        // if(a.category==="veg"){
        //   a.category="Veg Items"

        // }

        Object.assign(a, { quantity: 1, total: a.itemCost });
      });
      // console.log(this.itemList);
    });
  }

  suggestByCity(city:any){
    this.isCity = true;
    this.recommendation.getDataByCity(city).subscribe(data=>{
      this.data = data;
      this.city = city;
    });

  }

  tempItem: Menu = {
    itemId: 1,
    itemName: '',
    itemDescription: ' ',
    category: '',
    itemCost: 0,
    itemImage: '',

    quantity: 1,
  };

  public additems(menuitem: Menu) {

    if (
      this.tempdata.items.findIndex(
        (item) => item.itemId === menuitem.itemId
      ) == -1
    ) {
      (this.tempItem.itemId = menuitem.itemId),
        (this.tempItem.itemName = menuitem.itemName),
        (this.tempItem.itemDescription = menuitem.itemDescription),
        (this.tempItem.itemCost = menuitem.itemCost),
        (this.tempItem.itemImage = menuitem.itemImage),
        (this.tempItem.category = menuitem.category),
        (this.tempItem.quantity = 1);
      this.tempdata.items.push(this.tempItem);
    } else {
      this.tempdata.items[
        this.tempdata.items.findIndex((item) => item.itemId === menuitem.itemId)
      ].quantity += 1;
    }

    this.api.updateItems(this.tempdata, this.userEmailId).subscribe();
    this.alert = true;
    this.isPopUp = true;
    setTimeout(() => {
      this.isPopUp=false;
    }, 2000);

    this.tempItem = {
      itemId: 1,
      itemName: '',
      itemDescription: ' ',
      category: '',
      itemCost: 0,
      itemImage: '',

      quantity: 1,
    };

    if (this.authService.isloggedIn()) {
      return true;
    } else {
      this.routes.navigateByUrl('/login');
      return false;
    }
    

  }
  public isPopUpFalse(){
    this.isPopUp = false;
  }

}

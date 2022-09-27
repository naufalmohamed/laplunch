import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

import { Menu } from '../Items/menu.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartList : Menu[]=[];
  public menuList : Menu[]=[];
  tempItem!: Menu;
  constructor() { }

  getItems(){
   return this.menuList;
  }
  // tempdata : Cart={
  //   userEmailId : "karthiga@gmail.com",
  //   items: []
    
  // }
  
  // tempItem: Menu = { 
  //   itemId: 1,
  //   itemName: "",
  //   itemDescription: " ",
  //   category: "",
  //   itemCost:0,
  //   itemImage: "",

  //   quantity : 1,
  // };
  // setItems(){
  //   // tempItem :Menu = {}
  //   this.tempdata.items.push(this.tempItem)
  //   this.cartList.push(this.tempItem);
  //   this.menuList.push(this.tempItem);
  // }

  // addItemtocart(newitem: any){
 
   
  //   this.cartList.push(this.tempItem);
  //   this.menuList.push(this.tempItem);
  //   this.getTotalAmount();
  //   console.log(this.cartList);
  // }

  // getTotalAmount(): number{
  //   let totalAmount=0;
  //   this.cartList.map((a:any)=>{
  //     totalAmount +=a.total;
  //   })

  //   return totalAmount;
  // }

  // removeCartItem(newitem:any){
  //   this.cartList.map((a:any,index:any)=>{
  //     if(newitem.id === a.id){
  //       this.cartList.splice(index,1);
  //     }
  //   })
  //   this.menuList.concat(this.cartList);
  // }

  // removeFUllCartItems(){
  //   this.cartList=[];
  //   this.menuList.concat(this.cartList);
  // }
  // cartLists(newitem:any){
  //   this.menuList.map((a:any,index:any)=>{
  //     if(newitem.id === a.id){
  //      let currentData = this.cartList.findIndex(index,1);
  //      currentData= currentData +1;
  //     }
  //     return this.cartLists(newitem) ;

  //   })
  // }ng
//   CartItemDecrement (item:any) {
//     item.qty = item.qty - 1;
//     return this.menuList.concat(this.cartList);
// }


// IncrementItemQuantity (item:any) {

//   item.qty = item.qty + 1;
  
//   return this.menuList.concat(this.cartList);
// } 
}

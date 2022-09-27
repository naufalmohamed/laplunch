// import { ReturnStatement } from '@angular/compiler';
// import { Component, Input, OnInit } from '@angular/core';
// import { MatSnackBar } from '@angular/material/snack-bar';
// import { Router } from '@angular/router';
// import { AppRoutingModule } from 'src/app/app-routing.module';
// import { AuthServiceService } from 'src/app/login/Service/auth-service.service';
// import { Allitems } from '../Items/allitems';
// import { Cart } from '../Items/cart.model';
// import { Menu } from '../Items/menu.model';
// import { ApiserviceService } from '../menuapiservice/apiservice.service';
// import { CartService } from '../menuapiservice/cart.service';

// @Component({
//   selector: 'app-product',
//   templateUrl: './product.component.html',
//   styleUrls: ['./product.component.css'],
// })
// export class ProductComponent implements OnInit {

//   alert:boolean=false;
//   itemList :any[] =[];
//   searchedItems: Allitems[]=[];
//   searchKey : string="";
//   public filterCategory: any;
//   allitems: any;
//   tempdata!: Cart;
//   // alert:boolean=false;
//   @Input()
//   searchString: string = '';

//   constructor(
//     private api: ApiserviceService,
//     private cartService: CartService,
//     private route: AppRoutingModule,
//     private routes:Router,
//     private authService:AuthServiceService,
//     private snackbar:MatSnackBar
//   ) {}

//   message: any;

//   ngOnInit(): void {
//     console.log(this.searchKey);
//     this.api.getItem().subscribe((res) => {
//       this.itemList = res;
//       this.filterCategory = res;

//       console.log(this.searchKey);
//       this.api.getallitems().subscribe((res) => {
//         this.tempdata = res;
//       });

//       this.itemList.forEach((a: any) => {
//         // if(a.category==="veg"){
//         //   a.category="Veg Items"

//         // }

//         Object.assign(a, { quantity: 1, total: a.itemCost });
//       });
//       // console.log(this.itemList);
//     });
//     // this.route.params.subscribe((params: { [x: string]: string; })=>{
//     //   if(params['searchItem'])

//     //  this.allitems=this.cartService.getItems().filter(allitem=>allitem.itemName.toLowerCase().includes(params['searchItem'].toLowerCase()));

//     //   else
//     //    this.allitems =this.cartService.getItems();

//     //  })

//     this.api.search.subscribe((val: any) => {
//       //  console.log(this.searchKey);

//       this.searchedItems = [];
//       this.searchKey = val;
//       for (let i = 0; i < this.itemList.length; i++) {
//         //  console.log(this.searchKey);

//         if (
//           this.itemList[i].itemName
//             .toLowerCase()
//             .includes(this.searchKey.toLowerCase()) &&
//           this.searchKey != ''
//         ) {
//           console.log(this.itemList[i]);

//           this.searchedItems.push(this.itemList[i]);
//         }
//       }
//     });
//   }
//   scroll(el: HTMLElement) {
//     el.scrollIntoView({ behavior: 'smooth' });
//   }
//   // addItemsToCart(item:any){

//   //   this.cartService.addItemtocart(item);
//   // }

//   // tempdata: Cart = {
//   //   userEmailId: 'karthiga@gmail.com',
//   //   items: [],
//   // };
//   tempItem: Menu = {
//     itemId: 1,
//     itemName: '',
//     itemDescription: ' ',
//     category: '',
//     itemCost: 0,
//     itemImage: '',

//     quantity: 1,
//   };
//   public additems(menuitem: Allitems) {
//     // this.cart.menu.push(newitem)
//     // if(this.authService.isloggedIn()){
//     //   return true
//     // }else{
//     //   this.routes.navigateByUrl('/login')
//     //   return false
//     // };

//     if (
//       this.tempdata.items.findIndex(
//         (item) => item.itemId === menuitem.itemId
//       ) == -1
//     ) {
//       (this.tempItem.itemId = menuitem.itemId),
//         (this.tempItem.itemName = menuitem.itemName),
//         (this.tempItem.itemDescription = menuitem.itemDescription),
//         (this.tempItem.itemCost = menuitem.itemCost),
//         (this.tempItem.itemImage = menuitem.itemImage),
//         (this.tempItem.category = menuitem.category),
//         (this.tempItem.quantity = 1);
//       this.tempdata.items.push(this.tempItem);
   
     
//     } else {
//       this.tempdata.items[
//         this.tempdata.items.findIndex((item) => item.itemId === menuitem.itemId)
//       ].quantity += 1;
      
//     }

//     this.api.updateItems(this.tempdata).subscribe();
//    this.alert=true;
//  }
//  closeAlert(){
//   this.alert=false;
//  }
 
  
 
   

//     this.tempItem = {
//       itemId: 1,
//       itemName: '',
//       itemDescription: ' ',
//       category: '',
//       itemCost: 0,
//       itemImage: '',

//       quantity: 1,
//     };
    
//     if(this.authService.isloggedIn()){
//       return true
//     }else{
//       this.routes.navigateByUrl('/login')
//       return false
//     };
//   }
//   closeAlert(){
//     this.alert=false;
//   }

//   //   addItemsToCart(newitem:any){
//   // this.tempdata.menu.push(newitem)

//   //     this.api.updateItems(this.tempdata).subscribe((data)=>{
//   //       console.log(data)
//   //     })
//   // this.tempdata.menu.push(newitem)

//   // }

//   // ngOnInit(): void {
//   //     this.api.getItem().subscribe((data: Allitems[])=>{
//   //       console.log(data);
//   // //      this.filterCategory=data;
//   //       this.items=data;
//   //     });
//   // }

//   filter(category: string) {
//     this.filterCategory = this.itemList.filter((a: any) => {
//       if (a.category == category || category == '') {
//         return a;
//       }
//     });
//   }

// }

import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { AuthServiceService } from 'src/app/login/Service/auth-service.service';
import { Allitems } from '../Items/allitems';
import { Cart } from '../Items/cart.model';
import { Menu } from '../Items/menu.model';
import { ApiserviceService } from '../menuapiservice/apiservice.service';
import { CartService } from '../menuapiservice/cart.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
  userEmailId: any = sessionStorage.getItem('emailId');
  itemList: any[] = [];
  searchedItems: Allitems[] = [];
  searchKey: string = '';
  public filterCategory: any;
  allitems: any;
  tempdata!: Cart;
  alert: boolean = false;
  nameofitem: String="";
  @Input()
  searchString: string = '';

  constructor(
    private api: ApiserviceService,
    private cartService: CartService,
    private route: AppRoutingModule,
    private routes: Router,
    private authService: AuthServiceService,
    private snackbar: MatSnackBar
  ) {}

  message: any;

  ngOnInit(): void {
    console.log(this.searchKey);
    this.api.getItem().subscribe((res) => {
      this.itemList = res;
      this.filterCategory = res;

      console.log(this.searchKey);
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
    // this.route.params.subscribe((params: { [x: string]: string; })=>{
    //   if(params['searchItem'])

    //  this.allitems=this.cartService.getItems().filter(allitem=>allitem.itemName.toLowerCase().includes(params['searchItem'].toLowerCase()));

    //   else
    //    this.allitems =this.cartService.getItems();

    //  })

    this.api.search.subscribe((val: any) => {
      //  console.log(this.searchKey);

      this.searchedItems = [];
      this.searchKey = val;
      for (let i = 0; i < this.itemList.length; i++) {
        //  console.log(this.searchKey);

        if (
          this.itemList[i].itemName
            .toLowerCase()
            .includes(this.searchKey.toLowerCase()) &&
          this.searchKey != ''
        ) {
          console.log(this.itemList[i]);

          this.searchedItems.push(this.itemList[i]);
        }
      }
    });
  }
  scroll(el: HTMLElement) {
    el.scrollIntoView({ behavior: 'smooth' });
  }
  // addItemsToCart(item:any){

  //   this.cartService.addItemtocart(item);
  // }

  // tempdata: Cart = {
  //   userEmailId: 'karthiga@gmail.com',
  //   items: [],
  // };
  tempItem: Menu = {
    itemId: 1,
    itemName: '',
    itemDescription: ' ',
    category: '',
    itemCost: 0,
    itemImage: '',

    quantity: 1,
  };
  public additems(menuitem: Allitems) {
    // this.cart.menu.push(newitem)
    // if(this.authService.isloggedIn()){
    //   return true
    // }else{
    //   this.routes.navigateByUrl('/login')
    //   return false
    // };

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
    this.nameofitem=menuitem.itemName;

    this.alert = true;
    //setTimeout(this.closeAlert(),10000);
    setTimeout(() => {
      this.alert=false;
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
  closeAlert(): any {
    this.alert = false;
  }

  //   addItemsToCart(newitem:any){
  // this.tempdata.menu.push(newitem)

  //     this.api.updateItems(this.tempdata).subscribe((data)=>{
  //       console.log(data)
  //     })
  // this.tempdata.menu.push(newitem)

  // }

  // ngOnInit(): void {
  //     this.api.getItem().subscribe((data: Allitems[])=>{
  //       console.log(data);
  // //      this.filterCategory=data;
  //       this.items=data;
  //     });
  // }

  filter(category: string) {
    this.filterCategory = this.itemList.filter((a: any) => {
      if (a.category == category || category == '') {
        return a;
      }
    });
  }
}


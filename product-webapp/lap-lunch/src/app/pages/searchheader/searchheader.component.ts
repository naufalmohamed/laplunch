import { Component, OnInit } from '@angular/core';
import { Cart } from '../Items/cart.model';
import { ApiserviceService } from '../menuapiservice/apiservice.service';
import { CartService } from '../menuapiservice/cart.service';
import { Allitems } from '../Items/allitems';
import { filter } from 'rxjs/operators';
import { ActivatedRoute } from '@angular/router';
import { Menu } from '../Items/menu.model';
@Component({
  selector: 'app-searchheader',
  templateUrl: './searchheader.component.html',
  styleUrls: ['./searchheader.component.css'],
})
export class SearchheaderComponent implements OnInit {
  userEmailId: any = sessionStorage.getItem('emailId');
  public searchvalue: string = '';
  public itemscount: number = 0;
  allitems!: Allitems[];
  items!: Menu;
  searchItem: string = '';

  constructor(
    private apisearchservice: ApiserviceService,
    private cartService: CartService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.apisearchservice
      .getallitems(this.userEmailId)

      .subscribe((res) => {
        this.itemscount = res.items.length;
      });

    this.route.params.subscribe((params) => {
      if (params['searchItem']) this.searchItem = params['searchItem'];
    });
  }

  search(event: any) {
    this.searchvalue = (event.target as HTMLInputElement).value;
    //  console.log(this.searchvalue);
    this.apisearchservice.search.next(this.searchvalue);
  }
}
